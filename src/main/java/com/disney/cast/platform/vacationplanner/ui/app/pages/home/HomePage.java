package com.disney.cast.platform.vacationplanner.ui.app.pages.home;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.automation.webframework.visual.Ocular;
import com.disney.automation.webframework.visual.comparator.OcularResult;
import com.disney.automation.webframework.visual.snapshot.Snap;
import com.disney.cast.platform.vacationplanner.ui.app.pages.AbstractVacationPlannerPageObject;
import com.disney.cast.platform.vacationplanner.ui.app.pages.components.AlertMessageComponent;
import com.disney.cast.platform.vacationplanner.ui.app.pages.components.EntitlementCard;
import com.disney.cast.platform.vacationplanner.ui.app.pages.components.PerformanceHorizontalChart;
import com.disney.cast.platform.vacationplanner.ui.app.pages.performance.PerformanceSummaryPage;

/**
 * VACATIUON PLNNER HOME PAGE
 *
 * @author erick.ricardez
 */

@Snap("HomePage-#{OPT}.png")
public class HomePage extends AbstractVacationPlannerPageObject {

    private Supplier<WebElement> centerText = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(cssSelector("div.center-text h3")));

    private Supplier<WebElement> welcomeSubHeadingDiv = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(cssSelector("div.center-text div[class*='welcome']")));

    private Supplier<WebElement> thisMonthsPerformance = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(cssSelector("div.row div[class*='month-performance']")));

    private Supplier<WebElement> viewFullPerformance = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(cssSelector("div.row div[class*='summary-link']")));

    private Supplier<WebElement> viewFullPerformanceLink = () -> waitFor(
            ExpectedConditions.presenceOfNestedElementLocatedBy(viewFullPerformance.get(), tagName("a")));

    private Supplier<WebElement> viewRewardHistory = () -> waitFor(
            ExpectedConditions.presenceOfElementLocated(cssSelector("div.row div[class*='past-redemptions']")));

    private Supplier<WebElement> viewRewardHistoryLink = () -> waitFor(
            ExpectedConditions.presenceOfNestedElementLocatedBy(viewRewardHistory.get(), tagName("a")));

    private AlertMessageComponent alertMessageComponent = new AlertMessageComponent(
            cssSelector("div[class='kng-alert ng-scope kng-alert-warning']"));

    public final PerformanceHorizontalChart performanceChart = new PerformanceHorizontalChart(
            cssSelector("[class*='white-kng-cards-lg kng-cards-vertical']"));

    public final Supplier<List<EntitlementCard>> entitlements = () -> {
        waitFor(ExpectedConditions.elementToBeClickable(cssSelector("kng-cards[class*='recentRewards']")));
        return getDriver()
                .findElements(cssSelector("kng-cards[class*='recentRewards']"))
                .stream()
                .map(card -> new EntitlementCard(() -> card))
                .collect(Collectors.toList());
    };

    public boolean isEntitlementListEmpty() {
        return getDriver().findElements(cssSelector("kng-cards[class*='recentRewards']")).isEmpty();
    }

    public AlertMessageComponent getAlertMessageComponent() {
        return alertMessageComponent;
    }

    public String getCenterText() {
        return centerText.get().getText();
    }

    public String getWelcomeSubHeading() {
        return welcomeSubHeadingDiv.get().getText();
    }

    public String getThisMonthsPerformance() {
        return thisMonthsPerformance.get().getText().split("\n")[0];
    }

    public String getViewFullPerformance() {
        return viewFullPerformance.get().getText();
    }

    public PerformanceSummaryPage openFullPerformanceSummary() {
        viewFullPerformanceLink.get().click();
        return new PerformanceSummaryPage();
    }

    public String getRewardHistory() {
        return viewRewardHistory.get().getText();
    }

    public PastRedemptionsPage clickOnViewRewardHistory() {
        viewRewardHistoryLink.get().click();
        return new PastRedemptionsPage();
    }

    public void clickOnViewFullPerformance() {
        viewFullPerformanceLink.get().click();
        waitForLoad();
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/wdpr-cast/x_wdtpa_wdpr_vacat_WDPR%20Vacation%20Planner%20Page.do#!/home";
    }

    @Override
    public void goToOwnUrl() {
        super.goToOwnUrl();
        waitForLoad();
    }

    public boolean isPageDisplayed() {
        return getDriver().getCurrentUrl().equals(this.getOwnUrl());
    }

    private void waitForLoad() {
        waitFor(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-spinner")));
        waitFor(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".ng-animate"), 0));
    }

    public OcularResult compare() {
        return Ocular
                .snapshot()
                .from(this)
                .replaceAttribute("OPT", "")
                .sample()
                .using(getDriver())
                .compare();
    }

    public OcularResult compareSimilar() {
        return Ocular
                .snapshot()
                .from(this)
                .replaceAttribute("OPT", "similarity")
                .sample()
                .using(getDriver())
                .similarity(85)
                .compare();
    }

    public OcularResult compareMenu() {
        return Ocular
                .snapshot()
                .from(this)
                .replaceAttribute("OPT", "menu")
                .sample()
                // .excluding(getSearch())
                .using(getDriver())
                // .element(getSearch())
                .compare();
    }
}