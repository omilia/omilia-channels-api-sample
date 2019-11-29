package com.omilia.channels.commons.exceptions;

public class CriticalErrorException extends Exception {

    // constructors
    public CriticalErrorException() {

        super();
    }

    public CriticalErrorException(String message) {

        super(message);
    }

    public CriticalErrorException(String message, Throwable cause) {

        super(message, cause);
    }
}

