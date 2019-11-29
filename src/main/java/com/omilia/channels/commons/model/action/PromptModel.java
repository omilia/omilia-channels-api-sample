package com.omilia.channels.commons.model.action;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromptModel {

    // attributes
    @JsonProperty("content")
    private String content;

    @JsonProperty("voice")
    private boolean voice;

    @JsonProperty("visualize")
    private boolean visualize;

    @JsonProperty("prompt_urls")
    private List<String> promptUrls;

    // constructors
    public PromptModel() {

        this.content = "";
        this.voice = true;
        this.visualize = true;
    }

    public PromptModel(Builder builder) {

        this.content = builder.content;
        this.voice = builder.voice;
        this.visualize = builder.visualize;
        this.promptUrls = builder.promptUrls;
    }

    public static class Builder {

        private String content = "";
        private boolean voice = true;
        private boolean visualize = true;
        private List<String> promptUrls = new ArrayList<>();

        public Builder content(String content) {

            this.content = content;
            return this;
        }

        public Builder voice(boolean voice) {

            this.voice = voice;
            return this;
        }

        public Builder visualize(boolean visualize) {

            this.visualize = visualize;
            return this;
        }

        public Builder prompUrls(List<String> promptUrls) {

            this.promptUrls = promptUrls;
            return this;
        }

        public PromptModel build() {

            return new PromptModel(this);
        }
    }
}
