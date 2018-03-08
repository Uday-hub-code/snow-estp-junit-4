/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.config.components;

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
public class ConfigContentTable extends PageElement {
	private List<ConfigRow> rows;

	public ConfigContentTable(WebElement contextLocator) {
		super(contextLocator);
		List<WebElement> pageRows = contextLocator.findElements(By.tagName("tr"));
		rows = new ArrayList<ConfigRow>();
		for (WebElement pageRow : pageRows) {
			rows.add(new ConfigRow(pageRow));
		}
	}

	public <T extends SnowUpdateRecordBasePage> T editRecordByKey(String key, Class<T> pageToReturn)
			throws InstantiationException, IllegalAccessException {
		for (DataRow row : getRows()) {
			if (key.equals(((ConfigRow) row).getKey())) {
				return row.clickAtInfoIcon(pageToReturn);
			}
		}
		return null;
	}

	public List<ConfigRow> getRows() {
		return rows;
	}

}
