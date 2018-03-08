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
public class Entitlement {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("comments")
    private List<Comment> comments = null;
    @JsonProperty("earnedEndDate")
    private String earnedEndDate;
    @JsonProperty("earnedStartDate")
    private String earnedStartDate;
    @JsonProperty("eligible")
    private Boolean eligible;
    @JsonProperty("eligibleTitle")
    private String eligibleTitle;
    @JsonProperty("expectedDeliveryDate")
    private String expectedDeliveryDate;
    @JsonProperty("redemptionPeriodEndDate")
    private String redemptionPeriodEndDate;
    @JsonProperty("redemptionPeriodStartDate")
    private String redemptionPeriodStartDate;
    @JsonProperty("redemptionTimezone")
    private String redemptionTimezone;
    @JsonProperty("rewardLevel")
    private String rewardLevel;
    @JsonProperty("shippingAddress")
    private ShippingAddress shippingAddress;
    @JsonProperty("status")
    private List<Status> status = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("comments")
    public List<Comment> getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonProperty("earnedEndDate")
    public String getEarnedEndDate() {
        return earnedEndDate;
    }

    @JsonProperty("earnedEndDate")
    public void setEarnedEndDate(String earnedEndDate) {
        this.earnedEndDate = earnedEndDate;
    }

    @JsonProperty("earnedStartDate")
    public String getEarnedStartDate() {
        return earnedStartDate;
    }

    @JsonProperty("earnedStartDate")
    public void setEarnedStartDate(String earnedStartDate) {
        this.earnedStartDate = earnedStartDate;
    }

    @JsonProperty("eligible")
    public Boolean getEligible() {
        return eligible;
    }

    @JsonProperty("eligible")
    public void setEligible(Boolean eligible) {
        this.eligible = eligible;
    }

    @JsonProperty("eligibleTitle")
    public String getEligibleTitle() {
        return eligibleTitle;
    }

    @JsonProperty("eligibleTitle")
    public void setEligibleTitle(String eligibleTitle) {
        this.eligibleTitle = eligibleTitle;
    }

    @JsonProperty("expectedDeliveryDate")
    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    @JsonProperty("expectedDeliveryDate")
    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    @JsonProperty("redemptionPeriodEndDate")
    public String getRedemptionPeriodEndDate() {
        return redemptionPeriodEndDate;
    }

    @JsonProperty("redemptionPeriodEndDate")
    public void setRedemptionPeriodEndDate(String redemptionPeriodEndDate) {
        this.redemptionPeriodEndDate = redemptionPeriodEndDate;
    }

    @JsonProperty("redemptionPeriodStartDate")
    public String getRedemptionPeriodStartDate() {
        return redemptionPeriodStartDate;
    }

    @JsonProperty("redemptionPeriodStartDate")
    public void setRedemptionPeriodStartDate(String redemptionPeriodStartDate) {
        this.redemptionPeriodStartDate = redemptionPeriodStartDate;
    }

    @JsonProperty("redemptionTimezone")
    public String getRedemptionTimezone() {
        return redemptionTimezone;
    }

    @JsonProperty("redemptionTimezone")
    public void setRedemptionTimezone(String redemptionTimezone) {
        this.redemptionTimezone = redemptionTimezone;
    }

    @JsonProperty("rewardLevel")
    public String getRewardLevel() {
        return rewardLevel;
    }

    @JsonProperty("rewardLevel")
    public void setRewardLevel(String rewardLevel) {
        this.rewardLevel = rewardLevel;
    }

    @JsonProperty("shippingAddress")
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @JsonProperty("shippingAddress")
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @JsonProperty("status")
    public List<Status> getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(List<Status> status) {
        this.status = status;
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
    public static class ShippingAddress {

        @JsonProperty("city")
        private String city;
        @JsonProperty("country")
        private String country;
        @JsonProperty("email")
        private String email;
        @JsonProperty("lines")
        private List<String> lines = null;
        @JsonProperty("name")
        private String name;
        @JsonProperty("phone")
        private String phone;
        @JsonProperty("postalCode")
        private String postalCode;
        @JsonProperty("region")
        private String region;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("city")
        public String getCity() {
            return city;
        }

        @JsonProperty("city")
        public void setCity(String city) {
            this.city = city;
        }

        @JsonProperty("country")
        public String getCountry() {
            return country;
        }

        @JsonProperty("country")
        public void setCountry(String country) {
            this.country = country;
        }

        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }

        @JsonProperty("lines")
        public List<String> getLines() {
            return lines;
        }

        @JsonProperty("lines")
        public void setLines(List<String> lines) {
            this.lines = lines;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("phone")
        public String getPhone() {
            return phone;
        }

        @JsonProperty("phone")
        public void setPhone(String phone) {
            this.phone = phone;
        }

        @JsonProperty("postalCode")
        public String getPostalCode() {
            return postalCode;
        }

        @JsonProperty("postalCode")
        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        @JsonProperty("region")
        public String getRegion() {
            return region;
        }

        @JsonProperty("region")
        public void setRegion(String region) {
            this.region = region;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Status {

        @JsonProperty("date")
        private String date;
        @JsonProperty("name")
        private String name;
        @JsonProperty("userId")
        private String userId;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("date")
        public String getDate() {
            return date;
        }

        @JsonProperty("date")
        public void setDate(String date) {
            this.date = date;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("userId")
        public String getUserId() {
            return userId;
        }

        @JsonProperty("userId")
        public void setUserId(String userId) {
            this.userId = userId;
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Comment {
        @JsonProperty("comment")
        private String comment;
        @JsonProperty("dateTime")
        private String dateTime;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("comment")
        public String getComment() {
            return comment;
        }

        @JsonProperty("comment")
        public void setComment(String comment) {
            this.comment = comment;
        }

        @JsonProperty("dateTime")
        public String getDateTime() {
            return dateTime;
        }

        @JsonProperty("dateTime")
        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
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