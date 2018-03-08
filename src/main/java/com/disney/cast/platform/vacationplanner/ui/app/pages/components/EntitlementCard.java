package com.disney.cast.platform.vacationplanner.ui.app.pages.components;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.tagName;

import java.util.List;
import java.util.function.Supplier;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.disney.automation.webframework.pageobject.PageElement;

public class EntitlementCard extends PageElement {

    private final Supplier<WebElement> header;
    private final Supplier<WebElement> dates;
    private final Supplier<WebElement> rewardCardTitle;
    private final Supplier<List<WebElement>> expirationInfo;
    private final Supplier<WebElement> redeemButton;
    private final Supplier<List<WebElement>> redeemInfo;

    public final RedeemRewardConfirmationWindow confirmationWindow;

    public EntitlementCard(Supplier<WebElement> locatorSupplier) {
        super(locatorSupplier.get());
        header = () -> waitFor(
                ExpectedConditions.presenceOfNestedElementLocatedBy(locatorSupplier.get(), tagName("h4")));
        dates = () -> waitFor(
                ExpectedConditions.presenceOfNestedElementLocatedBy(locatorSupplier.get(),
                        cssSelector("div[class*='reward-earned-period ng-binding']")));
        rewardCardTitle = () -> waitFor(
                ExpectedConditions.presenceOfNestedElementLocatedBy(locatorSupplier.get(),
                        cssSelector("div[class*='row']>div + div")));

        expirationInfo = () -> waitFor(
                ExpectedConditions.presenceOfNestedElementLocatedBy(locatorSupplier.get(),
                        cssSelector(".no-redeemed-card")))
                                .findElements(cssSelector(".no-redeemed-card .row .ng-binding"));

        redeemInfo = () -> {
            waitFor(ExpectedConditions
                    .presenceOfElementLocated(cssSelector(".redeemed-card .margin-row-home.row div")));
            return waitFor(ExpectedConditions.presenceOfNestedElementLocatedBy(locatorSupplier.get(),
                    cssSelector(".redeemed-card")))
                            .findElements(cssSelector(".margin-row-home.row"));
        };

        redeemButton = () -> waitFor(
                ExpectedConditions.presenceOfNestedElementLocatedBy(locatorSupplier.get(),
                        cssSelector("button[type='submit']")));
        confirmationWindow = new RedeemRewardConfirmationWindow(locatorSupplier);
    }

    public String getHeader() {
        return header.get().getText();
    }

    public String getDates() {
        return dates.get().getText();
    }

    public String getStartDate() {
        return getDates().split("-")[0].trim();
    }

    public String getEndDate() {
        return getDates().split("-")[1].trim();
    }

    public String getRewardCardTitle() {
        return rewardCardTitle.get().getText();
    }

    public String getExpirationLabel() {
        return expirationInfo.get().get(0).getText();
    }

    public String getExpirationDate() {
        return expirationInfo.get().get(1).getText();
    }

    public String getStatus() {
        return redeemInfo.get().get(0).getText().split("\n")[1];
    }

    public String getOrderedDate() {
        return redeemInfo.get().get(1).getText().split("\n")[1];
    }

    public String getExpectedDeliveryDate() {
        return redeemInfo.get().get(2).getText().split("\n")[1];
    }

    public RedeemRewardConfirmationWindow clickRedeemNow() {
        redeemButton.get().click();
        return confirmationWindow;
    }

    public boolean isRedeemButtonVisible() {
        return redeemButton.get().isDisplayed() && redeemButton.get().isEnabled();
    }

    public String getEntitlementCardFullTextContent() {
        return getContextElement().getText();
    }
}
