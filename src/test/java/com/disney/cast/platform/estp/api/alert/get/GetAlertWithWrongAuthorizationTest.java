package com.disney.cast.platform.estp.api.alert.get;

import static com.disney.cast.platform.vacationplanner.api.app.AlertApi.getAlert;
import static com.disney.cast.platform.vacationplanner.test.api.ApiAuthLevel.WRONG_AUTH;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Test;

import com.disney.automation.servicetesting.core.ApiTestResponse;
import com.disney.cast.platform.common.api.model.Error;
import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.vacationplanner.test.api.AbstractVacationPlannerRewardsApiTest;
import com.fasterxml.jackson.core.type.TypeReference;

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

/**
 * https://jira.disney.com/browse/PPE-2340
 *
 * @author erick.ricardez
 */
public class GetAlertWithWrongAuthorizationTest extends AbstractVacationPlannerRewardsApiTest {

    public GetAlertWithWrongAuthorizationTest() throws MalformedURLException {
        super();
    }

    @Override
    public void specificSetUp() throws Exception {
    }

    @Description("Wrong authorization test for /alert endpoint.")
    @Epic("Regression Tests")
    @Issue("PPE-10717")
    @Owner("Jose")
    @Feature("Alert")
    @Tag("API")
    @DisplayName("Access to alert endpoint with wrong authorization")
    @Tag("API")
    @Tag("GET")
    @Link(name = "allure", type = "mylink", url = "https://example.org")
    @TmsLink("https://hpalm.com")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void getConfigurationWithWrongAuthorizationTest() throws Exception {
        ApiTestResponse alertResponse = getAlert(clients().get(WRONG_AUTH.toString()));
        int statusCode = alertResponse.getStatus();
        Error error = alertResponse
                .getBodyObject(new TypeReference<Result<Error>>() {
                })
                .getResult();
        assertEquals(
                String.format(
                        "When making a request to /vacation_planner/alert with wrong credentials, the HTTP status code of the response should be 401 instead of %s",
                        alertResponse.getStatus()),
                401, statusCode);
        assertEquals(
                String.format(
                        "When making a request to /vacation_planner/alert with wrong credentials, the error response body should show %s as message key",
                        Error.Messages.UNAUTHORIZED_MESSAGE_BODY),
                Error.Messages.UNAUTHORIZED_MESSAGE_BODY, error.getMessageKey());
        assertEquals(
                String.format(
                        "When making a request to /vacation_planner/alert with wrong credentials, the error response body should show %s as title key",
                        Error.Messages.UNAUTHORIZED_TITLE_KEY),
                Error.Messages.UNAUTHORIZED_TITLE_KEY, error.getTitleKey());
    }
}
