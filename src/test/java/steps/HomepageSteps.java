package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import Utils.TestBase;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.Homepage;
import pages.LoginPage;
import webdriver.Driver;


public class HomepageSteps extends TestBase {
    protected Homepage homepage;
    protected LoginPage loginPage;

    public HomepageSteps(){
        homepage = PageFactory.initElements(Driver.getWebdriver(), Homepage.class);
        loginPage = PageFactory.initElements(Driver.getWebdriver(), LoginPage.class);
    }

    @Given("^The user navigates to the application Homepage$")
    public void The_user_navigates_to_the_application_Homepage() {
        homepage.openPage();
    }
}