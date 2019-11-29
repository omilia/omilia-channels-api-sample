package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AsrData {

    // attributes
    @JsonProperty("rec_start")
    private long recStart;

    @JsonProperty("speech_start")
    private long speechStart;

    @JsonProperty("speech_duration")
    private long speechDuration;

    @JsonProperty("prompt_timeout")
    private long promptTimeout;


}
