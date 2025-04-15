package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

import static driver.DriverFactory.getDriver;

public class LoginTests {
    private WebDriver driver = getDriver();
    private LoginPage login;

    @Given("I access the login page")
    public void i_access_the_login_page() {
        driver.get("https://monetis-delta.vercel.app/login");
        login = new LoginPage(driver);
    }

    @When("I fill in username and password with {word} and {}")
    public void fill_username_and_password(String email, String password) {
        login.enterEmail(email);
        login.enterPassword(password);
    }

    @And("I click on the login button")
    public void click_login_btn() {
        login.clickLogin();
    }

    @Then("I should Verify user is on dashboard")
    public void check_dashboard_page() {
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
}
