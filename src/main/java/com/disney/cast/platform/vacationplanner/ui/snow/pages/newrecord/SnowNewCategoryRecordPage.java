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
public class SnowNewCategoryRecordPage extends SnowNewRecordBasePage {

    private Supplier<WebElement> nameLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='name')]")));

    private Supplier<WebElement> activeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='active')]")));

    private Supplier<WebElement> activeCheckBox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector("label[class*=' checkbox-label']")));

    private Supplier<WebElement> activeCheckBoxHidden = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_category.u_active")));

    private Supplier<WebElement> nameTextInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_category.u_name")));

    public boolean isNameLabelDisplayed() {

        return nameLabel.get().isDisplayed();
    }

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isCheckBoxEnabled() {
        return activeCheckBox.get().isDisplayed() && activeCheckBox.get().isEnabled();
    }

    public boolean isNameTextInputEnabled() {
        return nameTextInput.get().isDisplayed() && nameTextInput.get().isEnabled();
    }

    public void writeName(String name) {
        nameTextInput.get().sendKeys(name);
    }

    public boolean testClickabilityOnCheckbox() {
        if (isCheckBoxEnabled()) {
            boolean initialStatus = Boolean.valueOf(activeCheckBoxHidden.get().getAttribute("value"));
            activeCheckBox.get().click();
            return initialStatus != Boolean.valueOf(activeCheckBoxHidden.get().getAttribute("value"));
        }
        return Boolean.FALSE;
    }

    public boolean isNameTextInputEnabledWithWriting() {
        final String text = "writtable";
        if (isNameTextInputEnabled()) {
            nameTextInput.get().sendKeys(text);
            return text.equals(nameTextInput.get().getAttribute("value"));
        }
        return Boolean.FALSE;
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_category_list.do%3Fsysparm_userpref_module%3D81e52497db547e00a59ff9baae961916%26sysparm_clear_stack%3Dtrue%26sysparm_clear_stack%3Dtrue";
    }

}
