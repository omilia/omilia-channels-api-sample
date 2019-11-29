package com.omilia.channels.commons.exceptions;

public class InvalidDialogException extends Exception {

    // constructors
    public InvalidDialogException() {

        super();
    }

    public InvalidDialogException(String message) {

        super(message);
    }

    public InvalidDialogException(String message, Throwable cause) {

        super(message, cause);
    }
}
