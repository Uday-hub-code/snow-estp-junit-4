/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.rewards.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.DataRow;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author ragha
 */
public class RewardContentTable extends PageElement {
    private List<RewardsRow> rows;

    public RewardContentTable(WebElement contextLocator) {
        super(contextLocator);
        List<WebElement> pageRows = contextLocator.findElements(By.tagName("tr"));
        rows = new ArrayList<RewardsRow>();
        for (WebElement pageRow : pageRows) {
            rows.add(new RewardsRow(pageRow));
        }
    }

    public <T extends SnowUpdateRecordBasePage> T editRecordByKey(String key, Class<T> pageToReturn)
            throws InstantiationException, IllegalAccessException {
        for (DataRow row : getRows()) {
            if (key.equals(((RewardsRow) row).getRewardName())) {
                return row.clickAtInfoIcon(pageToReturn);
            }
        }
        return null;
    }

    public List<RewardsRow> getRows() {
        return rows;
    }

}
