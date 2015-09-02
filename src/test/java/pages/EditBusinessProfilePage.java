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
        uploadField.sendKeys(pathToIMGFile);
        waitUntilElementNotPresent(successDiv, defaultTimeOut);
        tryClick(saveChangesButton, defaultTimeOut);
        assertTrue(elementContainsText(successDiv, editedProfileMessage));
        assertTrue(uploadField.getAttribute("value").contains(imgFileName));

    }

    public void checkEditedChanges() {
        openPage();
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
}
