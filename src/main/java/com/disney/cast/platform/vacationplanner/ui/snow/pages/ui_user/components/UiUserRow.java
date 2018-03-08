/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.ui_user.components;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.DataRow;

/**
 * @author g.moreno
 */
public class UiUserRow extends DataRow {

    private WebElement active = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(3)>a")));

    private WebElement leader = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(4)")));

    private WebElement payroll = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(5)")));

    private WebElement role = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(6)")));

    private WebElement user = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(7)")));

    public UiUserRow(WebElement row) {
        super(row);
    }

    public String isActive() {
        return active.getText();
    }

    public String getLeader() {
        return leader.getText();
    }

    public String getPayroll() {
        return payroll.getText();
    }

    public String getRole() {
        return role.getText();
    }

    public String getUser() {
        return user.getText();
    }

}
