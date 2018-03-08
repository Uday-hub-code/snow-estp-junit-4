/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.rewards;

import org.openqa.selenium.By;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.rewards.components.RewardContentTable;

/**
 * @author ragha
 */
public class RewardRecordsListPage extends SnowRecordsListPage {

    public RewardContentTable getContentTable() {
        return new RewardContentTable(getDriver().findElement(By.cssSelector(".list2_body")));
    }
}
