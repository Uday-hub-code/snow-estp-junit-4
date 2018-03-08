package com.disney.cast.platform.vacationplanner.ui.app.pages.components.rewardlevels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.automation.webframework.pageobject.PageElement;
import com.google.common.base.Supplier;

/**
 * @author jose.oropeza
 */
public class Reward extends PageElement {

    private Supplier<WebElement> icon = () -> waitFor(ExpectedConditions.presenceOfNestedElementLocatedBy(
            getContextElement(), By.cssSelector("i[class*='kng-icon kng-icon-reward']")));

    private Supplier<WebElement> description = () -> waitFor(ExpectedConditions.presenceOfNestedElementLocatedBy(
            getContextElement(), By.cssSelector("p[class*='b2 book vp-reward-description']")));

    private Supplier<WebElement> type = () -> waitFor(
            ExpectedConditions.presenceOfNestedElementLocatedBy(getContextElement(),
                    By.cssSelector("p[class*='h4']")));

    private Supplier<WebElement> name = () -> waitFor(
            ExpectedConditions.presenceOfNestedElementLocatedBy(getContextElement(),
                    By.cssSelector("p[class*='b1']")));

    public Reward(WebElement contextLocatorElement) {
        super(contextLocatorElement);
    }

    public String getIconClassName() {
        return icon.get().getAttribute("class");
    }

    public String getDescription() {
        return description.get().getText();
    }

    public String getName() {
        return name.get().getText();
    }

    public String getType() {
        return type.get().getText();
    }

}
