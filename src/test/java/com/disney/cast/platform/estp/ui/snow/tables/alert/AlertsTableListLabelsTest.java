/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.estp.ui.snow.tables.alert;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.util.Set;

import org.junit.Test;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.test.ui.AbstractVacationPlannerRewardsUiTest;

/**
 * https://jira.disney.com/browse/PPE-2784 Verify Alerts table page labels in SNOW UI
 *
 * @author erick.ricardez
 */
public class AlertsTableListLabelsTest extends AbstractVacationPlannerRewardsUiTest {

    private static final String[] expectedTableLabels = {
            "active",
            "body",
            "type" };

    public AlertsTableListLabelsTest() throws MalformedURLException {
    }

    @Override
    public void specificSetUp() throws Exception {
    }

    @Test
    public void entitlementsTableListLabelsTest() throws Exception {
        SnowRecordsListPage entitlementsRecordsListPage = AlertsCommonFlow
                .navigationToAlertContent(users());
        entitlementsRecordsListPage.goToContentIframe();
        Set<String> entitlementsListHeadersText = entitlementsRecordsListPage
                .getListHeader()
                .getListHeadersText();
        assertTrue("The amount of labels in the records table header is not the expected one",
                entitlementsListHeadersText.size() >= expectedTableLabels.length);
        for (String expectedLabel : expectedTableLabels) {
            assertTrue(expectedLabel + " was supposed to be present in the records table headers",
                    entitlementsListHeadersText.contains(expectedLabel));
        }
    }

}
