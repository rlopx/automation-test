package pages;

import org.openqa.selenium.WebDriver;

public class DashboardPage {
    protected WebDriver driver;

    // identifiable elements in page

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        if (!driver.getTitle().contains("Dashboard")){
            throw new IllegalStateException("You are not in Dashboard, you're at " + driver.getCurrentUrl());
        }
    }

    /*
     * Encapsulations
     */
}
