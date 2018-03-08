package com.disney.cast.platform.estp.ui.app.home;

import static com.disney.cast.platform.vacationplanner.test.ui.UiAuthLevel.SNOWADMIN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Test;

import com.disney.automation.webframework.config.User;
import com.disney.cast.platform.common.ui.pages.ApplicationsLoginPage;
import com.disney.cast.platform.vacationplanner.test.ui.AbstractVacationPlannerRewardsUiTest;
import com.disney.cast.platform.vacationplanner.ui.app.pages.home.HomePage;

public class LoginSuccessfulTest extends AbstractVacationPlannerRewardsUiTest {

    private final User planner = users().get(SNOWADMIN.toString());

    public LoginSuccessfulTest() throws MalformedURLException {
    }

    @Override
    public void specificSetUp() throws Exception {
    }

    @Test
    public void loginSuccessfulTest() throws Exception {
        ApplicationsLoginPage loginPage = new ApplicationsLoginPage();
        HomePage homePage = loginPage.logIn(planner.getUserName(), planner.getPass(), HomePage.class);

        assertTrue("Planner should have been able to log in. Home page is not displayed", homePage.isVisible());
        assertEquals("Welcome, wdpr-cp-svc-ci-automation First Name", homePage.getCenterText());
        assertEquals("This Month's Performance", homePage.getThisMonthsPerformance());
        assertEquals("View Full Performance Summary", homePage.getViewFullPerformance());
        assertEquals("View Reward History", homePage.getRewardHistory());
    }

}
