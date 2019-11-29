package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DialogMetaData {

    @JsonProperty("no_inputs")
    private int noInputCnt;

    @JsonProperty("no_matches")
    private int noMatchCnt;

    @JsonProperty("duration")
    private long duration;

    @JsonProperty("app_version")
    private long appVersion;

    @JsonProperty("dialog_timestamp")
    private long dialogTimestamp;

    @JsonProperty("app")
    private String app;

    @JsonProperty("end_type")
    private String endType;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("origin_uri")
    private String originUri;

    @JsonProperty("device_type")
    private String deviceType;

    @JsonProperty("connection_id")
    private String connectionId;

    @JsonProperty("diamant_version")
    private String diamantVersion;

    @JsonProperty("destination_uri")
    private String destinationUri;

    @JsonProperty("diamant_instance")
    private String diamantInstance;

    @JsonProperty("dialog_direction")
    private String dialogDirection;

    @JsonProperty("hashed_origin_uri")
    private String hashedOriginUri;
}
