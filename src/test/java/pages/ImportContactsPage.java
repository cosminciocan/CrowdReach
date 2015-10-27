package pages;

import Utils.TestBase;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;


public class ImportContactsPage extends TestBase {

    private String url = baseUrl + importContactsPath;


    @FindBy(css = ".cr-file-upload .form-control")
    public WebElement importField;
    @FindBy(css = ".btn-square.pull-right")
    public WebElement importFileButton;
    @FindBy(css = ".ng-scope.ui-droppable")
    public WebElement listOfFieldsDiv;
    @FindBy(className = "btn-draggable")
    public List<WebElement> listOfMapFields;
    @FindBy(className = "cr-thumbnail-small")
    public List<WebElement> fileFields;
    @FindBy(css = "td .ng-scope")
    public List<WebElement> tableRowValues;
    @FindBy(className = "btn-square-default")
    public WebElement nextStepLink;
    @FindBy(className = "table-striped")
    public WebElement importedValuesTable;


    public void openPage() {
        driver.get(url);
    }


    public void uploadFile() {
        waitUntilElementNotPresent(successDiv, defaultTimeOut);
        waitForElement(importFileButton, defaultTimeOut);
        importField.sendKeys(pathToCSVFile);
//        assertTrue(importField.getAttribute("type").equals("file"));
        if (isElementPresent(successDiv))
            waitUntilElementNotPresent(successDiv, defaultTimeOut);
        tryClick(importFileButton, defaultTimeOut);
        assertTrue(elementContainsText(successDiv, uploadedMessage));
    }

    public void mapImportedFile() {
        waitForElement(listOfFieldsDiv, defaultTimeOut);
        for (int i = 0; i < fileFields.size(); i++) {
            String mapNameValue = listOfMapFields.get(i).getText();
            (new Actions(driver)).dragAndDrop(listOfMapFields.get(i), fileFields.get(i)).perform();
            assertTrue(elementContainsText(fileFields.get(i), mapNameValue));
            if (i == 5) {
                break;
            }
        }
        tryClick(nextStepLink, defaultTimeOut);
        waitForElement(importedValuesTable, defaultTimeOut);
    }

    //    TODO: Make this method read text values form file
    public void checkImportedValues() {
        for (int i = 0; i < tableRowValues.size(); i++) {
            assertTrue(tableRowValues.get(i).getText().equals(tableValues.get(i)));
        }
    }

    public void nextStepWithoutCsvUpload() {
        waitUntilElementNotPresent(successDiv, defaultTimeOut);
        waitForElement(importFileButton, defaultTimeOut);
        importField.sendKeys(pathToCSVFile);
        tryClick(nextStepLink, defaultTimeOut);
    }

    public void checkNoFileUploadMessage() {
        waitForElement(errorDiv, defaultTimeOut);
        assertTrue(elementContainsText(errorDiv, pleaseUploadCSVMessage));
    }

    public void uploadWrongFileFormat() {
        waitUntilElementNotPresent(successDiv, defaultTimeOut);
        waitForElement(importFileButton, defaultTimeOut);
        importField.sendKeys(pathToIMGFile);
        tryClick(importFileButton, defaultTimeOut);
    }

    public void checkWrongFileNotUploaded() {
        waitForElement(errorDiv, defaultTimeOut);
        assertTrue(elementContainsText(errorDiv, wrongFileUploadedMessage));
    }

}
