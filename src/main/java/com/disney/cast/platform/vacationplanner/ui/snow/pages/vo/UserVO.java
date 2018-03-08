package com.disney.cast.platform.vacationplanner.ui.snow.pages.vo;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

@SuppressWarnings("unused")
public class UserVO extends ValueObject {

    private final String userName;

    public UserVO(String userName) {
        this.userName = userName;
    }
}
