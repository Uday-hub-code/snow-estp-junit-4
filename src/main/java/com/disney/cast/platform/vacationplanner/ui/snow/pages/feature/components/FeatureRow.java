package com.disney.cast.platform.vacationplanner.ui.snow.pages.feature.components;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.feature.InfoFeaturePage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.feature.SnowUpdateFeatureRecordPage;

/**
 * @author g.moreno
 */
public class FeatureRow extends PageElement {

    private WebElement iIcon = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(),
                    cssSelector("td:nth-child(2)>a")));
    private WebElement key = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(),
                    cssSelector("td:nth-child(3)")));
    private WebElement value = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(),
                    cssSelector("td:nth-child(4)")));

    protected FeatureRow(WebElement row) {
        super(row);
    }

    public String getKey() {
        return key.getText();
    }

    public String getValue() {
        return value.getText();
    }

    protected FeatureRow(By contextLocator) {
        super(contextLocator);

    }

    public SnowUpdateFeatureRecordPage clickAtInfoIcon() {
        iIcon.click();
        return new SnowUpdateFeatureRecordPage();
    }

    public InfoFeaturePage getInfoIcon() {
        iIcon.click();
        return new InfoFeaturePage();

    }

}
