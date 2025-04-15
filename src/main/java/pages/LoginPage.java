package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver driver;

    // Locators
    private By logoBy = By.cssSelector(".logo");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By loginButtonBy = By.tagName("button");
    private By signUpLinkBy = By.cssSelector(".signup");

    // Constructor checks if on login page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().contains("Login")) {
            throw new IllegalStateException("This is not the Login page, you're at " + driver.getCurrentUrl());
        }
    }

    /*
     * Encapsulations to interact with page
     */

    public void clickLogo() {
        if (driver.findElement(logoBy).isDisplayed()) {
            driver.findElement(logoBy).click();
        }
    }

    public void enterEmail(String email) {
        driver.findElement(emailBy).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordBy).sendKeys(password);
    }

    public void clickLogin() {
        if (driver.findElement(loginButtonBy).isDisplayed()) {
            driver.findElement(loginButtonBy).click();
        }
    }

    public void clickSignUp() {
        if (driver.findElement(signUpLinkBy).isDisplayed()) {
            driver.findElement(signUpLinkBy).click();
        }
    }
}
