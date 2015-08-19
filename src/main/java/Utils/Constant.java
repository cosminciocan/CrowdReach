package Utils;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.Driver;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Constant {

//    URL
    public static String baseUrl = Driver.config().getProperty("rootUrl");
    public static String registerPath = Driver.config().getProperty("registerPath");
    public static String loginPath = Driver.config().getProperty("loginPath");
    public static String logOutPath = Driver.config().getProperty("logOutPath");
    public static String addContactsPath = Driver.config().getProperty("addContactsPath");
    public static String importContactsPath = Driver.config().getProperty("importContactsPath");


    //CREDENTIALS
    public String userNameValue = Driver.config().getProperty("usernameValue");
    public String userPasswordValue = Driver.config().getProperty("userPasswordValue");
    public String emailValue = Driver.config().getProperty("userEmailValue");
    public String userNameEmailDomain = Driver.config().getProperty("userNameEmailDomain");

    //VALUES
    public static int defaultTimeOut = Integer.parseInt(Driver.config().getProperty("defaultTimeOut"));
    public static String addedContactMessage = "Successfully added new contact";
    public static String loggedInMessage = "Login was successful";
    public static String registeredMessage = "Registration was successful";
    public static String uploadedMessage = "Your file was uploaded";

//    public static final int defaultTimeOut = 5;


    //time now value
//    public static java.util.Date date = new Date();
    public static Date myDate = DateUtils.addDays((new Date()), 1);
    // The date format should be changed after september to: MM/dd/yyyy
    public static SimpleDateFormat simpleDate = new SimpleDateFormat("M/dd/yyyy");

    /*
    Define locator elements using lower CamelCase
    Example:
     - nameOfLocator;
     */
    // LOCATORS
    @FindBy(css = ".btn.btn-default.btn-block")
    public WebElement submitButton;


    //    Header
    @FindBy(className = "toast-message")
    public WebElement successDiv;

    //      Edit Capacity Shift Page
    @FindBy(id = "btnAddShift")
    public WebElement addShiftButton;


    //    Make a reservation page
    @FindBy(id = "btnMakeReservation")
    public WebElement makeReservationButton;


    //    Manage reservation page
    @FindBy(id = "searchReservations")
    public WebElement manageMakeReservation;


    //    Manage Wait List Page
    @FindBy(id = "waitListTable")
    public WebElement waitListTable;


    //    Contact Us Page
    @FindBy(id = "locationDdl")
    public WebElement selectProcessingCenter;


}