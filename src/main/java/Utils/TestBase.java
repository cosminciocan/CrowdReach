package Utils;

import Utils.Constant;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.DocumentType;
import webdriver.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

// This abstract class contains the common methods that are used in multiple classes

public abstract class TestBase extends Constant {

    public static WebDriver driver;
    public JavascriptExecutor js;


    static {
        startSuite();
    }

    private static void startSuite() {
        try {
            Driver.initWebdriver();
            driver = Driver.getWebdriver();
        } catch (Exception e) {
            System.out.println("Exception when start suite:\n" + e);
        }
    }

    public void waitForElement(WebElement element, int timeOutSeconds) {
        //    Waits for an element to be present and visible on the page
//           The below ExpectedConditions actions are commented because they
//        are an alternative to this method. I found them to not be as reliable
//           Change them as desired.
//           wait.until(ExpectedConditions.visibilityOf(element));
//           wait.until(ExpectedConditions.elementToBeClickable(element));
//
//       }

        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        int timeOutTime = 0;
        boolean present = false;
        while (!isElementPresent(element)) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            timeOutTime++;
            if (timeOutTime == timeOutSeconds) {
                System.err.println("Timed out while waiting for the element!");
                present = true;
                break;
            }
        }
        Assert.assertFalse(present);
    }

    public static boolean isElementPresent(WebElement element) {
        //  This method returns a boolean value if the element is found/not found
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
//            element.getTagName();
//            element.isDisplayed();
//            exists = true;
            return true;
        } catch (Throwable e) {
            return false;
        }
    }

    public String generateRandomString(int length) {
        //    Returns a random String of length
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateRandomNumber(int length) {
        //    Returns a random Integer of length
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomAlphaNumeric(int length) {
//    This method returns an alphanumeric String that ends in a 2 character long Int
//    This is done to ensure it will always return an alphanumeric value
        String y = "";
        String x = "";
        if (length > 2) {
            y = RandomStringUtils.randomNumeric(2);
            x = RandomStringUtils.randomAlphanumeric(length - 2);
        } else
            x = RandomStringUtils.randomAlphanumeric(length);
        return x + y;
    }

    public static String setDateNow() throws ParseException {
        //    Returns a String with the current date with the given date format
        java.util.Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        return sd.format(d);
    }

    public void Sleep(double seconds) {
        //    Sleep method
        double milliseconds = seconds * 1000;
        try {
            Thread.sleep((long) milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public boolean isTextPresent(String text) {
        //    Verifies if the given text is prezent in the page source
        if (Driver.getWebdriver().getPageSource().contains(text)) {
            System.out.println("Text found");
            return true;
        } else {
            System.out.println("Text not found");
            return false;
        }
    }

    public boolean elementContainsText(WebElement element, String text) {
        //      Verifies if an element contains some text
//    This can be implemented using ExpectedConditions as well
//    However, I've noticed it's not extremely reliable

//        WebDriverWait wait = new WebDriverWait(driver, defaultTimeOut);
//        waitForElement(element,defaultTimeOut);
//        try {
//            ExpectedConditions.textToBePresentInElement(element, text);
//            return true;
//        } catch (Exception e) {
//            System.err.println(e);
//            return false;
//        }
        waitForElement(element, defaultTimeOut);
        if (element.getText().contains(text)) {
            return true;
        } else {
            try {
                return element.getAttribute("value").contains(text);
            } catch (NullPointerException error) {
                return false;
            }
        }
    }

    //TODO: Refactor this !
    public void waitUntilElementNotPresent(WebElement element, int timeOutSeconds) {
        //  Waits until the element is no longer visible
        int timeOutTime = 0;
        timeOutSeconds = timeOutSeconds * 1000;
        boolean present = false;
        while (isElementPresent(element)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeOutTime = timeOutTime + 100;
            if (timeOutTime == timeOutSeconds) {
                System.err.println("Timed out waiting for the element to disappear!");
                present = true;
                break;
            }
        }
        Assert.assertFalse(present);
    }

    public void tryClick(WebElement element, int timeOutSeconds) {
        //    Wait for element and click
        waitForElement(element, timeOutSeconds);
        element.click();
    }

    public int randomWithRange(int min, int max) {
        //    Returns a random int value, between two values
        int range = (max - min);
        return (int) (Math.random() * range) + min;
    }

    public void setText(WebElement element, String text) {
        //    Sets the given text in the text area
        waitForElement(element, defaultTimeOut);
        element.clear();
        element.sendKeys(text);
        elementContainsText(element, text);
    }

    public void setFieldValue(WebElement element, String... a) {
        //    Sets value to a text field. If left empty it sets a random alphanumeric value
        if (a.length == 0) {
            setText(element, generateRandomAlphaNumeric(10));
        } else {
            setText(element, a[0]);
        }

    }

    public boolean isAttribtuePresent(WebElement element, String attribute) {
        //    Checks if the element has the given attribute
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception ignored) {
        }
        return result;
    }

////    Run JS
//      JavascriptExecutor js;
//    js = (JavascriptExecutor)driver;
//    js.executeScript("");
}