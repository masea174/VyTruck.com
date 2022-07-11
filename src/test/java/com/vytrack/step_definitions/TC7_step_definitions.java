package com.vytrack.step_definitions;

import com.vytrack.utilities.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TC7_step_definitions extends TestBase {

    @When("truck driver see the Reset button onthe page")
    public void truck_driver_see_the_reset_button_onthe_page() {

    }
    @Then("the driver should be able to Grid Setings on the  right side of Reset button")
    public void the_driver_should_be_able_to_grid_setings_on_the_right_side_of_reset_button() {
       Assert.assertTrue(dashboardPage.ifButtonOnTheLeft(carEntitlesPage.gridSettings.getAttribute("title"),carEntitlesPage.reset.getAttribute("title")));
    }


}
