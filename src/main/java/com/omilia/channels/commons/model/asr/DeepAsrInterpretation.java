package com.omilia.channels.commons.model.asr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeepAsrInterpretation {

    // NOTE: DONT CHANGE JSON NAMES. DIAMANT NEEDS THEM AS IS

    // attributes
    @JsonProperty("input")
    private DeepAsrInput input;

    @JsonProperty("instance")
    private DeepAsrInstance instance;

    @JsonProperty("grammar")
    private String grammar;

    @JsonProperty("confidence")
    private String confidence;

    @JsonProperty("grName")
    private String grName;

    @JsonProperty("rawConf")
    private String rawConf;

    @JsonProperty("amConf")
    private String amConf;

    @JsonProperty("lmConf")
    private String lmConf;

    // constructors
    public DeepAsrInterpretation() {

        this.input = new DeepAsrInput();
    }

    // properties
    @JsonIgnore
    @XmlElement(name = "input")
    public void setInput(DeepAsrInput input) {

        this.input = input;
    }

    @JsonIgnore
    @XmlElement(name = "instance")
    public void setInstance(DeepAsrInstance instance) {

        this.instance = instance;
    }

    @JsonIgnore
    @XmlAttribute(name = "grammar")
    public void setGrammar(String grammar) {

        this.grammar = grammar;
    }

    @JsonIgnore
    @XmlAttribute(name = "confidence")
    public void setConfidence(String confidence) {

        this.confidence = confidence;
    }

    @JsonIgnore
    @XmlAttribute(name = "grName")
    public void setGrName(String grName) {

        this.grName = grName;
    }

    @JsonIgnore
    @XmlAttribute(name = "rawConf")
    public void setRawConf(String rawConf) {

        this.rawConf = rawConf;
    }

    @JsonIgnore
    @XmlAttribute(name = "amConf")
    public void setAmConf(String amConf) {

        this.amConf = amConf;
    }

    @JsonIgnore
    @XmlElement(name = "lmConf")
    public void setLmConf(String lmConf) {

        this.lmConf = lmConf;
    }

    // public
    @JsonIgnore
    public boolean isDTMF() {

        if (this.input != null) {
            if (this.input.getMode() != null && this.input.getMode().equals("dtmf")) {
                return true;
            }
        }
        return false;
    }

    @JsonIgnore
    public boolean isSpeech() {

        if (this.input != null) {
            if (this.input.getMode() != null && this.input.getMode().equals("speech")) {
                return true;
            }
        }
        return false;
    }
}
