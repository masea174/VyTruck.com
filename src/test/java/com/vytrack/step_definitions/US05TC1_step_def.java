package com.vytrack.step_definitions;

import com.vytrack.pages.CarEntitlesPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US05TC1_step_def {
    DashboardPage dashboardPage=new DashboardPage();
    LoginPage loginPage=new LoginPage();
    CarEntitlesPage carEntitlesPage=new CarEntitlesPage();

    @Given("truck driver on Dashboard page")
    public void truck_driver_on_dashboard_page() {
       loginPage.login("TruckDriver");
    }



    @When("truck driver scrolls to the fleet module")
    public void truck_driver_scrolls_to_the_fleet_module() throws Exception {
        dashboardPage.hoverOverToFleet("Fleet");



    }
    @Then("truck driver should be able to click the Vehicle Costs  grid")
    public void truck_driver_should_be_able_to_click_the_vehicle_costs_grid() {
        carEntitlesPage.vehicleCostBtn.click();


    }
    @Then("truck driver should be able to see the all \"Vehicle Costs\"page")
    public void truck_driver_should_be_able_to_see_the_all_vehicle_costs_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Vehicle Costs"));
       // Assert.assertEquals("Vehicle Costs",Driver.getDriver().getTitle());

    }

}
