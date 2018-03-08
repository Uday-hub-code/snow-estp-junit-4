package com.disney.cast.platform.vacationplanner.ui.snow.pages.common;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.components.Backable;

public abstract class ControlSnowBasePage extends SnowNewRecordBasePage implements Backable {
    protected Supplier<WebElement> backButton = () -> waitFor(
            presenceOfElementLocated(
                    cssSelector("button.btn.btn-default.icon-chevron-left.navbar-btn")));

    protected Supplier<WebElement> contextualMenuButton = () -> waitFor(
            presenceOfElementLocated(
                    cssSelector("button.btn.btn-icon.icon-menu.navbar-btn")));

    protected Supplier<WebElement> toggleMoreOptions = () -> waitFor(
            presenceOfElementLocated(
                    id("toggleMoreOptions")));

    private Supplier<WebElement> updateButton = () -> waitFor(
            presenceOfElementLocated(id("sysverb_update")));

    private Supplier<WebElement> deleteButton = () -> waitFor(
            presenceOfElementLocated(id("sysverb_delete")));

    public ControlSnowBasePage() {
    }

    public boolean isUpdateButtonDisplayed() {
        return updateButton.get().isDisplayed();
    }

    public boolean isDeleteButtonDisplayed() {
        return deleteButton.get().isDisplayed();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends SnowRecordsListPage> T back() {
        backButton.get().click();
        return (T) new SnowRecordsListPage();
    }

    protected String getTextFromInput(Supplier<WebElement> sup) {
        return WebElementValidationHelper.getTextFromInput(sup);
    }

    public boolean isInputEnabledWithWriting(Supplier<WebElement> element) {
        return WebElementValidationHelper.isInputEnabledWithWriting(element);
    }

    public boolean isElementEnabled(Supplier<WebElement> element) {
        return WebElementValidationHelper.isElementEnabled(element);
    }

    public boolean isInputEnabledWithWriting(Supplier<WebElement> element, String writableText) {
        return WebElementValidationHelper.isInputEnabledWithWriting(element, writableText);
    }

}
