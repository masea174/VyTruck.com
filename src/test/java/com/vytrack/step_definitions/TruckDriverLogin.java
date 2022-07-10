package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


    public class TruckDriverLogin extends TestBase {
        @Given("Truck driver is on the Login page")
        public static void truck_driver_is_on_the_login_page() {
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        }
        @When("Truck driver inputs correct credentials")
        public static void truck_driver_inputs_correct_credentials() {
           loginPage.login();
        }
        @Then("Truck driver should navigate to DashboardPage")
        public static void truck_driver_should_navigate_to_dashboard_page() {
    //       // BrowserUtilities.waitToLoad("Dashboard")

            wait.until(ExpectedConditions.titleIs("Dashboard"));
    // String currentT=(Driver.getDriver().getTitle());
            BrowserUtilities.verifyTitle("Dashboard");
        }
    }

