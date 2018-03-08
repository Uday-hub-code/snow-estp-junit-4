package com.disney.cast.platform.vacationplanner.api.app.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author walter.finkbeiner
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Config {

    private Map<String, Object> properties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getConfigs() {
        return this.properties;
    }

    @JsonAnySetter
    public void setConfig(String name, Object value) {
        this.properties.put(name, value);
    }

}
