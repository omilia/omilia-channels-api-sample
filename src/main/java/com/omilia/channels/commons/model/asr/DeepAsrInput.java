package com.omilia.channels.commons.model.asr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeepAsrInput {

    // NOTE: DONT CHANGE JSON NAMES. DIAMANT NEEDS THEM AS IS

    // attributes
    @JsonProperty("mode")
    private String mode = "";

    @JsonProperty("utterance")
    private String utterance = "";

    // properties
    @JsonIgnore
    @XmlValue
    public void setUtterance(String utterance) {

        this.utterance = utterance;
    }

    @JsonIgnore
    @XmlAttribute(name = "mode")
    public void setMode(String mode) {

        this.mode = mode;
    }
}
