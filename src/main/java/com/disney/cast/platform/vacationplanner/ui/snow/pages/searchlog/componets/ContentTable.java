/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.searchlog.componets;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.searchlog.SnowUpdateSearchLogRecordPage;

/**
 * @author Raghav
 */
public class ContentTable extends PageElement {

    private Supplier<List<SearchLogRow>> rows = () -> getContextElement()
            .findElements(By.tagName("tr"))
            .stream()
            .map(row -> new SearchLogRow(row))
            .collect(toList());

    public ContentTable(WebElement contextLocator) {
        super(contextLocator);
    }

    public List<SearchLogRow> getRows() {
        return rows.get();
    }

    public SnowUpdateSearchLogRecordPage editRecordByKey(String key) {
        for (SearchLogRow row : getRows()) {
            if (key.equals(row.getTerm())) {
                return row.clickAtInfoIcon();
            }
        }
        return null;
    }

}
