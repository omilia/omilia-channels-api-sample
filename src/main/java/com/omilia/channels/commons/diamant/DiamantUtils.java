package com.omilia.channels.commons.diamant;

import com.omilia.channels.commons.requests.SendMessageRequest;
import com.omilia.channels.commons.requests.StartDialogRequest;

public final class DiamantUtils {

    // constructors
    private DiamantUtils() {

    }

    // public static
    public static String getAni(StartDialogRequest request) {

        if (request == null) {
            return null;
        }

        if (request.user == null) {
            return null;
        }

        return request.user.fullname;
    }

    public static String getAni(SendMessageRequest request) {

        if (request == null) {
            return null;
        }

        if (request.getUser() == null) {
            return null;
        }

        return request.getUser().fullname;
    }

    public static String getNormalizedPrompt(String prompt) {

        return prompt.replace("[1P]", " ")
                .replace("[MP]", " ")
                .replace("[SP]", " ")
                .replaceAll("\\[MSG[^]]*\\]", " ")
                .replace("[EP]", " ")
                .replace("\\'", "'")
                .replace("\\n", "\n")
                .replaceFirst("-listItem-", ":")
                .replace("-listItem-", "\n")
                .replace("  ", " ")
                .replace("  ", " ")
                .trim();
    }
}
