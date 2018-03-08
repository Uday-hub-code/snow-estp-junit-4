package com.disney.cast.platform.vacationplanner.data;

import com.disney.cast.platform.common.data.Sheets;

public enum ExcelSheets implements Sheets {
    CONFIG,
    FEATURE,
    FAQ,
    ENTITLEMENT_STATUS,
    LOCATION,
    ALERT,
    REWARD_LEVEL,
    PAYROLL,
    REWARD,
    ELEGIBILITY,
    USER,
    ENTITLEMENT,
    PERFORMANCE;

    @Override
    public int getSheetNumber() {
        return this.ordinal();
    }
}
