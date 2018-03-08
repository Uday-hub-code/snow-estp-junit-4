/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;

/**
 * @author ragha
 */
public class SnowNewRewardsRecordPage extends SnowNewRecordBasePage {

    private Supplier<WebElement> rewardNameLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Reward Name')]")));

    private Supplier<WebElement> rewardAmountLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Reward Amount')]")));

    private Supplier<WebElement> activeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='active')]")));

    private Supplier<WebElement> currencyLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Currency')]")));

    private Supplier<WebElement> rewardDescriptionLabel = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//span[contains(@class, 'label-text') and (text()='Reward Description')]")));

    private Supplier<WebElement> itemCodeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Item code')]")));

    private Supplier<WebElement> itemQuantityLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Item quantity')]")));

    private Supplier<WebElement> rewardLevelLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Reward level')]")));

    private Supplier<WebElement> rewardTaxableLabel = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//span[contains(@class, 'label-text') and (text()='Reward Taxable')]")));

    private Supplier<WebElement> activeCheckbox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector(".input-group-checkbox>label")));

    private Supplier<WebElement> activeInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_active")));

    private Supplier<WebElement> rewardNameTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_name")));

    private Supplier<WebElement> itemTypeListbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_item_type")));

    private Supplier<WebElement> rewardDescriptionTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_description")));

    private Supplier<WebElement> rewardLevelTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_reward_level")));

    private Supplier<WebElement> rewardTaxableListbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_taxable")));

    private Supplier<WebElement> itemCodeTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_item_code")));

    private Supplier<WebElement> rewardAmountTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_amount")));

    private Supplier<WebElement> currencyListbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_currency")));

    private Supplier<WebElement> itemQuantityTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_item_quantity")));

    private Supplier<WebElement> perceivedValueTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_perceived_value")));

    private Supplier<WebElement> estimatedCostTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_estimated_cost")));

    private Supplier<WebElement> payrollValueTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward.u_payroll_value")));

    public boolean isRewardNameLabelDisplayed() {
        return rewardNameLabel.get().isDisplayed();
    }

    public boolean isRewardAmountLabelDisplayed() {
        return rewardAmountLabel.get().isDisplayed();
    }

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isActiveCheckboxDisplayed() {
        return activeCheckbox.get().isDisplayed();
    }

    public boolean isCurrencyLabelDisplayed() {
        return currencyLabel.get().isDisplayed();
    }

    public boolean isrewardDescriptionLabelDisplayed() {
        return rewardDescriptionLabel.get().isDisplayed();
    }

    public boolean isItemCodeLabelDisplayed() {
        return itemCodeLabel.get().isDisplayed();
    }

    public boolean isItemQuantityLabelDisplayed() {
        return itemQuantityLabel.get().isDisplayed();
    }

    public boolean isRewardLevelLabelDisplayed() {
        return rewardLevelLabel.get().isDisplayed();
    }

    public boolean isRewardTaxableLabelDisplayed() {
        return rewardTaxableLabel.get().isDisplayed();
    }

    public boolean isActiveCheckboxEditable() {
        boolean originalState = activeInput.get().getAttribute("value").equals("true");
        activeCheckbox.get().click();
        boolean newState = activeInput.get().getAttribute("value").equals("true");
        return originalState == !newState;
    }

    public boolean isRewardNameTextboxEditable() {
        return isEditable(rewardNameTextbox.get());
    }

    public boolean isRewardDescriptionTextboxEditable() {
        return isEditable(rewardDescriptionTextbox.get());
    }

    public boolean isRewardLevelTextboxEditable() {
        return rewardLevelTextbox.get().isEnabled();
    }

    public boolean isItemCodeTextboxEditable() {
        return isEditable(itemCodeTextbox.get());
    }

    public boolean isRewardAmountTextboxEditable() {
        return isEditable(rewardAmountTextbox.get());
    }

    public boolean isitemQuantityTextboxEditable() {
        return isEditable(itemQuantityTextbox.get());
    }

    public boolean isPerceivedValueTextboxEditable() {
        return isEditable(perceivedValueTextbox.get());
    }

    public boolean isEstimatedCostTextboxEditable() {
        return isEditable(estimatedCostTextbox.get());
    }

    public boolean ispayrollValueTextboxEditable() {
        return isEditable(payrollValueTextbox.get());
    }

    public boolean isItemtypeListboxEditable() {
        return itemTypeListbox.get().isEnabled();
    }

    public boolean isrewardTaxableListboxEditable() {
        return rewardTaxableListbox.get().isEnabled();
    }

    public boolean iscurrencyListBoxEditable() {
        return currencyListbox.get().isEnabled();
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_reward_list.do%3Fsysparm_userpref_module%3Dac1d9358db99fa40a59ff9baae96192c%26sysparm_clear_stack%3Dtrue%26sysparm_clear_stack%3Dtrue";
    }

}
