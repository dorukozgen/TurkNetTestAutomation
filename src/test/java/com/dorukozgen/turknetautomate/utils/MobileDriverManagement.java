package com.dorukozgen.turknetautomate.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class MobileDriverManagement {

    public static MobileDriverManagement instance;
    private AppiumDriverLocalService service;
    private ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    private ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    private MobileDriverManagement() {
    }

    public static MobileDriverManagement getInstance() {
        if (instance == null) {
            synchronized (MobileDriverManagement.class) {
                instance = new MobileDriverManagement();
            }
        }
        return instance;
    }

    public AndroidDriver getDriver() {
        return driver.get();
    }

    public WebDriverWait getWait() {
        return wait.get();
    }

    public void launch() {
        if (service == null) {
            setService();
        }
        if (driver.get() == null) {
            setDriver();
        }
    }

    public void setService() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withAppiumJS(
                        new File("C:\\Users\\loseu\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js")
                )
                .usingDriverExecutable(
                        new File("C:\\Program Files\\nodejs\\node.exe")
                )
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .withArgument (GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument (GeneralServerFlag.LOG_LEVEL, "debug");

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public void setDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 33");
        capabilities.setCapability("appPackage", "com.turknet.oim");
        capabilities.setCapability("appActivity", "com.turknet.oim.features.loginotp.presentation.login.LoginActivity");
        capabilities.setCapability("skipUnlock", "true");
        capabilities.setCapability("noReset", "false");

        AndroidDriver androidDriver = new AndroidDriver(service.getUrl(), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        this.driver.set(androidDriver);
        this.wait.set(
                new WebDriverWait(androidDriver, Duration.of(10, ChronoUnit.SECONDS))
        );
    }

    public void destroy() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
        if (wait.get() != null) {
            wait.remove();
        }
        if (service != null) {
            service.stop();
            service = null;
        }
    }
}
