/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.searchlog.componets;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;

/**
 * @author Raghav
 */
public class InfoPopUp extends PageElement {
    private WebElement content = waitFor(presenceOfNestedElementLocatedBy(getContextElement(),
            By.cssSelector(".section-content")));

    public InfoPopUp(WebElement contextLocator) {
        super(contextLocator);
    }

    public String getTerm() {
        return content
                .findElement(By.id("sys_original.x_wdtpa_wdpr_vacat_search_log.u_term"))
                .getAttribute("value");
    }

}
