package com.omilia.channels.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    // attributes
    @JsonProperty("user_id")
    public String userId;

    @JsonProperty("email")
    public String email;

    @JsonProperty("first_name")
    public String firstName;

    @JsonProperty("last_name")
    public String lastName;

    @JsonProperty("fullname")
    public String fullname;

    @JsonProperty("phone_number")
    public String phoneNumber;

    @JsonProperty("username")
    public String username;

    // constructors
    public User(Builder builder) {

        this.userId = builder.userId;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.fullname = builder.fullname;
        this.phoneNumber = builder.phoneNumber;
        this.username = builder.username;
    }

    private User() {
        // Default constructor required by jackson json deserializer
    }

    public static final class Builder {

        String userId;
        String email;
        String firstName;
        String lastName;
        String fullname;
        String phoneNumber;
        String username;

        public Builder userId(String userId) {

            this.userId = userId;
            return this;
        }

        public Builder email(String email) {

            this.email = email;
            return this;
        }

        public Builder firstName(String firstName) {

            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {

            this.lastName = lastName;
            return this;
        }

        public Builder fullname(String fullname) {

            this.fullname = fullname;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {

            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder username(String username) {

            this.username = username;
            return this;
        }

        public User build() {

            return new User(this);
        }
    }
}
