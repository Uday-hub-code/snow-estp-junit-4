/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.reward_level;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author g.moreno
 */
public class SnowUpdateRewardLevelRecordPage extends SnowUpdateRecordBasePage {
    private Supplier<WebElement> active = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward_level.u_active")));

    private Supplier<WebElement> importKey = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward_level.u_import_key")));

    private Supplier<WebElement> level = () -> waitFor(
            presenceOfElementLocated(By.xpath("//input[@id='x_wdtpa_wdpr_vacat_reward_level.u_level']")));

    private Supplier<WebElement> sortOrder = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward_level.u_sort_order")));

    private Supplier<WebElement> tier = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward_level.u_tier")));

    private Supplier<WebElement> uiDisplay = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_reward_level.u_ui_display")));

    public boolean isActive() {
        return active
                .get()
                .getAttribute("value")
                .equals("true");
    }

    public String getImportKey() {
        return importKey.get().getAttribute("value");
    }

    public String getLevel() {
        return level.get().getAttribute("value");
    }

    public String getSortOrder() {
        return sortOrder.get().getAttribute("value");
    }

    public String getTier() {
        return tier.get().getText();
    }

    public String getUiDisplay() {
        return uiDisplay.get().getText();
    }
}
