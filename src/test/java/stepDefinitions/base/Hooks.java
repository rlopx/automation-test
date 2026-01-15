package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.*;
import stepDefinitions.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.sql.Timestamp;

import static driver.DriverFactory.cleanupDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {
    public WebDriver driver;

    @Before
    public void setup() {
        getDriver();
    }

    @Before("login")
    public void registerUserBefore() {
        ApiUtils.registerUser(
                RegisterTests.registerName,
                RegisterTests.registerSurname,
                RegisterTests.registerEmail,
                "912345678",
                "Rua da Terra Fria",
                "0000-000",
                "Coimbra",
                "Portugal",
                RegisterTests.registerPassword,
                RegisterTests.registerPassword);
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
        if (RegisterTests.registerEmail != null && !RegisterTests.registerEmail.isEmpty()) {
            System.out.println("Cleaning up registered account: " + RegisterTests.registerEmail);
            ApiUtils.deleteUserAccount(RegisterTests.registerEmail);
        }
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}
