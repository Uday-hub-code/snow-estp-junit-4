/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;

/**
 * @author Raghav
 */
public class SnowNewOmittedwordsRecordPage extends SnowNewRecordBasePage {
    private static String SOME_TEXT = "some text";

    private Supplier<WebElement> valueLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='value')]")));

    private Supplier<WebElement> valueInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_omitted_word.u_value")));

    public boolean isValueLabelDisplayed() {
        return valueLabel.get().isDisplayed();
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprlatest.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_omitted_word_list.do%3Fsysparm_userpref_module%3Dd51dce97dbe87240a59ff9baae961983%26sysparm_clear_stack%3Dtrue%26sysparm_clear_stack%3D";
    }

    public boolean isValueInputEditable() {
        valueInput.get().sendKeys(SOME_TEXT);
        return valueInput.get().getAttribute("value").equals(SOME_TEXT);
    }

}
