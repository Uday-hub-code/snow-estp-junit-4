package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

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
public class SnowNewLocationsRecordPage extends SnowNewRecordBasePage implements Backable {

    private Supplier<WebElement> activeLabel = () -> waitFor(
            presenceOfElementLocated(By.xpath("//span[contains(@class, 'label-text') and (text()='active')]")));

    private Supplier<WebElement> importKeyLabel = () -> waitFor(
            presenceOfElementLocated(By.xpath("//span[contains(@class, 'label-text') and (text()='import key')]")));

    private Supplier<WebElement> nameLabel = () -> waitFor(
            presenceOfElementLocated(By.xpath("//span[contains(@class, 'label-text') and (text()='name')]")));

    private Supplier<WebElement> iconLabel = () -> waitFor(
            presenceOfElementLocated(By.xpath("//span[contains(@class, 'label-text') and (text()='icon')]")));

    private Supplier<WebElement> activeHiddenCheckBox = () -> waitFor(
            presenceOfElementLocated(By.xpath("//input[@id='x_wdtpa_wdpr_vacat_location.u_active']")));

    private Supplier<WebElement> activeClickableLabel = () -> waitFor(
            presenceOfElementLocated(By.xpath("//label[@id='label.ni.x_wdtpa_wdpr_vacat_location.u_active']")));

    private Supplier<WebElement> importKeyInput = () -> waitFor(
            presenceOfElementLocated(By.xpath("//input[@id='x_wdtpa_wdpr_vacat_location.u_import_key']")));

    private Supplier<WebElement> nameInput = () -> waitFor(
            presenceOfElementLocated(By.xpath("//input[@id='x_wdtpa_wdpr_vacat_location.u_name']")));

    private Supplier<WebElement> iconInput = () -> waitFor(
            presenceOfElementLocated(By.xpath("//input[@id='x_wdtpa_wdpr_vacat_location.u_icon']")));

    // Could be in SnowNewRecordBasePage
    protected Supplier<WebElement> backButton = () -> {
        return this.waitFor(
                presenceOfElementLocated(
                        By.cssSelector("button.btn.btn-default.icon-chevron-left.navbar-btn")));
    };

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isImportKeyLabelDisplayed() {
        return importKeyLabel.get().isDisplayed();
    }

    public boolean isNameLabelDisplayed() {
        return nameLabel.get().isDisplayed();
    }

    public boolean isIconLabelDisplayed() {
        return iconLabel.get().isDisplayed();
    }

    public boolean isNameInputEditable() {
        return isEditable(nameInput.get());
    }

    public boolean isImportKeyInputEditable() {
        return isEditable(importKeyInput.get());
    }

    public boolean isIconInputEditable() {
        return isEditable(iconInput.get());
    }

    public boolean isActiveHiddenCheckBoxEditable() {
        boolean originalState = activeHiddenCheckBox.get().getAttribute("value").equals("true");
        activeClickableLabel.get().click();
        boolean newState = activeHiddenCheckBox.get().getAttribute("value").equals("true");
        return originalState == !newState;
    }

    public boolean isElementEnabled(Supplier<WebElement> element) {
        return element.get().isDisplayed() && element.get().isEnabled();
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
