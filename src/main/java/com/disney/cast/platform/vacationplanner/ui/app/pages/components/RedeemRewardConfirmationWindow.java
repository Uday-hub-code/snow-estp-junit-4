package com.disney.cast.platform.vacationplanner.ui.app.pages.components;

import static com.disney.cast.platform.vacationplanner.ui.snow.pages.common.WebElementValidationHelper.getTextFromInput;
import static com.disney.cast.platform.vacationplanner.ui.snow.pages.common.WebElementValidationHelper.isInputEnabledWithWriting;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.disney.automation.webframework.pageobject.PageElement;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

public class RedeemRewardConfirmationWindow extends PageElement {
    private Supplier<WebElement> confirmButton;
    private Supplier<WebElement> cancelButton;
    public final Field rewardNameField;
    public final Field countrySelect;
    public final Field postalCodeField;
    public final Field zipCodeField;
    public final Field addressField;
    public final Field address2Field;
    public final Field address3Field;
    public final Field address4Field;
    public final Field cityField;
    public final Field stateField;
    public final Field phoneNumberField;
    static private RewardRedeemedConfirmationWindow rewardRedeemedConfirmationWindow;

    protected RedeemRewardConfirmationWindow(Supplier<WebElement> contextLocatorSupplier) {
        super(contextLocatorSupplier.get());
        cancelButton = () -> waitFor(
                ExpectedConditions.presenceOfElementLocated(cssSelector("[class*='kng-button-secondary']")));
        confirmButton = () -> waitFor(
                ExpectedConditions.presenceOfElementLocated(cssSelector("[class*='kng-button-primary']")));
        rewardNameField = new Field(cssSelector("div[label='Name on Reward']"));
        countrySelect = new Field(cssSelector("div[label='Country']"));
        postalCodeField = new Field(cssSelector("div[label='Postal Code']"));
        zipCodeField = new Field(cssSelector("div[label='Zip Code']"));
        addressField = new Field(cssSelector("div[label='Address']"));

        address2Field = new Field(cssSelector("div[label='Address 2']"));
        address3Field = new Field(cssSelector("div[label='Address 3']"));
        address4Field = new Field(cssSelector("div[label='Address 4']"));
        cityField = new Field(cssSelector("div[label='City']"));
        stateField = new Field(cssSelector("div[label='State']"));
        phoneNumberField = new Field(cssSelector("div[label='Phone Number']"));
    }

    public boolean isCountryListEditable() {
        return isCountryListEditable("United States");
    }

    public boolean isCountryListEditable(String option) {
        return countrySelect.isSelectEditable(option);
    }

    public boolean isStateListEditable(String option) {
        return stateField.isSelectEditable(option);
    }

    public boolean isStateTxtInputEditable() {
        return stateField.isTxtInputEditable();
    }

    public String getRewardNameTxtInputValue() {
        return getTextFromInput(rewardNameField.txtInput);
    }

    public boolean isRewardNameTxtInputEditable() {
        return isInputEnabledWithWriting(rewardNameField.txtInput);
    }

    public boolean isRewardNameTxtInputEditable(String textInput) {
        return isInputEnabledWithWriting(rewardNameField.txtInput, textInput);
    }

    public String getPostalCodeTxtInputValue() {
        return getTextFromInput(postalCodeField.txtInput);
    }

    public boolean isPostalCodeTxtInputEditable() {
        return isInputEnabledWithWriting(postalCodeField.txtInput);
    }

    public boolean isPostalCodeTxtInputEditable(String textInput) {
        return isInputEnabledWithWriting(postalCodeField.txtInput, textInput);
    }

    public String getZipCodeTxtInputValue() {
        return getTextFromInput(zipCodeField.txtInput);
    }

    public boolean isZipCodeTxtInputEditable() {
        return isInputEnabledWithWriting(zipCodeField.txtInput);
    }

    public boolean isZipCodeTxtInputEditable(String textInput) {
        return isInputEnabledWithWriting(zipCodeField.txtInput, textInput);
    }

    public String getAddressTxtInputValue() {
        return getTextFromInput(addressField.txtInput);
    }

    public boolean isAddressTxtInputEditable() {
        return isInputEnabledWithWriting(addressField.txtInput);
    }

    public boolean isAddressTxtInputEditable(String textInput) {
        return isInputEnabledWithWriting(addressField.txtInput, textInput);
    }

    public String getAddress2TxtInputValue() {
        return getTextFromInput(address2Field.txtInput);
    }

    public boolean isAddress2TxtInputEditable() {
        return isInputEnabledWithWriting(address2Field.txtInput);
    }

    public boolean isAddress2TxtInputEditable(String textInput) {
        return isInputEnabledWithWriting(address2Field.txtInput, textInput);
    }

    public String getAddress3TxtInputValue() {
        return getTextFromInput(address3Field.txtInput);
    }

    public boolean isAddress3TxtInputEditable() {
        return isInputEnabledWithWriting(address3Field.txtInput);
    }

    public boolean isAddress3TxtInputEditable(String TextInput) {
        return isInputEnabledWithWriting(address3Field.txtInput, TextInput);
    }

    public String getAddress4TxtInputValue() {
        return getTextFromInput(address4Field.txtInput);
    }

    public boolean isAddress4TxtInputEditable() {
        return isInputEnabledWithWriting(address4Field.txtInput);
    }

    public boolean isAddress4TxtInputEditable(String textInput) {
        return isInputEnabledWithWriting(address4Field.txtInput, textInput);
    }

    public String getCityTxtInputValue() {
        return getTextFromInput(cityField.txtInput);
    }

    public boolean isCityTxtInputEditable() {
        return isInputEnabledWithWriting(cityField.txtInput);
    }

    public boolean isCityTxtInputEditable(String txtInput) {
        return isInputEnabledWithWriting(cityField.txtInput, txtInput);
    }

    public String getStateTxtInputValue() {
        return getTextFromInput(stateField.txtInput);
    }

    public String getPhoneNumberTxtInputValue() {
        return getTextFromInput(phoneNumberField.txtInput);
    }

    public boolean isPhoneNumberTxtInputEditable() {
        return isInputEnabledWithWriting(phoneNumberField.txtInput);
    }

    public boolean isPhoneNumberTxtInputEditable(String textInput) {
        return isInputEnabledWithWriting(phoneNumberField.txtInput, textInput);
    }

    public boolean isConfirmButtonVisible() {
        return !getDriver().findElements(cssSelector("[class*='kng-button-primary']")).isEmpty()
                && confirmButton.get().isDisplayed() && confirmButton.get().isEnabled();
    }

    public boolean isCancelButtonVisible() {
        return !getDriver().findElements(cssSelector("[class*='kng-button-secondary']")).isEmpty()
                && cancelButton.get().isDisplayed() && cancelButton.get().isEnabled();
    }

    public boolean isRewardNameNotPresent() {
        return isElementNotPresent(cssSelector("div[label='Name on Reward']"))
                && !rewardNameField.isFieldDisplayed();
    }

    public RewardRedeemedConfirmationWindow clickOnConfirmButton() {
        confirmButton.get().click();
        return rewardRedeemedConfirmationWindow = new RewardRedeemedConfirmationWindow();
    }

    public void clickOnCancelButton() {
        cancelButton.get().click();
    }

    public Optional<RewardRedeemedConfirmationWindow> getRewardRedeemedConfirmationWindow() {
        if (rewardRedeemedConfirmationWindow == null) {
            getLogger().info("no confirmation Window opened");
            return Optional.absent();
        }
        return Optional.of(rewardRedeemedConfirmationWindow);
    }

    public static class RewardRedeemedConfirmationWindow extends PageElement {
        private final Supplier<WebElement> okButton = () -> waitFor(
                ExpectedConditions.presenceOfNestedElementLocatedBy(getContextLocator(), tagName("button")));
        // private final Supplier<WebElement> message = () -> waitFor(
        // ExpectedConditions.presenceOfNestedElementLocatedBy(getContextLocator(), tagName("h3")));

        protected RewardRedeemedConfirmationWindow() {
            super(cssSelector("[class='modal-dialog modal-md']"));
        }

        public String getMessage() {
            // return message.get().getText();
            return getDriver().findElement(getContextLocator()).getText();
        }

        public void clickOnOKButton() {
            okButton.get().click();
            rewardRedeemedConfirmationWindow = null;
        }

    }

    public static class Field extends PageElement {
        private final Supplier<WebElement> label = () -> waitFor(
                ExpectedConditions.presenceOfNestedElementLocatedBy(getContextLocator(), tagName("label")));
        public final Supplier<WebElement> txtInput = () -> waitFor(
                ExpectedConditions.presenceOfNestedElementLocatedBy(getContextLocator(), tagName("input")));
        private final Supplier<WebElement> select = () -> waitFor(
                ExpectedConditions.presenceOfNestedElementLocatedBy(getContextLocator(), tagName("select")));
        private Supplier<WebElement> errorMessageDiv = () -> waitFor(
                ExpectedConditions.presenceOfNestedElementLocatedBy(getContextLocator(), tagName("div")));

        public Field(By contextLocator) {
            super(contextLocator);
        }

        public boolean isFieldDisplayed() {
            return !getDriver().findElements(getContextLocator()).isEmpty();
        }

        public final String getLabel() {
            return label.get().getText();
        }

        public final String getErrorMessage() {
            return errorMessageDiv.get().getText();
        }

        public boolean isErrorMessageVisible() {
            label.get().click();
            return getDriver()
                    .findElement(getContextLocator())
                    .getAttribute("class")
                    .contains("kng-input-error");
        }

        public boolean isTxtInputEditable() {
            return isInputEnabledWithWriting(txtInput);
        }

        public boolean isSelectEditable(String option) {
            String value = getTextFromInput(select);
            select(select.get(), option);
            return !value.equalsIgnoreCase(getTextFromInput(select));
        }
    }

    public boolean isElementNotPresent(By locator) {
        try {
            new FluentWait<WebDriver>(getDriver())
                    .pollingEvery(500, TimeUnit.MILLISECONDS)
                    .withTimeout(1500, TimeUnit.MILLISECONDS)
                    .until(new Predicate<WebDriver>() {
                        @Override
                        public boolean apply(WebDriver driver) {
                            return driver.findElements(locator).isEmpty();
                        }
                    });
        } catch (TimeoutException te) {
            getLogger().debug("timeout exception caught after waiting for locator: " + locator.toString());
        }
        return getDriver().findElements(locator).isEmpty();
    }
}