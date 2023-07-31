package com.dorukozgen.turknetautomate.stepDefinations.desktop;

import com.dorukozgen.turknetautomate.pages.DesktopAltyapiSonucPage;
import com.dorukozgen.turknetautomate.pages.DesktopAltyapiSorgulaPage;
import com.dorukozgen.turknetautomate.pages.DesktopMainPage;
import com.dorukozgen.turknetautomate.utils.DesktopDriverManagement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DesktopTestSteps {

    DesktopMainPage mainPageObject;
    DesktopAltyapiSorgulaPage altyapiSorgulaPageObject;
    DesktopAltyapiSonucPage altyapiSonucPageObject;

    @Given("{string} websitesine git")
    public void website_git(String url) {
        DesktopDriverManagement.getInstance().getDriver().get(url);
    }

    @And("Sayfanın yüklenmesini bekle")
    public void sayfa_yukle() {
        DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.urlToBe("https://turk.net/")
        );

        DesktopDriverManagement.getInstance().getWait().until(
                driver -> {
                    assert driver != null;
                    return ((ChromeDriver) driver).executeScript("return document.readyState").equals("complete");
                }
        );
    }

    @Given("\"Altyapı Sorgula\" butonuna tıkla")
    public void altyapi_sorgula_butonuna_bas() {
        mainPageObject = new DesktopMainPage();
        mainPageObject.clickAltYapiSorgulaButton();
    }

    @When("\"Altyapı Sorgula\" sayfası yüklendiğinde")
    public void altyapi_sorgula_sayfasi_yukle() {
        DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.urlToBe("https://turk.net/internet-hiz-altyapi-sorgulama")
        );
        DesktopDriverManagement.getInstance().getWait().until(
                driver -> {
                    assert driver != null;
                    return ((ChromeDriver) driver).executeScript("return document.readyState").equals("complete");
                }
        );

        altyapiSorgulaPageObject = new DesktopAltyapiSorgulaPage();
    }

    @Then("\"İl\" alanından \"İSTANBUL\" seç")
    public void il_sec() throws InterruptedException {
        altyapiSorgulaPageObject.selectIl();
        Thread.sleep(1000);
    }

    @And("\"İlçe\" alanından \"ADALAR\" seç")
    public void ilce_sec() throws InterruptedException {
        altyapiSorgulaPageObject.selectIlce();
        Thread.sleep(1000);
    }

    @And("\"Mahalle\" alanından \"BURGAZADA\" seç")
    public void mahalle_sec() throws InterruptedException {
        altyapiSorgulaPageObject.selectMahalle();
        Thread.sleep(1000);
    }

    @And("\"Cadde \\/ Sokak\" alanından \"AYIŞIĞI SOKAGI\" seç")
    public void cadde_sokak_sec() throws InterruptedException {
        altyapiSorgulaPageObject.selectCaddeSokak();
        Thread.sleep(1000);
    }

    @And("\"Bina\" alanında \"NO: 2_\" seç")
    public void bina_sec() throws InterruptedException {
        altyapiSorgulaPageObject.selectBina();
        Thread.sleep(1000);
    }

    @And("\"Daire\" alanında \"\\/\" seç")
    public void daire_sec() throws InterruptedException {
        altyapiSorgulaPageObject.selectDaire();
        Thread.sleep(1000);
    }

    @Then("\"Sorgula\" butonuna tıkla")
    public void sorgula_butonu_tikla() throws InterruptedException {
        altyapiSorgulaPageObject.clickAltyapiSorgulaButton();
        Thread.sleep(1000);
    }

    @When("\"Sorgula\" butonuna tıklandıktan sonra altyapı bilgileri sayfası yüklendiğinde")
    public void altyapi_bilgileri_yuklendiginde() throws InterruptedException {
        altyapiSorgulaPageObject.checkErrorMessage();

        DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.urlContains("altyapi-sonucu")
        );
        DesktopDriverManagement.getInstance().getWait().until(
                driver -> {
                    assert driver != null;
                    return ((ChromeDriver) driver).executeScript("return document.readyState").equals("complete");
                }
        );

        altyapiSonucPageObject = new DesktopAltyapiSonucPage();
    }

    @Then("Altyapı bilgileri görüntülenir")
    public void altyapi_bilgileri_goruntulenir() {
        Assertions.assertEquals("Altyapı sorgulama sonucunuz", altyapiSonucPageObject.getAltyapiSonucTitle());
    }

}
