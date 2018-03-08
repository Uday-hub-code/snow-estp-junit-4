/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.api.app.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * @author Raghav
 */
public class Item {

    @JsonProperty("action")
    private String action;
    @JsonProperty("icon")
    private Object icon;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("translated")
    private Boolean translated;

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    @JsonProperty("icon")
    public Object getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(Object icon) {
        this.icon = icon;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("translated")
    public Boolean getTranslated() {
        return translated;
    }

    @JsonProperty("translated")
    public void setTranslated(Boolean translated) {
        this.translated = translated;
    }

}
