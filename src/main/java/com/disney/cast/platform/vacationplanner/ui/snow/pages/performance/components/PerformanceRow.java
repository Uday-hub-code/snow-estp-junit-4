/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.performance.components;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.DataRow;

/**
 * @author g.moreno
 */
public class PerformanceRow extends DataRow {

    private WebElement eligibility = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(3)")));

    private WebElement location = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(4)")));

    private WebElement level = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(5)")));

    private WebElement performanceData = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(6)")));

    private WebElement periodEndDate = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(7)")));

    private WebElement periodName = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(8)")));

    private WebElement periodStartDate = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(9)")));

    private WebElement reportDate = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(10)")));

    private WebElement portalId = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(11)")));

    public PerformanceRow(WebElement row) {
        super(row);
    }

    public String getEligibility() {
        return eligibility.getText();
    }

    public String getLocation() {
        return location.getText();
    }

    public String getLevel() {
        return level.getText();
    }

    public String getPerformanceData() {
        return performanceData.getText();
    }

    public String getPeriodEndDate() {
        return periodEndDate.getText();
    }

    public String getPeriodName() {
        return periodName.getText();
    }

    public String getPeriodStartDate() {
        return periodStartDate.getText();
    }

    public String getReportDate() {
        return reportDate.getText();
    }

    public String getPortalId() {
        return portalId.getText();
    }

}
