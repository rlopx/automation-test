package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    // ==========================
    // Constructor
    // ==========================
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Global error locator
    protected By globalErrorMessage = By.xpath(
            "//*[contains(@class, 'error') and @role='alert']"
    );

    public void assertNoGlobalErrorPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            WebElement error = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(globalErrorMessage)
            );
            Assert.fail("❌ Global error displayed: " + error.getText().trim());
        } catch (Exception ignored) {
        }
    }
}