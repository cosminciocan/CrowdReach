package pages;

import Utils.TestBase;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static junit.framework.Assert.*;

/***
 * Created by cciocan on 28-Aug-15.
 */
public class EditUserProfilePage extends TestBase {

    public String url = baseUrl + editUserProfilePath;

    @FindBy(id = "oldPassword")
    public WebElement oldPasswordField;
    @FindBy(id = "registerPassword")
    public WebElement onewPasswordField;
    @FindBy(id = "registerConfirmPassword")
    public WebElement confirmPasswordField;
    @FindBy(css = ".has-error.ng-binding")
    public WebElement hasErrorSpan;
    @FindBy(css = "div.has-error")
    public WebElement passwordComplexityErrorDiv;
    @FindBy(css = ".msg-error")
    public WebElement passwrodMatchErrorSpan;


    public void openPage() {
        driver.get(url);
    }

    //    TODO: Remove the assertion from the method,and then the old and new test
    public String changePassword(String oldPassword, String newPassword, String confirmPassword) {
        setText(oldPasswordField, oldPassword);
        setText(onewPasswordField, newPassword);
        setText(confirmPasswordField, confirmPassword);
        tryClick(saveChangesButton, defaultTimeOut);
        return newPassword;
    }

    public void checkPasswordChanged() {
        assertTrue(elementContainsText(successDiv, passwordChangedMessage));
        assertFalse(isElementPresent(errorDiv));
    }

    public void checkFieldMaxValidations() {
        String maxLength = "" + textFieldDefaultLenght;
        assertTrue(isAttribtuePresent(oldPasswordField, "required"));
        assertTrue(isAttribtuePresent(onewPasswordField, "required"));
        assertTrue(isAttribtuePresent(confirmPasswordField, "required"));
        assertTrue(oldPasswordField.getAttribute("maxlength").equals(maxLength));
        assertTrue(onewPasswordField.getAttribute("maxlength").equals(maxLength));
        assertTrue(confirmPasswordField.getAttribute("maxlength").equals(maxLength));
    }

    public void checkIncorrectOldPwdMessage() {
        assertTrue(elementContainsText(errorDiv, incorrectOldPasswordMessage));
    }

    public void checkPwdToShortMessage() {
//        assertTrue(elementContainsText(errorDiv, shortNewPasswordMessage));
        assertTrue(elementContainsText(passwordComplexityErrorDiv, passwordMinimumLengthMessage));
    }

    public void checkConfirmPwdNotMatchMessage(){
        assertTrue(elementContainsText(passwrodMatchErrorSpan, passwordMatchErrorMessage));
    }
}
