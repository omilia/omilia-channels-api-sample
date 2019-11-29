package com.omilia.channels.commons.exceptions;

public class ReloadFailureException extends Exception {

    // constructors
    public ReloadFailureException(String message) {

        super(message);
    }

    public ReloadFailureException(String message, Throwable cause) {

        super(message, cause);
    }
}
