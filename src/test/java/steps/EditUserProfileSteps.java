package steps;

import Utils.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.EditUserProfilePage;
import pages.LoginPage;
import webdriver.Driver;

/**
 * Created by cciocan on 28-Aug-15.
 */
public class EditUserProfileSteps extends TestBase {
    protected EditUserProfilePage editUserProfilePage;
    protected String newPassword;
    protected String password;
    protected LoginPage loginPage;


    public EditUserProfileSteps() {
        editUserProfilePage = PageFactory.initElements(Driver.getWebdriver(), EditUserProfilePage.class);
        loginPage = PageFactory.initElements(Driver.getWebdriver(), LoginPage.class);
    }


    @Given("^I navigate to the Edit User Profile page$")
    public void I_navigate_to_the_Edit_User_Profile_page() throws Throwable {
        editUserProfilePage.openPage();
    }

    @When("^I input the old password and set a new password$")
    public void I_input_the_old_password_and_set_a_new_password() throws Throwable {
        newPassword = generateRandomAlphaNumeric(8);
        password = editUserProfilePage.changePassword(userPasswordValue, newPassword);
    }

    @Then("^I should be able to login using that password$")
    public void I_should_be_able_to_login_using_that_password() throws Throwable {
        loginPage.login(userNameValue, password);
        loginPage.confirmLoggedIn();
    }


    @Then("^I set the default password for the test account$")
    public void I_set_the_default_password_for_the_test_account() throws Throwable {
        editUserProfilePage.changePassword(newPassword, userPasswordValue);
    }

    @And("^I do something$")
    public void I_do_something() throws Throwable {

    }
}
