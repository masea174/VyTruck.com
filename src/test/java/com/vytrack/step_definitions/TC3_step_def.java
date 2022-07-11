package com.vytrack.step_definitions;

import com.vytrack.utilities.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TC3_step_def extends TestBase {

    @When("the truck driver see the refresh button on the right side")
    public void the_truck_driver_see_the_refresh_button_on_the_right_side() {
       carEntitlesPage.isTheElementOnTheLeftSideOfPage(carEntitlesPage.refresh);
    }
    @Then("the truck driver should be able to click on the refresh button")
    public void the_truck_driver_should_be_able_to_click_on_the_refresh_button() {
        wait.until(ExpectedConditions.elementToBeClickable(carEntitlesPage.refresh));
        Assert.assertTrue(carEntitlesPage.refresh.isDisplayed());

        carEntitlesPage.refresh.click();


    }
}
