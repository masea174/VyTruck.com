package com.vytrack.step_definitions;

import com.vytrack.pages.CarEntitlesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TC5_Step_Def{
    CarEntitlesPage carEntitlesPage=new CarEntitlesPage();
    @When("truck driver clicks on Grid Setting button")
    public void truck_driver_clicks_on_grid_setting_button() {
        carEntitlesPage.gridSettings.click();
    }
    @Then("truck driver should be able to see a pop up window with options")
    public void truck_driver_should_be_able_to_see_a_pop_up_window_with_options() {
        Assert.assertTrue(carEntitlesPage.popUpSettingsMenu.isDisplayed());
    }

}
