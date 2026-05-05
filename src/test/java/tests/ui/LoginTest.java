package tests.ui;

import core.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import tests.base.BaseTest;

import java.sql.Driver;

public class LoginTest extends BaseTest{
    public void testLogin() {
        WebDriver driver = DriverFactory.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user", "password");
    }
}
