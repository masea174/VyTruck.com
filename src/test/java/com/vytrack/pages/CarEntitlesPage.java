package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarEntitlesPage {
    public CarEntitlesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//ul[@class='dropdown-menu'])[3]//i")
    public List<WebElement> optionsExportGrid;

    @FindBy(xpath = "//div[contains(@class, 'left grid-toolbar')]//div[@class = 'btn-group']//a[contains(@class, 'dropdown-toggle')]")
    public WebElement exportGrid;

    @FindBy(xpath = "//ul//li//a[@title='CSV']")
    public WebElement CSVdropdowmBtn;

    @FindBy(xpath = "//ul//li//a[@title='XLSX']")
    public WebElement XLSXdropdownBtn;

    @FindBy(xpath = "//h1[contains(@class,'subtitle')]")
    public WebElement subTitle;

    @FindBy(css = "a[title='Reset']")
    public WebElement reset;

    @FindBy(css = "a[title='Grid Settings']")
    public WebElement gridSettings;

    @FindBy(xpath = "//div[@class='actions-panel pull-right form-horizontal']//div//a")
    public List<WebElement> listOfFilters;

    @FindBy(xpath = "//a[@title='Refresh']")
    public WebElement refresh;

    @FindBy (xpath = "//label[@class='dib']")
    public WebElement center;


    @FindBy (xpath = "//div[@class='dropdown-menu']")
    public WebElement popUpSettingsMenu;




    public void assertOneButtonIsLeftToAnother(String one, String two) {
        int leftWebElement = 0;
        int rightWebElement = 0;

        for (WebElement eachFilter : optionsExportGrid) {
            if (eachFilter.getAttribute("title").equalsIgnoreCase(one)) {
                leftWebElement = eachFilter.getLocation().getX();
                System.out.println("leftWebElement = " + leftWebElement);
            }
        }
        for (WebElement eachFilter : optionsExportGrid) {
            if (eachFilter.getAttribute("title").equalsIgnoreCase(two)) {
                rightWebElement = eachFilter.getLocation().getX();
                System.out.println("rightWebElement = " + rightWebElement);

            }
        }
        Assert.assertTrue("Test failed, check button position", leftWebElement < rightWebElement);
    }

    public void assertPageTitle(String pageTitle) throws InterruptedException {

        Thread.sleep(3000);
        Assert.assertFalse(subTitle.getText().isEmpty());

        Assert.assertEquals(pageTitle, subTitle.getText());

    }

    public void assertDropdownOption(String dropdownOptionName) throws Exception {

        switch (dropdownOptionName.toLowerCase()) {
            case "csv":
                Assert.assertTrue(CSVdropdowmBtn.isDisplayed());
                break;
            case "xlsx":
                Assert.assertTrue(XLSXdropdownBtn.isDisplayed());
                break;
            default:
                throw new Exception("Unknown dropdown option name:" + dropdownOptionName);
        }

    }

    public void isTheElementOnTheLeftSideOfPage(WebElement element){
        int xElement = element.getLocation().getX();
        int winWidth = Driver.getDriver().manage().window().getSize().getWidth();
        int xCenter= winWidth/2;

        Assert.assertTrue(xCenter>xElement);

    }

    public void isTheElementOnTheRightSideOfPage(WebElement element){
        int xElement = element.getLocation().getX();
        int winWidth = Driver.getDriver().manage().window().getSize().getWidth();
        int xCenter=winWidth/2;

        Assert.assertTrue(xCenter<xElement);

    }

}
