package com.disney.cast.platform.vacationplanner.ui.snow.pages.newrecord;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.disney.cast.platform.common.ui.snow.pages.recordslist.SnowRecordsListPage;
import com.disney.cast.platform.vacationplanner.ui.snow.pages.common.ControlSnowBasePage;

public class SnowImportRecordPage extends ControlSnowBasePage {
    private Supplier<WebElement> numberTxtInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_wdpr_import_records.number")));

    private Supplier<WebElement> destinationTxtInput = () -> waitFor(
            presenceOfElementLocated(By.id("x_wdtpa_wdpr_vacat_wdpr_import_records.u_destination_table")));

    private Supplier<WebElement> attachButton = () -> waitFor(
            presenceOfElementLocated(By.id("header_add_attachment")));

    private Supplier<WebElement> sendFile = () -> waitFor(
            presenceOfElementLocated(By.id("attachFile")));

    private Supplier<WebElement> closeButton = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("button[data-dismiss='GlideModal'][class='btn btn-icon close icon-cross']")));

    private Supplier<WebElement> submit = () -> waitFor(presenceOfElementLocated(
            By.cssSelector("span.navbar_ui_actions button")));

    private Supplier<WebElement> processButton = () -> waitFor(
            presenceOfElementLocated(By.xpath("//button[text()='Process Attachment']")));

    private SnowImportRecordPage selectDestinationOption(String destination) {
        select(destinationTxtInput.get(), destination);
        return this;
    }

    public SnowRecordsListPage clickProcess() {
        click(processButton.get());
        return new SnowRecordsListPage();
    }

    public String getNumberFromTxtInput() {
        return getTextFromInput(numberTxtInput);
    }

    public SnowImportRecordPage clickAttachButton() {
        attachButton.get().click();
        return this;
    }

    public SnowRecordsListPage uploadFile(String destination, String fileName) {
        return clickAttachButton()
                .selectDestinationOption(destination)
                .sendToFileButton(fileName)
                .closeModalWindow()
                .clickOnSubmit();
    }

    private SnowImportRecordPage sendToFileButton(String fileName) {
        getJS().executeScript("arguments[0].removeAttribute('multiple');", sendFile.get());
        sendFile
                .get()
                .sendKeys(getClass().getClassLoader().getResource(fileName).getFile().replaceFirst("/", ""));
        return this;
    }

    private SnowImportRecordPage closeModalWindow() {
        closeButton.get().click();
        return this;
    }

    private SnowRecordsListPage clickOnSubmit() {
        submit.get().click();
        return new SnowRecordsListPage();
    }

    @Override
    protected String setOwnUrl() {
        return null;
    }

}
