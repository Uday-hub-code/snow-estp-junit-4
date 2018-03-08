package com.disney.cast.platform.vacationplanner.test.ui;

import static com.disney.cast.platform.vacationplanner.data.DataManager.ALERT_DATA_MANAGER;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Rule;

import com.disney.automation.webframework.logging.CustomTestWatcher;
import com.disney.automation.webframework.tests.JUnit4WebDriverTest;
import com.disney.cast.platform.vacationplanner.data.DataManager;

public abstract class AbstractVacationPlannerRewardsUiTest extends JUnit4WebDriverTest {

    public AbstractVacationPlannerRewardsUiTest() throws MalformedURLException {
        super();
    }

    @Rule
    public DataManager dataManager = new DataManager();

    @Rule
    public CustomTestWatcher customTestWatcher = new CustomTestWatcher();

    @Before
    public void generalSetup() throws Exception {
        ALERT_DATA_MANAGER.deleteAll();
        specificSetUp();
    }

    @Override
    protected Object[] setAuthLevels() {
        return UiAuthLevel.values();
    }

    protected abstract void specificSetUp() throws Exception;
}
