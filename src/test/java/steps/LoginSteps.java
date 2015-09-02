package steps;

import Utils.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.RegisterPage;
import webdriver.Driver;


public class LoginSteps extends TestBase {
    protected LoginPage loginPage;

    public LoginSteps() {
        loginPage = PageFactory.initElements(Driver.getWebdriver(), LoginPage.class);
    }

    @Given("^I navigate to the Login page$")
    public void The_user_navigates_to_the_Login_page() throws Throwable {
        loginPage.openPage();
    }

    @When("^I log in using my username and password$")
    public void Ted_logs_in_using_his_email_and_password() throws Throwable {
        loginPage.login(userNameValue, userPasswordValue);
    }

    @Then("I should be logged in")
    public void Ted_should_be_logged_in() throws Throwable {
        loginPage.confirmLoggedIn();
    }

    @Then("^I should see the login page$")
    public void I_should_see_the_login_page() throws Throwable {
        loginPage.checkLoggedInRequired();
    }

    @When("^I enter an incorrect Username$")
    public void I_enter_an_incorrect_Username() throws Throwable {
        String incorrectUser = generateRandomAlphaNumeric(8);
        loginPage.login(incorrectUser, incorrectUser);
    }

    @Then("^I should see an error message$")
    public void I_should_see_an_error_message() throws Throwable {
        loginPage.confirmNotLoggedIn();
    }

    @And("^I enter an incorrect password for a valid user$")
    public void I_enter_an_incorrect_password_for_a_valid_user() throws Throwable {
        String incorrectPassword = generateRandomAlphaNumeric(8);
        loginPage.login(userNameValue, incorrectPassword);
    }


    @Given("^I log in to the CrowdReach web-app$")
    public void I_log_in() throws Throwable {
        loginPage.openPage();
        loginPage.login(userNameValue, userPasswordValue);
        loginPage.confirmLoggedIn();
    }

}
