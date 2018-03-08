/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.location.components;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.DataRow;

/**
 * @author g.moreno
 */
public class LocationRow extends DataRow {

    private WebElement active = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(3)>a")));

    private WebElement importKey = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(4)")));

    private WebElement name = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(5)")));

    private WebElement icon = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(6)")));

    public LocationRow(WebElement row) {
        super(row);
    }

    public String isActive() {
        return active.getText();
    }

    public String getImportKey() {
        return importKey.getText();
    }

    public String getName() {
        return name.getText();
    }

    public String getIcon() {
        return icon.getText();
    }

}
