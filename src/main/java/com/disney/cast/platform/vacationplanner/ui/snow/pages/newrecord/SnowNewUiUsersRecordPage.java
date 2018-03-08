package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.Keys.ARROW_DOWN;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.components.Backable;

/**
 * Class that represents the page for adding new Ui Users
 *
 * @author g.moreno
 */
public class SnowNewUiUsersRecordPage extends SnowNewRecordBasePage implements Backable {

    private Supplier<WebElement> activeLabel = () -> waitFor(
            presenceOfElementLocated(By.xpath("//span[contains(@class, 'label-text') and (text()='User')]")));

    private Supplier<WebElement> userLabel = () -> waitFor(
            presenceOfElementLocated(By.xpath("//span[contains(@class, 'label-text') and (text()='User')]")));

    private Supplier<WebElement> leaderLabel = () -> waitFor(
            presenceOfElementLocated(By.xpath("//span[contains(@class, 'label-text') and (text()='Leader')]")));

    private Supplier<WebElement> payrollLabel = () -> waitFor(
            presenceOfElementLocated(By.xpath("//span[contains(@class, 'label-text') and (text()='Payroll')]")));

    private Supplier<WebElement> roleLabel = () -> waitFor(
            presenceOfElementLocated(By.xpath("//span[contains(@class, 'label-text') and (text()='Role')]")));

    private Supplier<WebElement> activeHiddenCheckBox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_ui_user.u_active")));

    private Supplier<WebElement> activeLabelClickable = () -> waitFor(
            presenceOfElementLocated(By.id("label.ni.x_wdtpa_wdpr_vacat_ui_user.u_active")));

    private Supplier<WebElement> userInput = () -> waitFor(
            presenceOfElementLocated(By.id("sys_display.x_wdtpa_wdpr_vacat_ui_user.u_user")));

    private Supplier<WebElement> leaderInput = () -> waitFor(
            presenceOfElementLocated(By.id("sys_display.x_wdtpa_wdpr_vacat_ui_user.u_leader")));

    private Supplier<WebElement> payrollInput = () -> waitFor(
            presenceOfElementLocated(By.id("sys_display.x_wdtpa_wdpr_vacat_ui_user.u_payroll")));

    private Supplier<WebElement> roleDropBox = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_ui_user.u_role")));

    // Could be in SnowNewRecordBasePage
    protected Supplier<WebElement> backButton = () -> {
        return this.waitFor(
                presenceOfElementLocated(
                        By.cssSelector("button.btn.btn-default.icon-chevron-left.navbar-btn")));
    };

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isUserLabelDisplayed() {
        return userLabel.get().isDisplayed();
    }

    public boolean isLeaderLabelDisplayed() {
        return leaderLabel.get().isDisplayed();
    }

    public boolean isPayrollLabelDisplayed() {
        return payrollLabel.get().isDisplayed();
    }

    public boolean isRoleLabelDisplayed() {
        return roleLabel.get().isDisplayed();
    }

    public boolean isActiveHiddenCheckBoxEditable() {
        boolean originalState = activeHiddenCheckBox.get().getAttribute("value").equals("true");
        activeLabelClickable.get().click();
        boolean newState = activeHiddenCheckBox.get().getAttribute("value").equals("true");
        return originalState == !newState;
    }

    public boolean isUserInputEditable() {
        return isEditable(userInput.get());
    }

    public boolean isLeaderInputEditable() {
        return isEditable(leaderInput.get());
    }

    public boolean isPayrollInputEditable() {
        return isEditable(payrollInput.get());
    }

    public boolean isElementEnabled(Supplier<WebElement> element) {
        return element.get().isDisplayed() && element.get().isEnabled();
    }

    public boolean isRoleDropBoxEditable() {
        boolean result = false;
        String originalState = roleDropBox.get().getAttribute("value");

        roleDropBox.get().sendKeys(ARROW_DOWN, ARROW_DOWN);
        roleDropBox.get().sendKeys(ENTER);
        String newState = roleDropBox.get().getAttribute("value");
        if (originalState != newState) {
            result = true;
        }
        return result;
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_user.do%3Fsys_id%3D-1%26sys_is_list%3Dtrue%26sys_target%3Dx_wdtpa_wdpr_vacat_user%26sysparm_checked_items%3D%26sysparm_ck%3D8dce7f40db717e00aa7df8fdae96191f31641734fbbd5b78df756dfe62332a5d7cb8d27e%26sysparm_fixed_query%3D%26sysparm_group_sort%3D%26sysparm_list_css%3D%26sysparm_query%3Du_user.active%253dtrue%26sysparm_referring_url%3Dx_wdtpa_wdpr_vacat_user_list.do%253fsysparm_query%253du_user.active%25253Dtrue%25255EEQ%254099%2540sysparm_clear_stack%253dtrue%26sysparm_target%3D%26sysparm_view%3D";
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends SnowRecordsListPage> T back() {
        backButton.get().click();
        return (T) new SnowRecordsListPage();
    }
}
