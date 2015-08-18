package pages;

import Utils.TestBase;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.Driver;

import static junit.framework.Assert.*;


public class LoginPage extends TestBase {

    // URL
    public static String url = BaseURL + logInPath;

    // Page Elements
    @FindBy(id = "loginUser")
    public WebElement usernameField;
    @FindBy(id = "loginPassword")
    public WebElement passwordField;
    @FindBy(className = "btn-block")
    public WebElement loginButton;


    RegisterPage registerPage = new RegisterPage();


    // METHODS
    public void openPage() {
        driver.get(url);
    }


    public void login(String username, String password) {
        waitForElement(usernameField, defaultTimeOut);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void confirmLoggedIn() {
        waitForElement(successDiv, defaultTimeOut);
        assertTrue(elementContainsText(successDiv, "Login was successful"));
    }
}
