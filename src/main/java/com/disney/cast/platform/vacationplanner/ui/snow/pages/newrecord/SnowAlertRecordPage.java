package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.ControlSnowBasePage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.components.CheckBoxComponent;

public class SnowAlertRecordPage extends ControlSnowBasePage {

    public static final String TYPE_MESSAGE = "message";
    public static final String TYPE_WARNING = "warning";
    public static final String ROLE_LEADER = "Leader";
    public static final String ROLE_PLANNER = "Planner";

    private Supplier<WebElement> activeLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("label[for*='ni.x_wdtpa_wdpr_vacat_notification.u_active'] span[class*='label-text']")));
    private Supplier<WebElement> bodyLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("label[for*='x_wdtpa_wdpr_vacat_notification.u_body'] span[class*='label-text']")));
    private Supplier<WebElement> typeLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("label[for*='x_wdtpa_wdpr_vacat_notification.u_type'] span[class*='label-text']")));
    private Supplier<WebElement> roleLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("label[for*='x_wdtpa_wdpr_vacat_notification.u_role'] span[class*='label-text']")));

    private CheckBoxComponent activeCheckbox = new CheckBoxComponent(
            By.id("x_wdtpa_wdpr_vacat_notification.u_active"));

    private Supplier<WebElement> bodyTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_notification.u_body")));
    private Supplier<WebElement> typeSelect = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_notification.u_type")));
    private Supplier<WebElement> roleSelect = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_notification.u_role")));

    public boolean isActiveChecked() {
        return activeCheckbox.isChecked();
    }

    public boolean isActiveEditable() {
        return activeCheckbox.isCheckBoxEnabled();
    }

    public boolean isActiveLabelDisplayed() {
        return isElementEnabled(activeLabel);
    }

    public boolean isBodyLabelDisplayed() {
        return isElementEnabled(bodyLabel);
    }

    public boolean isTypeLabelDisplayed() {
        return isElementEnabled(typeLabel);
    }

    public boolean isRoleLabelDisplayed() {
        return isElementEnabled(roleLabel);
    }

    public String getBodyTxtInputValue() {
        return getTextFromInput(bodyTxtInput);
    }

    public boolean isBodyTxtInputEditable() {
        return isInputEnabledWithWriting(bodyTxtInput);
    }

    public String getTypeSelectValue() {
        return getTextFromInput(typeSelect);
    }

    public boolean isTypeSelectEditable() {
        select(typeSelect.get(), TYPE_MESSAGE);
        return getTextFromInput(typeSelect).equals(TYPE_MESSAGE);
    }

    public String getRoleSelectValue() {
        return getTextFromInput(roleSelect);
    }

    public boolean isRoleSelectEditable() {
        select(roleSelect.get(), ROLE_LEADER);
        return getTextFromInput(roleSelect).equalsIgnoreCase(ROLE_LEADER);
    }

    @Override
    protected String setOwnUrl() {
        return null;
    }

}
