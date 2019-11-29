package com.omilia.channels.commons.model.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogTask extends EventLogger {

    private static final String DELIMITER = ":";
    @JsonProperty("task")
    private LogTaskType task;

    @JsonProperty("status")
    private LogStatus status;

    @JsonProperty("active-intent")
    private String activeIntent;

    @JsonProperty("task-id")
    private String taskId;

    @Override
    public String format() {

        StringJoiner stringJoiner = new StringJoiner(DELIMITER);

        stringJoiner.add(activeIntent);
        stringJoiner.add(getTaskValue());
        stringJoiner.add(logName);
        stringJoiner.add(getStatusValue());
        stringJoiner.add(exitReason);
        stringJoiner.add(comment);

        return stringJoiner.toString();
    }

    private String getStatusValue() {

        if (status == null) {
            return null;
        }

        return status.getValue();
    }

    private String getTaskValue() {

        if (task == null) {
            return null;
        }

        return task.getValue();
    }
}
