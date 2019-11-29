package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

/**
 * Table data record.
 * <p>
 * The data record has the following JSON structure:
 * <pre>
 * {
 *     "index": "1",
 *     "image":"https://demo-server1.omilia.com/photos/USD.jpg"
 *     "dynamic-field-1": "value-1",
 *     "dynamic-field-2": "value-2"
 * }
 * </pre>
 * Any fields other than <code>index</code> and <code>image</code> are dynamic and kept into the <code>data</code> map.
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Record {

    // attributes
    private int index;

    private String image;

    @JsonIgnore
    private Map<String, String> data;

    public Record() {

        data = new HashMap<>();
    }

    /**
     * Annotated with @JsonAnyGetter so that the key,value pairs in the data Map will be unwrapped at the
     * Record level as dynamic fields, along with index and image fields, i.e.:
     * <pre>
     * {
     *   "index": "1",
     *   "image":{
     *           "label":"USD",
     *           "url":"https://demo-server1.omilia.com/photos/USD.jpg"
     *        },
     *   "dynamic-field-1": "value-1",
     *   "dynamic-field-2": "value-2"
     * }
     * </pre>
     */
    @JsonAnyGetter
    public Map<String, String> getData() {

        return data;
    }

    /**
     * Annotated with @JsonAnySetter so that any dynamic fields in the Record level will be stored in the
     * data Map.
     * <pre>
     * {
     *   "index": "1",
     *   "image":{
     *           "label":"USD",
     *           "url":"https://demo-server1.omilia.com/photos/USD.jpg"
     *        },
     *   "dynamic-field-1": "value-1",
     *   "dynamic-field-2": "value-2"
     *   }
     * </pre>
     */
    @JsonAnySetter
    public void setData(String name, String value) {

        data.put(name, value);
    }
}
