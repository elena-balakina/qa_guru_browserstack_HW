package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.Browserstack;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.Project.androidConfig;

public class AndroidMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        return getAndroidDriver();
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", androidConfig.device());
        capabilities.setCapability("os_version", androidConfig.os());
        capabilities.setCapability("app", androidConfig.appUrl());

        return new AndroidDriver(Browserstack.browserstackUrl(), capabilities);
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "First Java Project");
        capabilities.setCapability("build", "Java Android");
        capabilities.setCapability("name", "first_test");
        capabilities.setCapability("autoGrantPermissions", "true");

        return capabilities;
    }
}
