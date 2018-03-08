
package com.disney.cast.platform.vacationplanner.api.app.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Strings {

    @JsonIgnore
    private Map<String, Object> strings = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getStrings() {
        return this.strings;
    }

    @JsonAnySetter
    public void setStrings(String name, Object value) {
        this.strings.put(name, value);
    }

}
