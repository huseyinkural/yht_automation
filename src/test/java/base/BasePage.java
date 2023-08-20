package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.testng.Assert;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }


    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }


    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }


    public String getText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void clear(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
    }

    public String getAttributeValue(By elementBy,String attributeName){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getAttribute(attributeName);
    }


    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(getText(elementBy), expectedText);

    }

    public void assertEqualsByAttributeValue (By elementBy, String attributeName,String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(getAttributeValue(elementBy,attributeName), expectedText);

    }
    public void assertContains (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertTrue(getText(elementBy).contains(expectedText));
    }

    public boolean isElementExist(By element){

        boolean exists = driver.findElements(element).size() != 0;

        return exists;

    }

    public void pressEnter(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(Keys.ENTER);
    }
}
