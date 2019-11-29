package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AsrInfo {

    // attributes
    @JsonProperty("omrtsp")
    public String omrtsp;

    @JsonProperty("dialogId")
    public String dialogId;

    @JsonProperty("app")
    public String app;

    @JsonProperty("step")
    public int step;

    @JsonProperty("cctype")
    public String cctype;

    @JsonProperty("bargedIn")
    public String bargedIn;

    @JsonProperty("userNoInputTime")
    public int userNoInputTime;

    @JsonProperty("promptDuration")
    public int promptDuration;

    @JsonProperty("speechDuration")
    public int speechDuration;

    @JsonProperty("recProcessTime")
    public int recProcessTime;

    @JsonProperty("recLatency")
    public int recLatency;

    @JsonProperty("recPostDelay")
    public int recPostDelay;

    @JsonProperty("mrcpSessionId")
    public String mrcpSessionId;

    @JsonProperty("logResult")
    public boolean logResult;

    @JsonProperty("prunned")
    public boolean prunned;

    @JsonProperty("recInputMode")
    public String recInputMode;

    @JsonProperty("mrsUri")
    public String mrsUri;

    @JsonProperty("vadUri")
    public String vadUri;

    @JsonProperty("recUri")
    public String recUri;

    @JsonProperty("ccause")
    public String ccause;

    @JsonProperty("audiourl")
    public String audiourl;

    @JsonProperty("result")
    public String result;
}
