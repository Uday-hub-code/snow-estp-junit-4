/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.omittedwords;

import org.openqa.selenium.By;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.omittedwords.components.OmittedWordsContentTable;

/**
 * @author luisfmp
 */
public class OmittedWordsRecordsListPage extends SnowRecordsListPage {

    public OmittedWordsContentTable getContentTable() {
        return new OmittedWordsContentTable(getDriver().findElement(By.cssSelector(".list2_body")));
    }
}
