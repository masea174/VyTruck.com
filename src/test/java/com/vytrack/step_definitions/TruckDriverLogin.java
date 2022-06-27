package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class TruckDriverLogin {
    @Given("Truck driver is on the Login page")
    public void truck_driver_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("Truck driver inputs correct credentials")
    public void truck_driver_inputs_correct_credentials() {
        LoginPage loginPage=new LoginPage();
        loginPage.userNameInput.sendKeys(ConfigurationReader.getProperty("truckDriver"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
    }
    @Then("Truck driver should navigate to DashboardPage")
    public void truck_driver_should_navigate_to_dashboard_page() {
//       // BrowserUtilities.waitToLoad("Dashboard")

        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
// String currentT=(Driver.getDriver().getTitle());
    }
}
