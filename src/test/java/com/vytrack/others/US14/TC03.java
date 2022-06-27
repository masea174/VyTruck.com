package com.vytrack.others.US14;

import com.vytrack.others.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC03 {


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
        WebElement vehicleModelBtn = driver.findElement(By.linkText("Vehicles Model"));
        vehicleModelBtn.click();
        Thread.sleep(3000);
    }

    @Test
    void us14TC03() {


//    Given store manager on "Create Vehicles Model" page
        WebElement createVehicleModelBtn=driver.findElement(By.xpath("(//a[contains(.,'Create Vehicles Model')])[5]"));
        createVehicleModelBtn.click();
//    Then store manager should be able to see all required fields
        WebElement allRequiredFileds=driver.findElement(By.tagName("fieldset"));
        Assert.assertTrue(allRequiredFileds.isDisplayed());
//    And store manager clicks on Fuel Type dropdown
        WebElement dropdownArrow = driver.findElement(By.xpath("(//span[@class='select2-chosen'])[2]"));
        dropdownArrow.click();

        List<WebElement> fuelOptions =(driver.findElements(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")));
//    Then store manager shold be able to see displayed Gasoline,Diesel,Electric,Hybird

        List<String >expectedFuelOptions=new ArrayList<>(Arrays.asList("Gasoline","Diesel","Electric","Hybird"));

        for (int i = 0; i <fuelOptions.size() ; i++) {
            String stringOption=fuelOptions.get(i).getText();
            Assert.assertEquals(stringOption,expectedFuelOptions.get(i));
        }
        driver.quit();

    }
}