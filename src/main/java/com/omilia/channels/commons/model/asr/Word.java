package com.omilia.channels.commons.model.asr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Word {

    // NOTE: DONT CHANGE JSON NAMES. DIAMANT NEEDS THEM AS IS

    // attributes
    @JsonProperty("start")
    private String start;

    @JsonProperty("end")
    private String end;

    @JsonProperty("confidence")
    private String confidence;

    @JsonProperty("word")
    private String word;

    // properties
    @JsonIgnore
    public String getStart() {

        return start;
    }

    @JsonIgnore
    @XmlAttribute(name = "start")
    public void setStart(String start) {

        this.start = start;
    }

    @JsonIgnore
    public String getEnd() {

        return end;
    }

    @JsonIgnore
    @XmlAttribute(name = "end")
    public void setEnd(String end) {

        this.end = end;
    }

    @JsonIgnore
    public String getConfidence() {

        return confidence;
    }

    @JsonIgnore
    @XmlAttribute(name = "confidence")
    public void setConfidence(String confidence) {

        this.confidence = confidence;
    }

    @JsonIgnore
    public String getWord() {

        return word;
    }

    @JsonIgnore
    @XmlValue
    public void setWord(String word) {

        this.word = word;
    }
}
