package com.omilia.channels.commons.requests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omilia.channels.commons.exceptions.InvalidRequestException;
import com.omilia.channels.commons.model.ChannelContext;
import com.omilia.channels.commons.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;

@Setter
@Getter
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class SendMessageRequest extends Request {

    // attributes
    private String dialogId;

    @JsonProperty("utterance")
    private String utterance;

    @JsonProperty("application_id")
    private String applicationId;

    @JsonProperty("source")
    public String source;

    @JsonProperty("context")
    private ChannelContext context;

    @JsonIgnore
    private User user;

    // constructors
    public SendMessageRequest() {

    }

    SendMessageRequest(Builder builder) {

        this.dialogId = builder.dialogId;
        this.utterance = builder.utterance;
        this.applicationId = builder.applicationId;
        this.source = builder.source;
        this.context = builder.context;
        this.user = builder.user;
    }

    // overrides
    @Override
    public void validate() throws InvalidRequestException {

        Validate.notEmpty(dialogId, "Empty dialogId");
        Validate.notEmpty(applicationId, "Application id is invalid.");
    }

    public static final class Builder {

        // attributes
        String dialogId;
        String utterance;
        String applicationId;
        String source;
        ChannelContext context;
        User user;

        // constructors
        public Builder() {

        }

        //
        public Builder dialogId(String dialogId) {

            this.dialogId = dialogId;
            return this;
        }

        public Builder utterance(String utterance) {

            this.utterance = utterance;
            return this;
        }

        public Builder applicationId(String applicationId) {

            this.applicationId = applicationId;
            return this;
        }

        public Builder source(String source) {

            this.source = source;
            return this;
        }

        public Builder context(ChannelContext context) {

            this.context = context;
            return this;
        }

        public Builder user(User user) {

            this.user = user;
            return this;
        }

        public Builder noinput() {

            this.utterance = "[noinput]";
            return this;
        }

        public SendMessageRequest build() {

            return new SendMessageRequest(this);
        }
    }

    // static public
    public static Builder builder() {

        return new Builder();
    }
}
