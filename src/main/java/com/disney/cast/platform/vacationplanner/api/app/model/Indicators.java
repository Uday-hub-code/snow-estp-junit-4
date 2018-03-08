package com.disney.cast.platform.vacationplanner.api.app.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Indicators {

    @JsonProperty("average")
    private Average average;
    @JsonProperty("individual")
    private Individual individual;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("average")
    public Average getAverage() {
        return average;
    }

    @JsonProperty("average")
    public void setAverage(Average average) {
        this.average = average;
    }

    @JsonProperty("individual")
    public Individual getIndividual() {
        return individual;
    }

    @JsonProperty("individual")
    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}