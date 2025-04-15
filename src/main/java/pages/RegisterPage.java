package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    protected WebDriver driver;

    private By logoBy = By.cssSelector(".logo");
    private By nameBy = By.name("name");
    private By surnameBy = By.name("surname");
    private By emailBy = By.name("email");
    private By phoneNumberBy = By.name("phone_number");
    private By addressBy = By.name("street_address");
    private By postalCodeBy = By.name("postal_code");
    private By cityBy = By.name("city");
    private By countryBy = By.id("react-select-2-input");
    private By passwordBy = By.name("password");
    private By confirmPasswordBy = By.name("confirmPassword");
    private By signUpButtonBy = By.tagName("button");
    private By signInLinkBy = By.cssSelector(".signup");

    public void clickLogo() {
        if (driver.findElement(logoBy).isDisplayed()) {
            driver.findElement(logoBy).click();
        }
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().contains("Register")) {
            throw new IllegalStateException("This is not the Register page, you're at " + driver.getCurrentUrl());
        }
    }

    public void enterName(String name) {
        driver.findElement(nameBy).sendKeys(name);
    }

    public void enterSurname(String surname) {
        driver.findElement(surnameBy).sendKeys(surname);
    }

    public void enterEmail(String email) {
        driver.findElement(emailBy).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneNumberBy).sendKeys(phone);
    }

    public void enterAddress(String address) {
        driver.findElement(addressBy).sendKeys(address);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(postalCodeBy).sendKeys(postalCode);
    }

    public void enterCity(String city) {
        driver.findElement(cityBy).sendKeys(city);
    }

    public void enterCountry(String country) {
        driver.findElement(countryBy).sendKeys(country);
        driver.findElement(countryBy).sendKeys(Keys.ENTER);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordBy).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordBy).sendKeys(confirmPassword);
    }

    public void clickSignUp() {
        if (driver.findElement(signUpButtonBy).isDisplayed()) {
            driver.findElement(signUpButtonBy).click();
        }
    }

    public void clickSignIn() {
        if (driver.findElement(signInLinkBy).isDisplayed()) {
            driver.findElement(signInLinkBy).click();
        }
    }
}
