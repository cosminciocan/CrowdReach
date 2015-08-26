package pages;

import Utils.TestBase;
import junit.framework.Assert;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import webdriver.Driver;

import java.util.List;


public class Homepage extends TestBase{
    RegisterPage registerPage = new RegisterPage();

    // URL


    public static String logInUrl = baseUrl + loginPath;
    public static String logOutUrl = baseUrl + "";

    // METHODS


    public void openPage(){
        Driver.getWebdriver().get(baseUrl);
    }


    public void logOut(){
        Driver.getWebdriver().get(logOutUrl);
    }

    public void checkIfLoggedIn(){
//        if(isElementPresent(menuButton)){
//            logOut();
//        }
    }

    public void playWithJS(){
        JavascriptExecutor js;
        js = (JavascriptExecutor)driver;
        Sleep(2);
        js.executeScript("document.getElementsByClassName('button')[1].setAttribute(\"name\", \"SomeName\");");
        tryClick(driver.findElement(By.name("SomeName")), defaultTimeOut);


//        Find elements by classes
        List<WebElement> listOfElements = driver.findElements(By.className("button"));
        System.out.println("The text of the element is: " + listOfElements.get(0).getText());
        for(int i = 0; i < listOfElements.size(); i++){
            System.out.println("This is the text button: " + listOfElements.get(i).getText());
            if(listOfElements.get(i).getText().contains("FIND RESERVATIONS")){
                listOfElements.get(i).click();
                break;
            }else{
                if(i == (listOfElements.size() -1))
                    Assert.fail("Button not found!");
            }
        }
        listOfElements.get(0).click();
        System.out.println("The number of elements: " + listOfElements.size());

//        Creating CSS locator
        driver.findElement(By.cssSelector(":not(.btnCancel).button[title^='Find Res']"));

    }
}

