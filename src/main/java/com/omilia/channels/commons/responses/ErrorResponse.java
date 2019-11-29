package com.omilia.channels.commons.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse extends Response {

    // constants
    private static final String DEFAULT_ERROR_MESSAGE = "generic_error";

    // attributes
    @JsonProperty("error_message")
    public String errorMessage;

    // constructors
    public ErrorResponse() {

        this(DEFAULT_ERROR_MESSAGE);
    }

    public ErrorResponse(String errorMessage) {

        super(false);
        this.errorMessage = errorMessage;
    }
}
