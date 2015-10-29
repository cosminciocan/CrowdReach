package steps;

import Utils.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CommunicationsPage;
import webdriver.Driver;

import static junit.framework.Assert.*;

public class CommunicationsSteps extends TestBase {
    protected CommunicationsPage communicationPage;
    public String generalMessageValue;
    public String specificMessageValue;
    public String activeField;
    public WebElement activeWebElement;


    public CommunicationsSteps() {
        communicationPage = PageFactory.initElements(Driver.getWebdriver(), CommunicationsPage.class);
    }

    @Given("^I navigate to the Communications Page$")
    public void I_navigate_to_the_Communications_Page() throws Throwable {
        communicationPage.openPage();
        communicationPage.expandAccordion();
    }

    @When("^I complete the general message field with a text message$")
    public void I_complete_the_message_field_with_a_text_message() throws Throwable {
        generalMessageValue = generateRandomAlphaNumeric(10);
        communicationPage.setText(communicationPage.generalMessageField, generalMessageValue);
    }


    @Then("^the message is also written in the social media, email and text message fields$")
    public void the_message_is_also_written_in_the_social_media_email_and_text_message_fields() throws Throwable {
        assertTrue(elementContainsText(communicationPage.twitterField, generalMessageValue));
        assertTrue(elementContainsText(communicationPage.facebookField, generalMessageValue));
        assertTrue(elementContainsText(communicationPage.emailField, generalMessageValue));
        assertTrue(elementContainsText(communicationPage.textMessageField, generalMessageValue));
    }

    @When("^I write a message in the \"([^\"]*)\" field$")
    public void I_write_a_message_in_the_field(String fieldName) throws Throwable {
        fieldName = fieldName.toLowerCase();
        specificMessageValue = generateRandomAlphaNumeric(10);
        activeField = fieldName;
        switch (fieldName) {
            case "twitter":
                communicationPage.setText(communicationPage.twitterField, specificMessageValue);
                activeWebElement = communicationPage.twitterField;
                break;

            case "facebook":
                communicationPage.setText(communicationPage.facebookField, specificMessageValue);
                activeWebElement = communicationPage.facebookField;
                break;

            case "email":
                communicationPage.setText(communicationPage.emailField, specificMessageValue);
                activeWebElement = communicationPage.emailField;
                break;

            case "textmessage":
                communicationPage.setText(communicationPage.textMessageField, specificMessageValue);
                activeWebElement = communicationPage.textMessageField;
                break;

            default:
                fail("Incorrect supplied value!");
        }
    }

    @Then("^It should not be copied in the other fields$")
    public void It_should_not_be_copied_in_the_other_fields() throws Throwable {
        communicationPage.checkValuesAppartFrom(activeField, specificMessageValue);
    }

    @Then("^the general message should not be changed$")
    public void the_general_message_should_not_be_changed() throws Throwable {
        assertTrue(elementContainsText(communicationPage.generalMessageField, generalMessageValue));
    }

    @Then("^the specific message for the field should not be changed$")
    public void the_specific_message_for_the_field_should_not_be_changed() throws Throwable {
        assertTrue(elementContainsText(activeWebElement, specificMessageValue));
    }
}
