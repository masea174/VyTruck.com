package com.vytrack.US14;

import com.vytrack.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC02 {
    WebDriver driver;
    @BeforeMethod
    void setUpLogin() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa3.vytrack.com/user/login");

        WebElement userName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName.sendKeys("storemanager69");

        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();
        WebElement fleetModule = driver.findElement(By.xpath("(//span[contains(.,'Fleet')])[1]"));
        fleetModule.click();
//    When store manager clicks the Vehicle Model menu item
        WebElement vehicleModelBtn=driver.findElement(By.linkText("Vehicles Model"));
        vehicleModelBtn.click();
        Thread.sleep(3000);
    }

    @Test
    public  void us06TC02() throws InterruptedException {

//    Given store manager on " All - Vehicles Model - Entities - System - Car - Entities - System" page
//    When store clicks on the "Create Vehicles Model" button
        WebElement createVehicleModelBtn=driver.findElement(By.xpath("(//a[contains(.,'Create Vehicles Model')])[5]"));
        createVehicleModelBtn.click();
//    Then store manager should be able to see "Create Vehicles Model" page
        String expectedPage="Create Vehicles Model";
        String actualPageTitle=driver.getTitle();
//    And store manager click on "Save and Close" Button
        WebElement saveAndCloseBtn = driver.findElement(By.cssSelector("button[class='btn btn-success action-button']"));
        Thread.sleep(3000);
        saveAndCloseBtn.submit();
        Thread.sleep(3000);
//    Then store manager should be able to see "Entity saved" mesage
        String expectedMessage="Entity saved";
        String actualMessage=driver.findElement(By.xpath("//div[@class ='flash-messages-holder']")).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        driver.quit();

    }
}
