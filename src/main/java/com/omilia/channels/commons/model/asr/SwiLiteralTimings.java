package com.omilia.channels.commons.model.asr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlElement;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwiLiteralTimings {

    // attributes
    @JsonProperty("alignment")
    private Alignment alignment;

    // properties
    @JsonIgnore
    public Alignment getAlignment() {

        return alignment;
    }

    @JsonIgnore
    @XmlElement(name = "alignment")
    public void setAlignment(Alignment alignment) {

        this.alignment = alignment;
    }
}
