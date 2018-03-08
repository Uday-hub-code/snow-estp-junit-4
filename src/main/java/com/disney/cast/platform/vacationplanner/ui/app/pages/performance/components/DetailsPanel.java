/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.app.pages.performance.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.automation.webframework.pageobject.PageElement;

/**
 * @author luis
 */
public class DetailsPanel extends PageElement {

    private Supplier<WebElement> closeButton = () -> waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), By.tagName("button")));

    private List<ResultCard> metricsList;

    public DetailsPanel(By contextLocator) {
        super(contextLocator);
    }

    public boolean isDisplayed() {
        return getContextElement().isDisplayed();
    }

    public String buttonText() {
        return closeButton.get().getText();
    }

    public List<ResultCard> getMetricsList() {
        List<WebElement> metricCards = waitFor(
                ExpectedConditions.presenceOfNestedElementsLocatedBy(getContextLocator(),
                        By.cssSelector(".container .kng-list-item")));
        metricsList = metricCards
                .stream()
                .map((metricCard) -> new ResultCard(metricCard))
                .collect(Collectors.toList());
        return metricsList;
    }

    public List<String> getMetricNamesList() {
        return getMetricsList().stream().map((metricCard) -> metricCard.getName()).collect(Collectors.toList());
    }

}
