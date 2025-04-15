package testsSemCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.RegisterPage;

import java.time.Duration;

public class RegisterNewUserTests {
    private final WebDriver driver = new ChromeDriver();

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void registerUser() {
        driver.get("https://monetis-delta.vercel.app/register");
        RegisterPage register = new RegisterPage(driver);
        try {
            register.enterName("Julie");
            register.enterSurname("Jolly");
            register.enterEmail("email@nttdata.com");
            register.enterPhone("912345678");
            register.enterAddress("Coubes");
            register.enterPostalCode("1234-567");
            register.enterCity("Coimbra");
            register.enterCountry("Portugal");
            register.enterPassword("mYpas$w0rd");
            register.enterConfirmPassword("mYpas$w0rd");
            register.clickSignUp();

            // Create WebDriverWait instance and wait for the element to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlContains("dashboard"));

            Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome"));

        } catch (Exception e) {
            System.out.println("\nError: " + driver.findElement(By.id("1")).getText());
            System.out.println("URL: " + driver.getCurrentUrl() + "\n");
            throw e;
        }
    }
}
