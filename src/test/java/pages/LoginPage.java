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
    @FindBy(id = "username")
    public WebElement usernameField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(className = "col-sm-10")
    public WebElement logInDiv;
    @FindBy(css = ".has-error.ng-binding")
    public WebElement hasErrorSpan;
    @FindBy(className = "toast-title")
    public WebElement successDiv;


    public static String loggedInUserNameValue;
    public static boolean loggedIn = false;

        // METHODS
    public void openPage() {
        driver.get(logInUrl);
    }

    public String login(String username, String password) {
        loggedInUserNameValue = username;
        driver.manage().deleteAllCookies();
        waitForElement(usernameField, defaultTimeOut);
        if (isElementPresent(successDiv))
            waitUntilElementNotPresent(successDiv, defaultTimeOut);
        assertTrue(isAttribtuePresent(usernameField, "required"));
        setText(usernameField, loggedInUserNameValue);
        setText(passwordField, password);
        submitButton.click();
        return loggedInUserNameValue;
    }

    public void confirmLoggedIn(String loggedInUser) {
//        System.out.println("this is the used username: " + loggedInUser);
        if (isElementPresent(welcomeNameDiv)) {
            if ((elementContainsText(welcomeNameDiv, ("Welcome, " + loggedInUser + "!"))) ||
                    elementContainsText(welcomeNameDiv, "Welcome, " + loggedInUserNameValue + "!")) {
                System.out.println("The user is logged in");
                loggedIn = true;
            }
        }
//
//        assertTrue((elementContainsText(welcomeNameDiv, ("Welcome, " + loggedInUser + "!"))) ||
//        elementContainsText(welcomeNameDiv, loggedInUserNameValue));
//        waitForElement(successDiv, defaultTimeOut);
//        assertTrue(elementContainsText(successDiv, loggedInMessage));
    }

    public void checkLoggedInRequired() {
        waitForElement(usernameField, defaultTimeOut);
        waitForElement(passwordField, defaultTimeOut);
        waitForElement(submitButton, defaultTimeOut);
    }

    public void confirmNotLoggedIn() {
        assertTrue(elementContainsText(hasErrorSpan, incorrectLoginPassword));
//        waitForElement(errorDiv, defaultTimeOut);
//        assertTrue(elementContainsText(errorDiv, incorrectLoginDetailsMessage));
    }

    public void logOut() {
        if(isElementPresent(successDiv)){
            waitUntilElementNotPresent(successDiv, defaultTimeOut);
        }
        tryClick(logOutButton, defaultTimeOut);
        waitForElement(submitButton, defaultTimeOut);
        assertTrue(elementContainsText(logInDiv, "Please enter your login details."));
    }

    public void executeLogin(){
        if (!loggedIn){
            login(userNameValue, userPasswordValue);
        }
    }

    public void checkLoggedOut(){
        if (isTextPresent("Log Out"))
            logOut();
    }
}
