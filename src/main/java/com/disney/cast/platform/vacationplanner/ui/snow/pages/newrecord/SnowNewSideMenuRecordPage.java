/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.components.Backable;

/**
 * @author ragha
 */
public class SnowNewSideMenuRecordPage extends SnowNewRecordBasePage implements Backable {

    private Supplier<WebElement> activeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Active')]")));

    private Supplier<WebElement> containerLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Container')]")));

    private Supplier<WebElement> nameLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Name')]")));

    private Supplier<WebElement> translationLabel = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//span[contains(@class, 'label-text') and (text()='Translation key')]")));

    private Supplier<WebElement> parentLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Parent')]")));

    private Supplier<WebElement> sortLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Sort order')]")));

    private Supplier<WebElement> separatorLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Separator')]")));

    private Supplier<WebElement> actionLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Action')]")));

    private Supplier<WebElement> typeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Type')]")));

    private Supplier<WebElement> iconLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Icon')]")));

    private Supplier<WebElement> advancedLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Advanced')]")));

    private Supplier<WebElement> activeCheckbox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector(".input-group-checkbox>label[id$='u_active']")));

    private Supplier<WebElement> activeInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu.u_active")));

    private Supplier<WebElement> containerCheckbox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector(".input-group-checkbox>label[id$='u_container']")));

    private Supplier<WebElement> containerInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu.u_container")));

    private Supplier<WebElement> advancedCheckbox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector(".input-group-checkbox>label[id$='u_advanced']")));

    private Supplier<WebElement> advancedInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu.u_advanced")));

    private Supplier<WebElement> nameTextInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu.u_name")));

    private Supplier<WebElement> parentTextInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu.u_parent")));

    private Supplier<WebElement> translationKeyTextInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu.u_translation_key")));

    private Supplier<WebElement> sortOrderTextInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu.u_sort_order")));

    private Supplier<WebElement> actionTextInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu.u_action")));

    private Supplier<WebElement> iconTextInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_side_menu.u_icon")));

    private Supplier<WebElement> typeSelect = () -> waitFor(
            presenceOfElementLocated(By.name("x_wdtpa_wdpr_vacat_side_menu.u_type")));

    private Supplier<WebElement> separatorSelect = () -> waitFor(
            presenceOfElementLocated(By.name("x_wdtpa_wdpr_vacat_side_menu.u_separator")));

    protected Supplier<WebElement> backButton = () -> {
        return this.waitFor(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("button.btn.btn-default.icon-chevron-left.navbar-btn")));
    };

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isContainerLabelDisplayed() {
        return containerLabel.get().isDisplayed();
    }

    public boolean isNameLabelDisplayed() {
        return nameLabel.get().isDisplayed();
    }

    public boolean isTranslationLabelDisplayed() {
        return translationLabel.get().isDisplayed();
    }

    public boolean isParenLabelDisplayed() {
        return parentLabel.get().isDisplayed();
    }

    public boolean isSortLabelDisplayed() {
        return sortLabel.get().isDisplayed();
    }

    public boolean isSeparatorLabelDisplayed() {
        return separatorLabel.get().isDisplayed();
    }

    public boolean isActiveCheckboxDisplayed() {
        return activeCheckbox.get().isDisplayed();
    }

    public boolean isActionLabelDisplayed() {
        return actionLabel.get().isDisplayed();
    }

    public boolean isTypeLabelDisplayed() {
        return typeLabel.get().isDisplayed();
    }

    public boolean isIconLabelDisplayed() {
        return iconLabel.get().isDisplayed();
    }

    public boolean isAdvancedLabelDisplayed() {
        return advancedLabel.get().isDisplayed();
    }

    public boolean isActiveCheckboxEditable() {
        boolean originalState = activeInput.get().getAttribute("value").equals("true");
        activeCheckbox.get().click();
        boolean newState = activeInput.get().getAttribute("value").equals("true");
        return originalState == !newState;
    }

    public boolean isContainerCheckboxEditable() {
        boolean originalState = containerInput.get().getAttribute("value").equals("true");
        containerCheckbox.get().click();
        boolean newState = containerInput.get().getAttribute("value").equals("true");
        return originalState == !newState;
    }

    public boolean isAdvancedCheckboxEditable() {
        boolean originalState = advancedInput.get().getAttribute("value").equals("true");
        advancedCheckbox.get().click();
        boolean newState = advancedInput.get().getAttribute("value").equals("true");
        return originalState == !newState;
    }

    public boolean isNameTextInputEditable() {
        return isEditable(nameTextInput.get());
    }

    public boolean isParentTextInputEditable() {
        return isEditable(parentTextInput.get());
    }

    public boolean isTranslationKeyTextInputEditable() {
        return isEditable(translationKeyTextInput.get());
    }

    public boolean isSortOrderTextInputEditable() {
        return isEditable(sortOrderTextInput.get());
    }

    public boolean isActionTextInputEditable() {
        return isEditable(actionTextInput.get());
    }

    public boolean isIconTextInputEditable() {
        return isEditable(iconTextInput.get());
    }

    public String getActiveInput() {
        return activeInput.get().getAttribute("value");
    }

    public String getContainerInput() {
        return containerInput.get().getAttribute("value");
    }

    public String getAdvancedInput() {
        return advancedInput.get().getAttribute("value");
    }

    public String getNameTextInput() {
        return nameTextInput.get().getAttribute("value");
    }

    public String getParentTextInput() {
        return parentTextInput.get().getAttribute("value");
    }

    public String getTranslationKeyTextInput() {
        return translationKeyTextInput.get().getAttribute("value");
    }

    public String getSortOrderTextInput() {
        return sortOrderTextInput.get().getAttribute("value");
    }

    public String getActionTextInput() {
        return actionTextInput.get().getAttribute("value");
    }

    public String getIconTextInput() {
        return iconTextInput.get().getAttribute("value");
    }

    public String getTypeValue() {
        return typeSelect.get().getAttribute("value");
    }

    public String getSeparatorValue() {
        return separatorSelect.get().getAttribute("value");
    }

    public boolean isTypeEditable() {
        containerCheckbox.get().click();
        return isSelectable(typeSelect.get());
    }

    public boolean isSelectable(WebElement selectElement) {
        String originalValue = selectElement.getAttribute("value");
        Select select = new Select(selectElement);
        select.selectByIndex(1);
        String newValue = selectElement.getAttribute("value");
        return !originalValue.equals(newValue);
    }

    @Override
    protected String setOwnUrl() {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends SnowRecordsListPage> T back() {
        backButton.get().click();
        return (T) new SnowRecordsListPage();
    }

}
