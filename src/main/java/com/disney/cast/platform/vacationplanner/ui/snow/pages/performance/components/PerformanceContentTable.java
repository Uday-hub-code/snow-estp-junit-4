/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.performance.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.DataRow;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author g.moreno
 */
public class PerformanceContentTable extends PageElement {
    private List<PerformanceRow> rows;

    public PerformanceContentTable(WebElement contextLocator) {
        super(contextLocator);
        List<WebElement> pageRows = contextLocator.findElements(By.tagName("tr"));
        rows = new ArrayList<PerformanceRow>();
        for (WebElement pageRow : pageRows) {
            rows.add(new PerformanceRow(pageRow));
        }
    }

    public <T extends SnowUpdateRecordBasePage> T editRecordByKey(String key, Class<T> pageToReturn)
            throws InstantiationException, IllegalAccessException {
        for (DataRow row : getRows()) {
            if (key.equals(((PerformanceRow) row).getPortalId())) {
                return row.clickAtInfoIcon(pageToReturn);
            }
        }
        return null;
    }

    public List<PerformanceRow> getRows() {
        return rows;
    }

}
