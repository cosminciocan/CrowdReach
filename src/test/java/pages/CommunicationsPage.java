package pages;

import Utils.TestBase;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static junit.framework.Assert.*;

/***
 * Created by cciocan on 02-Sep-15.
 */
public class CommunicationsPage extends TestBase {

    public String url = baseUrl + communicationPath;


    @FindBy(id = "message")
    public WebElement generalMessageField;
    @FindBy(id = "twitter")
    public WebElement twitterField;
    @FindBy(id = "facebook")
    public WebElement facebookField;
    @FindBy(className = "note-editable")
    public WebElement emailField;
    @FindBy(id = "textMessage")
    public WebElement textMessageField;


    public void openPage() {
        driver.get(url);
    }

    //    TODO: Find some way to do this better
    public void checkValuesAppartFrom(String element, String message) {
        switch (element) {
            case "twitter":
                checkTwitter(message);
                break;
            case "facebook":
                checkFacebook(message);
                break;
            case "email":
                checkEmail(message);
                break;
            case "textmessage":
                checkTextMessage(message);
                break;
            default:
                fail("Incorrect value supplied");
                break;
        }

    }

    public void checkTwitter(String message) {
        assertFalse(elementContainsText(facebookField, message));
        assertFalse(elementContainsText(emailField, message));
        assertFalse(elementContainsText(textMessageField, message));
    }

    public void checkFacebook(String message) {
        assertFalse(elementContainsText(twitterField, message));
        assertFalse(elementContainsText(emailField, message));
        assertFalse(elementContainsText(textMessageField, message));
    }

    public void checkEmail(String message) {
        assertFalse(elementContainsText(facebookField, message));
        assertFalse(elementContainsText(twitterField, message));
        assertFalse(elementContainsText(textMessageField, message));
    }

    public void checkTextMessage(String message) {
        assertFalse(elementContainsText(facebookField, message));
        assertFalse(elementContainsText(twitterField, message));
        assertFalse(elementContainsText(emailField, message));
    }
}
