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
    @FindBy(id = "profileAddress_value")
    public WebElement addressField;
    @FindBy(id = "profilePhone")
    public WebElement phoneField;
    //    @FindBy(css = ".ng-pristine.ng-valid-mask.ng-valid.ng-valid-required>img")
    @FindBy(css = ".cr-business-logo>img:not(.ng-hide)")
    public WebElement uploadedImage;
    @FindBy(className = "cr-delete-profile-logo-img")
    public WebElement deleteLogoButton;
    @FindBy(css = "div.angucomplete-description.ng-binding.ng-scope")
    public WebElement selectAddress;
    @FindBy(id = "zipCode")
    public WebElement zipCodeField;


    @FindBy(id = "crChooseFile")
    public WebElement uploadField;

    public String editName;
    public String editAddress;
    public String editPhone;

    public void openPage() {
        driver.get(url);
    }


    public void setEditProfileDetails() {
        editName = generateRandomAlphaNumeric(8);
        editAddress = "New York St, Aiken SC";
        editPhone = generateRandomNumber(10);
        uploadImg();
        setText(addressField, editAddress);
        tryClick(selectAddress, defaultTimeOut);
        setText(nameField, editName);
        setText(zipCodeField, generateRandomNumber(5));
        phoneField.sendKeys(editPhone);
        if(isElementPresent(successDiv)){
            waitUntilElementNotPresent(successDiv,defaultTimeOut);
        }
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
//        assertTrue(elementContainsText(addressField, editAddress));
//        assertTrue(elementContainsText(phoneField, editPhone));
    }

    public void checFieldsFormat() {
        waitForElement(nameField, defaultTimeOut);
        assertTrue(isAttribtuePresent(nameField, "required"));
        assertTrue(isAttribtuePresent(addressField, "required"));
        assertFalse(isAttribtuePresent(phoneField, "required"));
        assertTrue(phoneField.getAttribute("type").equals("tel"));
        assertTrue(uploadField.getAttribute("type").equals("file"));
    }

    public void uploadImg() {
        deleteLogo();
        uploadField.sendKeys(pathToIMGFile);
        waitForElement(uploadedImage, defaultTimeOut);
    }

    public void deleteLogo() {
        if (isElementPresent(uploadedImage)) {
            tryClick(deleteLogoButton, defaultTimeOut);
            assertFalse(isElementPresent(uploadedImage));
        }
    }

    public void checkLogo() {
        tryClick(submitButton, defaultTimeOut);
        assertTrue(elementContainsText(successDiv, editedProfileMessage));
        openPage();
        waitForElement(nameField, defaultTimeOut);
        assertFalse(isElementPresent(uploadedImage));
    }
}
