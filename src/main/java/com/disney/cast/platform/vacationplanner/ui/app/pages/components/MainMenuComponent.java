package com.disney.cast.platform.vacationplanner.ui.app.pages.components;

import static com.disney.cast.platform.vacationplanner.ui.common.NWElement.findNWElements;
import static java.lang.String.format;

import java.util.List;

import org.openqa.selenium.By;

import com.disney.automation.webframework.pageobject.PageElement;
import com.disney.cast.platform.vacationplanner.ui.app.pages.RewardLevelsPage;
import com.disney.cast.platform.vacationplanner.ui.common.NWElement;

/**
 * @author jose.oropeza
 */
public class MainMenuComponent extends PageElement {
    private List<NWElement> sideMenuLinks = findNWElements(getDriver(),
            By.cssSelector("kng-side-menu div[class='kng-side-menu left show']>div>div>div"));

    public MainMenuComponent(By contextElement) {
        super(contextElement);
    }

    private NWElement getSideMenuItemLink(String byText) {
        for (NWElement nwelement : sideMenuLinks) {
            if (byText.equalsIgnoreCase(nwelement.assuredGetText())) {
                return nwelement;
            }
        }
        throw new RuntimeException(format("Side menu item %s does not exist or was not found.", byText));
    }

    public RewardLevelsPage clickRewardLevels() {
        if (getSideMenuItemLink("Reward Levels").successfulClick()) {
            return new RewardLevelsPage();
        }
        throw new RuntimeException("Reward Levels was not possible to be clicked");
    }

}
