/* (c) Disney. All rights reserved. */
package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;

/**
 * @author Raghav
 */
public class SnowNewSearchLogRecordPage extends SnowNewRecordBasePage {

    private Supplier<WebElement> termLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='term')]")));

    private Supplier<WebElement> termtextbox = () -> waitFor(
            presenceOfElementLocated(xpath("//input[@name='x_wdtpa_wdpr_vacat_search_log.u_term']")));

    public boolean isTermLabelDisplayed() {

        return termLabel.get().isDisplayed();
    }

    public boolean isTermtextboxisEditable() {
        termtextbox.get().sendKeys("test");
        return termtextbox.get().isEnabled();

    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_search_log_list.do%3Fsysparm_userpref_module%3Dc9140d67db987e00a59ff9baae961921%26sysparm_clear_stack%3Dtrue%26sysparm_clear_stack%3Dtrue";
    }

}
