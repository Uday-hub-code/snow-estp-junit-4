package com.disney.cast.platform.vacationplanner.ui.snow.pages.vo;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

@SuppressWarnings("unused")
public class EntitlementVO extends ValueObject {
    private String displayName;
    private String active;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String city;
    private String comments;
    private String country;
    private String earnedEndDate;

    public EntitlementVO(String displayName, String active, String addressLine1, String addressLine2,
            String addressLine3, String addressLine4, String city, String comments, String country,
            String earnedEndDate) {
        excludeAttributesFromEquals("country", "comments");
        this.displayName = displayName;
        this.active = active;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.addressLine4 = addressLine4;
        this.city = city;
        this.comments = comments;
        this.country = country;
        this.earnedEndDate = earnedEndDate;
    }

    public String getComments() {
        return comments;
    }

    public String getCountry() {
        return country;
    }
}
