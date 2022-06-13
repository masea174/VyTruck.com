package com.vytrack.US14;

import com.vytrack.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC01 {
    WebDriver driver;
    @BeforeMethod
    void setUpLogin() {
        driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa3.vytrack.com/user/login");

        WebElement userName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName.sendKeys("storemanager69");

        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();
    }

    @Test
    void us06TC01() throws InterruptedException {

//    Given store manager on "Dashboard" page
//    When store manager scrolls to the fleet module
        WebElement fleetModule = driver.findElement(By.xpath("(//span[contains(.,'Fleet')])[1]"));
        fleetModule.click();
//    When store manager clicks the Vehicle Model menu item
        WebElement vehicleModelBtn=driver.findElement(By.linkText("Vehicles Model"));
        vehicleModelBtn.click();

//    Then store manager should be able see the All Vehicles Model  grid
        WebElement allVehiclesModelGrid=driver.findElement(By.xpath("//div[@class='grid-scrollable-container']"));
        Assert.assertTrue(allVehiclesModelGrid.isDisplayed());
//    And store manager shold be able to see the "All - Vehicles Model - Entities - System - Car - Entities - System"page
        Thread.sleep(3000);
        String expectedTitle="All - Vehicles Model - Entities - System - Car - Entities - System";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, actualTitle+" is here");
driver.quit();
    }


}