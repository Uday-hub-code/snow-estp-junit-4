package com.disney.cast.platform.vacationplanner.ui.snow.pages.feature;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author g.moreno
 */
public class SnowUpdateFeatureRecordPage extends SnowUpdateRecordBasePage {

    private Supplier<WebElement> key = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_feature.u_key")));

    private Supplier<WebElement> value = () -> waitFor(
            presenceOfElementLocated(By.cssSelector(".checkbox")));

    public String getKey() {
        return key.get().getAttribute("value");
    }

    public boolean getValue() {
        return value.get().isSelected();
    }
}
