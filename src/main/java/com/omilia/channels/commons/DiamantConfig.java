package com.omilia.channels.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.apache.commons.lang3.Validate;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DiamantConfig {

    // attributes
    @JsonProperty("app")
    private String app;

    @JsonProperty("base_url")
    private String baseUrl;

    @JsonProperty("api_token")
    private String apiToken;

    @JsonProperty("params")
    private DiamantParamsConfig params = new DiamantParamsConfig();

    /**
     * Semantic data to pass on to DiaManT on dialog start.
     *
     * <p><b>key</b> is the semantics field
     */
    @JsonProperty("dialog_start_semantics")
    private Map<String, String> dialogStartSemantics = new HashMap<>();

    // constructors
    public DiamantConfig(Builder builder) {

        this.app = builder.app;
        this.baseUrl = builder.baseUrl;
        this.apiToken = builder.apiToken;
        this.params = builder.params;
        this.dialogStartSemantics = builder.dialogStartSemantics;
    }

    private DiamantConfig() {
        // Default constructor required by jackson json deseriallizer
    }

    // public
    public void validate() {

        Validate.notEmpty(app, "Invalid diamant app name");
        Validate.notEmpty(baseUrl, "Invalid diamant url");
    }

    public static final class Builder {

        String app;
        String baseUrl;
        String apiToken;
        DiamantParamsConfig params;
        Map<String, String> dialogStartSemantics;

        public Builder() {

            params = new DiamantParamsConfig();
            dialogStartSemantics = new HashMap<>();
        }

        public Builder app(String app) {

            this.app = app;
            return this;
        }

        public Builder baseUrl(String baseUrl) {

            this.baseUrl = baseUrl;
            return this;
        }

        public Builder apiToken(String apiToken) {

            this.apiToken = apiToken;
            return this;
        }

        public Builder params(DiamantParamsConfig params) {

            this.params = params;
            return this;
        }

        public Builder dialogStartSemantics(Map<String, String> dialogStartSemantics) {

            this.dialogStartSemantics = dialogStartSemantics;
            return this;
        }

        public DiamantConfig build() {

            return new DiamantConfig(this);
        }
    }
}
