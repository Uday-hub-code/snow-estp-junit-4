/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.components.Backable;

/**
 * Class that represents the page for new records
 *
 * @author erick.ricardez
 */
public class SnowNewTranslationRecordPage extends SnowNewRecordBasePage implements Backable {

    private Supplier<WebElement> activeLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("label[for*='ni.x_wdtpa_wdpr_vacat_translation.u_active'] span[class*='label-text']")));

    private Supplier<WebElement> activeCheckBox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector("label[class*='checkbox-label']")));

    private Supplier<WebElement> activeCheckBoxHidden = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_translation.u_active")));

    private Supplier<WebElement> keyLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("label[for*='x_wdtpa_wdpr_vacat_translation.u_key'] span[class*='label-text']")));

    private Supplier<WebElement> keyTextInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_translation.u_key")));

    private Supplier<WebElement> languageLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("label[for*='x_wdtpa_wdpr_vacat_translation.u_language'] span[class*='label-text']")));

    private Supplier<WebElement> languageTextInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_translation.u_language")));

    private Supplier<WebElement> textValueLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("label[for*='x_wdtpa_wdpr_vacat_translation.u_text_value'] span[class*='label-text']")));

    private Supplier<WebElement> textValueTextInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_translation.u_text_value")));

    private Supplier<WebElement> htmlValueLabel = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("label[for*='x_wdtpa_wdpr_vacat_translation.u_html_value'] span[class*='label-text']")));

    private Supplier<WebElement> htmlValueTextInput = () -> waitFor(presenceOfElementLocated(By.id("tinymce")));

    protected Supplier<WebElement> backButton = () -> {
        return this.waitFor(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("button.btn.btn-default.icon-chevron-left.navbar-btn")));
        // ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-original-title='Back']")));
    };

    public String getTextFromInput(Supplier<WebElement> sup) {
        return sup.get().getAttribute("value");
    }

    public String getTextContentFromKeyInput() {
        return getTextFromInput(keyTextInput);
    }

    public String getTextFromLanguageInput() {
        return getTextFromInput(languageTextInput);
    }

    public String getTextFromTextValueInput() {
        return getTextFromInput(textValueTextInput);
    }

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isCheckBoxEnabled() {
        return activeCheckBox.get().isDisplayed() && activeCheckBox.get().isEnabled();
    }

    public boolean isKeyLabelDisplayed() {
        return keyLabel.get().isDisplayed();
    }

    public boolean isLanguageLabelDisplayed() {
        return languageLabel.get().isDisplayed();
    }

    public boolean isKeyTextInputEnabled() {
        return isElementEnabled(keyTextInput);
    }

    public boolean isElementEnabled(Supplier<WebElement> element) {
        return element.get().isDisplayed() && element.get().isEnabled();
    }

    public void writeKey(String name) {
        keyTextInput.get().sendKeys(name);
    }

    public boolean isLaguageLabeDisplayed() {
        return getLanguageLabel().isDisplayed();
    }

    public boolean isLanguageTextInputEnabled() {
        return isElementEnabled(languageTextInput);
    }

    public void writeLanguage(String language) {
        languageTextInput.get().sendKeys(language);
    }

    public boolean isTextValueLabeDisplayed() {
        return getTextValueLabel().isDisplayed();
    }

    public boolean isTextValueTextInputEnabled() {
        return isElementEnabled(textValueTextInput);
    }

    public void writeTextValue(String textValue) {
        textValueTextInput.get().sendKeys(textValue);
    }

    public boolean isHtmlValueLabeDisplayed() {
        return getHtmlValueLabel().isDisplayed();
    }

    public boolean isHtmlValueTextInputEnabled() {
        return isElementEnabled(htmlValueTextInput);
    }

    public void writeHtmlValue(String htmlValue) {
        try {
            getDriver()
                    .switchTo()
                    .frame(getDriver().findElement(By.id("x_wdtpa_wdpr_vacat_translation.u_html_value_ifr")));
            htmlValueTextInput.get().sendKeys(htmlValue);
        } finally {
            getDriver().switchTo().defaultContent();
            goToContentIframe();
        }
    }

    public String getTextFromHtmlValueTxtInput() {
        try {
            getDriver()
                    .switchTo()
                    .frame(getDriver().findElement(By.id("x_wdtpa_wdpr_vacat_translation.u_html_value_ifr")));
            return htmlValueTextInput.get().getText();
        } finally {
            getDriver().switchTo().defaultContent();
            goToContentIframe();
        }
    }

    public WebElement getLanguageLabel() {
        return languageLabel.get();
    }

    public WebElement getLanguageTextInput() {
        return languageTextInput.get();
    }

    public WebElement getTextValueLabel() {
        return textValueLabel.get();
    }

    public WebElement getTextValueInput() {
        return textValueTextInput.get();
    }

    public WebElement getHtmlValueLabel() {
        return htmlValueLabel.get();
    }

    public WebElement getHtmlValueTextInput() {
        return htmlValueTextInput.get();
    }

    public boolean isActiveCheckboxClickable() {
        if (isCheckBoxEnabled()) {
            boolean initialStatus = isActiveChecked();
            activeCheckBox.get().click();
            return initialStatus != Boolean.valueOf(activeCheckBoxHidden.get().getAttribute("value"));
        }
        return Boolean.FALSE;
    }

    public boolean isActiveChecked() {
        return Boolean.valueOf(activeCheckBoxHidden.get().getAttribute("value"));
    }

    public boolean isInputEnabledWithWriting(Supplier<WebElement> element) {
        return isInputEnabledWithWriting(element, "writable");
    }

    public boolean isInputEnabledWithWriting(Supplier<WebElement> element, String writableText) {
        final String text = writableText;
        if (isElementEnabled(element)) {
            element.get().sendKeys(text);
            return text.equals(element.get().getAttribute("value"));
        }
        return Boolean.FALSE;
    }

    public boolean isKeyTextInputEnabledWithWriting() {
        return isInputEnabledWithWriting(keyTextInput);
    }

    public boolean isLanguageTextInputEnabledWithWriting() {
        return isInputEnabledWithWriting(languageTextInput, "fr");
    }

    public boolean isTextValueTxtInputEnabledWithWriting() {
        return isInputEnabledWithWriting(textValueTextInput);
    }

    public boolean isHtmlValueTxtInputEnabledWithWriting() {
        final String writable = "writable";
        try {

            getJS().executeScript(
                    String.format("tinyMCE.activeEditor.setContent('%s');", writable));
            getDriver()
                    .switchTo()
                    .frame(getDriver().findElement(By.id("x_wdtpa_wdpr_vacat_translation.u_html_value_ifr")));
            return writable.equals(htmlValueTextInput.get().getText());
        } finally {
            getDriver().switchTo().defaultContent();
            goToContentIframe();
        }
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_translation.do%3Fsys_id%3D-1%26sys_is_list%3Dtrue%26sys_target%3Dx_wdtpa_wdpr_vacat_translation%26sysparm_checked_items%3D%26sysparm_ck%3De3e2ecf9db31b600a4645e65ce96191c38931912ec7648e553b212fec5cc480496e53cbf%26sysparm_fixed_query%3D%26sysparm_group_sort%3D%26sysparm_list_css%3D%26sysparm_query%3D%26sysparm_referring_url%3Dx_wdtpa_wdpr_vacat_translation_list.do%253fsysparm_clear_stack%253dtrue%26sysparm_target%3D%26sysparm_view%3D";
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends SnowRecordsListPage> T back() {
        backButton.get().click();
        return (T) new SnowRecordsListPage();
    }

}
