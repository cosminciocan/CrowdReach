package pages;

import Utils.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.Driver;

import static junit.framework.Assert.*;


public class LoginPage extends TestBase {

    // URL
    public static String logInUrl = baseUrl + loginPath;

    Driver dv = new Driver();
    // Page Elements
    @FindBy(id = "loginUser")
    public WebElement usernameField;
    @FindBy(id = "loginPassword")
    public WebElement passwordField;
    @FindBy(className = "btn-block")
    public WebElement loginButton;



    // METHODS
    public void openPage() {
        driver.get(logInUrl);
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
