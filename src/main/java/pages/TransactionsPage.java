package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransactionsPage {
    private WebDriver driver;

    // == Constructor ===========
    public TransactionsPage(WebDriver driver) {
        this.driver = driver;
    }

    // == Page Root =============
    private By pageContainer = By.cssSelector(".transactions");

    // == Page Header ===========
    private By pageTitle = By.xpath("//h1[text()='Transactions']");

    // == Sidebar Navigation ====
    private By dashboardLink = By.xpath("//span[text()='Dashboard']");
    private By transferLink = By.xpath("//span[text()='Transfer']");
    private By paymentsLink = By.xpath("//span[text()='Payments']");
    private By transactionsLink = By.xpath("//span[text()='Transactions']");
    private By accountsLink = By.xpath("//span[text()='Accounts']");
    private By settingsLink = By.xpath("//span[text()='Settings']");
    private By logoutButton = By.xpath("//button//span[text()='Log out']");

    // == Transactions Content ==
    private By transactionsList = By.cssSelector(".transactions-list");
    private By noDataMessage = By.cssSelector(".transactions-list .no-data");

    // (Future-proof selector if transactions appear as rows/cards)
    private By transactionItems = By.cssSelector(".transactions-list > div");

    // == Filters Section =======
    private By filtersSection = By.cssSelector(".filters");

    // == Loader  ===============
    private By loadingScreen = By.cssSelector(".loading_screen");

    // ==========================
    // Page Actions
    // ==========================
    public boolean isPageLoaded() {
        return driver.findElement(pageContainer).isDisplayed()
                && driver.findElement(pageTitle).isDisplayed();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    // ==========================
    // Navigation Actions
    // ==========================
    public void goToDashboard() {
        driver.findElement(dashboardLink).click();
    }

    public void goToTransfer() {
        driver.findElement(transferLink).click();
    }

    public void goToPayments() {
        driver.findElement(paymentsLink).click();
    }

    public void goToAccounts() {
        driver.findElement(accountsLink).click();
    }

    public void goToSettings() {
        driver.findElement(settingsLink).click();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }

    // ==========================
    // Transactions Validations
    // ==========================
    public boolean isNoDataMessageDisplayed() {
        return driver.findElement(noDataMessage).isDisplayed();
    }

    public String getNoDataMessageText() {
        return driver.findElement(noDataMessage).getText();
    }

    public int getNumberOfTransactions() {
        List<WebElement> items = driver.findElements(transactionItems);
        return items.size();
    }

    // ==========================
    // Loader Handling
    // ==========================
    public boolean isLoaderVisible() {
        return driver.findElement(loadingScreen).isDisplayed();
    }
}
