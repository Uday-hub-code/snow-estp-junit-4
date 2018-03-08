package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.components.Backable;

/**
 * Class that represents the page for adding new Users
 *
 * @author erick.ricardez
 */
public class SnowNewUsersRecordPage extends SnowNewRecordBasePage implements Backable {

    private Supplier<WebElement> userLabel = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.label-text")));

    private Supplier<WebElement> userTxtInput = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(By.id("sys_display.x_wdtpa_wdpr_vacat_user.u_user")));

    private Supplier<WebElement> searchUserIcon = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(By.id("lookup.x_wdtpa_wdpr_vacat_user.u_user")));

    protected Supplier<WebElement> backButton = () -> {
        return this.waitFor(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("button.btn.btn-default.icon-chevron-left.navbar-btn")));
    };

    public boolean isUserLabeDisplayed() {
        return userLabel.get().isDisplayed();
    }

    public boolean isUserTxtInputEditable() {
        return userTxtInput.get().isDisplayed() && userTxtInput.get().isEnabled();
    }

    public void writeUser(String user) {
        userTxtInput.get().sendKeys(user);
    }

    public WebElement getSearchIcon() {
        return searchUserIcon.get();
    }

    public String getTextValueFromUserTxtInput() {
        return userTxtInput.get().getAttribute("value");
    }

    public boolean isUserTxtInputEditableWithWriting() {
        return isInputEnabledWithWriting(userTxtInput, "writable");
    }

    public boolean isInputEnabledWithWriting(Supplier<WebElement> element, String writableText) {
        final String text = writableText;
        if (isElementEnabled(element)) {
            element.get().sendKeys(text);
            return text.equals(element.get().getAttribute("value"));
        }
        return Boolean.FALSE;
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
