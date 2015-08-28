package pages;

import Utils.TestBase;
import com.sun.imageio.plugins.wbmp.WBMPImageReader;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import steps.LoginSteps;

import java.util.List;
import java.util.Random;

import static junit.framework.Assert.*;

public class RegisterPage extends TestBase {

    // URL
    public String url = baseUrl + registerPath;

    //    Page Elements
    @FindBy(className = "alreadyHaveAccount")
    public WebElement alreadyMemberDiv;
    @FindBy(id = "registerEmail")
    public WebElement emailField;
    @FindBy(id = "registerUsername")
    public WebElement userNameField;
    @FindBy(id = "registerPassword")
    public WebElement passwordField;
    @FindBy(id = "registerConfirmPassword")
    public WebElement confirmPasswordField;
    @FindBy(id = "businessType")
    public List typeSelect;
    @FindBy(css = ".btn-square[title^='Register']")
    public WebElement registerButton;


    //     Variables
    public String typeOfBusinessDropdown = "businessType";


    public void openPage() {
        driver.get(url);
    }


    public void setEmailField() {
        emailValue = (generateRandomString(8) + userNameEmailDomain);
        waitForElement(alreadyMemberDiv, defaultTimeOut);
        elementContainsText(alreadyMemberDiv, "Already have an account?");
        setText(emailField, emailValue);
    }

    public String setUserNameField() {
        userNameValue = generateRandomAlphaNumeric(8);
        setText(userNameField, userNameValue);
        return userNameValue;
    }

    public String setPasswordField() {
        userPasswordValue = generateRandomAlphaNumeric(8);
        setText(passwordField, userPasswordValue);
        return userPasswordValue;
    }

    public void setConfirmPasswordField() {
        setText(confirmPasswordField, userPasswordValue);
    }

    public void setTypeSelect() {
//        TODO: Refactor this and make it to return the value selected
        List dropdownOptions = new Select(driver.findElement(By.id(typeOfBusinessDropdown))).getOptions();
        int randomNumber = (randomWithRange(0, (dropdownOptions.size() - 1)));
        Select dropdown = new Select(driver.findElement(By.id(typeOfBusinessDropdown)));
        dropdown.selectByIndex(randomNumber);
    }

    public void confirmRegistered() {
        tryClick(submitButton, defaultTimeOut);
        waitForElement(successDiv, defaultTimeOut);
//        Sleep(0.5);
//        tryClick(successDiv, defaultTimeOut);
        assertTrue(elementContainsText(successDiv, registeredMessage));
    }


    public void checkMandatoryField(int field) {
        waitUntilElementNotPresent(successDiv, defaultTimeOut);
        switch (field) {
            case 0:
                checkEmailRequired();
                break;
            case 1:
                checkUsernameField();
                break;
            case 2:
                checkPasswordField();
                break;
            case 3:
                checkConfirmPasswordField();
                break;
        }
    }

    public void checkEmailRequired() {
        setUserNameField();
        setPasswordField();
        setConfirmPasswordField();
        setTypeSelect();
        tryClick(submitButton, defaultTimeOut);
        assertFalse(isElementPresent(successDiv));
        assertTrue(emailField.getAttribute("value").isEmpty());
        setText(emailField, generateRandomAlphaNumeric(8));
        tryClick(submitButton, defaultTimeOut);
        assertFalse(isElementPresent(successDiv));
    }

    public void checkUsernameField() {
        userNameField.clear();
        setEmailField();
        setPasswordField();
        setConfirmPasswordField();
        setTypeSelect();
        tryClick(submitButton, defaultTimeOut);
        assertFalse(isElementPresent(successDiv));
        assertTrue(userNameField.getAttribute("value").isEmpty());
    }

    public void checkPasswordField() {
        passwordField.clear();
        setUserNameField();
        setEmailField();
        setConfirmPasswordField();
        setTypeSelect();
        tryClick(submitButton, defaultTimeOut);
        assertFalse(isElementPresent(successDiv));
        assertTrue(passwordField.getAttribute("value").isEmpty());
    }

    public void checkConfirmPasswordField() {
        confirmPasswordField.clear();
        setUserNameField();
        setEmailField();
        setPasswordField();
        setTypeSelect();
        tryClick(submitButton, defaultTimeOut);
        assertFalse(isElementPresent(successDiv));
        assertTrue(confirmPasswordField.getAttribute("value").isEmpty());
    }

}
