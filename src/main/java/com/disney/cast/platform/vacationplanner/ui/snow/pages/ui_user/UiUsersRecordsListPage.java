/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.ui_user;

import org.openqa.selenium.By;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.ui_user.components.UiUserContentTable;

/**
 * @author g.moreno
 */
public class UiUsersRecordsListPage extends SnowRecordsListPage {

    public UiUserContentTable getContentTable() {
        return new UiUserContentTable(getDriver().findElement(By.cssSelector(".list2_body")));
    }
}
