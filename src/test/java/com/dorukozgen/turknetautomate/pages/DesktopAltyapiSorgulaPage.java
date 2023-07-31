package com.dorukozgen.turknetautomate.pages;

import com.dorukozgen.turknetautomate.utils.DesktopDriverManagement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DesktopAltyapiSorgulaPage {

    @FindBy(xpath = "//div[@id='formTab']/label/div")
    WebElement ilDropdown;

    By ilOptionBy = By.xpath("//div[@id='react-select-2-option-0']");

    @FindBy(xpath = "//div[@id='__next']/div/div[2]/div/div/div/div[4]/form/div/div[2]/label/div/div/div/div[2]")
    WebElement ilceDropdown;

    By ilceOptionBy = By.xpath("//div[@id='react-select-3-option-0']");

    @FindBy(xpath = "//div[@id='__next']/div/div[2]/div/div/div/div[4]/form/div/div[3]/label/div/div/div/div[2]")
    WebElement mahalleDropdown;

    By mahalleOptionBy = By.xpath("//div[@id='react-select-4-option-0']");

    @FindBy(xpath = "//div[@id='__next']/div/div[2]/div/div/div/div[4]/form/div/div[4]/label/div/div/div/div[2]")
    WebElement caddeSokakDropdown;

    By caddeSokakOptionBy = By.xpath("//div[@id='react-select-5-option-0']");

    @FindBy(xpath = "//div[@id='__next']/div/div[2]/div/div/div/div[4]/form/div/div[5]/label/div/div/div/div[2]")
    WebElement binaDropdown;

    By binaOptionBy = By.xpath("//div[@id='react-select-6-option-2']");

    @FindBy(xpath = "//div[@id='__next']/div/div[2]/div/div/div/div[4]/form/div/div[6]/label/div/div/div/div[2]")
    WebElement daireDropdown;

    By daireOptionBy = By.xpath("//div[@id='react-select-7-option-0']");

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[4]/form/button")
    WebElement altyapiSorgulaButton;

    By errorMessageBy = By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[1]/div/div[4]/div/div");

    public DesktopAltyapiSorgulaPage() {
        PageFactory.initElements(DesktopDriverManagement.getInstance().getDriver(), this);
    }

    public void selectIl() throws InterruptedException {
        ilDropdown.click();
        Thread.sleep(1000);
        DesktopDriverManagement.getInstance().getDriver().findElement(ilOptionBy).click();
    }

    public void selectIlce() throws InterruptedException {
        ilceDropdown.click();
        Thread.sleep(1000);
        DesktopDriverManagement.getInstance().getDriver().findElement(ilceOptionBy).click();
    }

    public void selectMahalle() throws InterruptedException {
        mahalleDropdown.click();
        Thread.sleep(1000);
        DesktopDriverManagement.getInstance().getDriver().findElement(mahalleOptionBy).click();
    }

    public void selectCaddeSokak() throws InterruptedException {
        caddeSokakDropdown.click();
        Thread.sleep(1000);
        DesktopDriverManagement.getInstance().getDriver().findElement(caddeSokakOptionBy).click();
    }

    public void selectBina() throws InterruptedException {
        binaDropdown.click();
        Thread.sleep(1000);
        DesktopDriverManagement.getInstance().getDriver().findElement(binaOptionBy).click();
    }

    public void selectDaire() throws InterruptedException {
        daireDropdown.click();
        Thread.sleep(1000);
        DesktopDriverManagement.getInstance().getDriver().findElement(daireOptionBy).click();
    }

    public void clickAltyapiSorgulaButton() {
        altyapiSorgulaButton.click();
    }

    public void checkErrorMessage() {
        WebElement errorMessage;
        try {
            errorMessage = DesktopDriverManagement.getInstance().getWait().until(ExpectedConditions.visibilityOfElementLocated(errorMessageBy));
            if(errorMessage.isDisplayed()) {
                Assertions.fail("Altyapı sorgulama işleminde hata oluştu: " + errorMessage.getText());
            }
        } catch (Exception e) {

        }
    }
}
