package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePage {
    private WebDriver driver;

    // ==== Constructor =========
    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    // ==========================
    // Page Root & Header
    // ==========================
    private By pageContainer = By.cssSelector(".user_account");
    private By pageTitle = By.xpath("//h1[text()='Account']");
    private By backButton = By.cssSelector(".top svg");

    // ==========================
    // Account Actions
    // ==========================
    private By actionsSection = By.cssSelector(".actions");
    private By withdrawAction = By.xpath("//div[@class='action']//div[text()='Withdraw']");
    private By topUpAction = By.xpath("//div[@class='action']//div[text()='Top up']");
    private By editAction = By.xpath("//div[@class='action']//div[text()='Edit']");
    private By deleteAction = By.xpath("//div[@class='action']//div[text()='Delete']");

    // ==========================
    // Loader
    // ==========================
    private By loadingScreen = By.cssSelector(".loading_screen");

    // ==========================
    // Withdraw Dialog
    // ==========================
    private By withdrawDialog = By.xpath("//h2[text()='Withdraw amount']/ancestor::div[contains(@class,'dialog')]");
    private By withdrawAmountInput = By.xpath("//h2[text()='Withdraw amount']/ancestor::form//input[@required]");
    private By withdrawSubmitBtn = By.xpath("//button[text()='Withdraw']");
    private By withdrawCloseBtn = By.xpath("//h2[text()='Withdraw amount']/following-sibling::svg");

    // ==========================
    // Top Up Dialog
    // ==========================
    private By topUpDialog = By.xpath("//h2[text()='Top up account']/ancestor::div[contains(@class,'dialog')]");
    private By topUpAmountInput = By.xpath("//h2[text()='Top up account']/ancestor::form//input[@required]");
    private By topUpSubmitBtn = By.xpath("//button[text()='Top up']");
    private By topUpCloseBtn = By.xpath("//h2[text()='Top up account']/following-sibling::svg");

    // ==========================
    // Edit Account Dialog
    // ==========================
    private By editDialog = By.xpath("//h2[text()='Edit account']/ancestor::div[contains(@class,'dialog')]");
    private By accountNameInput = By.xpath("//label[text()='Account name']/following-sibling::input");
    private By updateAccountBtn = By.xpath("//button[text()='Update']");

    // ==========================
    // Delete Account Dialog
    // ==========================
    private By deleteDialog = By.xpath("//h2[text()='Delete account']/ancestor::div[contains(@class,'dialog')]");
    private By deleteConfirmBtn = By.xpath("//button[contains(@class,'delete')]");
    private By deleteCancelBtn = By.xpath("//button[text()='Cancel']");

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
    // Account Actions
    // ==========================
    public void openWithdrawDialog() {
        driver.findElement(withdrawAction).click();
    }

    public void openTopUpDialog() {
        driver.findElement(topUpAction).click();
    }

    public void openEditDialog() {
        driver.findElement(editAction).click();
    }

    public void openDeleteDialog() {
        driver.findElement(deleteAction).click();
    }

    // ==========================
    // Withdraw
    // ==========================
    public boolean isWithdrawDialogVisible() {
        return driver.findElement(withdrawDialog).isDisplayed();
    }

    public void withdraw(String amount) {
        driver.findElement(withdrawAmountInput).sendKeys(amount);
        driver.findElement(withdrawSubmitBtn).click();
    }

    // ==========================
    // Top Up
    // ==========================
    public boolean isTopUpDialogVisible() {
        return driver.findElement(topUpDialog).isDisplayed();
    }

    public void topUp(String amount) {
        driver.findElement(topUpAmountInput).sendKeys(amount);
        driver.findElement(topUpSubmitBtn).click();
    }

    // ==========================
    // Edit Account
    // ==========================
    public boolean isEditDialogVisible() {
        return driver.findElement(editDialog).isDisplayed();
    }

    public void editAccountName(String newName) {
        driver.findElement(accountNameInput).clear();
        driver.findElement(accountNameInput).sendKeys(newName);
        driver.findElement(updateAccountBtn).click();
    }

    // ==========================
    // Delete Account
    // ==========================
    public boolean isDeleteDialogVisible() {
        return driver.findElement(deleteDialog).isDisplayed();
    }

    public void confirmDeleteAccount() {
        driver.findElement(deleteConfirmBtn).click();
    }

    public void cancelDeleteAccount() {
        driver.findElement(deleteCancelBtn).click();
    }

    // ==========================
    // Navigation
    // ==========================
    public void goBackToAccounts() {
        driver.findElement(backButton).click();
    }

    public void goToTransactions() {
        driver.findElement(transactionsLink).click();
    }

    public void logout() {
        driver.findElement(logoutButton).click();
    }

    // ==========================
    // Utilities
    // ==========================
    public boolean isLoaderVisible() {
        return driver.findElement(loadingScreen).isDisplayed();
    }

    public boolean isToastDisplayed() {
        return driver.findElement(toastContainer).isDisplayed();
    }
}
