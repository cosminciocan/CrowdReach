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

    @FindBy(id = "oldPasswordUserInfo")
    public WebElement oldPasswordField;

    @FindBy(id = "rePassword")
    public WebElement confirmPasswordField;


    public void openPage() {
        driver.get(url);
    }

    //    TODO: Remove the assertion from the method,and then the old and new test
    public String changePassword(String oldPassword, String newPassword, String confirmPassword) {
        setText(oldPasswordField, oldPassword);
        setText(passwordField, newPassword);
        setText(confirmPasswordField, confirmPassword);
        tryClick(saveChangesButton, defaultTimeOut);
        return newPassword;
    }

    public void checkPasswordChanged() {
//        assertTrue(elementContainsText(successDiv, passwordChangedMessage));
        assertFalse(isElementPresent(errorDiv));
    }

    public void checkFieldMaxValidations() {
        String maxLength = "" + textFieldDefaultLenght;
        assertTrue(isAttribtuePresent(oldPasswordField, "required"));
        assertTrue(isAttribtuePresent(passwordField, "required"));
        assertTrue(isAttribtuePresent(confirmPasswordField, "required"));
        assertTrue(oldPasswordField.getAttribute("maxlength").equals(maxLength));
        assertTrue(passwordField.getAttribute("maxlength").equals(maxLength));
        assertTrue(confirmPasswordField.getAttribute("maxlength").equals(maxLength));
    }

    public void checkIncorrectOldPwdMessage() {
        assertTrue(elementContainsText(errorDiv, incorrectOldPasswordMessage));
    }

    public void checkPwdToShortMessage() {
        assertTrue(isAttribtuePresent(saveChangesButton, "disabled"));
        assertTrue(elementContainsText(errorDiv, shortNewPasswordMessage));
    }

    public void checkConfirmPwdNotMatchMessage(){
        assertTrue(elementContainsText(errorDiv, newAndConfirmPasswordMessage));
    }
}
