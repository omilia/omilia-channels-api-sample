package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entity {

    // attributes
    @JsonProperty("name")
    private String name;

    @JsonProperty("instances")
    private List<EntityInstance> instances;

    // constructors
    public Entity() {

        this.instances = new ArrayList<>();
    }

    // public
    public String getEntityInstance() {

        return CollectionUtils.isNotEmpty(instances) ? this.instances.get(0).getValue() : "";
    }
}
