package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grammars {

    // attributes
    @JsonProperty("speech_grammar")
    private String speechGrammar;

    @JsonProperty("dtmf_grammar")
    private String dtmfGrammar;

    @JsonProperty("workflow_id")
    private String workflowId;
}
