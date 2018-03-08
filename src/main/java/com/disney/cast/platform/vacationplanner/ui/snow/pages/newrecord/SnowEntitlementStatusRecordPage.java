package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.ControlSnowBasePage;

public class SnowEntitlementStatusRecordPage extends ControlSnowBasePage {

    private Supplier<WebElement> statusLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_entitlement_status.u_name'] span[class*='label-text']")));
    private Supplier<WebElement> entitlementLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='sys_display.x_wdtpa_wdpr_vacat_entitlement_status.u_entitlement'] span[class*='label-text']")));
    private Supplier<WebElement> dateLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_entitlement_status.u_date'] span[class*='label-text']")));
    private Supplier<WebElement> createdLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_entitlement_status.sys_created_on'] span[class*='label-text']")));
    private Supplier<WebElement> createdByLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_entitlement_status.sys_created_by'] span[class*='label-text']")));

    private Supplier<WebElement> statusSelect = () -> waitFor(presenceOfElementLocated(
            cssSelector("select[id*='x_wdtpa_wdpr_vacat_entitlement_status.u_name']")));
    private Supplier<WebElement> entitlementTxtInput = () -> waitFor(presenceOfElementLocated(
            cssSelector("input[id*='sys_display.x_wdtpa_wdpr_vacat_entitlement_status.u_entitlement']")));

    private Supplier<WebElement> dateTxtInput = () -> waitFor(presenceOfElementLocated(
            cssSelector("input[id='x_wdtpa_wdpr_vacat_entitlement_status.u_date']")));

    private Supplier<WebElement> createdTxtInput = () -> waitFor(presenceOfElementLocated(
            cssSelector("input[id='x_wdtpa_wdpr_vacat_entitlement_status.sys_created_on']")));
    private Supplier<WebElement> createdByTxtInput = () -> waitFor(presenceOfElementLocated(
            cssSelector("input[id='x_wdtpa_wdpr_vacat_entitlement_status.sys_created_by']")));

    public boolean isStatusLabelDisplayed() {
        return isElementEnabled(statusLabel);
    }

    public boolean isEntitlementLabelDisplayed() {
        return isElementEnabled(entitlementLabel);
    }

    public boolean isDateLabelDisplayed() {
        return isElementEnabled(dateLabel);
    }

    public boolean isCreatedLabelDisplayed() {
        return isElementEnabled(createdLabel);
    }

    public boolean isCreatedByLabelDisplayed() {
        return isElementEnabled(createdByLabel);
    }

    public String getStatusSelectValue() {
        return getTextFromInput(statusSelect);
    }

    public boolean isStatusSelectEditable() {
        final String option = "pending";
        select(statusSelect.get(), option);
        return getTextFromInput(statusSelect).equals(option);
    }

    public String getEntitlementTxtInputValue() {
        return getTextFromInput(entitlementTxtInput);
    }

    public boolean isEntitlementTxtInputEditable() {
        return isInputEnabledWithWriting(entitlementTxtInput);
    }

    public String getDateTxtInputValue() {
        return getTextFromInput(dateTxtInput);
    }

    public boolean isDateTxtInputEditable() {
        return isInputEnabledWithWriting(dateTxtInput);
    }

    public String getCreatedTxtInputValue() {
        return getTextFromInput(createdTxtInput);
    }

    public boolean isCreatedTxtInputEditable() {
        return isInputEnabledWithWriting(createdTxtInput);
    }

    public String getCreatedByTxtInputValue() {
        return getTextFromInput(createdByTxtInput);
    }

    public boolean isCreatedByTxtInputEditable() {
        return isInputEnabledWithWriting(createdByTxtInput);
    }

    @Override
    protected String setOwnUrl() {
        return null;
    }

}
