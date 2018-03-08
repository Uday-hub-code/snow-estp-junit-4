package com.disney.cast.platform.vacationplanner.ui.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.cast.platform.vacationplanner.ui.app.pages.components.rewardlevels.RewardLevelTier;
import com.google.common.base.Supplier;

/**
 *
 * @author jose.oropeza
 *
 */
public class RewardLevelsPage extends AbstractVacationPlannerPageObject {

	private Supplier<WebElement> title = () -> waitFor(
			ExpectedConditions.presenceOfElementLocated(By.cssSelector(".h3.ng-binding")));

	private RewardLevelTier tierOne = new RewardLevelTier(By.cssSelector("div[class*='vp-tier-one-container']"));

	private RewardLevelTier tierTwo = new RewardLevelTier(By.cssSelector("div[class*='vp-tier-two-container']"));

	public RewardLevelsPage() {
		super();
	}

	@Override
	protected String setOwnUrl() {
		return null;
	}

	public String getTitle() {
		return title.get().getText();
	}

	public RewardLevelTier getTierOne() {
		return tierOne;
	}

	public RewardLevelTier getTierTwo() {
		return tierTwo;
	}

}
