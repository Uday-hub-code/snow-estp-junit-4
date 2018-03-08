/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.reward_level;

import org.openqa.selenium.By;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.reward_level.components.RewardLevelContentTable;

/**
 * @author g.moreno
 */
public class RewardLevelRecordsListPage extends SnowRecordsListPage {

    public RewardLevelContentTable getContentTable() {
        return new RewardLevelContentTable(getDriver().findElement(By.cssSelector(".list2_body")));
    }
}
