package com.disney.cast.platform.vacationplanner.ui.snow.pages.vo;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

@SuppressWarnings("unused")
public class PayrollVO extends ValueObject {
    final private String activity;
    final private String businessArea;
    final private String companyCode;
    final private String costCenter;
    final private String costCenterDescription;
    final private String date;
    final private String destGeo;
    final private String infoType;
    final private String intOrder;
    final private String mpmIssue;
    final private String network;
    final private String number;
    final private String period;
    final private String reasonForChange;
    final private String textField;
    final private String unit;
    final private String wbsElement;

    public PayrollVO(String activity, String businessArea, String companyCode, String costCenter,
            String costCenterDescription, String date, String destGeo, String infoType, String intOrder,
            String mpmIssue,
            String network, String number, String period, String reasonForChange, String textField, String unit,
            String wbsElement) {
        this.activity = activity;
        this.businessArea = businessArea;
        this.companyCode = companyCode;
        this.costCenter = costCenter;
        this.costCenterDescription = costCenterDescription;
        this.date = date;
        this.destGeo = destGeo;
        this.infoType = infoType;
        this.intOrder = intOrder;
        this.mpmIssue = mpmIssue;
        this.network = network;
        this.number = number;
        this.period = period;
        this.reasonForChange = reasonForChange;
        this.textField = textField;
        this.unit = unit;
        this.wbsElement = wbsElement;
    }
}
