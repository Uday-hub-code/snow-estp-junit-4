package com.disney.cast.platform.vacationplanner.ui.app.pages;

import static org.openqa.selenium.By.cssSelector;

import com.disney.automation.webframework.pageobject.PageObject;
import com.disney.cast.platform.vacationplanner.ui.app.pages.components.TitleBarComponent;

/**
 *
 * @author jose.oropeza
 *
 */
public abstract class AbstractVacationPlannerPageObject extends PageObject {

	public final TitleBarComponent titleBarComponent = new TitleBarComponent(cssSelector(".kng-header"));

	public AbstractVacationPlannerPageObject() {
		super();
	}

	public TitleBarComponent getTitleBarComponent() {
		return titleBarComponent;
	}

}
