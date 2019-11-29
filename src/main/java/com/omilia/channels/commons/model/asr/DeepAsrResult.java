package com.omilia.channels.commons.model.asr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "result")
public class DeepAsrResult {

    // NOTE: DONT CHANGE JSON NAMES. DIAMANT NEEDS THEM AS IS

    //attributes
    @JsonProperty("interpretations")
    private List<DeepAsrInterpretation> interpretation;

    // constructors
    public DeepAsrResult() {

        this.interpretation = new ArrayList<>();
    }

    // properties
    @JsonIgnore
    public List<DeepAsrInterpretation> getInterpretation() {

        return interpretation;
    }

    @JsonIgnore
    @XmlElement(name = "interpretation")
    public void setInterpretation(List<DeepAsrInterpretation> interpretation) {

        this.interpretation = interpretation;
    }

    // public
    @JsonIgnore
    public boolean isDTMF() {

        return this.interpretation != null
                && !this.interpretation.isEmpty()
                && this.interpretation.get(0).isDTMF();
    }

    @JsonIgnore
    public boolean isSpeech() {

        return this.interpretation != null
                && !this.interpretation.isEmpty()
                && this.interpretation.get(0).isSpeech();
    }
}
