/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.searchlog;

import java.util.function.Supplier;

import org.openqa.selenium.By;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.searchlog.componets.ContentTable;

/**
 * @author Raghav
 */
public class SearchLogRecordsListPage extends SnowRecordsListPage {
    private Supplier<ContentTable> contentTable = () -> new ContentTable(
            getDriver().findElement(By.cssSelector(".list2_body")));

    public ContentTable getContentTable() {
        return contentTable.get();
    }
}
