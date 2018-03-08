package com.disney.cast.platform.vacationplanner.ui.snow.pages.vo;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

@SuppressWarnings("unused")
public class EligibilityVO extends ValueObject {
    private final String active;
    private final String name;
    private final String importKey;

    public EligibilityVO(String active, String name, String importKey) {
        this.active = active;
        this.name = name;
        this.importKey = importKey;
    }
}
