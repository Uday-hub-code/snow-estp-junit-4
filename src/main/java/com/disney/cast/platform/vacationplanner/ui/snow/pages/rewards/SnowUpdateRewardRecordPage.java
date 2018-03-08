/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.rewards;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author ragha
 */
public class SnowUpdateRewardRecordPage extends SnowUpdateRecordBasePage {
    private Supplier<WebElement> active = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward.u_active")));
    private Supplier<WebElement> rewardName = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward.u_name")));

    private Supplier<WebElement> rewardAmount = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward.u_amount")));

    private Supplier<WebElement> currency = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward.u_currency")));

    private Supplier<WebElement> rewardDescription = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward.u_description")));
    private Supplier<WebElement> itemCode = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward.u_item_code")));

    private Supplier<WebElement> itemQuantity = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward.u_item_quantity")));

    private Supplier<WebElement> rewardLevel = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward.u_reward_level")));

    private Supplier<WebElement> rewardtaxable = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward.u_taxable")));

    public boolean isActive() {
        return active
                .get()
                .getAttribute("value")
                .equals("true");
    }

    public String getRewardName() {
        return rewardName.get().getAttribute("value");
    }

    public String getRewardAmount() {
        return rewardAmount.get().getAttribute("value");
    }

    public String getCurrency() {
        return currency.get().getAttribute("value");
    }

    public String getRewardDescription() {
        return rewardDescription.get().getText();
    }

    public String getItemCode() {
        return itemCode.get().getText();
    }

    public String getItemQuantity() {
        return itemQuantity.get().getText();
    }

    public String getRewardLevel() {
        return rewardLevel.get().getText();
    }

    public String getRewardtaxable() {
        return rewardtaxable.get().getText();
    }

}
