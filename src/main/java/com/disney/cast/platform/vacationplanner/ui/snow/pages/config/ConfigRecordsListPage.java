/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.config;

import org.openqa.selenium.By;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.config.components.ConfigContentTable;

/**
 * @author luisfmp
 */
public class ConfigRecordsListPage extends SnowRecordsListPage {

    public ConfigContentTable getContentTable() {
        return new ConfigContentTable(getDriver().findElement(By.cssSelector(".list2_body")));
    }
}
