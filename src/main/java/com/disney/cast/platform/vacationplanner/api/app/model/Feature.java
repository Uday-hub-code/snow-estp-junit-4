package com.disney.cast.platform.vacationplanner.api.app.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feature {
    private String[] features;

    @JsonAnyGetter
    public String[] getFeatures() {
        return this.features;
    }

    @JsonAnySetter
    public void setFeatures(String[] features) {
        this.features = features;
    }

}
