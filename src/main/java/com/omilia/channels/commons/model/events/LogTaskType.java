package com.omilia.channels.commons.model.events;

public enum LogTaskType {

    SELF_SERVE("selfServe"),
    AUTHENTICATION("authentication"),
    HAND_OFF("handOff"),
    ROUTE_OUT("routeOut"),
    FORCED_SERVICE("forcedService"),
    OFFER("offer");

    private String value;

    LogTaskType(String value) {

        this.value = value;
    }

    public String getValue() {

        return value;
    }
}
