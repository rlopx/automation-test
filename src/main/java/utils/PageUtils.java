package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class PageUtils {
    /*
     * Wait for page title validation
     */
    public static void verifyPageTitle(WebDriver driver, String expectedTitle) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains(expectedTitle));
        } catch (Exception e) {
            throw new IllegalStateException("Expected page with title containing '" + expectedTitle + "' but got: " + driver.getCurrentUrl());
        }
    }
}
