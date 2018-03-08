/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.vo;

import com.disney.cast.platform.common.ui.snow.pages.vo.ValueObject;

/**
 * @author luis.martinez
 */
@SuppressWarnings("unused")
public class SideMenuVO extends ValueObject {
    private final String name;
    private final String action;
    private final String sortOrder;
    private final String container;
    private final String advanced;
    private final String icon;
    private final String separator;
    private final String active;

    /**
     * SideMenu
     *
     * @param name
     * @param action
     * @param sortOrder
     * @param container
     * @param advanced
     * @param icon
     * @param separator
     * @param active
     * @param type
     */
    public SideMenuVO(String name, String action, String sortOrder, String container, String advanced,
            String icon, String separator, String active) {
        super();
        this.name = name;
        this.action = action;
        this.sortOrder = sortOrder;
        this.container = container;
        this.advanced = advanced;
        this.icon = icon;
        this.separator = separator;
        this.active = active;
    }
}
