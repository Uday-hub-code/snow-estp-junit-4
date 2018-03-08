package com.disney.cast.platform.vacationplanner.ui.snow.pages.feature;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.SnowBasePage;

/**
 * @author g.moreno
 */
public class InfoFeaturePage extends SnowBasePage {

    @Override
    protected String setOwnUrl() {
        return null;
    }

    private Supplier<WebElement> keyTextBox = () -> waitFor(
            presenceOfElementLocated(cssSelector("#sys_readonly\2e x_wdtpa_wdpr_vacat_feature\2e u_key")));

    private Supplier<WebElement> valueCheckBox = () -> waitFor(
            elementToBeClickable(cssSelector("#ni\2e x_wdtpa_wdpr_vacat_feature\2e u_value")));

    private Supplier<WebElement> updateButton = () -> waitFor(
            elementToBeClickable(cssSelector("#sysverb_update")));

    private Supplier<WebElement> deleteButton = () -> waitFor(
            elementToBeClickable(cssSelector("#sysverb_delete")));

    public boolean isKeyTextBoxDisplayed() {

        return keyTextBox.get().isDisplayed();
    }

    public boolean isValueCheckBoxDisplayed() {
        return valueCheckBox.get().isDisplayed();
    }

    public boolean isUpdateButtonDisplayed() {
        return updateButton.get().isDisplayed();
    }

    public boolean isDeleteButtonDisplayed() {
        return deleteButton.get().isDisplayed();
    }

    public boolean isAllDisplayed() {
        boolean result = false;

        if (isKeyTextBoxDisplayed() && isValueCheckBoxDisplayed() && isUpdateButtonDisplayed()
                && isDeleteButtonDisplayed()) {
            result = true;
        }
        return result;
    }
}
