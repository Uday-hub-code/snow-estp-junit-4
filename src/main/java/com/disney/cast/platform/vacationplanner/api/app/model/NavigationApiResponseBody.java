/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.api.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
/**
 * @author ragha
 */
public class NavigationApiResponseBody {

    @JsonProperty("sortOrder")
    private Integer sortOrder;
    @JsonProperty("name")
    private Object name;
    @JsonProperty("separator")
    private String separator;
    @JsonProperty("items")
    private List<Item> items = null;

    @JsonProperty("sortOrder")
    public Integer getSortOrder() {
        return sortOrder;
    }

    @JsonProperty("sortOrder")
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @JsonProperty("name")
    public Object getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Object name) {
        this.name = name;
    }

    @JsonProperty("separator")
    public String getSeparator() {
        return separator;
    }

    @JsonProperty("separator")
    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

}
