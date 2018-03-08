/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.ui_user;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author g.moreno
 */
public class SnowUpdateUiUsersRecordPage extends SnowUpdateRecordBasePage {
    private Supplier<WebElement> active = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_ui_user.u_active")));

    private Supplier<WebElement> user = () -> waitFor(
            presenceOfElementLocated(By.id("sys_display.x_wdtpa_wdpr_vacat_ui_user.u_user")));

    private Supplier<WebElement> leader = () -> waitFor(
            presenceOfElementLocated(By.id("sys_display.x_wdtpa_wdpr_vacat_ui_user.u_leader")));

    private Supplier<WebElement> payroll = () -> waitFor(
            presenceOfElementLocated(By.id("sys_display.x_wdtpa_wdpr_vacat_ui_user.u_payroll")));

    private Supplier<WebElement> role = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_ui_user.u_role")));

    public String isActive() {
        return active
                .get()
                .getAttribute("value");
    }

    public String getUser() {
        return user.get().getAttribute("value");
    }

    public String getLeader() {
        return leader.get().getAttribute("value");
    }

    public String getPayroll() {
        return payroll.get().getAttribute("value");
    }

    public String getRole() {
        return role.get().getAttribute("value");
    }
}
