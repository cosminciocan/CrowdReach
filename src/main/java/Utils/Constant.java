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
    public final static String baseUrl = config().getProperty("rootUrl");
    public final static String registerPath = "/register";
    public final static String loginPath = "/login";
    public final static String logOutPath = "";
    public final static String addContactsPath = "/contacts/enterManually";
    public final static String importContactsPath = "/contacts/csvImport/step1";
    public final static String editBusinessProfilePath = "/editProfile";
    public final static String editUserProfilePath = "/editUserInfo";
    public final static String communicationPath = "/communications";


    //CREDENTIALS
    public String userNameValue = config().getProperty("usernameValue");
    public String userPasswordValue = config().getProperty("userPasswordValue");
    public String emailValue = config().getProperty("userEmailValue");
    public String userNameEmailDomain = config().getProperty("userNameEmailDomain");

    //VALUES
    public static int defaultTimeOut = Integer.parseInt(config().getProperty("defaultTimeOut"));
    public static List tableValues = Arrays.asList("TestName1", "TestName2", "TestName3", "TestName4");
    public static int textFieldDefaultLenght = 50;
    public static int textAreaDefaultLenght = 255;


    //    Messages
    public static String addedContactMessage = "Successfully added new contact";
    public static String loggedInMessage = "Login was successful";
    public static String registeredMessage = "Registration was successful";
    public static String uploadedMessage = "Your file was uploaded";
    public static String editedProfileMessage = "Successfully saved profile changes.";
    public static String passwordChangedMessage = "";
    public static String incorrectLoginDetailsMessage = "Username or password is incorrect. Please try again.";
    public static String pleaseUploadCSVMessage = "Please upload a csv file";
    public static String wrongFileUploadedMessage = "";
    public static String shortNewPasswordMessage = "New password should be at least 8 characters long.";
    public static String incorrectOldPasswordMessage = "There was an error on the server";
    public static String newAndConfirmPasswordMessage = "New and Confirm Password does not match.";


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