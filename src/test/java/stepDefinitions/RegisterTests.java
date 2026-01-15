package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class RegisterTests {
    private RegisterPage register;
    public static String registerName = "Joe";
    public static String registerSurname = "King";
    public static String registerEmail = "testingaccount@test.com";
    public static String registerPassword = "testingPassword!1";

    @When("I populate the form fields")
    public void populate_form_fields() {
        register.enterName(registerName);
        register.enterSurname(registerSurname);
        register.enterEmail(registerEmail);
        register.enterPassword(registerPassword);
        register.enterConfirmPassword(registerPassword);
        register.enterPhone("912345678");
        register.enterAddress("Rua da Terra Fria");
        register.enterPostalCode("0000-000");
        register.enterCity("Coimbra");
        register.enterCountry("Portugal");
    }

    @And("I click the sign up button")
    public void click_the_sign_up_button() {
        register.clickSignUp();
    }
}
