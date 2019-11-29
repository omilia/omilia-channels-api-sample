package com.omilia.channels.commons.model.asr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlElement;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeepAsrInstance {

    // NOTE: DONT CHANGE JSON NAMES. DIAMANT NEEDS THEM AS IS

    // attributes
    @JsonProperty("SWI_literalTimings")
    @XmlElement(name = "SWI_literalTimings")
    private SwiLiteralTimings swiLiteralTimings;
}
