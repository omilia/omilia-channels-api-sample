package com.omilia.channels.utils;

import org.apache.commons.lang3.StringUtils;

public final class PromptUtils {

    // public static
    public static String normalize(String prompt) {

        if (StringUtils.isEmpty(prompt)) {
            return prompt;
        }

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
