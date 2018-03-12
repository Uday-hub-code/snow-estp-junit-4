package com.disney.cast.platform.estp.ui.visual;

import static com.disney.cast.platform.vacationplanner.test.ui.UiAuthLevel.SNOWADMIN;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.nio.file.Paths;

import org.junit.Test;

import com.disney.automation.webframework.config.User;
import com.disney.cast.platform.common.ui.pages.ApplicationsLoginPage;
import com.disney.cast.platform.vacationplanner.test.ui.AbstractVacationPlannerRewardsUiTest;
import com.disney.cast.platform.vacationplanner.ui.app.pages.home.HomePage;
import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.junit4.Tag;

public class HomePageVisualTest extends AbstractVacationPlannerRewardsUiTest {

    private final User planner = users().get(SNOWADMIN.toString());

    public HomePageVisualTest() throws MalformedURLException {
    }

    @Override
    public void specificSetUp() throws Exception {
        Ocular
                .config()
                .resultPath(Paths.get("./target/result"))
                .snapshotPath(Paths.get("./target/snapshot"))
                .globalSimilarity(95)
                .saveSnapshot(true);
    }

    @Description("Visual validation of Home")
    @Epic("Visual Tests")
    @Issue("PPE-10717")
    @Owner("Luis")
    @Feature("Login")
    @DisplayName("Open Home Page")
    @Tag("UI")
    @Link(name = "allure", type = "mylink", url = "https://example.org")
    @TmsLink("https://hpalm.com")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void homePageVisualTest() throws Exception {
        ApplicationsLoginPage loginPage = new ApplicationsLoginPage();
        HomePage homePage = loginPage.logIn(planner.getUserName(), planner.getPass(), HomePage.class);
        OcularResult ocularResult = homePage.compare();
        assertTrue("Images should be equals", ocularResult.isEqualsImages());
    }

}
