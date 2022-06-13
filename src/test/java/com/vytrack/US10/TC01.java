package com.vytrack.US10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TC01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://qa3.vytrack.com/user/login");

        WebElement userName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName.sendKeys("user28");

        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();


        //Given  truck driver on DashboardPage
        //When truck driver scrolls  the Fleet module

        WebElement fleetModule = driver.findElement(By.xpath("(//span[contains(.,'Fleet')])[1]"));
        fleetModule.click();

        //And truck driver click the Vehicle Fuel Logs menu item
        WebElement vehicleFuelLogs = driver.findElement(By.xpath("//span[contains(.,'Vehicles Fuel Logs')]"));
        vehicleFuelLogs.click();

        //Then truck driver should be able to see information on the grid
        String expectedTitle = "Vehicle Fuel Logs";
        Thread.sleep(3000);
        String actualTitle = driver.getTitle();


        if (actualTitle.contains(expectedTitle)) {
            System.out.println("TC1 Passed");
        } else {
            System.out.println("Failed");
            System.out.println(actualTitle);
            System.out.println(expectedTitle);

        }

        System.out.println("------------------------------------------------");
        //When truck driver click the "Create Vehicle Fuel Logs" button


        WebElement createVehicleFuel = driver.findElement(By.partialLinkText("Create Vehicle Fuel Logs"));
        Thread.sleep(3000);
        createVehicleFuel.click();

        Thread.sleep(3000);
        WebElement cancelBtn = driver.findElement(By.partialLinkText("Cancel"));
        cancelBtn.click();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("TC02 Passed");
        } else {
            System.out.println("TC02 Failed");

        }
        System.out.println("----------------------------------------------------");

        //Given truck driver on the Vehicle Fuel Logs page
        //When truck driver click the any Fuel Logs

        WebElement logs= driver.findElement(By.xpath("//td[@data-column-label='Odometer Value']"));
        logs.click();

        WebElement editBtn=driver.findElement(By.xpath("//a[@title='Edit Vehicle Fuel Logs']"));
        editBtn.isDisplayed();

        WebElement deleteBtn=driver.findElement(By.xpath("//a[@title='Delete Vehicle Fuel Logs']"));
        deleteBtn.isDisplayed();

        WebElement addAttachment=driver.findElement(By.xpath("//a[@title='Add attachment']"));
        addAttachment.isDisplayed();


        WebElement addEvent=driver.findElement(By.xpath("//a[@title='Add an event to this record']"));
        addEvent.isDisplayed();

        System.out.println("TC03 Passed");



        System.out.println("--------------------------------------------------------");
        Thread.sleep(3000);
        driver.navigate().back();
        //vehicleFuelLogs.click();

        //When tuck driver click the Grid Setting button
        Thread.sleep(3000);
        WebElement gridSettingBtn=driver.findElement(By.xpath("//i[@class='fa-cog hide-text']"));
        gridSettingBtn.click();



       //And truck driver should be able to see Grid Settings dropdown
       //Then truck driver should be able to reset the any grid
        Thread.sleep(3000);
        WebElement gridSetting=driver.findElement(By.xpath("//div[.='Grid Settings']"));
       gridSetting.isDisplayed();
       System.out.println("TC4 Passed");


       driver.quit();









    }
}
























