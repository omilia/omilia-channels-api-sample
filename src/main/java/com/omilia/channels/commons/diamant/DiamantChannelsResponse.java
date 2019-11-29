package com.omilia.channels.commons.diamant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omilia.channels.commons.model.Action;
import com.omilia.channels.commons.model.AsrData;
import com.omilia.channels.commons.model.DialogMetaData;
import com.omilia.channels.commons.model.Entity;
import com.omilia.channels.commons.model.Field;
import com.omilia.channels.commons.model.Grammars;
import com.omilia.channels.commons.model.HandOff;
import com.omilia.channels.commons.model.Intent;
import com.omilia.channels.commons.model.Target;
import com.omilia.channels.commons.model.events.EventLogger;
import com.omilia.channels.utils.Json;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiamantChannelsResponse extends DiamantResponse {

    // constants
    private static final Logger logger = LoggerFactory.getLogger(DiamantChannelsResponse.class);

    // attributes
    @JsonProperty("trackers")
    private List<String> trackers;

    @JsonProperty("reactions")
    private List<String> reactions;

    @JsonProperty("annotations")
    private List<Entity> annotations;

    @JsonProperty("fields")
    private List<Field> fields;

    @JsonProperty("action")
    private Action action;

    @JsonProperty("dialog_events")
    private List<String> dialogEvents;

    @JsonProperty("all_dialog_events")
    private List<EventLogger> allDialogEvents;

    @JsonProperty("grammars")
    private Grammars grammars;

    @JsonProperty("exit_attached_data")
    private String exitAttachedData;

    @JsonProperty("rule_name")
    private String ruleName;

    @JsonProperty("context_param")
    private String contextParam;

    @JsonProperty("extension")
    private String extension = "";

    @JsonProperty("reason")
    private String reason;

    @JsonProperty("attached_data")
    private Map<String, String> attachedData;

    @JsonProperty("intent")
    private Intent intent;

    @JsonProperty("handoff_data")
    private HandOff handOff;

    @JsonProperty("target")
    private Target target;

    @JsonProperty("asr_data")
    private AsrData asrData;

    @JsonProperty("dialog_metadata")
    private DialogMetaData dialogMetaData;

    // constructors
    public DiamantChannelsResponse() {

        this.reactions = new ArrayList<>();
        this.annotations = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.trackers = new ArrayList<>();
        this.dialogEvents = new ArrayList<>();
        this.attachedData = new HashMap<>();
    }

    // overrides
    @Override
    public boolean hasDialogTransferred() {

        String actionType = action.getType();
        return ("transfer".equalsIgnoreCase(actionType));
    }

    @Override
    public boolean hasDialogExited() {

        String actionType = action.getType();
        return ("exit".equalsIgnoreCase(actionType));
    }

    @Override
    public boolean hasDialogEnded() {

        return hasDialogTransferred() || hasDialogExited();
    }

    @Override
    public boolean isAnnouncement() {

        return (action != null && "announcement".equalsIgnoreCase(action.getType()));
    }

    @Override
    public String getIntent() {

        return intent.getName();
    }

    @Override
    public String getActionType() {

        return action.getType();
    }

    @Override
    public List<Field> getFieldsToElicit() {

        return action.getFieldsToElicit();
    }

    // public static
    public static DiamantChannelsResponse newInstance(String response) {

        DiamantChannelsResponse obj = new DiamantChannelsResponse();
        try {
            logger.info("Diamant Response: {}", response);
            obj = Json.mapper.readValue(response, DiamantChannelsResponse.class);
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }

        return obj;
    }
}
