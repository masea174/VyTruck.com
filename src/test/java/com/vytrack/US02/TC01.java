package com.vytrack.US02;

import com.vytrack.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC01 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://qa2.vytrack.com/user/login%22");

                WebElement userName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName.sendKeys("storemanager69");

        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();


        //  Given store manager on Dashboard page
        //  When store manager scrolls to the fleet module
        WebElement fleetModule = driver.findElement(By.xpath("(//span[contains(.,'Fleet')])[1]"));
        fleetModule.click();

        //  When store manager clicks the vehicle menu item
        WebElement vehicleMenu = driver.findElement(By.xpath("(//span[contains(.,'Vehicles')])[1]"));
        vehicleMenu.click();

        //   Then store manager should be able see the vehicle page
        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Store manager should be able see the vehicle page test passed");
        }else{
            System.out.println("Store manager should be able see the vehicle page test failed");

        }

        driver.quit();




    }
}

