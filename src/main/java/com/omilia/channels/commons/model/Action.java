package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Action {

    // attributes
    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;
    //private ActionType type;

    @JsonProperty("subtype")
    private String subtype;

    @JsonProperty("action_log_event")
    private String actionLogEvent;

    @JsonProperty("fields_to_elicit")
    private List<Field> fieldsToElicit;

    //@JsonProperty("fieldsToConfirm")
    //private List<com.omilia.diamant.dialog.components.fields.Field> fieldsToConfirm;

    @JsonProperty("message")
    private Message message;

    @JsonProperty("tag")
    private String tag;

    // constructors
    public Action() {

        this.fieldsToElicit = new ArrayList<>();
        //this.fieldsToConfirm = new ArrayList<>();
    }
}
