package com.vytrack.step_definitions;

import com.vytrack.utilities.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TC3_step_def extends TestBase {

    @When("the truck driver see the refresh button on the right side")
    public void the_truck_driver_see_the_refresh_button_on_the_right_side() {
        System.out.println(carEntitlesPage.refresh.getLocation().getX());
    }
    @Then("the truck driver should be able to click on the refresh button")
    public void the_truck_driver_should_be_able_to_click_on_the_refresh_button() {
        carEntitlesPage.refresh.click();
     Assert.assertTrue(carEntitlesPage.refresh.isDisplayed());

    }
}
