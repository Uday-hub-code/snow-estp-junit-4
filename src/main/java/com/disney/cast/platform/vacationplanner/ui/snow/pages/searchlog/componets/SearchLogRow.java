/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.searchlog.componets;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.config.components.InfoPopUp;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.searchlog.SnowUpdateSearchLogRecordPage;

/**
 * @author Raghav
 */
public class SearchLogRow extends PageElement {

    private static String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
    private static String mouseOutScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseout',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseout');}";

    private WebElement iIcon = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(),
                    cssSelector("td:nth-child(2)>a")));

    private WebElement term = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(),
                    cssSelector("td:nth-child(3)>a")));

    protected SearchLogRow(WebElement row) {
        super(row);
    }

    public String getTerm() {
        return term.getText();
    }

    public InfoPopUp getInfoPopUp() throws AWTException {
        getJS().executeScript(mouseOverScript, iIcon);
        WebElement popUp = waitFor(presenceOfElementLocated(By.cssSelector(".popup")));
        return new InfoPopUp(popUp);
    }

    public void waitForPopUpToHide() {
        getJS().executeScript(mouseOutScript, iIcon);
        waitFor(invisibilityOfElementLocated(By.cssSelector(".popup")));
    }

    public SnowUpdateSearchLogRecordPage clickAtInfoIcon() {
        iIcon.click();
        return new SnowUpdateSearchLogRecordPage();
    }
}
