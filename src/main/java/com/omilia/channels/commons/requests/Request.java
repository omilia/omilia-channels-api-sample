package com.omilia.channels.commons.requests;

import com.omilia.channels.commons.exceptions.InvalidRequestException;

public abstract class Request {

    // constructors
    public Request() {

    }

    // abstract
    public abstract void validate() throws InvalidRequestException;
}