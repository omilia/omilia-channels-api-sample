package com.omilia.channels;

import com.omilia.channels.commons.DiamantConfig;
import com.omilia.channels.commons.DiamantParamsConfig;
import com.omilia.channels.commons.diamant.DiamantClient;
import com.omilia.channels.commons.diamant.DiamantClientFactory;
import com.omilia.channels.commons.diamant.DiamantResponse;
import com.omilia.channels.commons.exceptions.CriticalErrorException;
import com.omilia.channels.commons.exceptions.InvalidDialogException;
import com.omilia.channels.commons.model.ChannelContext;
import com.omilia.channels.commons.model.User;
import com.omilia.channels.commons.requests.SendMessageRequest;
import com.omilia.channels.commons.requests.StartDialogRequest;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class MainExample {

    // main
    public static void main(String[] args) throws Exception {

        // customer info
        User user = new User.Builder()
                .userId("userId123")
                .firstName("John")
                .lastName("Smith")
                .fullname("John Smith")
                .email("jsmith@omilia.com")
                .build();

        // set-up DiaManT client
        String baseUrl = "Base-URL"; //ex. https://demo.omilia.com:8444
        String app = "DiaManT - application name"; //ex. ABC.Bank
        String apiToken = "API-Token";
        String dmtDialogSource = "chat"; // ex. chat, fb

        DiamantParamsConfig params = new DiamantParamsConfig.Builder()
                .build();
        DiamantConfig dmtConfig = new DiamantConfig.Builder()
                .baseUrl(baseUrl)
                .app(app)
                .apiToken(apiToken)
                .params(params)
                .build();
        DiamantClient dmtClient = DiamantClientFactory.getDiamantClient(dmtConfig);

        // start a dialog
        DiamantResponse dmtResponse = startDialog(dmtClient, app, user, dmtDialogSource);
        String dialogId = dmtResponse.getDialogId();
        String welcomeMessage = dmtResponse.getPrompt();
        log.info("--- Welcome Message ---");
        log.info(welcomeMessage);

        // send message to DiaManT
        dmtResponse = sendMessage(dmtClient, app,
                user,
                params,
                dialogId,
                "What is my balance on my savings account?",
                null);
        log.info("--- DiaManT intent ---");
        log.info(dmtResponse.getIntent());
        log.info("--- DiaManT prompt ---");
        log.info(dmtResponse.getPrompt());

        // ending the dialog
        dmtClient.sendHangUp(app, dialogId);
    }

    // private static - DiaManT
    private static DiamantResponse startDialog(DiamantClient dmtClient, String dmtAppName, User user, String dmtDialogSource) throws InvalidDialogException, CriticalErrorException, IOException {

        log.info("Creating new dialog");
        StartDialogRequest startDialogRequest = StartDialogRequest.builder()
                .applicationId(dmtAppName)
                .user(user)
                .source(dmtDialogSource)
                .build();

        return dmtClient.startDialog(startDialogRequest);
    }

    private static DiamantResponse sendMessage(DiamantClient dmtClient, String dmtAppName, User user, DiamantParamsConfig params, String dialogId, String utterance, ChannelContext context) throws InvalidDialogException, CriticalErrorException, IOException {

        log.info("Sending message to DiaManT");
        String normalizedUtterance = utterance;
        if (params.getEnableLowercase() && !StringUtils.isEmpty(utterance)) {
            normalizedUtterance = utterance.toLowerCase();
        }

        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .applicationId(dmtAppName)
                .dialogId(dialogId)
                .utterance(normalizedUtterance)
                .context(context)
                .user(user)
                .build();

        return dmtClient.sendMessage(sendMessageRequest);
    }
}
