package pages;

import Utils.TestBase;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static junit.framework.Assert.*;

/**
 * Created by cciocan on 28-Aug-15.
 */
public class EditUserProfilePage extends TestBase {

    public String url = baseUrl + editUserProfilePath;

    @FindBy(id = "oldPasswordUserInfo")
    public WebElement oldPasswordField;
    @FindBy(id = "newPasswordUserInfo")
    public WebElement onewPasswordField;
    @FindBy(id = "confirmPasswordUserInfo")
    public WebElement confirmPasswordField;



    public void openPage() {
        driver.get(url);
    }

    public String changePassword(String oldPassword, String newPassword) {
        setText(oldPasswordField, oldPassword);
        setText(onewPasswordField, newPassword);
        setText(confirmPasswordField, newPassword);
        tryClick(saveChangesButton, defaultTimeOut);
        assertFalse(isElementPresent(errorDiv));
        assertTrue(elementContainsText(successDiv, passwordChangedMessage));
        return newPassword;
    }

    public void doSomething(){

    }


}
