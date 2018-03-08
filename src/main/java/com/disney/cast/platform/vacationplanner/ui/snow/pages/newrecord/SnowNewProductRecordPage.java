package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.newrecord.SnowNewRecordBasePage;

public class SnowNewProductRecordPage extends SnowNewRecordBasePage {

    private Supplier<WebElement> activeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Active')]")));

    private Supplier<WebElement> nameLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Name')]")));

    private Supplier<WebElement> descriptionLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Description')]")));

    private Supplier<WebElement> categoryLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Category')]")));

    private Supplier<WebElement> considerationsLabel = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//span[contains(@class, 'label-text') and (text()='Considerations')]")));

    private Supplier<WebElement> relatedProductsLabel = () -> waitFor(
            presenceOfElementLocated(
                    xpath("//span[contains(@class, 'label-text') and (text()='Related Products')]")));

    private Supplier<WebElement> keywordsLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Keywords')]")));

    private Supplier<WebElement> priceLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Price')]")));

    private Supplier<WebElement> quantityLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Quantity')]")));

    private Supplier<WebElement> productCodeLabel = () -> waitFor(
            presenceOfElementLocated(xpath("//span[contains(@class, 'label-text') and (text()='Product code')]")));

    private Supplier<WebElement> activeCheckbox = () -> waitFor(
            presenceOfElementLocated(By.cssSelector(".input-group-checkbox>label")));

    private Supplier<WebElement> activeInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_product.u_active")));
    private Supplier<WebElement> name = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_product.u_name")));
    private Supplier<WebElement> description = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_product.u_description")));
    private Supplier<WebElement> considerations = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_product.u_considerations")));
    private Supplier<WebElement> keywords = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_product.u_keywords")));
    private Supplier<WebElement> price = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_product.u_price")));
    private Supplier<WebElement> quantity = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_product.u_quantity")));
    private Supplier<WebElement> productCode = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_product.u_product_code")));

    public boolean isActiveLabelDisplayed() {
        return activeLabel.get().isDisplayed();
    }

    public boolean isNameLabelDisplayed() {
        return nameLabel.get().isDisplayed();
    }

    public boolean isDescriptionLabelDisplayed() {
        return descriptionLabel.get().isDisplayed();
    }

    public boolean isCategoryLabelDisplayed() {
        return categoryLabel.get().isDisplayed();
    }

    public boolean isConsiderationsLabelDisplayed() {
        return considerationsLabel.get().isDisplayed();
    }

    public boolean isRelatedProductsLabelDisplayed() {
        return relatedProductsLabel.get().isDisplayed();
    }

    public boolean isKeywordsLabelDisplayed() {
        return keywordsLabel.get().isDisplayed();
    }

    public boolean isPriceLabelDisplayed() {
        return priceLabel.get().isDisplayed();
    }

    public boolean isQuantityLabelDisplayed() {
        return quantityLabel.get().isDisplayed();
    }

    public boolean isProductCodeLabelDisplayed() {
        return productCodeLabel.get().isDisplayed();
    }

    public boolean areAllLabelsDisplayed() {
        boolean isDisplay = false;
        if (isActiveLabelDisplayed() && isNameLabelDisplayed() && isDescriptionLabelDisplayed()
                && isCategoryLabelDisplayed() && isConsiderationsLabelDisplayed()
                && isRelatedProductsLabelDisplayed()
                && isKeywordsLabelDisplayed() && isPriceLabelDisplayed() && isQuantityLabelDisplayed()
                && isProductCodeLabelDisplayed()) {
            isDisplay = true;
        }
        return isDisplay;
    }

    @Override
    protected String setOwnUrl() {
        return "https://wdprautomation.service-now.com/nav_to.do?uri=%2Fx_wdtpa_wdpr_vacat_product.do%3Fsys_id%3D3e7d3b72dba1f200eaef5434ce96193c%26sysparm_view%3D%26sysparm_record_target%3D%26sysparm_record_row%3D1%26sysparm_record_list%3DORDERBYDESCu_name%26sysparm_record_rows%3D1";
    }

    public boolean isNameEditable() {
        return isEditable(name.get());
    }

    public boolean isDescriptionEditable() {
        return isEditable(description.get());
    }

    public boolean isConsiderationsEditable() {
        return isEditable(considerations.get());
    }

    public boolean isKeywordsEditable() {
        return isEditable(keywords.get());
    }

    public boolean isPriceEditable() {
        return isEditable(price.get());
    }

    public boolean isQuantityEditable() {
        return isEditable(quantity.get());
    }

    public boolean isProductCodeEditable() {
        return isEditable(productCode.get());
    }

    public boolean isActiveCheckboxEditable() {
        boolean originalState = activeInput.get().getAttribute("value").equals("true");
        activeCheckbox.get().click();
        boolean newState = activeInput.get().getAttribute("value").equals("true");
        return originalState == !newState;
    }

}
