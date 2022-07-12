package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    public AmazonPage(){

        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy (id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(css = ".s-pagination-next")
    public WebElement nextButton;
}
