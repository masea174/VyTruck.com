package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends TestBase {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicleFeature;
    @FindBy(xpath = "//a//span[normalize-space(text()) = 'Fleet' and contains(@class, title-level-1)]")
    public WebElement fleetModule;

    @FindBy(xpath = "//a//span[normalize-space(text()) = 'Customer' and contains(@class, title-level-1)]")
    public WebElement customerModule;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicles;

    @FindBy(xpath = "//span[.='Vehicle Odometer']")
    public WebElement vehicleOdometer;


    public void hoverOverToFleet(String moduleName) throws Exception {

        Actions action = new Actions(Driver.getDriver());
        switch (moduleName.toLowerCase()) {
            case "fleet":
                wait.until(ExpectedConditions.visibilityOf(fleetModule));
                action.moveToElement(fleetModule).perform();
                break;
            case "customer":
                action.moveToElement(customerModule).perform();
                break;
            default:
                throw new Exception("Unknown module name:" + moduleName);
        }


    }
    public void clickSubModule(String vehicleName) throws Exception {

        switch (vehicleName.toLowerCase()) {
            case "vehicles":
                vehicles.click();
                break;
            case "vehicle odometer":
                vehicleOdometer.click();
                break;
            default:
                throw new Exception( "Unknown submodule name:" + vehicleName );
        }
    }
}