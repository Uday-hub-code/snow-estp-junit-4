/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.omittedwords.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.DataRow;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author luisfmp
 */
public class OmittedWordsContentTable extends PageElement {
    private List<OmittedWordsRow> rows;

    public OmittedWordsContentTable(WebElement contextLocator) {
        super(contextLocator);
        List<WebElement> pageRows = contextLocator.findElements(By.tagName("tr"));
        rows = new ArrayList<OmittedWordsRow>();
        for (WebElement pageRow : pageRows) {
            rows.add(new OmittedWordsRow(pageRow));
        }
    }

    public <T extends SnowUpdateRecordBasePage> T editRecordByValue(String value, Class<T> pageToReturn)
            throws InstantiationException, IllegalAccessException {
        for (DataRow row : getRows()) {
            if (value.equals(((OmittedWordsRow) row).getValue())) {
                return row.clickAtInfoIcon(pageToReturn);
            }
        }
        return null;
    }

    public List<OmittedWordsRow> getRows() {
        return rows;
    }

}
