package pages;

import Utils.TestBase;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.net.URISyntaxException;


public class ImportContactsPage extends TestBase {

    private String url = baseUrl + importContactsPath;


    @FindBy(css = ".ng-pristine.ng-untouched.ng-valid")
    public WebElement importField;
    @FindBy(css = ".col-md-6>button")
    public WebElement importFileButton;


    public void openPage() {
        driver.get(url);
    }


    public void uploadFile() {
//        File file = null;
//
//        try {
//            file = new File(ImportContactsPage.class.getClassLoader().getResource("files\\file.csv").toURI());
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        Assert.assertTrue(file.exists());

        waitUntilElementNotPresent(successDiv,defaultTimeOut);
        waitForElement(importFileButton, defaultTimeOut);
//        JavascriptExecutor js;
//        js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementsByClassName(\"ng-valid\")[0].setAttribute(\"type\",\"file\");");
//  importFileButton.sendKeys(file.getAbsolutePath());
        importField.sendKeys("C:\\Automation\\Files\\file.csv");
        tryClick(importFileButton,defaultTimeOut);
//        Sleep(10);
        tryClick(successDiv, defaultTimeOut);
//        Sleep(2);
        Assert.assertTrue(elementContainsText(successDiv, uploadedMessage));
    }

}
