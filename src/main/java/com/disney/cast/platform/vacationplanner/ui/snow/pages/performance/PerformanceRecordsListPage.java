/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.performance;

import org.openqa.selenium.By;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.performance.components.PerformanceContentTable;

/**
 * @author g.moreno
 */
public class PerformanceRecordsListPage extends SnowRecordsListPage {

    public PerformanceContentTable getContentTable() {
        return new PerformanceContentTable(getDriver().findElement(By.cssSelector(".list2_body")));
    }
}
