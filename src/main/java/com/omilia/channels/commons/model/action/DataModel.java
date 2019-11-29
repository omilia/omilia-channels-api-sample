package com.omilia.channels.commons.model.action;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omilia.channels.commons.model.Column;
import com.omilia.channels.commons.model.Coordinates;
import com.omilia.channels.commons.model.Image;
import com.omilia.channels.commons.model.InteractiveOption;
import com.omilia.channels.commons.model.OutputMessage;
import com.omilia.channels.commons.model.Record;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataModel {

    // attributes
    @JsonProperty("type")
    private String type;

    @JsonProperty("subtype")
    private String subtype;

    @JsonProperty("direction")
    private String direction;

    @JsonProperty("template_name")
    private String templateName;

    @JsonProperty("title")
    private String title;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("tip")
    private String tip;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("coordinates")
    private Coordinates coordinates;

    @JsonProperty("interactive_option")
    private List<InteractiveOption> interactiveOptions;

    @JsonProperty("entries")
    private List<OutputMessage> entries;

    @JsonProperty("columns")
    private List<Column> columns;

    @JsonProperty("records")
    private List<Record> records;

    // constructors
    private DataModel() {

        this.interactiveOptions = new ArrayList<>();
        this.entries = new ArrayList<>();
        this.columns = new ArrayList<>();
        this.records = new ArrayList<>();
    }

    // public
    @JsonIgnore
    public String getImageUrl() {

        if (image == null) {
            return null;
        }

        return image.getUrl();
    }
}
