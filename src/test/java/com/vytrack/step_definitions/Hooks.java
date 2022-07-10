package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends TestBase {

    @Before
    public void setUp() throws Exception {
        System.out.println("Before scenario is running");
//        loginPage.login();
//        T2Executions.selects_vehicles_feature_under_fleet_module();
//        T2Executions.should_navigate_to_car_entitles_page();
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("After scenario is running");
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());//}
        }Driver.closeDriver();
    }
}
