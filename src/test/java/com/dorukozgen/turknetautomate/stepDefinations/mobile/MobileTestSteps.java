package com.dorukozgen.turknetautomate.stepDefinations.mobile;

import com.dorukozgen.turknetautomate.pages.MobileMainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MobileTestSteps {

    MobileMainPage mobileMainPageObject;

    @Given("Bildirim ekranından bildirimlere izin ver")
    public void bildirim_izin_ver() throws InterruptedException {
        mobileMainPageObject = new MobileMainPage();
        mobileMainPageObject.clickNotificationAllowButton();
        Thread.sleep(1000);
    }

    @And("TC kimlik numarası alanına {string} gir")
    public void tc_kimlik_gir(String tc) throws InterruptedException {
        mobileMainPageObject.setUserNameInput(tc);
        Thread.sleep(1000);
    }

    @And("Şifre alanına {string} gir")
    public void sifre_gir(String password) throws InterruptedException {
        mobileMainPageObject.setPasswordInput(password);
        Thread.sleep(1000);
    }

    @And("\"Devam Et\" butonuna tıkla")
    public void devam_et_buton_tikla() throws InterruptedException {
        mobileMainPageObject.clickLoginButton();
        Thread.sleep(1000);
    }

    @Then("Giriş yapabildiğini kontrol et")
    public void giris_yapabildigini_kontrol_et() {
        mobileMainPageObject.checkUserNameErrorMessage();
    }
}
