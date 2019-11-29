package com.omilia.channels.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.omilia.channels.commons.exceptions.InvalidRequestException;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class DiamantParamsConfig {

    // attributes
    @JsonProperty("enable_lowercase")
    private Boolean enableLowercase = false;

    @JsonProperty("connect_timeout")
    private int connectTimeout = 10000; // 10 seconds

    @JsonProperty("read_timeout")
    private int readTimeout = 10000; // 10 seconds

    @JsonProperty("delay")
    private int delay = 0;

    /**
     * Number of {@code [noinput]} requests to send to DiaManT after dialog start.
     * <p>
     * Some applications require a number of {@code [noinput]} requests after starting a dialog, in order to show
     * the initial user prompt.<br>
     * These are not the {@code noinput} requests send to DiaManT in response to ANNOUNCEMENT responses.
     */
    @JsonProperty("num_no_inputs")
    private int numNoInputs = 0;

    /**
     * Maximum number of consecutive announcements allowed.
     * <p>
     * Diamant sends a response with {@code action.type == announcement} to denote that another response
     * follows. In this case we send a {@code noinput} request to get the follow-up response. The follow-up
     * response could also be an announcement in which case we continue sending {@code noinput} requests
     * till we get a non announcement response.
     * </p>
     * This parameter sets a limit to the number of consecutive announcements allowed in order to prevent
     * the system entering an infinite loop in case the application is incorrectly configured to always
     * respond with {@code action.type == announcement}
     */
    @JsonProperty("max_consecutive_announcements")
    private int maxConsecutiveAnnouncements = 10;

    /**
     * Maximum time to wait for user's input in seconds.
     * <p>
     * Time in seconds to wait for user input. If no input is sent by the user for {@code userInputTimeout}
     * seconds an action should be taken like sending a {@code [noinput]} message to Diamant.
     * This can be used to ping the user in order to keep the dialog alive.
     * <p>
     * When set to 0, user timeout is disabled.
     */
    @JsonProperty("user_input_timeout")
    private int userInputTimeout;

    // public
    public void validate() throws InvalidRequestException {

        if (connectTimeout < 0) {
            throw new InvalidRequestException("Invalid connect timeout");
        }

        if (readTimeout < 0) {
            throw new InvalidRequestException("Invalid read timeout");
        }

        if (delay < 0 || delay > 10000) {
            throw new InvalidRequestException("Invalid delay range [0, 10000]");
        }

        if (maxConsecutiveAnnouncements < 0 || maxConsecutiveAnnouncements > 10) {
            throw new InvalidRequestException("Invalid maxConsecutiveAnnouncements range [0, 10]");
        }
    }

    public boolean hasDelay() {

        return (delay > 0);
    }

    public static final class Builder {

        DiamantParamsConfig diamantParamsConfig;

        public Builder() {

            diamantParamsConfig = new DiamantParamsConfig();
        }

        public Builder enableLowercase(Boolean enableLowercase) {

            diamantParamsConfig.enableLowercase = enableLowercase;
            return this;
        }

        public Builder connectTimeout(int connectTimeout) {

            diamantParamsConfig.connectTimeout = connectTimeout;
            return this;
        }

        public Builder readTimeout(int readTimeout) {

            diamantParamsConfig.readTimeout = readTimeout;
            return this;
        }

        public Builder delay(int delay) {

            diamantParamsConfig.delay = delay;
            return this;
        }

        public Builder numNoInputs(int numNoInputs) {

            diamantParamsConfig.numNoInputs = numNoInputs;
            return this;
        }

        public Builder maxConsecutiveAnnouncements(int maxConsecutiveAnnouncements) {

            diamantParamsConfig.maxConsecutiveAnnouncements = maxConsecutiveAnnouncements;
            return this;
        }

        public DiamantParamsConfig build() {

            return diamantParamsConfig;
        }
    }
}
