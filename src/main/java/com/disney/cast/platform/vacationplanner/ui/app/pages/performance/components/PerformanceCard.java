/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.app.pages.performance.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.automation.webframework.pageobject.PageElement;

/**
 * @author luis
 */
public class PerformanceCard extends PageElement {
    private Supplier<WebElement> level = () -> waitFor(presenceOfNestedElementLocatedBy(getContextElement(), By
            .xpath("/.//div[@class='ng-binding' and text()='Level']/../following-sibling::div/div[contains(@class,'float-right')]")));
    private Supplier<WebElement> goal = () -> waitFor(presenceOfNestedElementLocatedBy(getContextElement(), By
            .xpath("/.//div[@class='ng-binding' and text()='Goal']/../following-sibling::div/div[contains(@class,'float-right')]")));
    private Supplier<WebElement> avgPerTicket = () -> waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), By
                    .xpath("/.//div[@class='ng-binding' and text()='Avg Pts. Per Ticket']/../following-sibling::div/div[contains(@class,'float-right')]")));
    private Supplier<WebElement> volume = () -> waitFor(presenceOfNestedElementLocatedBy(getContextElement(), By
            .xpath("/.//div[@class='ng-binding' and text()='Volume']/../following-sibling::div/div[contains(@class,'float-right')]")));
    private Supplier<WebElement> detailsLink = () -> waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), By.cssSelector(".performance-details>a")));

    public boolean isDetailsLinkDisplayed() {
        return detailsLink.get().isDisplayed();
    }

    public String getLevel() {
        return level.get().getText();
    }

    public String getGoal() {
        return goal.get().getText();
    }

    public String getAvgPerTicket() {
        return avgPerTicket.get().getText();
    }

    public String getVolume() {
        return volume.get().getText();
    }

    public void showDetails() {
        detailsLink.get().click();
        waitForLoad();
    }

    private void waitForLoad() {
        waitFor(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-spinner")));
        waitFor(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".ng-animate"), 0));
    }

    public PerformanceCard(WebElement contextLocator) {
        super(contextLocator);
    }

}
