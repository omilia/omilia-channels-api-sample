package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityInstance {

    // attributes
    @JsonProperty("value")
    private String value;

    @JsonProperty("begin")
    private int begin;

    @JsonProperty("end")
    private int end;

    @JsonProperty("confidence")
    private float confidence;

    @JsonProperty("covered_text")
    private String coveredText;

    @JsonProperty("features")
    private Map<String, String> features;

    // constructors
    public EntityInstance() {

        this.features = new HashMap<>();
    }
}
