package com.omilia.channels.commons.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    // attributes
    @JsonProperty
    public final boolean success;

    // constructors
    public Response(boolean success) {

        this.success = success;
    }
}
