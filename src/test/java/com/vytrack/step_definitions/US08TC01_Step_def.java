package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US08TC01_Step_def {

    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    @Given("store manager and sales manager on dashboard page")
    public void store_manager_and_sales_manager_on_dashboard_page() {

        loginPage.login("storeManager69");

    }
    @When("store manager and sales manager scrolls to fleet module")
    public void store_manager_and_sales_manager_scrolls_to_fleet_module() throws Exception {
        dashboardPage.hoverOverToFleet("Fleet");
        dashboardPage.vehicleContractsBtn.click();
    }
    @When("store manager and sales manager clicks on Vehicle contracts")
    public void store_manager_and_sales_manager_clicks_on_vehicle_contracts() {
        dashboardPage.vehicleContractsBtn.click();
    }
    @Then("store manager and sales manager has access to All Vehicle Contracts on grid")
    public void store_manager_and_sales_manager_has_access_to_on_grid(String string) {
        System.out.println("did this work?");
    }

}
