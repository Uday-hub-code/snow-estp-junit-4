package com.disney.cast.platform.vacationplanner.test.api;

import static com.disney.cast.platform.vacationplanner.data.DataManager.ALERT_DATA_MANAGER;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Rule;

import com.disney.automation.servicetesting.core.AbstractApiTest;
import com.disney.cast.platform.vacationplanner.data.DataManager;

/**
 * @author walter.finkbeiner
 */
public abstract class AbstractVacationPlannerRewardsApiTest extends AbstractApiTest {

    public AbstractVacationPlannerRewardsApiTest() throws MalformedURLException {
        super();
    }

    @Rule
    public DataManager dataManager = new DataManager();

    @Before
    public void generalSetup() throws Exception {
        ALERT_DATA_MANAGER.deleteAll();
        specificSetUp();
    }

    protected abstract void specificSetUp() throws Exception;

    @Override
    protected Object[] setAuthLevels() {
        return ApiAuthLevel.values();
    }
}
