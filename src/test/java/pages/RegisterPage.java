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
    public String registerPage = baseUrl + registerPath;

    // URL

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
    @FindBy(className = "btn-block")
    public WebElement registerButton;


    //     Variables
    public String typeOfBusinessDropdown = "businessType";



    public void openPage() {
        driver.get(registerPage);
    }


    public void setEmailField() {
        emailValue = (generateRandomString(8) + userNameEmailDomain);
        waitForElement(alreadyMemberDiv, defaultTimeOut);
        elementContainsText(alreadyMemberDiv, "Already have an account?");
        emailField.sendKeys(emailValue);
    }

    public void setUserNameField() {
        userNameValue = generateRandomAlphaNumeric(8);
        userNameField.sendKeys(userNameValue);
    }

    public void setPasswordField() {
        userPasswordValue = generateRandomAlphaNumeric(8);
        passwordField.sendKeys(userPasswordValue);
    }

    public void setConfirmPasswordField() {
        confirmPasswordField.sendKeys(userPasswordValue);
    }

    public void setTypeSelect() {
//        TODO: Refactor this and make it to return the value selected
        List dropdownOptions = new Select(driver.findElement(By.id(typeOfBusinessDropdown))).getOptions();
        int randomNumber = (randomWithRange(0, (dropdownOptions.size() - 1)));
        Select dropdown = new Select(driver.findElement(By.id(typeOfBusinessDropdown)));
        dropdown.selectByIndex(randomNumber);
    }

    public void confirmRegistered() {
        tryClick(registerButton, defaultTimeOut);
        waitForElement(successDiv, defaultTimeOut);
//        Sleep(0.5);
        tryClick(successDiv,defaultTimeOut);
        assertTrue(elementContainsText(successDiv, "Registration was successful"));
    }


}
