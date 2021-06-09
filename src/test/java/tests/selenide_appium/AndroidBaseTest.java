package tests.selenide_appium;

import com.codeborne.selenide.Configuration;
import drivers.AndroidMobileDriver;
import org.junit.jupiter.api.BeforeAll;

public class AndroidBaseTest extends TestBase {

    @BeforeAll
    public static void setup() {
        Configuration.browser = AndroidMobileDriver.class.getName();
    }
}
