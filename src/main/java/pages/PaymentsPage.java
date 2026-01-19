package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // ---------------- Constructor ----------------
    public PaymentsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------------- Page Header ----------------
    private By pageTitle = By.xpath("//h1[normalize-space()='Payments']");

    // ---------------- Step Indicator ----------------
    private By detailsStep = By.xpath("//div[contains(@class,'status')]//span[text()='Details']");
    private By confirmationStep = By.xpath("//div[contains(@class,'status')]//span[text()='Confirmation']");
    private By successStep = By.xpath("//div[contains(@class,'status')]//span[text()='Success']");

    // ---------------- Form Fields ----------------
    private By transactionDateInput = By.name("effectivedate");
    private By entityInput = By.name("entity");
    private By referenceInput = By.name("reference");
    private By categoryLabel = By.xpath("//label[text()='Category']");
    private By amountInput = By.name("amount");

    // ---------------- Buttons ----------------
    private By nextButton = By.xpath("//button[normalize-space()='Next']");

    // ---------------- Navigation ----------------
    private By logoutButton = By.xpath("//button//span[normalize-space()='Log out']");

    // ==================================================
    // Page Validations
    // ==================================================

    public boolean isPaymentsPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }

    public boolean isDetailsStepActive() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(detailsStep)).isDisplayed();
    }

    // ==================================================
    // Form Actions
    // ==================================================

    public String getTransactionDate() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(transactionDateInput))
                .getAttribute("value");
    }

    public void enterEntity(String entity) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(entityInput));
        field.clear();
        field.sendKeys(entity);
    }

    public void enterReference(String reference) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(referenceInput));
        field.clear();
        field.sendKeys(reference);
    }

    public void enterAmount(String amount) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(amountInput));
        field.clear();
        field.sendKeys(amount);
    }

    // ==================================================
    // Navigation Actions
    // ==================================================
    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}