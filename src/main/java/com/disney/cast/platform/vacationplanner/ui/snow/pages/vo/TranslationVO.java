package com.disney.cast.platform.vacationplanner.ui.snow.pages.vo;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

@SuppressWarnings("unused")
public class TranslationVO extends ValueObject {
    private final String active;
    private final String key;
    private final String language;
    private final String textValue;

    public TranslationVO(String active, String key, String language, String textValue) {
        this.active = active;
        this.key = key;
        this.language = language;
        this.textValue = textValue;
    }
}