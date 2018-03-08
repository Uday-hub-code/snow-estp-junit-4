/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.config.components;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.DataRow;

/**
 * @author luisfmp
 */
public class ConfigRow extends DataRow {

    private WebElement active = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(3)>a")));

    private WebElement key = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(4)")));

    private WebElement type = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(5)")));

    private WebElement value = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(6)")));

    public ConfigRow(WebElement row) {
        super(row);
    }

    public boolean isActive() {
        return active.getText().equals("true");
    }

    public String getKey() {
        return key.getText();
    }

    public String getType() {
        return type.getText();
    }

    public String getValue() {
        return value.getText();
    }

}
