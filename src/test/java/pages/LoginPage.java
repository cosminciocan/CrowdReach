package pages;

import Utils.TestBase;
import org.junit.Assert;
import org.omg.CORBA.PUBLIC_MEMBER;
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
        driver.manage().deleteAllCookies();
        waitForElement(usernameField, defaultTimeOut);
        if (isElementPresent(successDiv))
            waitUntilElementNotPresent(successDiv, defaultTimeOut);
        assertTrue(isAttribtuePresent(usernameField, "required"));
        setText(usernameField, username);
        setText(passwordField, password);
        submitButton.click();
    }

    public void confirmLoggedIn() {
        waitForElement(successDiv, defaultTimeOut);
        assertTrue(elementContainsText(successDiv, loggedInMessage));
    }

    public void checkLoggedInRequired() {
        waitForElement(usernameField, defaultTimeOut);
        waitForElement(passwordField, defaultTimeOut);
        waitForElement(submitButton, defaultTimeOut);
    }

    public void confirmNotLoggedIn(){
        waitForElement(errorDiv, defaultTimeOut);
        assertTrue(elementContainsText(errorDiv, incorrectLoginDetailsMessage));
    }
}
