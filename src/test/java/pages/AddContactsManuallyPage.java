package pages;


import Utils.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static junit.framework.Assert.assertTrue;

public class AddContactsManuallyPage extends TestBase {

    //url
    public String url = baseUrl + addContactsPath;


//Page elements

    @FindBy(id = "contactsFirstName")
    public WebElement firstNameField;
    @FindBy(id = "contactsLastName")
    public WebElement lastNameField;
    @FindBy(id = "contactsEmail")
    public WebElement emailField;
    @FindBy(id = "contactsPhone")
    public WebElement phoneField;
    @FindBy(id = "contactsTwitter")
    public WebElement twitterField;
    @FindBy(id = "contactsFacebook")
    public WebElement facebookField;
    @FindBy(id = "contactsNotes")
    public WebElement notesArea;
    @FindBy(id = "contactsCountry")
    public WebElement countryField;
    @FindBy(id = "contactsAddressLine1_value")
    public WebElement address1Field;
    @FindBy(id = "contactsAddressLine2")
    public WebElement address2Field;
    @FindBy(id = "contactsCity")
    public WebElement cityField;
    @FindBy(id = "contactsState")
    public WebElement stateField;
    @FindBy(id = "contactsZip")
    public WebElement zipField;


    //    Methods
    public void openPage() {
        driver.get(url);
    }

    public void completeFields() {
        setFieldValue(firstNameField);
        setFieldValue(lastNameField);
        setFieldValue(emailField, generateRandomAlphaNumeric(8) + userNameEmailDomain);
        phoneField.sendKeys(generateRandomNumber(10));
        setFieldValue(twitterField);
        setFieldValue(facebookField);
        setFieldValue(notesArea);
        setFieldValue(countryField);
        setFieldValue(address1Field);
        setFieldValue(address2Field);
        setFieldValue(cityField);
        setFieldValue(stateField);
        setFieldValue(zipField, generateRandomNumber(5));
    }

    public void manualContactAdded() {
        tryClick(submitButton, defaultTimeOut);
        assertTrue(elementContainsText(successDiv, addedContactMessage));
    }

    public void checkMandatoryFields() {
        waitForElement(firstNameField, defaultTimeOut);
        assertTrue(isAttribtuePresent(phoneField, "required"));
        assertTrue(phoneField.getAttribute("type").equals("tel"));
        assertTrue(isAttribtuePresent(emailField, "required"));
        assertTrue(emailField.getAttribute("type").equals("email"));
    }
}
