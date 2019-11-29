package com.omilia.channels.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Json {

    public static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.setSerializationInclusion(Include.NON_EMPTY);
    }

    public static String encode(Object obj) throws IOException {

        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new IOException("Failed to encode as JSON: " + e.getMessage());
        }
    }

    public static <T> T decodeValue(String str, Class<T> clazz) throws IOException {

        try {
            return mapper.readValue(str, clazz);
        } catch (Exception e) {
            throw new IOException("Failed to decode: " + e.getMessage());
        }
    }

    public static <T> T decodeValue(String str, TypeReference<T> type) throws IOException {

        try {
            return mapper.readValue(str, type);
        } catch (Exception e) {
            throw new IOException("Failed to decode: " + e.getMessage(), e);
        }
    }
}
