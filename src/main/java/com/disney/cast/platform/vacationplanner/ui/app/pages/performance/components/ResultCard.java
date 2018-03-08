/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.app.pages.performance.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;

/**
 * @author luis
 */
public class ResultCard extends PageElement {
    private Supplier<WebElement> name = () -> waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), By.className("h4")));

    public ResultCard(WebElement contextLocator) {
        super(contextLocator);
    }

    protected ResultCard(By contextLocator) {
        super(contextLocator);
    }

    public String getName() {
        return name.get().getText();
    }

}
