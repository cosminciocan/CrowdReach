package steps;

import Utils.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.Homepage;
import pages.LoginPage;
import pages.RegisterPage;
import webdriver.Driver;


public class RegistrationSteps extends TestBase {
    protected Homepage homepage;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    private String password;
    private String username;
    private int count = 0;

    public RegistrationSteps() {
        registerPage = PageFactory.initElements(Driver.getWebdriver(), RegisterPage.class);
        homepage = PageFactory.initElements(Driver.getWebdriver(), Homepage.class);
        loginPage = PageFactory.initElements(Driver.getWebdriver(), LoginPage.class);
    }

    @And("^I navigate to the Register page$")
    public void The_user_navigates_to_the_Register_page() throws Throwable {
        registerPage.openPage();
    }

    @Given("^Ted wants to enter his email address$")
    public void Ted_wants_to_enter_his_email_address() throws Throwable {
        registerPage.setEmailField();
    }

    @And("^Ted enters a username$")
    public void Ted_enters_a_username() throws Throwable {
        username = registerPage.setUserNameField();
    }

    @And("^Ted wants to enter his password twice for verification$")
    public void Ted_wants_to_enter_his_password_twice_for_verification() throws Throwable {
        password = registerPage.setPasswordField();
        registerPage.setConfirmPasswordField();
    }

    @When("^Ted wants to identify his business type so that the features shall be tailored to his business$")
    public void Ted_wants_to_identify_his_business_type_so_that_the_features_shall_be_tailored_to_his_business() throws Throwable {
        registerPage.setTypeSelect();
    }

    @Then("^Ted should be able to register successfully$")
    public void Ted_should_be_able_to_register_successfully() throws Throwable {
        registerPage.confirmRegistered();
    }

    @And("^Ted should be able to log in$")
    public void Ted_should_be_able_to_log_in() throws Throwable {
        loginPage.logOut();
        loginPage.openPage();
        loginPage.login(username, password);
    }

    @Given("^I want to register$")
    public void I_want_to_register() throws Throwable {
        if (count > 0)
            registerPage.openPage();
    }

    @When("^I forget to complete a required field$")
    public void I_forget_to_complete_a_required_field() throws Throwable {
        registerPage.checkMandatoryField(count);
    }

    @Then("^I should not be allowed to continue$")
    public void I_should_not_be_allowed_to() throws Throwable {
        for (count = 1; count <= 3; count++) {
            I_want_to_register();
            I_forget_to_complete_a_required_field();
        }
    }

    @Then("^the max length validations should be as expected$")
    public void the_validations_should_be_as_expected() throws Throwable {
        registerPage.checkFieldMaxLengthValidations();
    }

}
