package steps;

import Utils.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.EditProfilePage;
import webdriver.Driver;


public class EditProfileSteps extends TestBase{
    protected EditProfilePage editProfilePage;

    public EditProfileSteps(){
        editProfilePage = PageFactory.initElements(Driver.getWebdriver(), EditProfilePage.class);
    }

    @And("^I edit my profile details$")
    public void I_edit_my_profile_details() throws Throwable {
        editProfilePage.setEditProfileDetails();
    }

    @When("^I navigate to the Edit Business Profile page$")
    public void I_navigate_to_the_Edit_Business_Profile_page() throws Throwable {
        editProfilePage.openPage();
    }

    @Then("^the changes should be saved$")
    public void the_changes_should_be_saved() throws Throwable {
        editProfilePage.checkEditedChanges();
    }

}
