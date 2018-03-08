package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;

public class SnowNewConfigRecordPage extends SnowNewRecordBasePage {

    private Supplier<WebElement> keyLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Key')]")));

    private Supplier<WebElement> valueLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Value')]")));

    private Supplier<WebElement> activeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Active')]")));

    private Supplier<WebElement> typeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Type')]")));

    private Supplier<WebElement> activeCheckbox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector(".input-group-checkbox>label")));

    private Supplier<WebElement> activeInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_config.u_active")));

    private Supplier<WebElement> keyTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_config.u_key")));

    private Supplier<WebElement> valueTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_config.u_value")));

    public boolean isKeyLabelDisplayed() {
        return keyLabel.get().isDisplayed();
    }

    public boolean isValueLabelDisplayed() {
        return valueLabel.get().isDisplayed();
    }

    public boolean isTypeLabelDisplayed() {
        return typeLabel.get().isDisplayed();
    }

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isActiveCheckboxDisplayed() {
        return activeCheckbox.get().isDisplayed();
    }

    public boolean isActiveCheckboxEditable() {
        boolean originalState = activeInput.get().getAttribute("value").equals("true");
        activeCheckbox.get().click();
        boolean newState = activeInput.get().getAttribute("value").equals("true");
        return originalState == !newState;
    }

    public boolean isKeyTextBoxEditable() {
        return isEditable(keyTextbox.get());
    }

    public boolean isValueTextBoxEditable() {
        return isEditable(valueTextbox.get());
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_config_list.do%3Fsysparm_userpref_module%3Dbef6fb07db147e00a59ff9baae961964%26sysparm_clear_stack%3Dtrue%26sysparm_clear_stack%3Dtrue";
    }

}
