package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PageUtils;

import java.time.Duration;

public class RegisterPage extends BasePage {
    private final WebDriverWait wait;

    // ==== Constructor =========
    public RegisterPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageUtils.verifyPageTitle(driver, "Register");
    }

    private final By logoBy = By.cssSelector(".logo");
    private final By nameBy = By.name("name");
    private final By surnameBy = By.name("surname");
    private final By emailBy = By.name("email");
    private final By phoneNumberBy = By.name("phone_number");
    private final By addressBy = By.name("street_address");
    private final By postalCodeBy = By.name("postal_code");
    private final By cityBy = By.name("city");
    private final By countryBy = By.id("react-select-2-input");
    private final By passwordBy = By.name("password");
    private final By confirmPasswordBy = By.name("confirmPassword");
    private final By signUpButtonBy = By.tagName("button");
    private final By signInLinkBy = By.cssSelector(".signup");
    private final By termsCheckBoxBy = By.id("terms");

    public void clickLogo() {
        wait.until(ExpectedConditions.elementToBeClickable(logoBy)).click();
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(nameBy)).sendKeys(name);
    }

    public void enterSurname(String surname) {
        wait.until(ExpectedConditions.elementToBeClickable(surnameBy)).sendKeys(surname);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailBy)).sendKeys(email);
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberBy)).sendKeys(phone);
    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.elementToBeClickable(addressBy)).sendKeys(address);
    }

    public void enterPostalCode(String postalCode) {
        wait.until(ExpectedConditions.elementToBeClickable(postalCodeBy)).sendKeys(postalCode);
    }

    public void enterCity(String city) {
        wait.until(ExpectedConditions.elementToBeClickable(cityBy)).sendKeys(city);
    }

    public void enterCountry(String country) {
        wait.until(ExpectedConditions.elementToBeClickable(countryBy)).sendKeys(country);
        wait.until(ExpectedConditions.elementToBeClickable(countryBy)).sendKeys(Keys.ENTER);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordBy)).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordBy)).sendKeys(confirmPassword);
    }

    public void clickSignUp() {
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckBoxBy)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signUpButtonBy)).click();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLinkBy)).click();
    }
}
