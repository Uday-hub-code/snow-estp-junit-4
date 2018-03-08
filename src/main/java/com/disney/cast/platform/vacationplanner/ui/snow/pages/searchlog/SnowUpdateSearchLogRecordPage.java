/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.searchlog;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author Raghav
 */
public class SnowUpdateSearchLogRecordPage extends SnowUpdateRecordBasePage {

    private Supplier<WebElement> term = () -> waitFor(
            presenceOfElementLocated(By.id("sys_original.x_wdtpa_wdpr_vacat_search_log.u_term")));

    public String getTerm() {
        return term.get().getAttribute("value");
    }

}
