package com.vytrack.utilities;

import com.github.javafaker.Faker;
import com.vytrack.pages.DashboardPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class BrowserUtilities {
    DashboardPage dashboardPage=new DashboardPage();
    static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
    public static void verifyTitle( String expectedTitle){
        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }
//    Create a new class called BrowserUtils
//2. Create a method to make Multiple Windows logic re-usable
//3. When method is called, it should switch window and verify
//    title.
//
//
//    Method info:
//            • Name: switchWindowAndVerify
//• Return type: void
//• Arg1: WebDriver
//• Arg2: String expectedInUrl
//• Arg3: String expectedTitle

    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for(String each:windowHandles){
            Driver.getDriver().switchTo().window(each);
            if( Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        Assert.assertTrue("Title verification Failed!!!", Driver.getDriver().getTitle().contains(expectedTitle));

    }
    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public static void waitFor(int seconds){

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static List<String> getElementsText(List<WebElement> elements) {


        List<String> elementsText=new ArrayList<>();

        for (WebElement element : elements) {
            elementsText.add( element.getText());
        }

        return elementsText;
    }


    public static List<String> getElementsTextWithStream(List<WebElement> elements) {

        return elements.stream().map(x->x.getText()).collect(Collectors.toList());
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
            BrowserUtilities.waitFor(2);
        }
        while(!Driver.getDriver().getCurrentUrl().equals(str));
        return flag;
    }

    public static void waitToLoad(String title){
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.titleIs(title));
    }

}
