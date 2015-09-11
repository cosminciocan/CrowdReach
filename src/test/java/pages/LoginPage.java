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


    @FindBy(className = "login")
    public WebElement logOutButton;
    @FindBy(css = ".nav-btn.ng-binding")
    public WebElement userNameNavBar;

    @FindBy(className = "error")
    public WebElement errorSpan;


    // METHODS
    public void openPage() {
        driver.get(logInUrl);
    }

    public String login(String username, String password) {
        if (isElementPresent(userNameNavBar)){
            System.out.println("User already logged in");
        } else {
            driver.manage().deleteAllCookies();
            waitForElement(usernameField, defaultTimeOut);
//        if (isElementPresent(successDiv))
//            waitUntilElementNotPresent(successDiv, defaultTimeOut);
            assertTrue(isAttribtuePresent(usernameField, "required"));
            setText(usernameField, username);
            setText(passwordField, password);
            submitButton.click();
        }
        return username;
    }

    public void confirmLoggedIn(String username) {
        waitForElement(userNameNavBar, defaultTimeOut);
        assertTrue(elementContainsText(userNameNavBar, username));
        waitForElement(logOutButton, defaultTimeOut);
        assertTrue(elementContainsText(logOutButton, logOutButtonText));
        waitUntilElementNotPresent(successDiv, defaultTimeOut);
    }

    public void checkLoggedInRequired() {
        waitForElement(usernameField, defaultTimeOut);
        waitForElement(passwordField, defaultTimeOut);
        waitForElement(submitButton, defaultTimeOut);
    }

    public void confirmNotLoggedIn() {
        waitForElement(errorSpan, defaultTimeOut);

        assertTrue(elementContainsText(errorSpan, "Invalid Password"));
    }

    public void logOut() {
        if (isElementPresent(logOutButton)) {
            tryClick(logOutButton, defaultTimeOut);
            openPage();
            waitForElement(logOutButton,defaultTimeOut);
            assertTrue(elementContainsText(logOutButton,"LOGIN"));
        } else {
            System.out.println("User not logged in.");
        }
    }

}
