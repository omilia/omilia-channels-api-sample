package com.omilia.channels.commons.diamant;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omilia.channels.commons.model.Field;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DiamantResponse {

    // attributes
    @JsonProperty("dialogId")
    protected String dialogId;

    @JsonProperty("app")
    protected String app;

    @JsonProperty("step")
    protected int step = 0;

    @JsonProperty("prompt")
    protected String prompt = "";

    @JsonProperty("utterance")
    protected String utterance = "";

    @JsonProperty("server")
    protected String server;

    @JsonProperty("version")
    protected String version;

    // abstract

    /**
     * Check if the dialog has completed with transfer.
     */
    public abstract boolean hasDialogTransferred();

    /**
     * Check if the dialog has completed with normal exit.
     */
    public abstract boolean hasDialogExited();

    /**
     * Check if the dialog has completed (either with transfer or normal exit).
     */
    public abstract boolean hasDialogEnded();

    @JsonIgnore
    public abstract boolean isAnnouncement();

    @JsonIgnore
    public abstract String getIntent();

    @JsonIgnore
    public abstract String getActionType();

    @JsonIgnore
    public abstract List<Field> getFieldsToElicit();
}
