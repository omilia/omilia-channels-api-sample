package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChannelContext {

    // attributes
    @JsonProperty("semantics")
    private Map<String, String> semantics;

    @JsonProperty("asr_info")
    private AsrInfo asrInfo;

    // constructors
    public ChannelContext() {

        this.semantics = new HashMap<>();
    }

    // public
    public void addSemantic(String key, String value) {

        semantics.put(key, value);
    }
}