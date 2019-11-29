package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Intent {

    // attributes
    @JsonProperty("name")
    private String name;

    @JsonProperty("log_name")
    private String logName;

    @JsonProperty("status")
    private String status;

    // constructors
    public Intent() {

    }
}
