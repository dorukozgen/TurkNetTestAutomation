package com.dorukozgen.turknetautomate.pages;

import com.dorukozgen.turknetautomate.utils.DesktopDriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage {

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/main/div/div/section[1]/div/div[1]/div/div[12]/div/div/a")
    WebElement altYapiSorgulaButton;

    public MainPage() {
        PageFactory.initElements(DesktopDriverManagement.getInstance().getDriver(), this);
    }

    public void clickAltYapiSorgulaButton() {
        altYapiSorgulaButton.click();
    }


}
