package com.disney.cast.platform.vacationplanner.ui.snow.pages.updaterecord;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.cast.platform.common.ui.snow.pages.SnowBasePage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;

public class SnowUpdateRecordBasePage extends SnowBasePage {

    private Supplier<WebElement> updateButton = () -> {
        return this.waitFor(ExpectedConditions.presenceOfElementLocated(By.id("sysverb_update")));
    };

    private Supplier<WebElement> deleteButton = () -> {
        return this.waitFor(ExpectedConditions.presenceOfElementLocated(By.id("sysverb_delete")));
    };

    protected Supplier<WebElement> backButton = () -> {
        return this.waitFor(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn.btn-default.icon-chevron-left.navbar-btn")));
    };

    public boolean isUpdateButtonDisplayed() {
        return this.updateButton.get().isDisplayed();
    }

    public boolean isDeleteButtonDisplayed() {
        return this.deleteButton.get().isDisplayed();
    }

    public SnowRecordsListPage back() {
        backButton.get().click();
        return new SnowRecordsListPage();
    }

    @Override
    protected String setOwnUrl() {
        return null;
    }

}