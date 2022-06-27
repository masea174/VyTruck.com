package com.vytrack.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DriverUtilities {
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }


    public static void switchWindowAndVerify(WebDriver driver,String expectedInUrl, String expectedTitle){
        Set<String> windowHandles = driver.getWindowHandles();
        for(String each:windowHandles){
            driver.switchTo().window(each);
            if( driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains(expectedTitle),"Title verification Failed!!!");

    }
    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    //Return a list of string from a list of elements */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }


    /** 3. Performs a pause */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /** 4. Waits for element matching the locator to be visible on the page */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    /** 5. Scrolls down to an element using JavaScript */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    /** 6. Selects with visibleText */
    public static void selectByVisibleText(WebElement elementDropdown, String visibleText) {
        Select dropdown = new Select(elementDropdown);
        dropdown.selectByVisibleText(visibleText);
    }


    /** 7. Checks element is displayed */
    public static boolean elementIsDisplayed(List<WebElement> elements) {
        for (WebElement element : elements) {
            if (!element.isDisplayed()) {
                System.err.println(element.getText() + " is not displayed");
                return false;
            }
        }
        return true;
    }
    /** 8. Check Element is not Located */
    public static boolean waitForElementIsNotLocated(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            System.err.println("Create Car button does not exist");
        }
        return false;
    }


    /** 9. returns random number between a to b */
    public static int randomNumber(int a, int b) {
        return new Faker().number().numberBetween(a, b);
    }


    /** 10. click all unchecked boxes */
    public static boolean getIsCheck(List<WebElement> allCheckboxes,WebElement nextButton){
        boolean flag = true;
        String str = "";
        do{ str = Driver.getDriver().getCurrentUrl();
            for (WebElement checkbox : allCheckboxes) {
                if(!checkbox.isSelected()) {
                    flag = false;
                    break;
                }
            }
            nextButton.click();
            DriverUtilities.waitFor(2);
        }
        while(!Driver.getDriver().getCurrentUrl().equals(str));
        return flag;
    }

}
