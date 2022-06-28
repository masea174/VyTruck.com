package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){
    }
   private static WebDriver driver;


    public static WebDriver getDriver(){
        //it will check if the driver is null and if its we will set uo browser inside the if statement
        //if you already have the driver set up it will return you that one otherway it will create you a driver


        if(driver==null){

            // we read the browser type from configuration reader class with get property
            String browserType=ConfigurationReader.getProperty("browser");
            switch (browserType){
                default:
                case"chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

            }

        }return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();// will kill the sesion so u need to assing the null value to the  singleton method to work
            driver=null;
        }}

}
