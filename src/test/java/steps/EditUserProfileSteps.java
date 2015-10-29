package steps;

import Utils.TestBase;
import com.gargoylesoftware.htmlunit.Page;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.ChangePasswordPage;
import pages.EditUserProfilePage;
import pages.LoginPage;
import webdriver.Driver;

/**
 * Created by cciocan on 28-Aug-15.
 */
public class EditUserProfileSteps extends TestBase {
    protected EditUserProfilePage editUserProfilePage;
    protected ChangePasswordPage changePasswordPage;
    protected String newPassword;
    protected String password;
    protected LoginPage loginPage;
    public String loggedInUser;

    public EditUserProfileSteps() {
        editUserProfilePage = PageFactory.initElements(Driver.getWebdriver(), EditUserProfilePage.class);
        loginPage = PageFactory.initElements(Driver.getWebdriver(), LoginPage.class);
        changePasswordPage = PageFactory.initElements(Driver.getWebdriver(), ChangePasswordPage.class);
    }


    @Given("^I navigate to the Edit User Profile page$")
    public void I_navigate_to_the_Edit_User_Profile_page() throws Throwable {
        editUserProfilePage.openPage();
    }

    @When("^I input the old password and set a new password$")
    public void I_input_the_old_password_and_set_a_new_password() throws Throwable {
        newPassword = generateRandomAlphaNumeric(generatedPasswordLength);
        password = editUserProfilePage.changePassword(userPasswordValue, newPassword, newPassword);
        editUserProfilePage.checkPasswordChanged();
    }

    @Then("^I should be able to login using that password$")
    public void I_should_be_able_to_login_using_that_password() throws Throwable {
        loginPage.logOut();
        loginPage.openPage();
        loggedInUser = loginPage.login(userNameValue, password);
        loginPage.confirmLoggedIn(loggedInUser);
    }

    @Then("^I set the default password for the test account$")
    public void I_set_the_default_password_for_the_test_account() throws Throwable {
        password = editUserProfilePage.changePassword(newPassword, userPasswordValue, userPasswordValue);
        editUserProfilePage.checkPasswordChanged();
    }

    @When("^I check the field max length validations$")
    public void I_check_the_field_validations() throws Throwable {
        editUserProfilePage.checkFieldMaxValidations();
    }

    @When("^I enter an incorrect old password$")
    public void I_enter_an_incorrect_old_password() throws Throwable {
        newPassword = generateRandomAlphaNumeric(generatedPasswordLength);
        editUserProfilePage.changePassword(newPassword, newPassword, newPassword);
    }

    @When("^I enter a new password of (\\d+) characters$")
    public void I_enter_a_password_shorter_than_characters(int arg1) throws Throwable {
        newPassword = generateRandomAlphaNumeric(arg1);
        editUserProfilePage.changePassword(userPasswordValue, newPassword, newPassword);
    }

    @Then("^I should see an error message regarding the old password$")
    public void I_should_see_an_error_message_regarding_the_old_password() throws Throwable {
        editUserProfilePage.checkIncorrectOldPwdMessage();
    }

    @When("^I type the confirm password different from the new one$")
    public void I_type_the_confirm_password_different_from_the_new_one() throws Throwable {
        newPassword = generateRandomAlphaNumeric(generatedPasswordLength);
        editUserProfilePage.changePassword(userPasswordValue, newPassword, generateRandomAlphaNumeric(8));
    }

    @Then("^I should see an error message regarding the password being to short$")
    public void I_should_see_an_error_message_regarding_the_password_being_to_short() throws Throwable {
        editUserProfilePage.checkPwdToShortMessage();
    }

    @Then("^I shouls see an error message regarding the confirm password$")
    public void I_shouls_see_an_error_message_regarding_the_confirm_password() throws Throwable {
        editUserProfilePage.checkConfirmPwdNotMatchMessage();
    }

    @Given("^I navigate to the Change Password page$")
    public void I_navigate_to_the_Change_Password_page() throws Throwable {
        changePasswordPage.openPage();
    }

}
