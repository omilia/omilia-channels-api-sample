package com.omilia.channels.commons.model.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omilia.channels.utils.StringJoinerUtils;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogEvent extends EventLogger {

    private static final String DELIMITER = ":";

    @JsonProperty("event")
    private String event;

    @Override
    public String format() {

        StringJoiner stringJoiner = new StringJoiner(DELIMITER);

        stringJoiner.add(event);

        StringJoinerUtils.addIfNotEmpty(stringJoiner, logName);
        StringJoinerUtils.addIfNotEmpty(stringJoiner, exitReason);
        StringJoinerUtils.addIfNotEmpty(stringJoiner, comment);

        return stringJoiner.toString();
    }
}
