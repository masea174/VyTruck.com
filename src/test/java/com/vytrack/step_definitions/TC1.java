package com.vytrack.step_definitions;

import com.vytrack.utilities.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class TC1 extends TestBase {

    @When("Export Grid dropdown is clicked")
    public void export_grid_dropdown_is_clicked() {
        carEntitlesPage.exportGrid.click();


    }
    @Then("CSV and XLSX links should be displayed")
    public void csv_and_xlsx_links_should_be_displayed() {
        for (WebElement each :carEntitlesPage.optionsExportGrid ) {
            Assert.assertTrue(each.isDisplayed());
        }
        }

}
