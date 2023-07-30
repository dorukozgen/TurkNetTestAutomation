package com.dorukozgen.turknetautomate.stepDefinations.desktop;

import com.dorukozgen.turknetautomate.utils.DesktopDriverManagement;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TurkNetTest {

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
        WebElement altyapiSorgulaButton = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("/html/body/div[3]/div[3]/div/div/main/div/div/section[1]/div/div[1]/div/div[12]/div/div/a")
                        )
                )
        );
        altyapiSorgulaButton.click();
    }

    @When("\"Altyapı Sorgula\" sayfası yüklendiğinde")
    public void altyapi_sorgula_sayfasi_yukle() {
        DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.urlToBe("https://turk.net/internet-hiz-altyapi-sorgulama")
        );
    }

    @Then("\"İl\" alanından \"İSTANBUL\" seç")
    public void il_sec() throws InterruptedException {
        WebElement ilDropdown = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='formTab']/label/div")
                        )
                )
        );
        ilDropdown.click();

        Thread.sleep(1000);

        WebElement ilIstanbul = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='react-select-2-option-0']")
                        )
                )
        );
        ilIstanbul.click();

        Thread.sleep(1000);
    }

    @And("\"İlçe\" alanından \"ADALAR\" seç")
    public void ilce_sec() throws InterruptedException {
        WebElement ilceDropdown = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='__next']/div/div[2]/div/div/div/div[4]/form/div/div[2]/label/div/div/div/div[2]")
                        )
                )
        );
        ilceDropdown.click();

        Thread.sleep(1000);

        WebElement ilceAdalar = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='react-select-3-option-0']")
                        )
                )
        );
        ilceAdalar.click();

        Thread.sleep(1000);
    }

    @And("\"Mahalle\" alanından \"BURGAZADA\" seç")
    public void mahalle_sec() throws InterruptedException {
        WebElement mahalleDropdown = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='__next']/div/div[2]/div/div/div/div[4]/form/div/div[3]/label/div/div/div/div[2]")
                        )
                )
        );
        mahalleDropdown.click();

        Thread.sleep(1000);

        WebElement mahalleBurgazada = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='react-select-4-option-0']")
                        )
                )
        );
        mahalleBurgazada.click();

        Thread.sleep(1000);
    }

    @And("\"Cadde \\/ Sokak\" alanından \"AYIŞIĞI SOKAGI\" seç")
    public void cadde_sokak_sec() throws InterruptedException {
        WebElement caddeSokakDropdown = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='__next']/div/div[2]/div/div/div/div[4]/form/div/div[4]/label/div/div/div/div[2]")
                        )
                )
        );
        caddeSokakDropdown.click();

        Thread.sleep(1000);

        WebElement caddeSokakAyisigiSokagi = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='react-select-5-option-0']")
                        )
                )
        );
        caddeSokakAyisigiSokagi.click();

        Thread.sleep(1000);
    }

    @And("\"Bina\" alanında \"NO: 2_\" seç")
    public void bina_sec() throws InterruptedException {
        WebElement binaDropdown = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='__next']/div/div[2]/div/div/div/div[4]/form/div/div[5]/label/div/div/div/div[2]")
                        )
                )
        );
        binaDropdown.click();

        Thread.sleep(1000);

        WebElement binaNo2 = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='react-select-6-option-2']")
                        )
                )
        );
        binaNo2.click();

        Thread.sleep(1000);
    }

    @And("\"Daire\" alanında \"\\/\" seç")
    public void daire_sec() throws InterruptedException {
        WebElement daireDropdown = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='__next']/div/div[2]/div/div/div/div[4]/form/div/div[6]/label/div/div/div/div[2]")
                        )
                )
        );
        daireDropdown.click();

        Thread.sleep(1000);

        WebElement daireSlash = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("//div[@id='react-select-7-option-0']")
                        )
                )
        );
        daireSlash.click();

        Thread.sleep(1000);
    }

    @Then("\"Sorgula\" butonuna tıkla")
    public void sorgula_butonu_tikla() throws InterruptedException {
        WebElement sorgulaButonu = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.elementToBeClickable(
                        DesktopDriverManagement.getInstance().getDriver().findElement(
                                By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[4]/form/button")
                        )
                )
        );
        sorgulaButonu.click();

        Thread.sleep(1000);
    }

    @When("\"Sorgula\" butonuna tıklandıktan sonra altyapı bilgileri sayfası yüklendiğinde")
    public void altyapi_bilgileri_yuklendiginde() throws InterruptedException {
        try {
            WebElement hataMesaji = DesktopDriverManagement.getInstance().getWait().until(
                    ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"__next\"]/div/div[2]/div[1]/div[1]/div/div[4]/div/div")
                    )
            );
            if (hataMesaji.isDisplayed()) {
                Assertions.fail("Altyapı sorgulamada hata mesajı görüntülendi: " + hataMesaji.getText());
            }
        } catch (Exception e) {
            System.out.println("Altyapı sorgulamada hata mesajı görüntülenmedi.");
        }


        DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.urlContains("altyapi-sonucu")
        );
        DesktopDriverManagement.getInstance().getWait().until(
                driver -> {
                    assert driver != null;
                    return ((ChromeDriver) driver).executeScript("return document.readyState").equals("complete");
                }
        );
    }

    @Then("Altyapı bilgileri görüntülenir")
    public void cu() {
        WebElement sayfaBasligi = DesktopDriverManagement.getInstance().getWait().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div[1]/div/div[2]/div[1]/h4")
                )
        );
        Assertions.assertEquals("Altyapı sorgulama sonucunuz", sayfaBasligi.getText());
    }

}
