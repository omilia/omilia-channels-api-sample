package com.omilia.channels.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiamantApp {

    // attributes
    @JsonProperty
    private String id;

    @JsonProperty
    private String appName;

    @JsonProperty
    private String baseUrl;

    // constructors
    public DiamantApp() {

    }

    public DiamantApp(String id, String appName, String baseUrl) {

        this.id = id;
        this.appName = appName;
        this.baseUrl = baseUrl;
    }
}
