package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;

import static driver.DriverFactory.getDriver;

public class LoginTests {
    private final WebDriver driver = getDriver();
    private LoginPage login;

    @Given("I access the login page")
    public void i_access_the_login_page() {
        driver.get("https://monetis-delta.vercel.app/login");
        login = new LoginPage(driver);
    }

    @When("I fill in username and password")
    public void fill_username_and_password() {
        login.enterEmail(RegisterTests.registerEmail);
        login.enterPassword(RegisterTests.registerPassword);
    }

    @And("I click on the login button")
    public void click_login_btn() {
        login.clickLogin();
    }

    @Then("I should Verify user is on dashboard")
    public void check_dashboard_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome"));
    }
}
