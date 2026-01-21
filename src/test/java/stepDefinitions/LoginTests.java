package stepDefinitions;

import config.Config;
import context.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static driver.DriverFactory.getDriver;

public class LoginTests {
    private WebDriver driver;
    private LoginPage login;

    @Given("I access the login page")
    public void i_access_the_login_page() {
        driver = getDriver();
        driver.get(Config.getBaseUrl() + "/login");
        login = new LoginPage(driver);
    }

    @When("I fill in username and password")
    public void fill_username_and_password() {
        login.enterEmail((String) ScenarioContext.get("email"));
        login.enterPassword((String) ScenarioContext.get("password"));
    }

    @And("I click on the login button")
    public void click_login_btn() {
        login.clickLogin();
    }

}
