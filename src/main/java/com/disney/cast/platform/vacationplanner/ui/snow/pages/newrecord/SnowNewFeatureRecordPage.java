package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;

public class SnowNewFeatureRecordPage extends SnowNewRecordBasePage {

    private Supplier<WebElement> keyLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='key')]")));

    private Supplier<WebElement> valueLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='value')]")));

    public boolean isKeyLabelDisplayed() {

        return keyLabel.get().isDisplayed();
    }

    public boolean isValueLabelDisplayed() {
        return valueLabel.get().isDisplayed();
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_feature.do%3Fsys_id%3D-1%26sys_is_list%3Dtrue%26sys_target%3Dx_wdtpa_wdpr_vacat_feature%26sysparm_checked_items%3D%26sysparm_ck%3Db574ea10db293200a4645e65ce96195b22cff4289d965011a5c93566d29a52dbb719c422%26sysparm_fixed_query%3D%26sysparm_group_sort%3D%26sysparm_list_css%3D%26sysparm_query%3D%26sysparm_referring_url%3Dx_wdtpa_wdpr_vacat_feature_list.do%253fsysparm_clear_stack%253dtrue%26sysparm_target%3D%26sysparm_view%3D";
    }

}
