package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {

    // ==== Constructor =========
    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    // ==========================
    // Page Root & Header
    // ==========================
    private By pageContainer = By.cssSelector(".settings");
    private By pageTitle = By.xpath("//h1[text()='Settings']");

    // ==========================
    // Tabs
    // ==========================
    private By tabsContainer = By.cssSelector(".tabs");
    private By personalInfoTab = By.xpath("//span[text()='Personal information']");
    private By changePasswordTab = By.xpath("//span[text()='Change Password']");
    private By deleteAccountTab = By.xpath("//span[text()='Delete account']");

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
    // Loader & Toast
    // ==========================
    private By loadingScreen = By.cssSelector(".loading_screen");
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
    // Tabs Actions
    // ==========================
    public void openPersonalInformation() {
        driver.findElement(personalInfoTab).click();
    }

    public void openChangePassword() {
        driver.findElement(changePasswordTab).click();
    }

    public void openDeleteAccount() {
        driver.findElement(deleteAccountTab).click();
    }

    // ==========================
    // Navigation
    // ==========================
    public void goToDashboard() {
        driver.findElement(dashboardLink).click();
    }

    public void goToAccounts() {
        driver.findElement(accountsLink).click();
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