package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.ControlSnowBasePage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.components.CheckBoxComponent;

public class SnowEligibilitiesRecordPage extends ControlSnowBasePage {

    private Supplier<WebElement> activeLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='ni.x_wdtpa_wdpr_vacat_elligibility.u_active'] span[class*='label-text']")));

    private Supplier<WebElement> nameLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_elligibility.u_name'] span[class*='label-text']")));

    private Supplier<WebElement> importKeyLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_elligibility.u_import_key'] span[class*='label-text']")));

    CheckBoxComponent activeCheckBox = new CheckBoxComponent(id("x_wdtpa_wdpr_vacat_elligibility.u_active"));

    Supplier<WebElement> nameTxtInput = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(id("x_wdtpa_wdpr_vacat_elligibility.u_name")));

    Supplier<WebElement> importKeyTxtInput = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(id("x_wdtpa_wdpr_vacat_elligibility.u_import_key")));

    public boolean isActiveChecked() {
        return activeCheckBox.isChecked();
    }

    public boolean isActiveDisplayed() {
        return activeCheckBox.isCheckBoxEnabled();
    }

    public boolean isActiveCheckboxClickable() {
        return activeCheckBox.isCheckboxClickable();
    }

    public String getNameFromTxtInput() {
        return getTextFromInput(nameTxtInput);
    }

    public boolean isNameTxtInputEditable() {
        return isInputEnabledWithWriting(nameTxtInput);
    }

    public String getImportKeyFromTxtInput() {
        return getTextFromInput(importKeyTxtInput);
    }

    public boolean isImportTxtInputEditable() {
        return isInputEnabledWithWriting(importKeyTxtInput);
    }

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed() && activeLabel.get().isEnabled();
    }

    public boolean isNameLabelDisplayed() {
        return nameLabel.get().isDisplayed() && nameLabel.get().isEnabled();
    }

    public boolean isImportKeyLabelDisplayed() {
        return importKeyLabel.get().isDisplayed() && importKeyLabel.get().isEnabled();
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprlatest.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_elligibility.do%3Fsys_id%3D-1%26sys_is_list%3Dtrue%26sys_target%3Dx_wdtpa_wdpr_vacat_elligibility%26sysparm_checked_items%3D%26sysparm_ck%3Dce425315db0bf2002d3cd024ce9619ccbf81f6002f4b4e07589d1f2f2face31b96a421f2%26sysparm_fixed_query%3D%26sysparm_group_sort%3D%26sysparm_list_css%3D%26sysparm_query%3D%26sysparm_referring_url%3Dx_wdtpa_wdpr_vacat_elligibility_list.do%253fsysparm_clear_stack%253dtrue%26sysparm_target%3D%26sysparm_view%3D";
    }

}
