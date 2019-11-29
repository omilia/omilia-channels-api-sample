package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omilia.channels.commons.model.action.DataModel;
import com.omilia.channels.commons.model.action.PromptModel;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    // attributes
    @JsonProperty("prompts")
    private List<PromptModel> prompts;

    @JsonProperty("data_model")
    private DataModel dataModel;

    // constructors
    public Message() {

        this.prompts = new ArrayList<>();
    }
}
