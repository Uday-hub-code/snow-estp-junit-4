/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.config.components;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;

/**
 * @author luisfmp
 */
public class InfoPopUp extends PageElement {
    private WebElement content = waitFor(presenceOfNestedElementLocatedBy(getContextElement(),
            By.cssSelector(".section-content")));

    public InfoPopUp(WebElement contextLocator) {
        super(contextLocator);
    }

    public boolean isActive() {
        return content
                .findElement(By.id("sys_original.x_wdtpa_wdpr_vacat_config.u_active"))
                .getAttribute("value")
                .equals("true");
    }

    public String getKey() {
        return content
                .findElement(By.id("sys_original.x_wdtpa_wdpr_vacat_config.u_key"))
                .getAttribute("value");
    }

    public String getValue() {
        return content
                .findElement(By.id("sys_original.x_wdtpa_wdpr_vacat_config.u_value"))
                .getAttribute("value");
    }

}
