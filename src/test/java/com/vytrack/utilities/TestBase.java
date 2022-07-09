package com.vytrack.utilities;

import com.vytrack.pages.CarEntitlesPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public static DashboardPage dashboardPage;
    public static WebDriverWait wait;
    public static CarEntitlesPage carEntitlesPage;
    public static LoginPage loginPage;
    public static Actions actions;

    static {
        dashboardPage = new DashboardPage();
        wait = new WebDriverWait(Driver.getDriver(), 5);
        carEntitlesPage = new CarEntitlesPage();
        loginPage = new LoginPage();
        actions = new Actions(Driver.getDriver());
    }
}
