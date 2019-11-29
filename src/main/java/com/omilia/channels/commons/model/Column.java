package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Column {

    // attributes
    private int index;

    private String name;

    private String label;
}
