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
import static webdriver.Driver.getWebdriver;



public class Constant {

    //    URL
    public final static String baseUrl = Driver.config().getProperty("rootUrl");
    public final static String registerPath = "/register";
    public final static String loginPath = "/login";
    public final static String logOutPath = "";
    public final static String addContactsPath = "/contacts/enterManually";
    public final static String importContactsPath = "/contacts/csvImport/step1";
    public final static String editBusinessProfilePath = "/businessProfile";
    public final static String editUserProfilePath = "/editUserInfo";
    public final static String communicationPath = "/communications";
    public final static String subscribersListPath = "/subscribers";
    public final static String changePasswordPath = "/changepassword";


    //CREDENTIALS
    public String userNameValue = config().getProperty("usernameValue");
    public String userPasswordValue = config().getProperty("userPasswordValue");
    public String emailValue = config().getProperty("userEmailValue");
    public String userNameEmailDomain = config().getProperty("userNameEmailDomain");

    //VALUES
    public static int defaultTimeOut = Integer.parseInt(config().getProperty("defaultTimeOut"));
    public static List tableValues = Arrays.asList("TestName1", "TestName2", "TestName3", "TestName4","TestName5", "TestName6");
    public static int textFieldDefaultLenght = 50;
    public static int textAreaDefaultLenght = 255;
    public static int generatedPasswordLength = 8;


    //    Messages
    public static String logOutButtonText = "LOG OUT";
    public static String addedContactMessage = "Successfully added new contact.";
    public static String loggedInMessage = "Login was successful";
    public static String registeredMessage = "Registration was successful";
    public static String uploadedMessage = "Your file was uploaded";
    public static String editedProfileMessage = "Successfully saved profile changes.";
    public static String passwordChangedMessage = "Invalid type of file. Accepted types are .csv";
    public static String incorrectLoginDetailsMessage = "Username or password is incorrect. Please try again.";
    public static String incorrectLoginPassword = "Invalid Password";
    public static String pleaseUploadCSVMessage = "Please upload a csv file";
    public static String wrongFileUploadedMessage = "";
    public static String shortNewPasswordMessage = "New password should be at least 8 characters long.";
    public static String incorrectOldPasswordMessage = "Invalid Password";
    public static String newAndConfirmPasswordMessage = "New and Confirm Password does not match.";
    public static String passwordMinimumLengthMessage = "At least 8 characters long";
    public static String passwordMatchErrorMessage = "Passwords don't match.";


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

    @FindBy(id = "username")
    public WebElement usernameField;
    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(className = "btn-block")
    public WebElement saveChangesButton;

    @FindBy(className = "toast-error")
    public WebElement errorDiv;



    //    Header
    @FindBy(className = "toast-message")
    public WebElement successDiv;
    @FindBy(className = "cr-logged-user-name")
    public WebElement welcomeNameDiv;
    @FindBy(css = ".dropdown-menu.dropdown-menu-right>li>a>span")
    public WebElement logOutButton;
    @FindBy(css = "li.dropdown.bubble-dropdown:not(.open)")
    public WebElement profileDropdownLink;
    @FindBy(className = "col-sm-10")
    public WebElement logInDiv;
    @FindBy(className = "cr-top-menu")
    public WebElement topMenuDiv;


}