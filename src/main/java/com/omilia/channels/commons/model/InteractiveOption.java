package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InteractiveOption {

    // attributes
    @JsonProperty("semantics")
    private Map<String, String> semantics;

    @JsonProperty("label")
    private String label;

    @JsonProperty("selection_text")
    private String selectionText;

    @JsonProperty("url")
    private String url;

    private Image image;

    @Setter
    @JsonIgnore
    private String referralUrl;

    // constructors
    public InteractiveOption() {

    }

    private InteractiveOption(Builder builder) {

        this.semantics = builder.semantics;
        this.label = builder.label;
        this.selectionText = builder.selectionText;
        this.url = builder.url;
        this.image = builder.image;
    }

    // public
    public boolean isUrl() {

        return !StringUtils.isEmpty(url);
    }

    public boolean isCall() {

        return (!StringUtils.isEmpty(url) && url.startsWith("tel://"));
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
        private Map<String, String> semantics = new HashMap<>();
        private String label = "";
        private String selectionText = "";
        private String url = "";
        private Image image = null;

        // public
        public Builder semantics(Map<String, String> semantics) {

            this.semantics = semantics;
            return this;
        }

        public Builder label(String label) {

            this.label = label;
            return this;
        }

        public Builder selectionText(String selectionText){
            this.selectionText = selectionText;
            return this;
        }

        public Builder url(String url) {

            this.url = url;
            return this;
        }

        public Builder image(Image image) {

            this.image = image;
            return this;
        }

        public InteractiveOption build() {

            return new InteractiveOption(this);
        }
    }
}
