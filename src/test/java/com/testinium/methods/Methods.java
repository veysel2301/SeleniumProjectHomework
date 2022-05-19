package com.testinium.methods;

import com.testinium.page.driver.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;

    public Methods() {
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
        jsdriver=(JavascriptExecutor) driver;

    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void senKeys(By by,String text){
        findElement(by).sendKeys(text);


    }
    public boolean isElementVisible(By by){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch(Exception e){
            return false;
        }

    }
    public void scrollWithAction(By by){
        Actions actions =new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();

    }

//    public void scrollWithJavascript(By by){
//        jsdriver.executeScript("arguments[0].scrollIntoView();",findElement(by));
//
//    }

    public Select getSelect(By by){

        return new Select(findElement(by));
    }
    public void selectByText(By by ,String text){// nereden ne seçtirecem seklinde by ve text param verdik.
        getSelect(by).selectByVisibleText(text);

    }


    public String getAttribute(By by,String attributeName){

        return findElement(by).getAttribute(attributeName);
    }
    public String getText(By by){

        return findElement(by).getText();
    }
    public String getValue(By by){
        return jsdriver.executeScript("return arguments[0].value",findElement(by)).toString();
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public boolean click(By by) {
        findElement(by).click();
        return false;
    }
}
