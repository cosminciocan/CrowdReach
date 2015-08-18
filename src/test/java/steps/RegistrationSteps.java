package steps;

import Utils.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.Homepage;
import pages.RegisterPage;
import webdriver.Driver;


public class RegistrationSteps extends TestBase {
    protected Homepage homepage;
    protected RegisterPage registerPage;


    public RegistrationSteps() {
        registerPage = PageFactory.initElements(Driver.getWebdriver(), RegisterPage.class);
        homepage = PageFactory.initElements(Driver.getWebdriver(), Homepage.class);
    }

    @And("^The user navigates to the Register page$")
    public void The_user_navigates_to_the_Register_page() throws Throwable {
        registerPage.openPage();
    }

    @Given("^Ted wants to enter his email address$")
    public void Ted_wants_to_enter_his_email_address() throws Throwable {
        registerPage.setEmailField();
    }

    @And("^Ted enters a username$")
    public void Ted_enters_a_username() throws Throwable {
        registerPage.setUserNameField();
    }

    @And("^Ted wants to enter his password twice for verification$")
    public void Ted_wants_to_enter_his_password_twice_for_verification() throws Throwable {
        registerPage.setPasswordField();
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
}
