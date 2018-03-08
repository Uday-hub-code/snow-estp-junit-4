/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.ui_user.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.DataRow;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.SnowUpdateRecordBasePage;

/**
 * @author g.moreno
 */
public class UiUserContentTable extends PageElement {
    private List<UiUserRow> rows;

    public UiUserContentTable(WebElement contextLocator) {
        super(contextLocator);
        List<WebElement> pageRows = contextLocator.findElements(By.tagName("tr"));
        rows = new ArrayList<UiUserRow>();
        for (WebElement pageRow : pageRows) {
            rows.add(new UiUserRow(pageRow));
        }
    }

    public <T extends SnowUpdateRecordBasePage> T editRecordByKey(String key, Class<T> pageToReturn)
            throws InstantiationException, IllegalAccessException {
        for (DataRow row : getRows()) {
            if (key.equals(((UiUserRow) row).getUser()) || (((UiUserRow) row).getUser().endsWith("...")
                    && key.contains(((UiUserRow) row).getUser().substring(0, 39)))) {
                return row.clickAtInfoIcon(pageToReturn);
            }
        }
        return null;
    }

    public List<UiUserRow> getRows() {
        return rows;
    }

}
