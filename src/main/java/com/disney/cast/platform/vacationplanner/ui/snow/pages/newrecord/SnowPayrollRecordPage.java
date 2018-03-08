package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.ControlSnowBasePage;

public class SnowPayrollRecordPage extends ControlSnowBasePage {

    private Supplier<WebElement> periodLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_period'] span[class*='label-text']")));
    private Supplier<WebElement> infoTypeLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_infotype'] span[class*='label-text']")));
    private Supplier<WebElement> numberLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_number'] span[class*='label-text']")));
    private Supplier<WebElement> unitLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_unit'] span[class*='label-text']")));
    private Supplier<WebElement> dateLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_date'] span[class*='label-text']")));
    private Supplier<WebElement> reasonForChangeLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_reason_for_change'] span[class*='label-text']")));
    private Supplier<WebElement> businessAreaLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_business_area'] span[class*='label-text']")));
    private Supplier<WebElement> costCenterLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_cost_center'] span[class*='label-text']")));
    private Supplier<WebElement> companyCodeLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_company_code'] span[class*='label-text']")));
    private Supplier<WebElement> wbsElementLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_wbs_element'] span[class*='label-text']")));
    private Supplier<WebElement> intOrderLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_int_order'] span[class*='label-text']")));
    private Supplier<WebElement> networkLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_network'] span[class*='label-text']")));
    private Supplier<WebElement> activityLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_activity'] span[class*='label-text']")));
    private Supplier<WebElement> mpmIssueLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_mpm_issue'] span[class*='label-text']")));
    private Supplier<WebElement> destGeoLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_dest_geo'] span[class*='label-text']")));
    private Supplier<WebElement> textFieldLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector("label[for*='x_wdtpa_wdpr_vacat_payroll.u_text_field'] span[class*='label-text']")));
    private Supplier<WebElement> costCenterDescriptionLabel = () -> waitFor(presenceOfElementLocated(
            cssSelector(
                    "label[for*='x_wdtpa_wdpr_vacat_payroll.u_cost_center_description'] span[class*='label-text']")));
    private Supplier<WebElement> periodTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_period")));
    private Supplier<WebElement> infoTypeTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_infotype")));
    private Supplier<WebElement> numberTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_number")));
    private Supplier<WebElement> unitTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_unit")));
    private Supplier<WebElement> dateTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_date")));
    private Supplier<WebElement> reasonForChangeTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_reason_for_change")));
    private Supplier<WebElement> businessAreaTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_business_area")));
    private Supplier<WebElement> costCenterTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_cost_center")));
    private Supplier<WebElement> companyCodeTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_company_code")));
    private Supplier<WebElement> wbsElementTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_wbs_element")));
    private Supplier<WebElement> intOrderTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_int_order")));
    private Supplier<WebElement> networkTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_network")));
    private Supplier<WebElement> activityTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_activity")));
    private Supplier<WebElement> mpmIssueTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_mpm_issue")));
    private Supplier<WebElement> destGeoTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_dest_geo")));
    private Supplier<WebElement> textFieldTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_text_field")));
    private Supplier<WebElement> costCenterDescriptionTxtInput = () -> waitFor(presenceOfElementLocated(
            id("x_wdtpa_wdpr_vacat_payroll.u_cost_center_description")));

    Supplier<WebElement> nameTxtInput = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(id("x_wdtpa_wdpr_vacat_elligibility.u_name")));

    Supplier<WebElement> importKeyTxtInput = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(id("x_wdtpa_wdpr_vacat_elligibility.u_import_key")));

    public String getPeriodTxtInputValue() {
        return getTextFromInput(periodTxtInput);
    }

    public boolean isPeriodTxtInputEditable() {
        return isInputEnabledWithWriting(periodTxtInput);
    }

    public String getInfoTypeTxtInputValue() {
        return getTextFromInput(infoTypeTxtInput);
    }

    public boolean isInfoTypeTxtInputEditable() {
        return isInputEnabledWithWriting(infoTypeTxtInput);
    }

    public String getNumberTxtInputValue() {
        return getTextFromInput(numberTxtInput);
    }

    public boolean isNumberTxtInputEditable() {
        return isInputEnabledWithWriting(numberTxtInput);
    }

    public String getUnitTxtInputValue() {
        return getTextFromInput(unitTxtInput);
    }

    public boolean isUnitTxtInputEditable() {
        return isInputEnabledWithWriting(unitTxtInput);
    }

    public String getDateTxtInputValue() {
        return getTextFromInput(dateTxtInput);
    }

    public boolean isDateTxtInputEditable() {
        return isInputEnabledWithWriting(dateTxtInput);
    }

    public String getReasonForChangeTxtInputValue() {
        return getTextFromInput(reasonForChangeTxtInput);
    }

    public boolean isReasonForChangeTxtInputEditable() {
        return isInputEnabledWithWriting(reasonForChangeTxtInput);
    }

    public String getBusinessAreaTxtInputValue() {
        return getTextFromInput(businessAreaTxtInput);
    }

    public boolean isBusinessAreaTxtInputEditable() {
        return isInputEnabledWithWriting(businessAreaTxtInput);
    }

    public String getCostCenterTxtInputValue() {
        return getTextFromInput(costCenterTxtInput);
    }

    public boolean isCostCenterTxtInputEditable() {
        return isInputEnabledWithWriting(costCenterTxtInput);
    }

    public String getCompanyCodeTxtInputValue() {
        return getTextFromInput(companyCodeTxtInput);
    }

    public boolean isCompanyCodeTxtInputEditable() {
        return isInputEnabledWithWriting(companyCodeTxtInput);
    }

    public String getWbsElementTxtInputValue() {
        return getTextFromInput(wbsElementTxtInput);
    }

    public boolean isWbsElementTxtInputEditable() {
        return isInputEnabledWithWriting(wbsElementTxtInput);
    }

    public String getIntOrderTxtInputValue() {
        return getTextFromInput(intOrderTxtInput);
    }

    public boolean isIntOrderTxtInputEditable() {
        return isInputEnabledWithWriting(intOrderTxtInput);
    }

    public String getNetworkTxtInputValue() {
        return getTextFromInput(networkTxtInput);
    }

    public boolean isNetworkTxtInputEditable() {
        return isInputEnabledWithWriting(networkTxtInput);
    }

    public String getActivityTxtInputValue() {
        return getTextFromInput(activityTxtInput);
    }

    public boolean isActivityTxtInputEditable() {
        return isInputEnabledWithWriting(activityTxtInput);
    }

    public String getMpmIssueTxtInputValue() {
        return getTextFromInput(mpmIssueTxtInput);
    }

    public boolean isMpmIssueTxtInputEditable() {
        return isInputEnabledWithWriting(mpmIssueTxtInput);
    }

    public String getDestGeoTxtInputValue() {
        return getTextFromInput(destGeoTxtInput);
    }

    public boolean isDestGeoTxtInputEditable() {
        return isInputEnabledWithWriting(destGeoTxtInput);
    }

    public String getTextFieldTxtInputValue() {
        return getTextFromInput(textFieldTxtInput);
    }

    public boolean isTextFieldTxtInputEditable() {
        return isInputEnabledWithWriting(textFieldTxtInput);
    }

    public String getCostCenterDescriptionTxtInputValue() {
        return getTextFromInput(costCenterDescriptionTxtInput);
    }

    public boolean isCostCenterDescriptionTxtInputEditable() {
        return isInputEnabledWithWriting(costCenterDescriptionTxtInput);
    }

    public boolean isPeriodLabelDisplayed() {
        return isElementEnabled(periodLabel);
    }

    public boolean isInfoTypeLabelDisplayed() {
        return isElementEnabled(infoTypeLabel);
    }

    public boolean isNumberLabelDisplayed() {
        return isElementEnabled(numberLabel);
    }

    public boolean isUnitLabelDisplayed() {
        return isElementEnabled(unitLabel);
    }

    public boolean isDateLabelDisplayed() {
        return isElementEnabled(dateLabel);
    }

    public boolean isReasonForChangeLabelDisplayed() {
        return isElementEnabled(reasonForChangeLabel);
    }

    public boolean isBusinessAreaLabelDisplayed() {
        return isElementEnabled(businessAreaLabel);
    }

    public boolean isCostCenterLabelDisplayed() {
        return isElementEnabled(costCenterLabel);
    }

    public boolean isCompanyCodeLabelDisplayed() {
        return isElementEnabled(companyCodeLabel);
    }

    public boolean isWbsElementLabelDisplayed() {
        return isElementEnabled(wbsElementLabel);
    }

    public boolean isIntOrderLabelDisplayed() {
        return isElementEnabled(intOrderLabel);
    }

    public boolean isNetworkLabelDisplayed() {
        return isElementEnabled(networkLabel);
    }

    public boolean isActivityLabelDisplayed() {
        return isElementEnabled(activityLabel);
    }

    public boolean isMpmIssueLabelDisplayed() {
        return isElementEnabled(mpmIssueLabel);
    }

    public boolean isDestGeoLabelDisplayed() {
        return isElementEnabled(destGeoLabel);
    }

    public boolean isTextFieldLabelDisplayed() {
        return isElementEnabled(textFieldLabel);
    }

    public boolean isCostCenterDescriptionLabelDisplayed() {
        return isElementEnabled(costCenterDescriptionLabel);
    }

    @Override
    protected String setOwnUrl() {
        return null;
    }

}
