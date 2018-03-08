/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.reward_level.components;

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
public class RewardLevelContentTable extends PageElement {
    private List<RewardLevelRow> rows;

    public RewardLevelContentTable(WebElement contextLocator) {
        super(contextLocator);
        List<WebElement> pageRows = contextLocator.findElements(By.tagName("tr"));
        rows = new ArrayList<RewardLevelRow>();
        for (WebElement pageRow : pageRows) {
            rows.add(new RewardLevelRow(pageRow));
        }
    }

    public <T extends SnowUpdateRecordBasePage> T editRecordByKey(String key, Class<T> pageToReturn)
            throws InstantiationException, IllegalAccessException {
        for (DataRow row : getRows()) {
            if (key.equals(((RewardLevelRow) row).getImportKey())) {
                return row.clickAtInfoIcon(pageToReturn);
            }
        }
        return null;
    }

    public List<RewardLevelRow> getRows() {
        return rows;
    }

}
