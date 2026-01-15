package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageUtils;

public class DashboardPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // identifiable elements in page

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageUtils.verifyPageTitle(driver, "Dashboard");
    }

    /*
     * Encapsulations
     */
}
