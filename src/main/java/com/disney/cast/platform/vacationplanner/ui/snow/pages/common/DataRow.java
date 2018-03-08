package com.disney.cast.platform.vacationplanner.ui.snow.pages.common;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfNestedElementLocatedBy;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.config.components.InfoPopUp;

public abstract class DataRow extends PageElement {
    private static String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
    private static String mouseOutScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseout',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseout');}";

    private WebElement iIcon = waitFor(
            presenceOfNestedElementLocatedBy(getContextElement(), cssSelector("td:nth-child(2)>a")));

    protected DataRow(WebElement row) {
        super(row);
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

    public <T extends SnowUpdateRecordBasePage> T clickAtInfoIcon(Class<T> pageToReturn)
            throws InstantiationException, IllegalAccessException {
        iIcon.click();
        return pageToReturn.newInstance();
    }
}
