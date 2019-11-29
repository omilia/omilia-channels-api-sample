package com.omilia.channels.commons.exceptions;

public class InvalidRequestException extends Exception {

    // constructors
    public InvalidRequestException(String message) {

        super(message);
    }

    public InvalidRequestException(String message, Throwable cause) {

        super(message, cause);
    }
}
