package com.dorukozgen.turknetautomate.pages;

import com.dorukozgen.turknetautomate.utils.DesktopDriverManagement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AltyapiSonucPage {

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/main/div/div/section[1]/div/div[1]/div/div[12]/div/div/a")
    WebElement altyapiSonucTitle;

    public AltyapiSonucPage() {
        PageFactory.initElements(DesktopDriverManagement.getInstance().getDriver(), this);
    }

    public String getAltyapiSonucTitle() {
        return altyapiSonucTitle.getText();
    }
}
