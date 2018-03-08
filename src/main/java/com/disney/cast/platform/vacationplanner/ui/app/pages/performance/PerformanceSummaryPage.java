/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.app.pages.performance;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.automation.webframework.pageobject.PageObject;
import com.disney.cast.platform.vacationplanner.ui.app.pages.performance.components.DetailsPanel;
import com.disney.cast.platform.vacationplanner.ui.app.pages.performance.components.PerformanceCard;

/**
 * @author luis.martinez
 */
public class PerformanceSummaryPage extends PageObject {

    private DetailsPanel detailsPanel = new DetailsPanel(By.cssSelector("div[id='kng-panel-id-2']>.kng-panel"));

    private List<PerformanceCard> performanceCards;

    public List<PerformanceCard> getPerformanceCards() {
        List<WebElement> cards = getDriver().findElements(By.className("vpr-performance-cards-container"));
        performanceCards = cards.stream().map((card) -> new PerformanceCard(card)).collect(Collectors.toList());
        return performanceCards;
    }

    public boolean isDetailsPanelDisplayed() {
        return detailsPanel.isDisplayed();
    }

    public DetailsPanel getDetailsPanel() {
        return detailsPanel;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.disney.automation.webframework.pageobject.PageObject#setOwnUrl()
     */
    @Override
    protected String setOwnUrl() {
        // TODO Auto-generated method stub
        return null;
    }

}
