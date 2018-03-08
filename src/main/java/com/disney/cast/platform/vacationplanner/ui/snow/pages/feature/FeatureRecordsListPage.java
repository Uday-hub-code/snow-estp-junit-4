package com.disney.cast.platform.vacationplanner.ui.snow.pages.feature;

import java.util.function.Supplier;

import org.openqa.selenium.By;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.feature.components.FeatureContentTable;

/**
 * @author g.moreno
 */
public class FeatureRecordsListPage extends SnowRecordsListPage {

    private Supplier<FeatureContentTable> contentTable = () -> new FeatureContentTable(
            getDriver().findElement(By.cssSelector(".list2_body")));

    public FeatureContentTable getContentTable() {

        return contentTable.get();
    }

}