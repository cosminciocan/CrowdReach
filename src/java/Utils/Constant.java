package Utils;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Constant {

    //BASE URL
    public static final String BaseURL = "http://localhost:4391";
    //    PATHS
    public static final String logOutPath = "";
    public static final String logInPath = "/#/login";
    public static final String registerPath = "/#/register";


    //CREDENTIALS
    public static final String volunteerUser = "";
    public static final String volunteerPassword = "";
    public String emailValue;
    public String userNameValue = "cosmin1";
    public String userPasswordValue = "123456";
    public String typeOfBusinessDropdown = "businessType";

    //VALUES
    public static final String atTestDomain = "@sfpTest.com";
    public static final String highReservationGroupSize = "200"; // This should be a number above 100
    public static final int defaultTimeOut = 5;


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