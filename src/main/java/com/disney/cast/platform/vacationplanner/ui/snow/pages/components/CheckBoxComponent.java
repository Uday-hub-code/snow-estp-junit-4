package com.disney.cast.platform.vacationplanner.ui.snow.pages.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;

public class CheckBoxComponent extends PageElement {

    private final Supplier<WebElement> checkBox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector("label[class*='checkbox-label']")));

    final private Supplier<WebElement> checkBoxHidden;

    public CheckBoxComponent(By contextLocator) {
        super(contextLocator);
        checkBoxHidden = () -> waitFor(
                presenceOfElementLocated(contextLocator));
    }

    public boolean isCheckboxClickable() {
        if (isCheckBoxEnabled()) {
            boolean initialStatus = isChecked();
            checkBox.get().click();
            return initialStatus != Boolean.valueOf(checkBoxHidden.get().getAttribute("value"));
        }
        return Boolean.FALSE;
    }

    public boolean isChecked() {
        return Boolean.valueOf(checkBoxHidden.get().getAttribute("value"));
    }

    public boolean isCheckBoxEnabled() {
        return checkBox.get().isDisplayed() && checkBox.get().isEnabled();
    }

}
