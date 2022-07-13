package com.vytrack.step_definitions;

import com.vytrack.pages.AmazonPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

public class AmazonPage_def {
    AmazonPage amazonPage = new AmazonPage();


    @Given("User on Amazon Page")
    public void user_on_amazon_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon"));
    }
    @When("User is looking {string} in the search box")
    public void user_is_looking_in_the_search_box(String string) {
     amazonPage.searchBox.sendKeys(string + Keys.ENTER);
    }
    @Then("User should be able to see all the pages with the web results")
    public void user_should_be_able_to_see_all_the_pages_with_the_web_results() {

        while(true){
            try{
             amazonPage.nextButton.click();
        } catch (RuntimeException e){
                System.out.println("Last Page");
                break;
            }

            }
    }

}
