package com.disney.cast.platform.vacationplanner.ui.snow.pages.common;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

public class WebElementValidationHelper {

    public static boolean isInputEnabledWithWriting(Supplier<WebElement> element) {
        return isInputEnabledWithWriting(element, "writable");
    }

    public static boolean isInputEnabledWithWriting(Supplier<WebElement> element, String writableText) {
        final String text = writableText;
        if (isElementEnabled(element)) {
            element.get().clear();
            element.get().sendKeys(text);
            return text.equals(element.get().getAttribute("value"));
        }
        return Boolean.FALSE;
    }

    public static boolean isElementEnabled(Supplier<WebElement> element) {
        return element.get().isDisplayed() && element.get().isEnabled();
    }

    public static String getTextFromInput(Supplier<WebElement> sup) {
        return sup.get().getAttribute("value");
    }
}
