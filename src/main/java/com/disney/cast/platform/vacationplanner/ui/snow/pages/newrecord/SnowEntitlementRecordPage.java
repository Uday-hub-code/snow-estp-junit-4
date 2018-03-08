package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.ControlSnowBasePage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.components.CheckBoxComponent;

public class SnowEntitlementRecordPage extends ControlSnowBasePage {
    private Supplier<WebElement> activeLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_entitlement.u_active'] span[class*='label-text']")));
    private Supplier<WebElement> entitlementNameLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_entitlement.u_entitlement_name'] span[class*='label-text']")));
    private Supplier<WebElement> userLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_entitlement.u_user'] span[class*='label-text']")));
    private Supplier<WebElement> eligibilityLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_entitlement.u_eligibility'] span[class*='label-text']")));
    private Supplier<WebElement> rewardLevelLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_entitlement.u_reward_level'] span[class*='label-text']")));
    private Supplier<WebElement> rewardLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_entitlement.u_reward'] span[class*='label-text']")));
    private Supplier<WebElement> entitlementStatusLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_entitlement.u_entitlement_status'] span[class*='label-text']")));
    private Supplier<WebElement> earnedStartDateLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_entitlement.u_earned_start_date'] span[class*='label-text']")));
    private Supplier<WebElement> earnedEndDateLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_entitlement.u_earned_end_date'] span[class*='label-text']")));
    private Supplier<WebElement> redemptionPeriodStartDateLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_entitlement.u_redemption_period_start_date'] span[class*='label-text']")));
    private Supplier<WebElement> redemptionPeriodEndDateLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_entitlement.u_redemption_period_end_date'] span[class*='label-text']")));
    private Supplier<WebElement> redemptionTimezoneLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_entitlement.u_redemption_timezone'] span[class*='label-text']")));

    private CheckBoxComponent activeCheckBox = new CheckBoxComponent(id("x_wdtpa_wdpr_vacat_entitlement.u_active"));

    private Supplier<WebElement> entitlementNameTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_entitlement_name")));
    private Supplier<WebElement> userTxtInput = () -> waitFor(presenceOfElementLocated(
            id("sys_display.x_wdtpa_wdpr_vacat_entitlement.u_user")));
    private Supplier<WebElement> eligibilityTxtInput = () -> waitFor(presenceOfElementLocated(
            id("sys_display.x_wdtpa_wdpr_vacat_entitlement.u_eligibility")));
    private Supplier<WebElement> rewardLevelTxtInput = () -> waitFor(presenceOfElementLocated(
            id("sys_display.x_wdtpa_wdpr_vacat_entitlement.u_reward_level")));
    private Supplier<WebElement> rewardTxtInput = () -> waitFor(presenceOfElementLocated(
            id("sys_display.x_wdtpa_wdpr_vacat_entitlement.u_reward")));
    private Supplier<WebElement> entitlementStatusSelect = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_entitlement_status")));
    private Supplier<WebElement> earnedStartDateTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_earned_start_date")));
    private Supplier<WebElement> earnedEndDateTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_earned_end_date")));
    private Supplier<WebElement> redemptionPeriodStartDateTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_redemption_period_start_date")));
    private Supplier<WebElement> redemptionPeriodEndDateTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_redemption_period_end_date")));
    private Supplier<WebElement> redemptionTimezoneTxtInput = () -> waitFor(presenceOfElementLocated(
            id("sys_display.x_wdtpa_wdpr_vacat_entitlement.u_redemption_timezone")));
    private Supplier<WebElement> expectedDeliveryTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_expected_delivery")));
    private Supplier<WebElement> AddressLine1TxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_address_line1")));
    private Supplier<WebElement> AddressLine2TxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_address_line2")));
    private Supplier<WebElement> AddressLine3TxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_address_line3")));
    private Supplier<WebElement> AddressLine4TxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_address_line4")));
    private Supplier<WebElement> cityTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_city")));
    private Supplier<WebElement> stateTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_state")));

    private Supplier<WebElement> countryTxtInput = () -> waitFor(presenceOfElementLocated(
            id("sys_display.x_wdtpa_wdpr_vacat_entitlement.u_country")));

    private Supplier<List<WebElement>> tabs = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "div[class='tabs2_strip']"))).findElements(By.cssSelector("span.tabs2_tab"));

    private Supplier<WebElement> commentsTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_entitlement.u_comments")));

    private Supplier<WebElement> comments = () -> waitFor(presenceOfElementLocated(
            cssSelector("div[id='element.x_wdtpa_wdpr_vacat_entitlement.u_comments.additional']>span")));

    public boolean isActiveCheckboxChecked() {
        return activeCheckBox.isChecked();
    }

    public boolean isActiveCheckboxEditable() {
        return activeCheckBox.isCheckboxClickable();
    }

    public boolean isActiveLabelDisplayed() {
        return isElementEnabled(activeLabel);
    }

    public boolean isEntitlementNameLabelDisplayed() {
        return isElementEnabled(entitlementNameLabel);
    }

    public boolean isUserLabelDisplayed() {
        return isElementEnabled(userLabel);
    }

    public boolean isEligibilityLabelDisplayed() {
        return isElementEnabled(eligibilityLabel);
    }

    public boolean isRewardLevelLabelDisplayed() {
        return isElementEnabled(rewardLevelLabel);
    }

    public boolean isRewardLabelDisplayed() {
        return isElementEnabled(rewardLabel);
    }

    public boolean isEntitlementStatusLabelDisplayed() {
        return isElementEnabled(entitlementStatusLabel);
    }

    public boolean isEarnedStartDateLabelDisplayed() {
        return isElementEnabled(earnedStartDateLabel);
    }

    public boolean isEarnedEndDateLabelDisplayed() {
        return isElementEnabled(earnedEndDateLabel);
    }

    public boolean isRedemptionPeriodEndDateLabelDisplayed() {
        return isElementEnabled(redemptionPeriodEndDateLabel);
    }

    public boolean isRedemptionPeriodStartDateLabelDisplayed() {
        return isElementEnabled(redemptionPeriodStartDateLabel);
    }

    public boolean isRedemptionTimezoneLabelDisplayed() {
        return isElementEnabled(redemptionTimezoneLabel);
    }

    public String getEntitlementNameTxtInputValue() {
        return getTextFromInput(entitlementNameTxtInput);
    }

    public boolean isEntitlementNameTxtInputEditable() {
        return isInputEnabledWithWriting(entitlementNameTxtInput);
    }

    public String getUserTxtInputValue() {
        return getTextFromInput(userTxtInput);
    }

    public boolean isUserTxtInputEditable() {
        return isInputEnabledWithWriting(userTxtInput);
    }

    public String getEligibilityTxtInputValue() {
        return getTextFromInput(eligibilityTxtInput);
    }

    public boolean isEligibilityTxtInputEditable() {
        return isInputEnabledWithWriting(eligibilityTxtInput);
    }

    public String getRewardLevelTxtInputValue() {
        return getTextFromInput(rewardLevelTxtInput);
    }

    public boolean isRewardLevelTxtInputEditable() {
        return isInputEnabledWithWriting(rewardLevelTxtInput);
    }

    public String getRewardTxtInputValue() {
        return getTextFromInput(rewardTxtInput);
    }

    public boolean isRewardTxtInputEditable() {
        return isInputEnabledWithWriting(rewardTxtInput);
    }

    public String getEarnedStartDateTxtInputValue() {
        return getTextFromInput(earnedStartDateTxtInput);
    }

    public boolean isEarnedStartDateTxtInputEditable() {
        return isInputEnabledWithWriting(earnedStartDateTxtInput);
    }

    public String getEarnedEndDateTxtInputValue() {
        return getTextFromInput(earnedEndDateTxtInput);
    }

    public boolean isEarnedEndDateTxtInputEditable() {
        return isInputEnabledWithWriting(earnedEndDateTxtInput);
    }

    public String getRedemptionPeriodStartDateTxtInputValue() {
        return getTextFromInput(redemptionPeriodStartDateTxtInput);
    }

    public boolean isRedemptionPeriodStartDateTxtInputEditable() {
        return isInputEnabledWithWriting(redemptionPeriodStartDateTxtInput);
    }

    public String getRedemptionPeriodEndDateTxtInputValue() {
        return getTextFromInput(redemptionPeriodEndDateTxtInput);
    }

    public boolean isRedemptionPeriodEndDateTxtInputEditable() {
        return isInputEnabledWithWriting(redemptionPeriodEndDateTxtInput);
    }

    public String getRedemptionTimezoneTxtInputValue() {
        return getTextFromInput(redemptionTimezoneTxtInput);
    }

    public boolean isRedemptionTimezoneTxtInputEditable() {
        return isInputEnabledWithWriting(redemptionTimezoneTxtInput);
    }

    public String getExpectedDeliveryTxtInputValue() {
        return getTextFromInput(expectedDeliveryTxtInput);
    }

    public boolean isExpectedDeliveryTxtInputEditable() {
        return isInputEnabledWithWriting(expectedDeliveryTxtInput);
    }

    public void selectElementStatusOption(String option) {
        select(entitlementStatusSelect.get(), option);
    }

    public String getAddressLine1TxtInputValue() {
        return getTextFromInput(AddressLine1TxtInput);
    }

    public boolean isAddressLine1TxtInputEditable() {
        return isInputEnabledWithWriting(AddressLine1TxtInput);
    }

    public String getAddressLine2TxtInputValue() {
        return getTextFromInput(AddressLine2TxtInput);
    }

    public boolean isAddressLine2TxtInputEditable() {
        return isInputEnabledWithWriting(AddressLine2TxtInput);
    }

    public String getAddressLine3TxtInputValue() {
        return getTextFromInput(AddressLine3TxtInput);
    }

    public boolean isAddressLine3TxtInputEditable() {
        return isInputEnabledWithWriting(AddressLine3TxtInput);
    }

    public String getAddressLine4TxtInputValue() {
        return getTextFromInput(AddressLine4TxtInput);
    }

    public boolean isAddressLine4TxtInputEditable() {
        return isInputEnabledWithWriting(AddressLine4TxtInput);
    }

    public String getCityTxtInputValue() {
        return getTextFromInput(cityTxtInput);
    }

    public boolean isCityTxtInputEditable() {
        return isInputEnabledWithWriting(cityTxtInput);
    }

    public String getCommentsTxtInputValue() {
        try {
            clickOnSecondTabForComments();
            return getTextFromInput(commentsTxtInput);
        } finally {
            clickOnFirstTabForDeliveryAddress();
        }
    }

    public String getStateTxtInputValue() {
        return stateTxtInput.get().getAttribute("value");
    }

    public String getCountrySelectValue() {
        return countryTxtInput.get().getAttribute("value");
    }

    public boolean isCommentsTxtInputEditable() {
        try {
            clickOnSecondTabForComments();
            return isInputEnabledWithWriting(commentsTxtInput);
        } finally {
            clickOnFirstTabForDeliveryAddress();
        }
    }

    public String getComment() {
        try {
            clickOnSecondTabForComments();
            String[] co = comments.get().getText().split("\n");
            return co[co.length - 1];
        } finally {
            clickOnFirstTabForDeliveryAddress();
        }
    }

    public void clickOnSecondTabForComments() {
        tabs.get().get(1).click();
    }

    public void clickOnFirstTabForDeliveryAddress() {
        tabs.get().get(0).click();
    }

    @Override
    protected String setOwnUrl() {
        return null;
    }
}
