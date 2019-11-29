package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Target {

    // attributes
    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    // constructors
    public Target() {

    }
}
