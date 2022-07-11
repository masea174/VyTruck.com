package com.vytrack.step_definitions;

import com.vytrack.utilities.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TC6_step_definition extends TestBase {
    @When("user is looking for the reset button")
    public void user_is_looking_for_the_reset_button() {
      Assert.assertTrue(dashboardPage.ifButtonOnTheLeft(carEntitlesPage.reset.getAttribute("title"), carEntitlesPage.refresh.getAttribute("title")));
    }
    @Then("user should see it on the rigth side of the resset Button")
    public void user_should_see_it_on_the_rigth_side_of_the_resset_button() {

    }

}
