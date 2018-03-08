package com.disney.cast.platform.vacationplanner.api.app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Performance {

    @JsonProperty("performance")
    private List<PerformanceInfo> performanceInfo = null;
    @JsonProperty("periodEndDate")
    private String periodEndDate;
    @JsonProperty("periodName")
    private String periodName;
    @JsonProperty("periodStartDate")
    private String periodStartDate;
    @JsonProperty("reportedDate")
    private String reportedDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("performance")
    public List<PerformanceInfo> getPerformance() {
        return performanceInfo;
    }

    @JsonProperty("performance")
    public void setPerformance(List<PerformanceInfo> performance) {
        this.performanceInfo = performance;
    }

    @JsonProperty("periodEndDate")
    public String getPeriodEndDate() {
        return periodEndDate;
    }

    @JsonProperty("periodEndDate")
    public void setPeriodEndDate(String periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    @JsonProperty("periodName")
    public String getPeriodName() {
        return periodName;
    }

    @JsonProperty("periodName")
    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    @JsonProperty("periodStartDate")
    public String getPeriodStartDate() {
        return periodStartDate;
    }

    @JsonProperty("periodStartDate")
    public void setPeriodStartDate(String periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    @JsonProperty("reportedDate")
    public String getReportedDate() {
        return reportedDate;
    }

    @JsonProperty("reportedDate")
    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PerformanceInfo {

        @JsonProperty("location")
        private Location location;
        @JsonProperty("indicators")
        private Indicators indicators;
        @JsonProperty("rewardLevel")
        private String rewardLevel;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("location")
        public Location getLocation() {
            return location;
        }

        @JsonProperty("location")
        public void setLocation(Location location) {
            this.location = location;
        }

        @JsonProperty("indicators")
        public Indicators getIndicators() {
            return indicators;
        }

        @JsonProperty("indicators")
        public void setIndicators(Indicators indicators) {
            this.indicators = indicators;
        }

        @JsonProperty("rewardLevel")
        public String getRewardLevel() {
            return rewardLevel;
        }

        @JsonProperty("rewardLevel")
        public void setRewardLevel(String rewardLevel) {
            this.rewardLevel = rewardLevel;
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
}