package com.disney.cast.platform.vacationplanner.ui.snow.pages.feature.components;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.feature.SnowUpdateFeatureRecordPage;

/**
 * @author g.moreno
 */
public class FeatureContentTable extends PageElement {

    private Supplier<List<FeatureRow>> rows = () -> getContextElement()
            .findElements(By.tagName("tr"))
            .stream()
            .map(row -> new FeatureRow(row))
            .collect(toList());

    public FeatureContentTable(WebElement contextLocator) {
        super(contextLocator);
    }

    public List<FeatureRow> getRows() {
        return rows.get();
    }

    public SnowUpdateFeatureRecordPage editRecordByKey(String key) {
        for (FeatureRow row : getRows()) {
            if (key.equals(row.getKey())) {
                return row.clickAtInfoIcon();
            }
        }
        return null;
    }

}
