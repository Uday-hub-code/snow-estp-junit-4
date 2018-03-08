package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.Keys.TAB;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;

/**
 * @author g.moreno
 */
public class SnowNewPerformanceRecordPage extends SnowNewRecordBasePage {

    private Supplier<WebElement> reportDateLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Report date')]")));

    private Supplier<WebElement> reportDateInput = () -> waitFor(
            presenceOfElementLocated(xpath("//input[@id='x_wdtpa_wdpr_vacat_performance.u_report_date']")));

    private Supplier<WebElement> periodStartDateLabel = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//span[contains(@class, 'label-text') and (text()='Period start date')]")));

    private Supplier<WebElement> periodStartDateInput = () -> waitFor(
            presenceOfElementLocated(xpath("//input[@id='x_wdtpa_wdpr_vacat_performance.u_period_start_date']")));

    private Supplier<WebElement> periodEndDateLabel = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//span[contains(@class, 'label-text') and (text()='Period end date')]")));

    private Supplier<WebElement> periodEndDateInput = () -> waitFor(
            presenceOfElementLocated(xpath("//input[@id='x_wdtpa_wdpr_vacat_performance.u_period_end_date']")));

    private Supplier<WebElement> periodNameLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Period name')]")));

    private Supplier<WebElement> periodNameInput = () -> waitFor(
            presenceOfElementLocated(xpath("//input[@id='x_wdtpa_wdpr_vacat_performance.u_period_name']")));

    private Supplier<WebElement> performanceDataLabel = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//span[contains(@class, 'label-text') and (text()='Performance data')]")));

    private Supplier<WebElement> portalIdLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Portal Id')]")));

    private Supplier<WebElement> portalIdInput = () -> waitFor(
            presenceOfElementLocated(xpath("//input[@id='x_wdtpa_wdpr_vacat_performance.u_username']")));

    private Supplier<WebElement> levelLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Level')]")));

    private Supplier<WebElement> levelInput = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//input[@id='sys_display.x_wdtpa_wdpr_vacat_performance.u_overall_cast_level']")));

    private Supplier<WebElement> eligibilityLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Eligibility')]")));

    private Supplier<WebElement> eligibilityInput = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//input[@id='sys_display.x_wdtpa_wdpr_vacat_performance.u_eligibility']")));

    private Supplier<WebElement> locationLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Location')]")));

    private Supplier<WebElement> locationInput = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//input[@id='sys_display.x_wdtpa_wdpr_vacat_performance.u_location']")));

    public boolean isReportDateLabelDisplayed() {
        return reportDateLabel.get().isDisplayed();
    }

    public boolean isReportDateInputEditable() {
        return isEditable(reportDateInput.get());
    }

    public boolean isPeriodStartDateLabelDisplayed() {
        return periodStartDateLabel.get().isDisplayed();
    }

    public boolean isPeriodStartDateInputEditable() {
        return isEditable(periodStartDateInput.get());
    }

    public boolean isPeriodEndDateLabelDisplayed() {
        return periodEndDateLabel.get().isDisplayed();
    }

    public boolean isPeriodEndDateInputEditable() {
        return isEditable(periodEndDateInput.get());
    }

    public boolean isLevelLabelDisplayed() {
        return levelLabel.get().isDisplayed();
    }

    public boolean isLevelInputEditable() {
        portalIdInput.get().sendKeys(TAB);
        waitFor(elementToBeClickable(levelInput.get()));
        return isEditable(levelInput.get());
    }

    public boolean isPeriodNameLabelDisplayed() {
        return periodNameLabel.get().isDisplayed();
    }

    public boolean isPeriodNameInputEditable() {
        return isEditable(periodNameInput.get());
    }

    public boolean isPerformanceDataLabelDisplayed() {
        return performanceDataLabel.get().isDisplayed();
    }

    public boolean isPortalIdLabelDisplayed() {
        return portalIdLabel.get().isDisplayed();
    }

    public boolean isPortalIdInputEditable() {
        return isEditable(portalIdInput.get());
    }

    public boolean isEligibilityLabelisplayed() {
        return eligibilityLabel.get().isDisplayed();
    }

    public boolean isEligibilityInputEditable() {
        portalIdInput.get().sendKeys(TAB);
        waitFor(elementToBeClickable(eligibilityInput.get()));
        return isEditable(eligibilityInput.get());
    }

    public boolean isLocationLabelDisplayed() {
        return locationLabel.get().isDisplayed();
    }

    public boolean isLocationInputEditable() {
        return isEditable(locationInput.get());
    }

    @Override
    protected String setOwnUrl() {
        return null;
    }

}
