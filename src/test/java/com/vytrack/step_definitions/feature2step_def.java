package com.vytrack.step_definitions;

import com.vytrack.utilities.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class feature2step_def extends TestBase {
    @When("Truck Driver is looking for Export Grid Dropdown")
    public void truckDriverIsLookingForExportGridDropdown() {
        carEntitlesPage.exportGrid.getLocation();

    }

    @Then("Truck Driver should see it on the left side of the page")
    public void truckDriverShouldSeeItOnTheLeftSideOfThePage() {
        Assert.assertTrue(carEntitlesPage.isTheElementOnTheLeftSideOfPage(carEntitlesPage.exportGrid));

    }
}
