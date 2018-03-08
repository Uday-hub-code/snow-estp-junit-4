package com.disney.cast.platform.estp.api.alert.get;

import static com.disney.cast.platform.vacationplanner.api.app.AlertApi.getAlert;
import static com.disney.cast.platform.vacationplanner.test.api.ApiAuthLevel.NO_AUTH;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.Test;

import com.disney.automation.servicetesting.core.ApiTestResponse;
import com.disney.cast.platform.common.api.model.Error;
import com.disney.cast.platform.common.api.model.Result;
import com.disney.cast.platform.vacationplanner.test.api.AbstractVacationPlannerRewardsApiTest;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * https://jira.disney.com/browse/PPE-2340
 *
 * @author erick.ricardez
 */
public class GetAlertWithoutAuthorizationTest extends AbstractVacationPlannerRewardsApiTest {

    public GetAlertWithoutAuthorizationTest() throws MalformedURLException {
        super();
    }

    @Override
    public void specificSetUp() throws Exception {
    }

    @Test
    public void getAlertWithoutAuthorizationTest() throws Exception {
        ApiTestResponse alertResponse = getAlert(clients().get(NO_AUTH.toString()));
        int statusCode = alertResponse.getStatus();
        Error error = alertResponse
                .getBodyObject(new TypeReference<Result<Error>>() {
                })
                .getResult();
        assertEquals(
                String.format(
                        "When making a request to /vacation_planner/alert without credentials, the HTTP status code of the response should be 401 instead of %s",
                        alertResponse.getStatus()),
                401, statusCode);
        assertEquals(
                String.format(
                        "When making a request to /vacation_planner/alert without credentials, the error response body should show %s as message key",
                        Error.Messages.UNAUTHORIZED_MESSAGE_BODY),
                Error.Messages.UNAUTHORIZED_MESSAGE_BODY, error.getMessageKey());
        assertEquals(
                String.format(
                        "When making a request to /vacation_planner/alert without credentials, the error response body should show %s as title key",
                        Error.Messages.UNAUTHORIZED_TITLE_KEY),
                Error.Messages.UNAUTHORIZED_TITLE_KEY, error.getTitleKey());
    }
}
