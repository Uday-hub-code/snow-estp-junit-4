/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;

/**
 * @author Raghav
 */
public class SnowNewImagesRecordPage extends SnowNewRecordBasePage {
    private Supplier<WebElement> nameLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='name')]")));

    private Supplier<WebElement> activeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='active')]")));

    private Supplier<WebElement> rectangleLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='rectangle')]")));

    private Supplier<WebElement> sortorderLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='sort_order')]")));

    private Supplier<WebElement> thumbnailLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='thumbnail')]")));

    private Supplier<WebElement> fullLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='full')]")));

    private Supplier<WebElement> activeCheckbox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector(".input-group-checkbox>label")));

    private Supplier<WebElement> activeInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_image.u_active")));

    private Supplier<WebElement> nameTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_image.u_name")));

    private Supplier<WebElement> sortorderTextbox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_image.u_sort_order")));

    public boolean isNameLabelDisplayed() {

        return nameLabel.get().isDisplayed();
    }

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isRectangleLabelDisplayed() {

        return rectangleLabel.get().isDisplayed();
    }

    public boolean isSortOrderLabelDisplayed() {
        return sortorderLabel.get().isDisplayed();
    }

    public boolean isThaumbnailLabelDisplayed() {
        return thumbnailLabel.get().isDisplayed();
    }

    public boolean isFullLabelDisplayed() {
        return fullLabel.get().isDisplayed();
    }

    public boolean isActiveCheckboxEditable() {
        boolean originalState = activeInput.get().getAttribute("value").equals("true");
        activeCheckbox.get().click();
        boolean newState = activeInput.get().getAttribute("value").equals("true");
        return originalState == !newState;
    }

    public boolean isNameTextboxEditable() {
        return isEditable(nameTextbox.get());
    }

    public boolean isSortOrderTextBoxEditable() {
        return isEditable(sortorderTextbox.get());
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_image_list.do%3Fsysparm_userpref_module%3D60436417db547e00a59ff9baae9619a2%26sysparm_clear_stack%3Dtrue%26sysparm_clear_stack%3D";
    }

}
