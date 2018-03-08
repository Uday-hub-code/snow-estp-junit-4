/**
 *
 */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.category;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.updaterecord.SnowUpdateRecordBasePage;

/**
 * @author erick.ricardez
 */
public class CategorySnowUpdateRecordPage extends SnowUpdateRecordBasePage {

    private Supplier<WebElement> activeCheckbox = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(By.id("label.ni.x_wdtpa_wdpr_vacat_category.u_active")));

    private Supplier<WebElement> activeCheckboxHidden = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(By.id("ni.x_wdtpa_wdpr_vacat_category.u_active")));

    private Supplier<WebElement> nameTxtInput = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_category.u_name")));

    public boolean isActiveCheckBoxEnabled() {
        return activeCheckbox.get().isDisplayed() && activeCheckbox.get().isEnabled();
    }

    public boolean isNameTxtInputEnabled() {
        return nameTxtInput.get().isDisplayed() && nameTxtInput.get().isEnabled();
    }

    public void clickCheckbox() {
        click(activeCheckbox.get());
    }

    public boolean isActiveChecked() {
        return Boolean.valueOf(activeCheckboxHidden.get().getAttribute("value"));
    }

    public void writeName(String nameTxt) {
        nameTxtInput.get().sendKeys(nameTxt);
    }

    public String getTxtInputValue() {
        return nameTxtInput.get().getAttribute("value");
    }

    @Override
    public SnowRecordsListPage back() {
        try {
            backButton.get().click();
            return new CategorySnowRecordsListPageContent();
        } finally {
            goToContentIframe();
        }
    }

    public WebElement getActiveCheckBox() {
        return activeCheckbox.get();
    }

    public WebElement getNameTxtInput() {
        return nameTxtInput.get();
    }

}
