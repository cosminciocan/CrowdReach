package steps;

import Utils.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.EditBusinessProfilePage;
import webdriver.Driver;

public class EditBusinessProfileSteps extends TestBase{
    protected EditBusinessProfilePage editBusinessProfilePage;

    public EditBusinessProfileSteps(){
        editBusinessProfilePage = PageFactory.initElements(Driver.getWebdriver(), EditBusinessProfilePage.class);
    }

    @And("^I edit my profile details$")
    public void I_edit_my_profile_details() throws Throwable {
        editBusinessProfilePage.setEditProfileDetails();
    }

    @When("^I navigate to the Edit Business Profile page$")
    public void I_navigate_to_the_Edit_Business_Profile_page() throws Throwable {
        editBusinessProfilePage.openPage();
    }

    @Then("^the changes should be saved$")
    public void the_changes_should_be_saved() throws Throwable {
        editBusinessProfilePage.checkEditedChanges();
    }

    @And("^I check the fields format and the mandatory fields$")
    public void I_check_the_fields_format_and_the_mandatory_fields() throws Throwable {
        editBusinessProfilePage.checFieldsFormat();
    }

    @And("^I can delete the uploaded logo$")
    public void I_can_delete_the_uploaded_logo() throws Throwable {
        editBusinessProfilePage.uploadImg();
        editBusinessProfilePage.deleteLogo();
    }

    @Then("^the logo chage should be saved$")
    public void the_logo_chage_should_be_saved() throws Throwable {
        editBusinessProfilePage.checkLogo();
    }
}
