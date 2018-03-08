/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.config;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author luisfmp
 */
public class SnowUpdateConfigRecordPage extends SnowUpdateRecordBasePage {
    private Supplier<WebElement> active = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_config.u_active")));

    private Supplier<WebElement> key = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_config.u_key")));

    private Supplier<WebElement> value = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_config.u_value")));

    public boolean isActive() {
        return active
                .get()
                .getAttribute("value")
                .equals("true");
    }

    public String getKey() {
        return key.get().getAttribute("value");
    }

    public String getValue() {
        return value.get().getAttribute("value");
    }
}
