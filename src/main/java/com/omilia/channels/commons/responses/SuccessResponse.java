package com.omilia.channels.commons.responses;

public class SuccessResponse extends Response {

    // constants
    private static final String DEFAULT_MESSAGE = "success";

    // attributes
    public final String message;

    // constructors
    public SuccessResponse() {

        this(DEFAULT_MESSAGE);
    }

    public SuccessResponse(String message) {

        super(true);
        this.message = message;
    }
}
