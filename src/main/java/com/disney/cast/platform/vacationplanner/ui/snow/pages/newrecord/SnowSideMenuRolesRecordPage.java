/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.components.Backable;

/**
 * @author ragha
 */
public class SnowSideMenuRolesRecordPage extends SnowNewRecordBasePage implements Backable {

    private Supplier<WebElement> activeLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector(
                    "label[for*='ni.x_wdtpa_wdpr_vacat_side_menu_role.u_active'] span[class*='label-text']")));

    private Supplier<WebElement> activeCheckBox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector("label[class*='checkbox-label']")));

    private Supplier<WebElement> activeCheckBoxHidden = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu_role.u_active")));

    private Supplier<WebElement> nameLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("label[for*='x_wdtpa_wdpr_vacat_side_menu_role.u_name'] span[class*='label-text']")));

    private Supplier<WebElement> nameTxtInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu_role.u_name")));

    private Supplier<WebElement> functionLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_side_menu_role.u_function'] span[class*='label-text']")));

    private Supplier<WebElement> functionTxtInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu_role.u_function")));
    protected Supplier<WebElement> backButton = () -> {
        return this.waitFor(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("button.btn.btn-default.icon-chevron-left.navbar-btn")));
    };

    public String getTextFromInput(Supplier<WebElement> sup) {
        return sup.get().getAttribute("value");
    }

    public String getTextFromNameTxtInput() {
        return getTextFromInput(nameTxtInput);
    }

    public String getTextFromFunctionTxtInput() {
        return getTextFromInput(functionTxtInput);
    }

    public boolean isElementEnabled(Supplier<WebElement> element) {
        return element.get().isDisplayed() && element.get().isEnabled();
    }

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isCheckBoxEnabled() {
        return activeCheckBox.get().isDisplayed() && activeCheckBox.get().isEnabled();
    }

    public boolean isActiveCheckboxClickable() {
        if (isCheckBoxEnabled()) {
            boolean initialStatus = isActiveChecked();
            activeCheckBox.get().click();
            return initialStatus != Boolean.valueOf(activeCheckBoxHidden.get().getAttribute("value"));
        }
        return Boolean.FALSE;
    }

    public boolean isActiveChecked() {
        return Boolean.valueOf(activeCheckBoxHidden.get().getAttribute("value"));
    }

    public boolean isNameLabelDisplayed() {
        return nameLabel.get().isDisplayed();
    }

    public boolean isFunctionLabelDisplayed() {
        return functionLabel.get().isDisplayed();
    }

    public boolean isNameTextInputEnabled() {
        return isElementEnabled(nameTxtInput);
    }

    public boolean isFunctionTextInputEnabled() {
        return isElementEnabled(functionTxtInput);
    }

    public boolean isInputEnabledWithWriting(Supplier<WebElement> element) {
        return isInputEnabledWithWriting(element, "writable");
    }

    public void writeKey(String name) {
        nameTxtInput.get().sendKeys(name);
    }

    public boolean isNameTxtInputEnabledWithWriting() {
        return isInputEnabledWithWriting(nameTxtInput);
    }

    public boolean isFunctionTxtInputEnabledWithWriting() {
        return isInputEnabledWithWriting(functionTxtInput);
    }

    public boolean isInputEnabledWithWriting(Supplier<WebElement> element, String writableText) {
        final String text = writableText;
        if (isElementEnabled(element)) {
            element.get().sendKeys(text);
            return text.equals(element.get().getAttribute("value"));
        }
        return Boolean.FALSE;
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_side_menu_role_list.do%3Fsysparm_userpref_module%3Da68d547cdb913200a59ff9baae9619c4%26sysparm_clear_stack%3Dtrue%26sysparm_clear_stack%3D";
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends SnowRecordsListPage> T back() {
        backButton.get().click();
        return (T) new SnowRecordsListPage();
    }

}
