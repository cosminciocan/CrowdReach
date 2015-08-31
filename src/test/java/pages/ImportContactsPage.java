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


public class ImportContactsPage extends TestBase {

    private String url = baseUrl + importContactsPath;


    @FindBy(css = ".ng-pristine.ng-untouched.ng-valid")
    public WebElement importField;
    @FindBy(css = ".btn-square.pull-right")
    public WebElement importFileButton;
    @FindBy(css = ".ng-scope.ui-droppable")
    public WebElement listOfFieldsDiv;
    @FindBy(className = "btn-draggable")
    public List<WebElement> listOfMapFields;
    @FindBy(className = "thumbnail")
    public List<WebElement> fileFields;
    @FindBy(css = "td .ng-scope")
    public List<WebElement> tableRowValues;
    @FindBy(css = ".col-md-1.col-md-offset-4>a")
    public WebElement nextStepLink;
    @FindBy(className = "table-striped")
    public WebElement importedValuesTable;


    public void openPage() {
        driver.get(url);
    }


    public void uploadFile() {
        waitUntilElementNotPresent(successDiv, defaultTimeOut);
        waitForElement(importFileButton, defaultTimeOut);
        waitForElement(importField, defaultTimeOut);
        Assert.assertTrue(importField.getAttribute("type").equals("file"));
        importField.sendKeys(pathToCSVFile);
        tryClick(importFileButton, defaultTimeOut);
        tryClick(successDiv, defaultTimeOut);
        Assert.assertTrue(elementContainsText(successDiv, uploadedMessage));
    }

    public void mapImportedFile() {
        waitForElement(listOfFieldsDiv, defaultTimeOut);
        for (int i = 0; i < fileFields.size() - 1; i++) {
            String mapNameValue = listOfMapFields.get(i).getText();
            (new Actions(driver)).dragAndDrop(listOfMapFields.get(i), fileFields.get(i)).perform();
            Assert.assertTrue(elementContainsText(fileFields.get(i), mapNameValue));
        }
        tryClick(nextStepLink, defaultTimeOut);
        waitForElement(importedValuesTable, defaultTimeOut);
    }

    public void checkImportedValues() {
        for (int i = 0; i < tableRowValues.size(); i++) {
            Assert.assertTrue(tableRowValues.get(i).getText().equals(tableValues.get(i)));
        }
    }
}
