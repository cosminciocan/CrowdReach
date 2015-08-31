package steps;

import Utils.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.AddContactsManuallyPage;
import pages.ImportContactsPage;
import webdriver.Driver;

import static junit.framework.Assert.*;


public class ContactsSteps extends TestBase {
    protected AddContactsManuallyPage addContactsPage;
    protected ImportContactsPage importContactsPage;

    public ContactsSteps() {
        addContactsPage = PageFactory.initElements(Driver.getWebdriver(), AddContactsManuallyPage.class);
        importContactsPage = PageFactory.initElements(Driver.getWebdriver(), ImportContactsPage.class);
    }


    @Given("^I navigate to the Add Contacts Manually page$")
    public void I_navigate_to_the_Add_Contacts_Manually_page() throws Throwable {
        addContactsPage.openPage();
    }

    @And("^I complete all the mandatory fields$")
    public void I_complete_all_the_mandatory_fields() throws Throwable {
        addContactsPage.completeFields();
    }

    @Then("^I can successfully add the contact$")
    public void I_can_successfully_add_the_contact() throws Throwable {
        addContactsPage.manualContactAdded();
    }

    @Given("^I navigate to the Import From CSV page$")
    public void I_navigate_to_the_Import_From_CSV_page() throws Throwable {
        importContactsPage.openPage();
    }

    @And("^I upload a file$")
    public void I_upload_a_file() throws Throwable {
        importContactsPage.uploadFile();
    }

    @Then("^I can map the fields in the file$")
    public void I_can_map_the_fields_in_the_file() throws Throwable {
        importContactsPage.mapImportedFile();
    }

    @And("^I can see the values being mapped$")
    public void I_can_see_the_values_being_mapped() throws Throwable {
        importContactsPage.checkImportedValues();
    }


    @Then("^I check that all the fields are mandatory$")
    public void I_check_that_all_the_fields_are_mandatory() throws Throwable {
        addContactsPage.checkMandatoryFields();
    }


}
