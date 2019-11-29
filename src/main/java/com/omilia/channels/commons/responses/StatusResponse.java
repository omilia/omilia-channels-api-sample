package com.omilia.channels.commons.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omilia.channels.commons.DiamantApp;
import java.util.ArrayList;
import java.util.List;

public class StatusResponse extends Response {

    // constants
    protected static final String DEFAULT_MESSAGE = "Service is operating normally";

    // attributes
    public final String message;

    public final String version;

    @JsonProperty("diamant_apps")
    public final List<DiamantApp> diamantApps;

    // constructors
    public StatusResponse(String version) {

        this(version, DEFAULT_MESSAGE, new ArrayList<>());
    }

    public StatusResponse(String version, String message) {

        this(version, message, new ArrayList<>());
    }

    public StatusResponse(String version, List<DiamantApp> diamantApps) {

        this(version, DEFAULT_MESSAGE, new ArrayList<>());
    }

    public StatusResponse(String version, String message, List<DiamantApp> diamantApps) {

        super(true);
        this.version = version;
        this.message = message;
        this.diamantApps = diamantApps;
    }
}
