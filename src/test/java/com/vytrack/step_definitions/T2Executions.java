package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class T2Executions extends TestBase {


    @When("selects Vehicles feature under Fleet module")
    public static void selects_vehicles_feature_under_fleet_module() throws Exception {


//         try{
//         WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
//        wait.until(ExpectedConditions.elementToBeSelected(dashboardPage.fleetModule));}catch (TimeoutException e){
//             System.out.println(e.printStackTrace(););
// Driver.getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
//      wait.until(ExpectedConditions.invisibilityOf(loginPage.loadingBar));
//        BrowserUtilities.mouseHoverJScript(dashboardPage.fleetModule);
//       // wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("\"(//ul[@class='dropdown-menu'])[3]//i\"")));
//        actions.moveToElement(dashboardPage.vehicleFeature).click().perform();

        dashboardPage.hoverOverToFleet("fleet");
        dashboardPage.clickSubModule("vehicles");
    }

    @Then("Truck Driver on Vehicle Page")
    public static void should_navigate_to_car_entitles_page() {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
BrowserUtilities.waitFor(5);
     //   wait.until(ExpectedConditions.titleIs("Car - Entities - System - Car - Entities - System"));
        BrowserUtilities.verifyTitle("Car - Entities - System - Car - Entities - System");
    }

}
