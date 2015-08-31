package Utils;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.Driver;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static webdriver.Driver.config;


public class Constant {

    //    URL
    public static String baseUrl = config().getProperty("rootUrl");
    public static String registerPath = "/register";
    public static String loginPath = "/login";
    public static String logOutPath = "";
    public static String addContactsPath = "/contacts/enterManually";
    public static String importContactsPath = "/contacts/csvImport/step1";
    public static String editBusinessProfilePath = "/editProfile";
    public static String editUserProfilePath = "/editUserInfo";


    //CREDENTIALS
    public String userNameValue = config().getProperty("usernameValue");
    public String userPasswordValue = config().getProperty("userPasswordValue");
    public String emailValue = config().getProperty("userEmailValue");
    public String userNameEmailDomain = config().getProperty("userNameEmailDomain");

    //VALUES
    public static int defaultTimeOut = Integer.parseInt(config().getProperty("defaultTimeOut"));
    public static List tableValues = Arrays.asList("TestName1", "TestName2", "TestName3", "TestName4");

    //    Messages
    public static String addedContactMessage = "Successfully added new contact";
    public static String loggedInMessage = "Login was successful";
    public static String registeredMessage = "Registration was successful";
    public static String uploadedMessage = "Your file was uploaded";
    public static String editedProfileMessage = "Successfully saved profile changes.";
    public static String passwordChangedMessage = "";
    public static String incorrectLoginDetailsMessage = "Username or password is incorrect. Please try again.";

    //    files
    public static String pathToCSVFile = config().getProperty("pathToCSVFile").replaceAll("\"", "");
    public static String pathToIMGFile = config().getProperty("pathToIMGFile").replaceAll("\"", "");
    public static String imgFileName = "img.png";


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
    @FindBy(className = "btn-square")
    public WebElement submitButton;

    @FindBy(className = "btn-default")
    public WebElement saveChangesButton;

    @FindBy(className = "toast-error")
    public WebElement errorDiv;


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