package tests.base;

import config.ConfigManager;
import core.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        String browser = ConfigManager.getInstance().getProperty("browser");
        DriverFactory.initDriver(browser);

        DriverFactory.getDriver().get(
                ConfigManager.getInstance().getProperty("baseUrl")

        );

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}