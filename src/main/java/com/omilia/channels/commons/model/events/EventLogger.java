package com.omilia.channels.commons.model.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.NoClass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@class", defaultImpl = NoClass.class)
@JsonSubTypes({
        @Type(value = LogEvent.class, name = "LogEvent"),
        @Type(value = LogTask.class, name = "LogTask")
})
public abstract class EventLogger {

    @JsonProperty("exitReason")
    protected String exitReason;

    @JsonProperty("comment")
    protected String comment;

    @JsonProperty("logName")
    protected String logName;

    @JsonProperty("index")
    protected int index;

    @JsonProperty("actionLog")
    protected boolean isActionLog;

    public abstract String format();
}

