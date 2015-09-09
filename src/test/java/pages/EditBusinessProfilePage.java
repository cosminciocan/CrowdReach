package pages;


import Utils.TestBase;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static junit.framework.Assert.*;

public class EditBusinessProfilePage extends TestBase {

    public String url = baseUrl + editBusinessProfilePath;


    @FindBy(id = "profileName")
    public WebElement nameField;
    @FindBy(id = "profileAddress")
    public WebElement addressField;
    @FindBy(id = "profilePhone")
    public WebElement phoneField;
    //    @FindBy(css = ".ng-pristine.ng-valid-mask.ng-valid.ng-valid-required>img")
    @FindBy(css = ".ng-valid-required :not(.ng-hide)[type^='image']")
    public WebElement uploadedImage;
    @FindBy(css = ".btn.ng-scope")
    public WebElement deleteLogoButton;


    @FindBy(className = "ng-isolate-scope")
    public WebElement uploadField;

    public String editName;
    public String editAddress;
    public String editPhone;

    public void openPage() {
        driver.get(url);
    }


    public void setEditProfileDetails() {
        editName = generateRandomAlphaNumeric(8);
        editAddress = generateRandomAlphaNumeric(8);
        editPhone = generateRandomNumber(10);
        setText(nameField, editName);
        setText(addressField, editAddress);
        phoneField.sendKeys(editPhone);
        uploadImg();
        tryClick(submitButton, defaultTimeOut);
        assertTrue(elementContainsText(successDiv, editedProfileMessage));
        assertTrue(uploadField.getAttribute("value").contains(imgFileName));
        openPage();
        tryClick(submitButton, defaultTimeOut);
    }

    public void checkEditedChanges() {
        openPage();
        waitForElement(uploadedImage, defaultTimeOut);
        assertTrue(elementContainsText(nameField, editName));
        assertTrue(elementContainsText(addressField, editAddress));
//        assertTrue(elementContainsText(phoneField, editPhone));
    }

    public void checFieldsFormat() {
        waitForElement(nameField, defaultTimeOut);
        assertTrue(isAttribtuePresent(nameField, "required"));
        assertFalse(isAttribtuePresent(addressField, "required"));
        assertFalse(isAttribtuePresent(phoneField, "required"));
        assertTrue(phoneField.getAttribute("type").equals("tel"));
        assertTrue(uploadField.getAttribute("type").equals("file"));
    }

    public void uploadImg(){
        deleteLogo();
        uploadField.sendKeys(pathToIMGFile);
        waitForElement(uploadedImage, defaultTimeOut);
    }

    public void deleteLogo(){
        if (isElementPresent(uploadedImage)) {
            tryClick(deleteLogoButton, defaultTimeOut);
            assertFalse(isElementPresent(uploadedImage));
        }
    }

    public void checkLogo(){
        tryClick(submitButton, defaultTimeOut);
        assertTrue(elementContainsText(successDiv, editedProfileMessage));
        openPage();
        waitForElement(nameField, defaultTimeOut);
        assertFalse(isElementPresent(uploadedImage));
    }
}
