package com.vytrack.others.US08;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;


public class TC01 {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    public void US08TC01() {
//        Given store manager and sales manager on dashboard page
//        When store manager and sales manager scrolls to fleet module
//        When store manager and sales manager clicks on Vehicle contracts
//        Then store manager and sales manager has access to "All Vehicle Contracts" on grid

        // TEST CASE 1 MAKE A METHOD
        loginPage.login("storemanager69");
        dashboardPage.fleetModule.click();
        dashboardPage.vehicleContractsBtn.click();

    }
}
