package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="prependedInput")
    public WebElement userNameInput;

    @FindBy(id="prependedInput2")
    public WebElement passwordInput;

    @FindBy(id="_submit")
    public WebElement loginBtn;

    @FindBy (xpath = "//div[@class='bar']")
    public WebElement loadingBar;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        userNameInput.sendKeys(ConfigurationReader.getProperty("truckDriver"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginBtn.click();
    }



}
