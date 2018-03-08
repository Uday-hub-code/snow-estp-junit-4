/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.rewards.components;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.DataRow;

/**
 * @author ragha
 */
public class RewardsRow extends DataRow {

    private WebElement active = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(3)>a")));

    private WebElement rewardName = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(4)")));

    private WebElement rewardAmount = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(5)")));

    private WebElement currency = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(6)")));

    private WebElement rewardDescription = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(7)")));

    private WebElement itemCode = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(8)")));

    private WebElement itemQuantity = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(9)")));

    private WebElement rewardLevel = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(10)")));

    private WebElement rewardtaxable = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(11)")));

    public RewardsRow(WebElement row) {
        super(row);
    }

    public boolean isActive() {
        return active.getText().equals("true");
    }

    public String getRewardName() {
        return rewardName.getText();
    }

    public String getRewardAmount() {
        return rewardAmount.getText();
    }

    public String getCurrency() {
        return currency.getText();
    }

    public String getRewardDescription() {
        return rewardDescription.getText();
    }

    public String getItemCode() {
        return itemCode.getText();
    }

    public String getItemQuantity() {
        return itemQuantity.getText();
    }

    public String getRewardLevel() {
        return rewardLevel.getText();
    }

    public String getRewardtaxable() {
        return rewardtaxable.getText();
    }

}
