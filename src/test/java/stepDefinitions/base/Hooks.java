package stepDefinitions.base;

import com.fasterxml.jackson.databind.JsonNode;
import context.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ApiAssertions;
import utils.ApiUtils;
import utils.TestDataReader;

import java.sql.Timestamp;

import static driver.DriverFactory.cleanupDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {
    public WebDriver driver;

    @Before
    public void setup() {
        ApiUtils.restConfig();
        RestAssured.baseURI = "https://monetis-delta.vercel.app/api";
        getDriver();
    }

    @Before("@login")
    public void registerUserBefore() {
        JsonNode users = TestDataReader.getJsonData("users.json");
        JsonNode validUser = users.get("validUser");
        System.out.println("// ==========================");
        System.out.println("//  API");
        System.out.println("// ==========================\n");
        System.out.println(validUser.toString());
        Response response = ApiUtils.registerUser(validUser);
        System.out.println(response.getBody().asString());
        ApiAssertions.assertStatus(response, 200, 201);
        System.out.println("// ==========================\n");
        // Store for later use (login + cleanup)
        ScenarioContext.set("email", validUser.get("email").asText());
        ScenarioContext.set("password", validUser.get("password").asText());
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //long type variable
            String timeMilliseconds = Long.toString(timestamp.getTime()); //convert long to string

            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds); //attaches image to failed steps
        }
    }

    @After("@register or @login")
    public void cleanupAccount() {
        String email = (String) ScenarioContext.get("email");
        String password = (String) ScenarioContext.get("password");
        System.out.println("// ==========================");
        System.out.println("//  API");
        System.out.println("// ==========================\n");
        if (email != null) {
            ApiUtils.deleteUserAccount(email, password);
        }
        System.out.println("// ==========================\n");
    }

    @After
    public void tearDown() {
        ScenarioContext.clear();
        cleanupDriver();
    }
}
