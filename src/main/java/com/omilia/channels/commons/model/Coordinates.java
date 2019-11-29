package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {

    // attributes
    @JsonProperty(value = "lat")
    private Double latitude;

    @JsonProperty(value = "long")
    private Double longitude;

    // public
    public String toString() {

        return latitude + "," + longitude;
    }
}
