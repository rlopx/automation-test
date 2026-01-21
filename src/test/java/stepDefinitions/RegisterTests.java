package stepDefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import config.Config;
import context.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.RegisterPage;
import utils.TestDataReader;

import static driver.DriverFactory.getDriver;

public class RegisterTests {
    private RegisterPage register;

    @Given("I access the register page")
    public void i_access_the_register_page() {
        getDriver().get(Config.getBaseUrl() + "/register");
        register = new RegisterPage(getDriver());
    }

    @When("I populate the form fields")
    public void i_populate_the_form_fields() {
        JsonNode users = TestDataReader.getJsonData("users.json");
        JsonNode user = users.get("validUser");
        String email = user.get("email").asText();
        String password = user.get("password").asText();

        // Store for later use (dashboard validation / cleanup)
        ScenarioContext.set("email", email);
        ScenarioContext.set("password", password);

        register.enterName(user.get("name").asText());
        register.enterSurname(user.get("surname").asText());
        register.enterEmail(email);
        register.enterPassword(password);
        register.enterConfirmPassword(password);
        register.enterPhone(user.get("phone_number").asText());
        register.enterAddress(user.get("street_address").asText());
        register.enterPostalCode(user.get("postal_code").asText());
        register.enterCity(user.get("city").asText());
        register.enterCountry(user.get("country").asText());
        register.enterPassword(user.get("password").asText());
        register.enterConfirmPassword(user.get("password").asText());
    }

    @And("I click the sign up button")
    public void click_the_sign_up_button() {
        register.clickSignUp();
        new BasePage(getDriver()).assertNoGlobalErrorPresent();
    }
}
