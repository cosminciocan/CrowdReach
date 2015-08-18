package steps;

import Utils.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.RegisterPage;
import webdriver.Driver;


public class LoginSteps  extends TestBase {
    protected LoginPage loginPage;

    public LoginSteps(){
        loginPage = PageFactory.initElements(Driver.getWebdriver(), LoginPage.class);
    }

    @Given("^The user navigates to the Login page$")
    public void The_user_navigates_to_the_Login_page() throws Throwable {
        loginPage.openPage();
    }

    @When("^Ted logs in using his email and password$")
    public void Ted_logs_in_using_his_email_and_password() throws Throwable {
        loginPage.login(userNameValue,userPasswordValue);
    }

    @Then("^Ted should be logged in$")
    public void Ted_should_be_logged_in() throws Throwable {
        loginPage.confirmLoggedIn();
    }

}
