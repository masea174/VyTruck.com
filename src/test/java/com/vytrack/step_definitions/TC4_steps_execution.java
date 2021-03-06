package com.vytrack.step_definitions;

import com.vytrack.pages.CarEntitlesPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TC4_steps_execution  {
LoginPage loginPage=new LoginPage();
DashboardPage dashboardPage=new DashboardPage();
CarEntitlesPage carEntitlesPage=new CarEntitlesPage();
    @Given("{string} is on {string} page")
    public void is_on_page(String truckDriver, String vehiclesPage) throws Exception {
        loginPage.login(truckDriver);
        dashboardPage.hoverOverToFleet("Fleet");
        dashboardPage.clickSubModule(vehiclesPage);

    }

    @When("{string} see the reset button on the right side.")
    public void see_the_reset_button_on_the_right_side(String string) {
        carEntitlesPage.isTheElementOnTheRightSideOfPage(carEntitlesPage.reset);
    }

    @Then("{string} will be able to click reset button")
    public void will_be_able_to_click_reset_button(String string) {
        Assert.assertTrue(carEntitlesPage.reset.isDisplayed());
        carEntitlesPage.reset.click();
    }
}
