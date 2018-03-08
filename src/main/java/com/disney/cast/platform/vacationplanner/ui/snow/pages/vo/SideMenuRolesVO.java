/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.vo;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

/**
 * @author ragha
 */
@SuppressWarnings("unused")
public class SideMenuRolesVO extends ValueObject {

    private final String name;

    public SideMenuRolesVO(String name) {
        super();

        this.name = name.trim();

    }
}
