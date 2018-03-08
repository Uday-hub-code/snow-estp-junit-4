/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.reward_level.components;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.DataRow;

/**
 * @author g.moreno
 */
public class RewardLevelRow extends DataRow {

    private WebElement active = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(3)>a")));

    private WebElement importKey = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(4)")));

    private WebElement level = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(5)")));

    private WebElement sortOrder = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(6)")));

    private WebElement tier = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(7)")));

    private WebElement uiDisplay = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(8)")));

    public RewardLevelRow(WebElement row) {
        super(row);
    }

    public boolean isActive() {
        return active.getText().equals("true");
    }

    public String getImportKey() {
        return importKey.getText();
    }

    public String getLevel() {
        return level.getText();
    }

    public String getSortOrder() {
        return sortOrder.getText();
    }

    public String getTier() {
        return tier.getText();
    }

    public String getUiDisplay() {
        return uiDisplay.getText();
    }

}
