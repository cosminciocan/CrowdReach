package pages;

import Utils.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.Driver;

import static junit.framework.Assert.*;


public class LoginPage extends TestBase {

    // URL
    private String logInUrl = baseUrl + loginPath;

    Driver dv = new Driver();
    // Page Elements
    @FindBy(id = "loginUser")
    public WebElement usernameField;
    @FindBy(id = "loginPassword")
    public WebElement passwordField;


    // METHODS
    public void openPage() {
        driver.get(logInUrl);
    }

    public void login(String username, String password) {
        if (isElementPresent(successDiv))
            waitUntilElementNotPresent(successDiv, defaultTimeOut);
        waitForElement(usernameField, defaultTimeOut);
        setText(usernameField, username);
        setText(passwordField, password);
        submitButton.click();
    }

    public void confirmLoggedIn() {
        waitForElement(successDiv, defaultTimeOut);
        assertTrue(elementContainsText(successDiv, loggedInMessage));
    }
}
