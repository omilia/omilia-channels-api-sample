package com.omilia.channels.utils;

import java.util.Collection;

public class Preconditions {

    // constructors
    private Preconditions() {

        super();
    }

    // public static
    public static boolean isNotNull(Object value) {

        return value != null;
    }

    public static boolean isValue(String value) {

        return value != null && !value.trim().isEmpty();
    }

    public static <T> T argumentNotNull(T argument, String parameterName) {

        if (argument == null) {
            throw new IllegalArgumentException("Parameter \"" + parameterName
                    + "\" cannot be null");
        }

        return argument;
    }

    public static <T> T argumentIsValue(T argument, String parameterName) {

        argumentNotNull(argument, parameterName);
        String value = argument.toString();

        if (value.trim().isEmpty()) {

            if (argument instanceof String) {
                throw new IllegalArgumentException("Parameter \"" + parameterName
                        + "\" cannot be an empty string");
            } else {
                throw new IllegalArgumentException("Parameter \"" + parameterName
                        + "\".toString() cannot be an empty string");
            }
        }

        return argument;
    }

    public static String lengthGreaterThan(String argument, int length, String parameterName) {

        argumentNotNull(argument, parameterName);

        if (argument.length() <= length) {
            throw new IllegalArgumentException("Parameter \"" + parameterName
                    + "\" must be longer than " + length + " characters");
        }

        return argument;
    }

    public static String lengthGreaterThanOrEqual(String argument, int length, String parameterName) {

        argumentNotNull(argument, parameterName);

        if (argument.length() < length) {
            throw new IllegalArgumentException("Parameter \"" + parameterName
                    + "\" must be at least " + length + " characters long");
        }

        return argument;
    }

    public static String lengthLessThan(String argument, int length, String parameterName) {

        argumentNotNull(argument, parameterName);

        if (argument.length() >= length) {
            throw new IllegalArgumentException("Parameter \"" + parameterName
                    + "\" must be no less than " + length + " characters long");
        }

        return argument;
    }

    public static String lengthLessThanOrEqual(String argument, int length, String parameterName) {

        argumentNotNull(argument, parameterName);

        if (argument.length() > length) {
            throw new IllegalArgumentException("Parameter \"" + parameterName
                    + "\" must be no more than " + length + " characters long");
        }

        return argument;
    }

    public static <T extends Collection<?>> T collectionNotEmpty(T argument, String parameterName) {

        argumentNotNull(argument, "parameterName");

        if (argument.isEmpty()) {
            throw new IllegalArgumentException("Parameter \"" + parameterName
                    + "\" cannot be an empty collection");
        }

        return argument;
    }

    public static <T extends Collection<?>> T collectionItemsNotNull(T argument, String parameterName) {

        Preconditions.argumentNotNull(argument, "parameter");

        int i = 0;
        for (Object item : argument) {
            Preconditions.argumentNotNull(item, parameterName + "[" + i + "]");
            i++;
        }

        return argument;
    }

    public static <T extends Collection<?>> T collectionItemsAreValues(T argument, String parameterName) {

        Preconditions.argumentNotNull(argument, "parameter");

        int i = 0;
        for (Object item : argument) {
            Preconditions.argumentIsValue(item, parameterName + "[" + i + "]");
            i++;
        }

        return argument;
    }

    private static void valueGreaterThanError(Object argument, Object value, String parameterName) {

        throw new IllegalArgumentException("Parameter \"" + parameterName
                + "\" value [" + argument + "] must be greater than [" + value + "]");
    }

    public static Byte valueGreaterThan(Byte argument, Byte value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument <= value) {
            valueGreaterThanError(argument, value, parameterName);
        }

        return argument;
    }

    public static Double valueGreaterThan(Double argument, Double value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument <= value) {
            valueGreaterThanError(argument, value, parameterName);
        }

        return argument;
    }

    public static Float valueGreaterThan(Float argument, Float value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument <= value) {
            valueGreaterThanError(argument, value, parameterName);
        }

        return argument;
    }

    public static Integer valueGreaterThan(Integer argument, Integer value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument <= value) {
            valueGreaterThanError(argument, value, parameterName);
        }

        return argument;
    }

    public static Long valueGreaterThan(Long argument, Long value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument <= value) {
            valueGreaterThanError(argument, value, parameterName);
        }

        return argument;
    }

    public static Short valueGreaterThan(Short argument, Short value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument <= value) {
            valueGreaterThanError(argument, value, parameterName);
        }

        return argument;
    }

    private static void valueGreaterThanOrEqualError(Object argument, Object value, String parameterName) {

        throw new IllegalArgumentException("Parameter \"" + parameterName
                + "\" value [" + argument + "] must be greater than or equal to ["
                + value + "]");
    }

    public static Byte valueGreaterThanOrEqual(Byte argument, Byte value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument < value) {
            valueGreaterThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    public static Double valueGreaterThanOrEqual(Double argument, Double value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument < value) {
            valueGreaterThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    public static Float valueGreaterThanOrEqual(Float argument, Float value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument < value) {
            valueGreaterThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    public static Integer valueGreaterThanOrEqual(Integer argument, Integer value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument < value) {
            valueGreaterThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    public static Long valueGreaterThanOrEqual(Long argument, Long value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument < value) {
            valueGreaterThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    public static Short valueGreaterThanOrEqual(Short argument, Short value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".min");

        if (argument < value) {
            valueGreaterThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    private static void valueLessThanError(Object argument, Object value, String parameterName) {

        throw new IllegalArgumentException("Parameter \"" + parameterName
                + "\" value [" + argument + "] must be less than [" + value + "]");
    }

    public static Byte valueLessThan(Byte argument, Byte value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument >= value) {
            valueLessThanError(argument, value, parameterName);
        }

        return argument;
    }

    public static Double valueLessThan(Double argument, Double value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument >= value) {
            valueLessThanError(argument, value, parameterName);
        }

        return argument;
    }

    public static Float valueLessThan(Float argument, Float value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument >= value) {
            valueLessThanError(argument, value, parameterName);
        }

        return argument;
    }

    public static Integer valueLessThan(Integer argument, Integer value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument >= value) {
            valueLessThanError(argument, value, parameterName);
        }

        return argument;
    }

    public static Long valueLessThan(Long argument, Long value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument >= value) {
            valueLessThanError(argument, value, parameterName);
        }

        return argument;
    }

    public static Short valueLessThan(Short argument, Short value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument >= value) {
            valueLessThanError(argument, value, parameterName);
        }

        return argument;
    }

    private static void valueLessThanOrEqualError(Object argument, Object value, String parameterName) {

        throw new IllegalArgumentException("Parameter \"" + parameterName
                + "\" value [" + argument + "] must be less than or equal to ["
                + value + "]");
    }

    public static Byte valueLessThanOrEqual(Byte argument, Byte value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument > value) {
            valueLessThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    public static Double valueLessThanOrEqual(Double argument, Double value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument > value) {
            valueLessThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    public static Float valueLessThanOrEqual(Float argument, Float value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument > value) {
            valueLessThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    public static Integer valueLessThanOrEqual(Integer argument, Integer value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument > value) {
            valueLessThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    public static Long valueLessThanOrEqual(Long argument, Long value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument > value) {
            valueLessThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }

    public static Short valueLessThanOrEqual(Short argument, Short value, String parameterName) {

        argumentNotNull(argument, parameterName);
        argumentNotNull(value, parameterName + ".max");

        if (argument > value) {
            valueLessThanOrEqualError(argument, value, parameterName);
        }

        return argument;
    }
}