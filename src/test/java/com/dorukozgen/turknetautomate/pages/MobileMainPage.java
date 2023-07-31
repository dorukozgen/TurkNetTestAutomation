package com.dorukozgen.turknetautomate.pages;

import com.dorukozgen.turknetautomate.utils.MobileDriverManagement;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MobileMainPage {

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]")
    WebElement notifcationAllowButton;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")
    WebElement userNameInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText")
    WebElement passwordInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button")
    WebElement loginButton;

    By userNameErrorMessage = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");

    public MobileMainPage() {
        PageFactory.initElements(
                new AppiumFieldDecorator(MobileDriverManagement.getInstance().getDriver()),
                this
        );
    }

    public void clickNotificationAllowButton() {
        notifcationAllowButton.click();
    }

    public void setUserNameInput(String userName) throws InterruptedException {
        userNameInput.click();
        Thread.sleep(1000);
        userNameInput.sendKeys(userName);
    }

    public void setPasswordInput(String password) throws InterruptedException {
        passwordInput.click();
        Thread.sleep(1000);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void checkUserNameErrorMessage() {
        try {
            WebElement userNameErrorMessageEl = MobileDriverManagement.getInstance().getWait().until(
                    ExpectedConditions.visibilityOfElementLocated(userNameErrorMessage)
            );
            Assertions.assertFalse(userNameErrorMessageEl.isDisplayed(), "TC kimlik numarası alanında hata mesajı görüntülendi: " + userNameErrorMessageEl.getText());
        } catch (Exception ignored) {

        }
    }
}
