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
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);

//           wait.until(ExpectedConditions.visibilityOf(element));
//           wait.until(ExpectedConditions.elementToBeClickable(element));
//
//       }
        int timeOutTime = 0;
        boolean present = false;
//
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
//
        Assert.assertFalse(present);
    }

    //  This method returns a boolean value if the element is found/not found
    public static boolean isElementPresent(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 1);

//        boolean exists = false;
//
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        try {
            wait.until(ExpectedConditions.visibilityOf(element));
//            element.getTagName();
//            element.isDisplayed();
//            exists = true;

            return true;
        } catch (Throwable e) {
            return false;
            /// Do nothing!
        }
//        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
//
//        return exists;
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomAlphaNumeric(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String setDateNow() throws ParseException {
        java.util.Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        return sd.format(d);
    }

    public void Sleep(double seconds) {
        double milliseconds = seconds * 1000;
        try {
            Thread.sleep((long) milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isTextPresent(String text) {
        while (isAlertPresent()) {
            driver.switchTo().alert().accept();
        }
        if (Driver.getWebdriver().getPageSource().contains(text)) {
            System.out.println("Text found");
            return true;
        } else {
            System.out.println("Expected text not found in the page source!");
            return false;
        }
    }

    public boolean elementContainsText(WebElement element, String text) {
//        waitForElement(element, defaultTimeOut);
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
                if (element.getAttribute("value").contains(text)) {
                    return true;
                } else {
                    return false;
                }
            } catch (NullPointerException error) {
                return false;
            }
        }
    }

//    public boolean fieldContainsText(WebElement element, String text) {
//        waitForElement(element, defaultTimeOut);
////        WebDriverWait wait = new WebDriverWait(driver, defaultTimeOut);
//
//        try {
//            ExpectedConditions.textToBePresentInElementValue(element, text);
//            return true;
//        } catch (Exception er) {
//            System.err.println(er);
//            return false;
//        }
//    }


    //TODO: Refactor this !
    public void waitUntilElementNotPresent(WebElement element, int timeOutSeconds) {
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

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void tryClick(WebElement element, int timeOutSeconds) {
//        boolean found;
//        int count = 0; //Count needed for checking the Make Reservation button
//        timeOutSeconds = timeOutSeconds * 10;
//        do {
//            try {
////                WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
////                wait.until(ExpectedConditions.elementToBeClickable(element));
//                element.click();
//                found = true;
//            } catch (Exception e) {
//                found = false;
//                Sleep(0.1);
//            }
//            if (count == timeOutSeconds) {
//                Assert.fail("Element not found!");
//                break;
//            }
//            count++;
//        } while (!found);

        waitForElement(element, timeOutSeconds);
        element.click();

//    }

    }

    public int randomWithRange(int min, int max) {
        int range = (max - min);
        return (int) (Math.random() * range) + min;
    }

    public void setText(WebElement element, String text) {
        waitForElement(element, defaultTimeOut);
        element.clear();
        element.sendKeys(text);
        elementContainsText(element, text);
    }

    //    Sets value to a text field. If left empty it sets a random value
    public void setFieldValue(WebElement element, String... a) {
        if (a.length == 0) {
            setText(element, generateRandomAlphaNumeric(10));
        } else {
            setText(element, a[0]);
        }

    }

    public boolean isAttribtuePresent(WebElement element, String attribute) {
        Boolean result = false;
        try {
            String value = element.getAttribute(attribute);
            if (value != null) {
                result = true;
            }
        } catch (Exception e) {
        }
//  Do nothing
        return result;
    }

////    Run JS
//      JavascriptExecutor js;
//    js = (JavascriptExecutor)driver;
//    js.executeScript("");
}