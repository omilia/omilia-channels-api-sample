package com.omilia.channels.commons.diamant;

import com.omilia.channels.commons.DiamantConfig;
import com.omilia.channels.commons.DiamantParamsConfig;

public final class DiamantClientFactory {

    // constructors
    private DiamantClientFactory() {

    }

    // static
    public static DiamantClient getDiamantClient(DiamantConfig config) {

        return getDiamantClient(config.getBaseUrl(), config.getApp(), config.getApiToken(), config.getParams());
    }

    public static DiamantClient getDiamantClient(String diamantBaseUrl, String diamantApp, String apiToken, DiamantParamsConfig params) {

        return DiamantChannelsClient.builder()
                .baseUrl(diamantBaseUrl)
                .appName(diamantApp)
                .apiToken(apiToken)
                .connectTimeout(params.getConnectTimeout())
                .readTimeout(params.getReadTimeout())
                .build();
    }
}
