package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        waitForElement(locator);
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        waitForElement(locator);
        driver.findElement(locator).sendKeys();
    }

    protected String getText(By locator) {waitForElement(locator);
       return driver.findElement(locator).getText();
    }

    protected void waitForElement(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
