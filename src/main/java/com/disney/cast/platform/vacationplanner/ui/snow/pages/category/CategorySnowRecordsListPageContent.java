package com.disney.cast.platform.vacationplanner.ui.snow.pages.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;

/**
 * Class that extends SnowRecordsListPage in order to get the snow table content
 * for Category
 * 
 * @author erick.ricardez
 *
 */
public class CategorySnowRecordsListPageContent extends SnowRecordsListPage {
	private static final String HOVER_SCRIPT = "if(document.createEvent){"
			+ "var evObj = document.createEvent('MouseEvents');"
			+ "evObj.initEvent('mouseover', true, false);arguments[0].dispatchEvent(evObj);"
			+ "} else if(document.createEventObject){ arguments[0].fireEvent('onmouseover');} ";

	private Supplier<List<WebElement>> popupIcons = () -> waitFor(ExpectedConditions
			.presenceOfAllElementsLocatedBy(By.cssSelector("a.btn.btn-icon.table-btn-lg.icon-info.list_popup")));

	private Supplier<List<WebElement>> categoryNames = () -> getDriver()
			.findElements(By.cssSelector("a.linked.formlink"));
	
	private Supplier<WebElement> contextualWindowElement = () -> waitFor(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.section-content")));
	
	public List<WebElement> getListPopupIcons(){
		return popupIcons.get();
	}

	public String getActiveLabel(int rowNumber) {
		List<WebElement> actives = getDriver().findElements(By.cssSelector("td.vt"));
		if (rowNumber * 3 - 2 < actives.size())
			return actives.get(rowNumber * 3 - 2).getText();
		return "";
	}

	public String getCategoryName(int rowIndex) {
		return categoryNames.get().get(rowIndex).getText();
	}

	public List<String> getCategoryActiveLabels() {
		List<WebElement> actives = getDriver().findElements(By.cssSelector("td.vt"));
		List<String> activesStr = new ArrayList<>();
		for (int i = 1; i < actives.size(); i += 3) {
			activesStr.add(actives.get(i).getText());
		}
		return activesStr;
	}


	public Map<String, String> getCategoryValues() {
		Map<String, String> categories = new HashMap<>();
		List<WebElement> cats = categoryNames.get();
		List<String> activeLabels = getCategoryActiveLabels();
		if (cats.size() != activeLabels.size()) {
			throw new RuntimeException("the number of category names and active Labels don't match");
		}
		for (int i = 0; i < cats.size(); i++) {
			categories.put(cats.get(i).getText(), activeLabels.get(i));
		}
		return categories;
	}

	public CategorySnowUpdateRecordPage clickOnPopupIcon(int index) {
		click(popupIcons.get().get(index));
		return new CategorySnowUpdateRecordPage();
	}

	public ContextualWindow hoverOnPopupIcon(int index) {		
		hoverOnWebElement(popupIcons.get().get(index));		
		return new ContextualWindow(contextualWindowElement.get());
	}

	public void hoverOnWebElement(WebElement webElement) {
		getJS().executeScript(HOVER_SCRIPT, webElement);
	}

	public static class ContextualWindow extends PageElement {
		private Supplier<List<WebElement>> labels = () -> waitFor(
				ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("span.label-text")));

		protected ContextualWindow(By contextLocator) {
			super(contextLocator);
		}
		
		protected ContextualWindow(WebElement contextWebElement) {
			super(contextWebElement);
		}

		public List<WebElement> getLabels() {
			return labels.get();
		}

		public boolean isChecked() {
			return getContextElement().findElement(By.cssSelector("span.input-group-checkbox input[type='checkbox']"))
					.getAttribute("checked") != null;
		}

		public String getInputTextValue() {
			return getDriver().findElement(By.cssSelector("input.form-control.disabled")).getAttribute("value").trim();
		}
	}

}
