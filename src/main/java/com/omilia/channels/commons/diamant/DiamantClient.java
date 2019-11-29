package com.omilia.channels.commons.diamant;

import com.omilia.channels.commons.exceptions.CriticalErrorException;
import com.omilia.channels.commons.exceptions.InvalidDialogException;
import com.omilia.channels.commons.requests.SendMessageRequest;
import com.omilia.channels.commons.requests.StartDialogRequest;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public abstract class DiamantClient {

    // constants
    protected static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    //attributes
    protected String diamantUrl;
    protected OkHttpClient httpClient;

    // abstract
    /**
     * Start a new dialog.
     *
     * @param request StarDialogRequest
     * @return DiamantResponse
     * @throws IOException
     * @throws InvalidDialogException
     * @throws CriticalErrorException
     */
    public abstract DiamantResponse startDialog(StartDialogRequest request) throws IOException, InvalidDialogException, CriticalErrorException;

    /**
     *
     * @param request
     * @return DiamantResponse
     * @throws IOException
     * @throws InvalidDialogException
     * @throws CriticalErrorException
     */
    public abstract DiamantResponse sendMessage(SendMessageRequest request) throws IOException, InvalidDialogException, CriticalErrorException;

    /**
     *
     * @param applicationId The application name
     * @param dialogId
     * @return DiamantResponse
     * @throws IOException
     * @throws InvalidDialogException
     * @throws CriticalErrorException
     */
    public abstract DiamantResponse sendHangUp(String applicationId, String dialogId) throws IOException, InvalidDialogException, CriticalErrorException;

}
