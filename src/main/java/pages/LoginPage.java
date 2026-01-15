package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageUtils;

import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Locators
    private final By logoBy = By.cssSelector(".logo");
    private final By emailBy = By.name("email");
    private final By passwordBy = By.name("password");
    private final By loginButtonBy = By.tagName("button");
    private final By signUpLinkBy = By.cssSelector(".signup");

    // Constructor checks if on login page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageUtils.verifyPageTitle(driver, "Login");
    }

    /*
     * Encapsulations to interact with page
     */

    public void clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(logoBy)).click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailBy)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordBy)).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonBy)).click();
    }

    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpLinkBy)).click();
    }
}
