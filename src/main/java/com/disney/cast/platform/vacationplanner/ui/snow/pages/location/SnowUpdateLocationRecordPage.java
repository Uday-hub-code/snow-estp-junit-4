/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.location;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author g.moreno
 */
public class SnowUpdateLocationRecordPage extends SnowUpdateRecordBasePage {
    private Supplier<WebElement> active = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_location.u_active")));

    private Supplier<WebElement> name = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_location.u_name")));

    private Supplier<WebElement> importKey = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_location.u_import_key")));

    private Supplier<WebElement> icon = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_location.u_icon")));

    public String isActive() {
        return active
                .get()
                .getAttribute("value");
    }

    public String getName() {
        return name.get().getAttribute("value");
    }

    public String getImportKey() {
        return importKey.get().getAttribute("value");
    }

    public String getIcon() {
        return icon.get().getAttribute("value");
    }
}
