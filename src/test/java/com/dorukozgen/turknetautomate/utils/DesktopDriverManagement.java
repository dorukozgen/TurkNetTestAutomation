package com.dorukozgen.turknetautomate.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public final class DesktopDriverManagement {

    private static DesktopDriverManagement instance;
    private ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();
    private ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();


    private DesktopDriverManagement() {
    }

    public static DesktopDriverManagement getInstance() {
        if (instance == null) {
            synchronized (DesktopDriverManagement.class) {
                instance = new DesktopDriverManagement();
            }
        }
        return instance;
    }

    public ChromeDriver getDriver() {
        return driver.get();
    }

    public WebDriverWait getWait() {
        return wait.get();
    }

    public void launch() {
        if (driver.get() == null) {
            setDriver();
        }
    }

    public void setDriver() {
        System.setProperty(
                "webdriver.chrome.driver",
                Paths.get("").resolve("./src/test/resources/drivers/chromedriver.exe").toAbsolutePath().toString()
        );

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        ChromeDriver chromeDriver = new ChromeDriver(options);

        this.driver.set(chromeDriver);
        this.wait.set(
                new WebDriverWait(chromeDriver, Duration.of(10, ChronoUnit.SECONDS))
        );
    }

    public void destroy() {
        try {
            driver.get().quit();
        } catch (WebDriverException e) {
            e.printStackTrace();
        } finally {
            driver.remove();
            wait.remove();
        }
    }

}
