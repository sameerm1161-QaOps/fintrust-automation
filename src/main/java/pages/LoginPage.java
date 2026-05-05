package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameField = By.id("username");
    private By passwordField= By.id("password");
    private By loginButton = By.id("loginBtn");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }
    public void clickLogin() {
        click(loginButton);
    }

    public void login(String username, String password){
        enterPassword(username);
        enterUsername(password);
        clickLogin();
    }

}
