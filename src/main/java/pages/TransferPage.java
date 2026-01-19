package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // ---------- Constructor ----------
    public TransferPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- Page Title ----------
    private By pageTitle = By.xpath("//h1[text()='Transfer']");

    // ---------- Select Account ----------
    private By accountSelect = By.xpath("//input[starts-with(@id, 'react-select-2')]");
    private By accountBalance = By.xpath("//*[@class='item balance']/text()[1]");
    private By accountIBAN = By.xpath("//span[normalize-space()='IBAN']/following-sibling::text()[1]");
    private By seeAccountDetails = By.xpath("//button[text()='See account details']");

    // ---------- Account Type Radio Buttons ----------
    private By otherAccountOption = By.xpath("//span[text()='Other Account']");
    private By ownAccountOption = By.xpath("//span[text()='Own Account']");

    // ---------- Target Account Dropdown (React Select) ----------
    private By targetAccountDropdown = By.xpath("//div[contains(@class,'select')]");
    private By targetAccountInput = By.xpath("//input[@aria-autocomplete='list']");

    // ---------- Form Fields ----------
    private By ibanInput = By.name("iban");
    private By amountInput = By.name("amount");
    private By transactionDateInput = By.name("effectivedate");

    // ---------- Buttons ----------
    private By nextButton = By.xpath("//button[normalize-space()='Next']");

    // ---------- Status Steps ----------
    private By detailsStep = By.xpath("//span[text()='Details']");
    private By confirmationStep = By.xpath("//span[text()='Confirmation']");
    private By successStep = By.xpath("//span[text()='Success']");

    // ---------- Navigation ----------
    private By logoutButton = By.xpath("//button//span[text()='Log out']");

    // ==========================================================
    // Page Actions
    // ==========================================================

    public boolean isTransferPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }

    public void selectOtherAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(otherAccountOption)).click();
    }

    public void selectOwnAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(ownAccountOption)).click();
    }

    public void selectTargetAccount(String accountName) {
        wait.until(ExpectedConditions.elementToBeClickable(targetAccountDropdown)).click();
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(targetAccountInput));
        input.sendKeys(accountName);
        input.sendKeys("\n");
    }

    public void enterIban(String iban) {
        WebElement ibanField = wait.until(ExpectedConditions.visibilityOfElementLocated(ibanInput));
        ibanField.clear();
        ibanField.sendKeys(iban);
    }

    public void enterAmount(String amount) {
        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
        amountField.clear();
        amountField.sendKeys(amount);
    }

    public String getTransactionDate() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(transactionDateInput))
                .getAttribute("value");
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public boolean isDetailsStepActive() {
        return driver.findElement(detailsStep).isDisplayed();
    }

    public boolean isConfirmationStepVisible() {
        return driver.findElement(confirmationStep).isDisplayed();
    }

    public boolean isSuccessStepVisible() {
        return driver.findElement(successStep).isDisplayed();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}