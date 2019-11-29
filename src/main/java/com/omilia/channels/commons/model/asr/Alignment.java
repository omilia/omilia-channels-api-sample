package com.omilia.channels.commons.model.asr;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Alignment {

    // NOTE: DONT CHANGE JSON NAMES. DIAMANT NEEDS THEM AS IS

    // attributes
    @JsonProperty("type")
    private String type;

    @JsonProperty("unit_msecs")
    private String unitmsecs;

    @JsonProperty("word")
    private List<Word> wordList;

    // constructors
    public Alignment() {

        this.wordList = new ArrayList<>();
    }

    // properties
    @JsonIgnore
    @XmlAttribute(name = "type")
    public String getType() {

        return type;
    }

    @JsonIgnore
    public void setType(String type) {

        this.type = type;
    }

    @JsonIgnore
    @XmlAttribute(name = "unit_msecs")
    public String getUnitmsecs() {

        return unitmsecs;
    }

    @JsonIgnore
    public void setUnitmsecs(String unitmsecs) {

        this.unitmsecs = unitmsecs;
    }

    @JsonIgnore
    public List<Word> getWordList() {

        return wordList;
    }

    @JsonIgnore
    @XmlElement(name = "word")
    public void setWordList(List<Word> wordList) {

        this.wordList = wordList;
    }
}
