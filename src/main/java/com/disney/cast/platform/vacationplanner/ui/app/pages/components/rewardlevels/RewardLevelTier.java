package com.disney.cast.platform.vacationplanner.ui.app.pages.components.rewardlevels;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.disney.automation.webframework.pageobject.PageElement;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;

/**
 *
 * @author jose.oropeza
 *
 */
public class RewardLevelTier extends PageElement {
	private final By locator = By.cssSelector("div[class*='kng-list-item']");
	private Supplier<WebElement> name = () -> waitFor(ExpectedConditions
			.presenceOfNestedElementLocatedBy(getContextLocator(), By.cssSelector(".h3 .ng-binding")));

	public Supplier<List<Reward>> rewards = () -> {
		if (elementExists(locator)) {
			return getDriver().findElement(getContextLocator()).findElements(locator).stream().map(e -> new Reward(e))
					.collect(Collectors.toList());
		}
		return new ArrayList<Reward>();

	};

	public RewardLevelTier(By contextLocator) {
		super(contextLocator);
	}

	public String getName() {
		return name.get().getText();
	}

	public List<Reward> getRewards() throws InterruptedException {
		return rewards.get();

	}

	public boolean elementExists(By by) {
		try {
			new FluentWait<WebDriver>(getDriver()).pollingEvery(500, TimeUnit.MILLISECONDS)
					.withTimeout(1500, TimeUnit.MILLISECONDS).until(new Predicate<WebDriver>() {
						@Override
						public boolean apply(WebDriver driver) {
							return !getContextElement().findElements(by).isEmpty();
						}
					});
		} catch (TimeoutException te) {
			getLogger().debug("element not found");
		}
		return !getContextElement().findElements(by).isEmpty();
	}

}
