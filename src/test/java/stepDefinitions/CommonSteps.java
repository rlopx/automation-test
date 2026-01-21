package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static driver.DriverFactory.getDriver;

public class CommonSteps {
    private WebDriver driver;

    @Then("I should Verify user is on dashboard")
    public void check_dashboard_page() {
        driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome"));
    }
}
