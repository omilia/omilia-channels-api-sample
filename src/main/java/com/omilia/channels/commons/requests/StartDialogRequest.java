package com.omilia.channels.commons.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omilia.channels.commons.exceptions.InvalidRequestException;
import com.omilia.channels.commons.model.ChannelContext;
import com.omilia.channels.commons.model.SimulationData;
import com.omilia.channels.commons.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class StartDialogRequest extends Request {

    // attributes
    @JsonProperty("application_id")
    public String applicationId;

    @JsonProperty("source")
    public String source;

    @JsonProperty("context")
    private ChannelContext context;

    @JsonProperty("user")
    public User user;

    @JsonProperty("simulation_data")
    private SimulationData simulationData;

    // constructors
    StartDialogRequest(Builder builder) {

        this.applicationId = builder.applicationId;
        this.source = builder.source;
        this.context = builder.context;
        this.user = builder.user;
        this.simulationData = builder.simulationData;
    }

    // overrides
    @Override
    public void validate() throws InvalidRequestException {

        if (StringUtils.isEmpty(applicationId)) {
            throw new InvalidRequestException("Application id is invalid.");
        }

        if (StringUtils.isEmpty(source)) {
            throw new InvalidRequestException("Source is empty");
        }
    }

    public static final class Builder {

        // attributes
        String applicationId;
        String source;
        ChannelContext context;
        User user;
        SimulationData simulationData;

        // constructors
        public Builder() {

        }

        //
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

        public Builder simulationData(SimulationData simulationData) {

            this.simulationData = simulationData;
            return this;
        }

        public StartDialogRequest build() {

            return new StartDialogRequest(this);
        }
    }

    // static public
    public static Builder builder() {

        return new Builder();
    }
}
