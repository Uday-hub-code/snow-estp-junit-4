/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.location;

import org.openqa.selenium.By;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.location.components.LocationContentTable;

/**
 * @author g.moreno
 */
public class LocationsRecordsListPage extends SnowRecordsListPage {

    public LocationContentTable getContentTable() {
        return new LocationContentTable(getDriver().findElement(By.cssSelector(".list2_body")));
    }
}
