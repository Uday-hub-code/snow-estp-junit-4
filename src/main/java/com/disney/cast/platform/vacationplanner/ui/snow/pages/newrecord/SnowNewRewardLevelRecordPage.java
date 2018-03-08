package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;

public class SnowNewRewardLevelRecordPage extends SnowNewRecordBasePage {

    private Supplier<WebElement> activeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Active')]")));

    private Supplier<WebElement> activeCheckBox = () -> waitFor(
            presenceOfElementLocated(By.id("ni.x_wdtpa_wdpr_vacat_reward_level.u_active")));

    private Supplier<WebElement> activeHiddenLabel = () -> waitFor(
            presenceOfElementLocated(By.id("label.ni.x_wdtpa_wdpr_vacat_reward_level.u_active")));

    private Supplier<WebElement> importKeyLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Import Key')]")));

    private Supplier<WebElement> importKeyInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward_level.u_import_key")));

    private Supplier<WebElement> tierLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Tier')]")));

    private Supplier<WebElement> tierInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward_level.u_tier")));

    private Supplier<WebElement> levelLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Level')]")));

    private Supplier<WebElement> levelInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward_level.u_level")));

    private Supplier<WebElement> sortOrderLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Sort Order')]")));

    private Supplier<WebElement> sortOrderInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_reward_level.u_sort_order")));

    private Supplier<WebElement> uiDisplayLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='UI Display')]")));

    private Supplier<WebElement> uiDisplayCheckBox = () -> waitFor(
            presenceOfElementLocated(By.id("ni.x_wdtpa_wdpr_vacat_reward_level.u_ui_display")));

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isActiveCheckboxDisplayed() {
        return activeCheckBox.get().isDisplayed();
    }

    public boolean isActiveCheckboxEditable() {
        boolean result = false;
        boolean originalState = activeCheckBox.get().isSelected();
        activeHiddenLabel.get().click();
        boolean newState = activeCheckBox.get().isSelected();
        if (originalState != newState) {
            result = true;
        }
        return result;
    }

    public boolean isImportKeyLabelDisplayed() {
        return importKeyLabel.get().isDisplayed();
    }

    public boolean isImportKeyInputDisplayed() {
        return importKeyInput.get().isDisplayed();
    }

    public boolean isTierLabelDisplayed() {
        return tierLabel.get().isDisplayed();
    }

    public boolean isTierInputDisplayed() {
        return tierInput.get().isDisplayed();
    }

    public boolean isLevelLabelDisplayed() {
        return levelLabel.get().isDisplayed();
    }

    public boolean isLevelInputDisplayed() {
        return levelInput.get().isDisplayed();
    }

    public boolean isSortOrderLabelDisplayed() {
        return sortOrderLabel.get().isDisplayed();
    }

    public boolean isSortOrderInputDisplayed() {
        return sortOrderInput.get().isDisplayed();
    }

    public boolean isUiDisplayLabelDisplayed() {
        return uiDisplayLabel.get().isDisplayed();
    }

    public boolean isUiDisplayCheckBoxDisplayed() {
        return uiDisplayCheckBox.get().isDisplayed();
    }

    public boolean isImportKeyInputEditable() {
        return isEditable(importKeyInput.get());
    }

    public boolean isSortOrderInputEditable() {
        return isEditable(sortOrderInput.get());
    }

    @Override
    protected String setOwnUrl() {
        return null;
    }

}
