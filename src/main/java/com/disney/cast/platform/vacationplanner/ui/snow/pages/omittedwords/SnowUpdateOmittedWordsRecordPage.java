/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.omittedwords;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author luisfmp
 */
public class SnowUpdateOmittedWordsRecordPage extends SnowUpdateRecordBasePage {
    private Supplier<WebElement> value = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_omitted_word.u_value")));

    public String getValue() {
        return value.get().getAttribute("value");
    }
}
