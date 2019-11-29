package com.omilia.channels.utils;

import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringJoinerUtils {

    public static void addIfNotEmpty(StringJoiner stringJoiner, String value) {

        if (StringUtils.isEmpty(value)) {
            return;
        }

        stringJoiner.add(value);
    }
}
