package com.disney.cast.platform.vacationplanner.ui.snow.pages.performance;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author g.moreno
 */
public class SnowUpdatePerformanceRecordPage extends SnowUpdateRecordBasePage {

    private Supplier<WebElement> reportDate = () -> waitFor(
            presenceOfElementLocated(By.xpath("//input[@id='x_wdtpa_wdpr_vacat_performance.u_report_date']")));

    private Supplier<WebElement> periodStartDate = () -> waitFor(
            presenceOfElementLocated(
                    By.xpath("//input[@id='x_wdtpa_wdpr_vacat_performance.u_period_start_date']")));

    private Supplier<WebElement> periodEndDate = () -> waitFor(
            presenceOfElementLocated(By.xpath("//input[@id='x_wdtpa_wdpr_vacat_performance.u_period_end_date']")));

    private Supplier<WebElement> periodName = () -> waitFor(
            presenceOfElementLocated(By.xpath("//input[@id='x_wdtpa_wdpr_vacat_performance.u_period_name']")));

    private Supplier<WebElement> portalId = () -> waitFor(
            presenceOfElementLocated(By.xpath("//input[@id='x_wdtpa_wdpr_vacat_performance.u_username']")));

    private Supplier<WebElement> level = () -> waitFor(
            presenceOfElementLocated(
                    By.xpath("//input[@id='sys_display.x_wdtpa_wdpr_vacat_performance.u_overall_cast_level']")));

    private Supplier<WebElement> eligibility = () -> waitFor(
            presenceOfElementLocated(
                    By.xpath("//input[@id='sys_display.x_wdtpa_wdpr_vacat_performance.u_eligibility']")));

    private Supplier<WebElement> location = () -> waitFor(
            presenceOfElementLocated(
                    By.xpath("//input[@id='sys_display.x_wdtpa_wdpr_vacat_performance.u_location']")));

    private Supplier<WebElement> performanceData = () -> waitFor(
            presenceOfElementLocated(
                    By.xpath("//textarea[@id='x_wdtpa_wdpr_vacat_performance.u_performance_data']")));

    public String getReportDate() {
        return reportDate.get().getAttribute("value");
    }

    public String getPeriodStartDate() {
        return periodStartDate.get().getAttribute("value");
    }

    public String getPeriodEndDate() {
        return periodEndDate.get().getAttribute("value");
    }

    public String getPeriodName() {
        return periodName.get().getAttribute("value");
    }

    public String getPortalId() {
        return portalId.get().getAttribute("value");
    }

    public String getLevel() {
        return level.get().getAttribute("value");
    }

    public String getEligibility() {
        return eligibility.get().getAttribute("value");
    }

    public String getLocation() {
        return location.get().getAttribute("value");
    }

    public String getPerformanceData() {
        return performanceData.get().getAttribute("value");
    }
}
