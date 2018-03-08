package com.disney.cast.platform.vacationplanner.ui.snow.pages.vo;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

@SuppressWarnings("unused")
public class EntitlementStatusVO extends ValueObject {
    private String status;
    private String date;
    private String entitlement;
    private String created;
    private String createdBy;

    public EntitlementStatusVO(String status, String date, String entitlement) {
        this.status = status;
        this.date = date;
        this.entitlement = entitlement;
    }

    public EntitlementStatusVO(String status, String date, String entitlement, String created, String createdBy) {
        this.status = status;
        this.date = date;
        this.entitlement = entitlement;
        this.created = created;
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        EntitlementStatusVO e = (EntitlementStatusVO) o;
        excludeAttributesFromEquals("created");
        return super.equals(e) && (null == created || null == e.created ? created == e.created
                : trimDate(created).equals(trimDate(e.created)));
    }

    private String trimDate(String createdDate) {
        return createdDate.substring(0, createdDate.lastIndexOf(":"));
    }
}
