package com.omilia.channels.commons.diamant;

import com.omilia.channels.commons.exceptions.CriticalErrorException;
import com.omilia.channels.commons.exceptions.InvalidDialogException;
import com.omilia.channels.commons.requests.SendMessageRequest;
import com.omilia.channels.commons.requests.StartDialogRequest;
import com.omilia.channels.utils.Json;
import com.omilia.channels.utils.ServletUtils;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class DiamantChannelsClient extends DiamantClient {

    // constants
    private static final Logger logger = LoggerFactory.getLogger(DiamantChannelsClient.class);

    // attributes
    private final String apiToken;

    //  constructors
    DiamantChannelsClient(Builder builder) {

        this.diamantUrl = builder.baseUrl + "/DiaManT/api/internal";
        this.apiToken = builder.apiToken;
        this.httpClient = builder.httpClient;
    }

    // overrides
    @Override
    public DiamantResponse startDialog(StartDialogRequest request)
            throws IOException, InvalidDialogException {

        String targetUrl = diamantUrl + "/dialogs";

        logger.info("Sending start request to DiaManT [{}]", Json.mapper.writeValueAsString(request));

        okhttp3.Request.Builder httpRequestBuilder = new okhttp3.Request.Builder()
                .url(targetUrl)
                .post(RequestBody.create(JSON, Json.mapper.writeValueAsBytes(request)))
                .addHeader(ServletUtils.AUTHORIZATION, "Bearer " + apiToken);

        okhttp3.Request httpRequest = httpRequestBuilder.build();

        okhttp3.Response response = httpClient.newCall(httpRequest).execute();
        logger.info("Request sent to DiaManT | Response Status Code: {}", response.code());

        // NOTE: Consume response body to avoid conn leak.
        String body = response.body().string();

        int statusCode = response.code();
        logger.info("{}", statusCode);
        if (statusCode != 200) {
            throw new InvalidDialogException("Failed to start dialog with diamant.");
        }

        if (StringUtils.isEmpty(body)) {
            throw new InvalidDialogException("DiaManT response is empty");
        }

        DiamantChannelsResponse dmtResponse = DiamantChannelsResponse.newInstance(body);
        logger.info("Diamant response parsed | STEP no: {} ", dmtResponse.getStep());

        return dmtResponse;
    }

    @Override
    public DiamantResponse sendMessage(SendMessageRequest request)
            throws IOException, InvalidDialogException, CriticalErrorException {

        String targetUrl = diamantUrl + "/dialogs/" + request.getDialogId();

        logger.info("Sending request to DiaManT [{}]", Json.mapper.writeValueAsString(request));

        okhttp3.Request.Builder httpRequestBuilder = new okhttp3.Request.Builder()
                .url(targetUrl)
                .post(RequestBody.create(JSON, Json.mapper.writeValueAsBytes(request)))
                .addHeader(ServletUtils.AUTHORIZATION, "Bearer " + apiToken);

        okhttp3.Request httpRequest = httpRequestBuilder.build();

        okhttp3.Response response = httpClient.newCall(httpRequest).execute();
        logger.info("Request sent to DiaManT | Response Status Code: {}", response.code());

        // NOTE: Consume response body to avoid conn leak.
        String body = response.body().string();

        int statusCode = response.code();
        logger.info("{}", statusCode);
        if (statusCode == 404) {
            throw new InvalidDialogException("Failed to send message to diamant. Reason: " + body);
        }

        if (statusCode != 200) {
            throw new CriticalErrorException("Failed to send message to diamant. Reason: " + body);
        }

        if (StringUtils.isEmpty(body)) {
            throw new InvalidDialogException("DiaManT response is empty");
        }

        DiamantChannelsResponse dmtResponse = DiamantChannelsResponse.newInstance(body);
        logger.info("Diamant response parsed | STEP no: {} ", dmtResponse.getStep());

        return dmtResponse;
    }

    @Override
    public DiamantResponse sendHangUp(String applicationId, String dialogId)
            throws IOException, InvalidDialogException, CriticalErrorException {

        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .applicationId(applicationId)
                .dialogId(dialogId)
                .utterance("[hup]")
                .build();

        return sendMessage(sendMessageRequest);
    }

    public static final class Builder {

        // attributes
        String baseUrl;
        String appName;
        String apiToken;
        int connectTimeout;
        int readTimeout;
        OkHttpClient httpClient;

        // constructors
        public Builder() {

            connectTimeout = 10000;
            readTimeout = 10000;
        }

        //
        public Builder baseUrl(String baseUrl) {

            this.baseUrl = baseUrl;
            return this;
        }

        public Builder appName(String appName) {

            this.appName = appName;
            return this;
        }

        public Builder apiToken(String apiToken) {

            this.apiToken = apiToken;
            return this;
        }

        public Builder connectTimeout(int connectTimeout) {

            this.connectTimeout = connectTimeout;
            return this;
        }

        public Builder readTimeout(int readTimeout) {

            this.readTimeout = readTimeout;
            return this;
        }

        public Builder httpClient(OkHttpClient httpClient) {

            this.httpClient = httpClient;
            return this;
        }

        public Builder defaultHttpClient() {

            OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();

            try {
                final TrustManager[] trustAllCerts = new TrustManager[] {new OmiliaTrustManager()};
                final SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

                httpBuilder.sslSocketFactory(sslContext.getSocketFactory(),
                        (X509TrustManager) trustAllCerts[0])
                        .hostnameVerifier(new HostnameVerifier() {

                            @Override
                            public boolean verify(String hostname, SSLSession session) {

                                return true;
                            }
                        });
            } catch (NoSuchAlgorithmException | KeyManagementException e) {
                logger.error("Failed to initialize SSL. Reason: {}", ExceptionUtils.getStackTrace(e));
            }

            this.httpClient = httpBuilder
                    .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                    .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                    .build();
            return this;
        }

        public DiamantChannelsClient build() {

            if (httpClient == null) {
                defaultHttpClient();
            }

            return new DiamantChannelsClient(this);
        }
    }

    // static public
    public static Builder builder() {

        return new Builder();
    }

    // inner class
    private static class OmiliaTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
                String authType) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
                String authType) throws CertificateException {

        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {

            return new java.security.cert.X509Certificate[] {};
        }
    }
}