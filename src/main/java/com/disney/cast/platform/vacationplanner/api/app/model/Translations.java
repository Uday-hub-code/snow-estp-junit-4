
package com.disney.cast.platform.vacationplanner.api.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Translations {

    @JsonProperty("language")
    private String language;
    @JsonProperty("strings")
    private Strings strings;

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("strings")
    public Strings getStrings() {
        return strings;
    }

    @JsonProperty("strings")
    public void setStrings(Strings strings) {
        this.strings = strings;
    }
}
