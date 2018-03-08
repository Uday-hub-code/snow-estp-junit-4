package com.disney.cast.platform.vacationplanner.ui.app.pages.home;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageObject;
import com.disney.cast.platform.vacationplanner.ui.app.pages.components.HistoryEntitlementCard;

public class PastRedemptionsPage extends PageObject {

    private Supplier<WebElement> homeLink = () -> waitFor(presenceOfElementLocated(
            cssSelector("[class='kng-breadcrumbs ng-scope'] a[class*='kng-breadcrumb ng-binding']")));

    private Supplier<WebElement> rewardHistoryHeader = () -> waitFor(
            presenceOfElementLocated(cssSelector(".kng-container div[class='container ng-scope'] p")));

    public final Supplier<List<HistoryEntitlementCard>> entitlements = () -> waitFor(presenceOfAllElementsLocatedBy(
            cssSelector("div[class*='kng-list'] div[class='kng-list-item ng-scope']")))
                    .stream()
                    .map(e -> new HistoryEntitlementCard(e))
                    .collect(Collectors.toList());

    public HomePage clickOnHomeLink() {
        homeLink.get().click();
        return new HomePage();
    }

    public String getRewardhistoryHeader() {
        return rewardHistoryHeader.get().getText();
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/wdpr-cast/x_wdtpa_wdpr_vacat_WDPR%20Vacation%20Planner%20Page.do#!/past-redemptions";
    }

}
