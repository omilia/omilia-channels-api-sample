package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Image {

    // attributes
    @JsonProperty("label")
    private String label;

    @JsonProperty("url")
    private String url;

    // static
    public static Builder builder() {

        return new Builder();
    }

    // constructors
    public Image() {

        this.label = "";
        this.url = "";
    }

    private Image(Builder builder) {

        this.label = builder.label;
        this.url = builder.url;
    }

    // builder
    public static class Builder {

        // attributes
        private String label = "";
        private String url = "";

        // public
        public Builder label(String label) {

            this.label = label;
            return this;
        }

        public Builder url(String url) {

            this.url = url;
            return this;
        }

        public Image build() {

            return new Image(this);
        }
    }
}
