package com.vytrack.step_definitions;

import com.vytrack.pages.CarEntitlesPage;
import io.cucumber.java.en.Then;

public class TC8_step_def {
CarEntitlesPage carEntitlesPage=new CarEntitlesPage();
    @Then("user should be able to see the Grid Button on the right of the page")
    public void user_should_be_able_to_see_the_grid_button_on_the_right_of_the_page() {
        carEntitlesPage.isTheElementOnTheRightSideOfPage(carEntitlesPage.gridSettings);
    }
}
