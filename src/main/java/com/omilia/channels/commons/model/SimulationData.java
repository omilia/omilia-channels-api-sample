package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SimulationData {

    @JsonProperty("initial")
    private Map<String, String> initialData;

    @JsonProperty("backend")
    private Map<String, Map<String, String>> backendData;
}
