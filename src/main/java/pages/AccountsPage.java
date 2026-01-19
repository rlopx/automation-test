package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountsPage extends BasePage {
    private WebDriver driver;

    // ==== Constructor =========
    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    // ==========================
    // Page Root
    // ==========================
    private By pageContainer = By.cssSelector(".accounts");

    // ==========================
    // Page Header
    // ==========================
    private By pageTitle = By.xpath("//h1[text()='Accounts']");

    // ==========================
    // Total Balance Section
    // ==========================
    private By totalBalanceContainer = By.cssSelector(".totalBalance");
    private By totalBalanceLabel = By.cssSelector(".totalBalance .total");
    private By totalBalanceCurrency = By.xpath("//div[@class='totalBalance']//span[contains(text(),'EUR')]");

    // ==========================
    // Accounts List
    // ==========================
    private By accountsBalanceContainer = By.cssSelector(".accounts_balance");

    // (Future-proof selector for account cards)
    private By accountItems = By.cssSelector(".accounts_balance > div");

    // ==========================
    // Sidebar Navigation
    // ==========================
    private By dashboardLink = By.xpath("//span[text()='Dashboard']");
    private By transferLink = By.xpath("//span[text()='Transfer']");
    private By paymentsLink = By.xpath("//span[text()='Payments']");
    private By transactionsLink = By.xpath("//span[text()='Transactions']");
    private By accountsLink = By.xpath("//span[text()='Accounts']");
    private By settingsLink = By.xpath("//span[text()='Settings']");
    private By logoutButton = By.xpath("//button//span[text()='Log out']");

    // ==========================
    // Loader
    // ==========================
    private By loadingScreen = By.cssSelector(".loading_screen");

    // ==========================
    // New Account Dialog
    // ==========================
    private By newAccountDialog = By.cssSelector(".dialog");
    private By dialogTitle = By.xpath("//h2[text()='New Account']");
    private By closeDialogButton = By.cssSelector(".dialog .header svg");

    private By effectiveDateInput = By.xpath("//label[text()='Effective Date']/following-sibling::input");
    private By accountHolderInput = By.xpath("//label[text()='Account Holder']/following-sibling::input");
    private By accountNameInput = By.xpath("//label[text()='Account Name']/following-sibling::input");
    private By initialDepositInput = By.xpath("//label[text()='Initial Deposit']/following::input[@name='amount']");
    private By createAccountButton = By.xpath("//button[@type='submit' and text()='Create account']");

    // ==========================
    // Toast Notifications
    // ==========================
    private By toastContainer = By.cssSelector(".Toastify");

    // ==========================
    // Page Validations
    // ==========================
    public boolean isPageLoaded() {
        return driver.findElement(pageContainer).isDisplayed()
                && driver.findElement(pageTitle).isDisplayed();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    // ==========================
    // Total Balance Actions
    // ==========================
    public boolean isTotalBalanceDisplayed() {
        return driver.findElement(totalBalanceContainer).isDisplayed();
    }

    public String getTotalBalanceLabel() {
        return driver.findElement(totalBalanceLabel).getText();
    }

    public String getTotalBalanceCurrency() {
        return driver.findElement(totalBalanceCurrency).getText();
    }

    // ==========================
    // Accounts List Actions
    // ==========================
    public boolean isAccountsListDisplayed() {
        return driver.findElement(accountsBalanceContainer).isDisplayed();
    }

    public int getNumberOfAccounts() {
        List<WebElement> accounts = driver.findElements(accountItems);
        return accounts.size();
    }

    // ==========================
    // New Account Dialog Actions
    // ==========================
    public boolean isNewAccountDialogVisible() {
        return driver.findElement(newAccountDialog).isDisplayed();
    }

    public void closeNewAccountDialog() {
        driver.findElement(closeDialogButton).click();
    }

    public void createNewAccount(String accountName, String initialDeposit) {
        driver.findElement(accountNameInput).sendKeys(accountName);
        driver.findElement(initialDepositInput).clear();
        driver.findElement(initialDepositInput).sendKeys(initialDeposit);
        driver.findElement(createAccountButton).click();
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

    public void goToTransactions() {
        driver.findElement(transactionsLink).click();
    }

    public void goToSettings() {
        driver.findElement(settingsLink).click();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }

    // ==========================
    // Loader & Toast
    // ==========================
    public boolean isLoaderVisible() {
        return driver.findElement(loadingScreen).isDisplayed();
    }

    public boolean isToastDisplayed() {
        return driver.findElement(toastContainer).isDisplayed();
    }
}