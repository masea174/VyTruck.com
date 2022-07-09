package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarEntitlesPage{
public CarEntitlesPage(){
    PageFactory.initElements(Driver.getDriver(),this);
}
@FindBy (xpath ="//i[@class=\'fa-upload\']")
    public WebElement gridButton;
@FindBy( xpath = "(//ul[@class='dropdown-menu'])[3]")
    public WebElement dropDownGrid;
@FindBy(xpath = "(//ul[@class='dropdown-menu'])[3]//i")
    public List<WebElement> optionsExportGrid;


}
