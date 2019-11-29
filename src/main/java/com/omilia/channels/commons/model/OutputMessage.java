package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OutputMessage {

    // attributes
    private int index;

    @JsonProperty("header")
    private String header;

    @JsonProperty("details")
    private String details;

    @Setter
    @JsonProperty("image")
    private Image image;

    @JsonProperty("coordinates")
    private String coordinates;

    @JsonProperty("interactive_option")
    private List<InteractiveOption> interactiveOptions;

    @JsonProperty("payload")
    private JsonNode payload;

    // static
    public static Builder builder() {

        return new Builder();
    }

    // constructors
    public OutputMessage() {

        this.interactiveOptions = new ArrayList<>();
    }

    private OutputMessage(Builder builder) {

        this.details = builder.details;
        this.header = builder.header;
        this.image = builder.image;
        this.interactiveOptions = builder.interactiveOptions;
        this.index = builder.index;
    }

    // public
    @JsonIgnore
    public boolean hasCoordinates() {

        return !StringUtils.isEmpty(coordinates);
    }

    @JsonIgnore
    public String getImageUrl() {

        if (image == null) {
            return null;
        }

        return image.getUrl();
    }

    // builder
    public static class Builder {

        // attributes
        private int index;
        private String header = "";
        private String details = "";
        private Image image;
        private List<InteractiveOption> interactiveOptions;

        // public
        public Builder index(int index) {

            this.index = index;
            return this;
        }

        public Builder header(String header) {

            this.header = header;
            return this;
        }

        public Builder details(String details) {

            this.details = details;
            return this;
        }

        public Builder image(Image image) {

            this.image = image;
            return this;
        }

        public Builder interactiveOptions(List<InteractiveOption> interactiveOptions) {

            this.interactiveOptions = interactiveOptions;
            return this;
        }

        public OutputMessage build() {

            return new OutputMessage(this);
        }
    }
}
