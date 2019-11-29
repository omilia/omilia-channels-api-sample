package com.omilia.channels.commons.model.events;

public enum LogStatus {

    INITIATED("initiated"),
    COMPLETED("completed"),
    FAILED("failed"),
    NONE("");

    private String value;

    LogStatus(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }
}
