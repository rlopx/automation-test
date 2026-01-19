package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage {

    private WebDriver driver;

    // ==========================
    // Constructor
    // ==========================
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================
    // Locators
    // ==========================

    // Page identification
    private By welcomeHeader = By.tagName("h1");

    // Navigation (left menu)
    private By dashboardMenu = By.xpath("//span[text()='Dashboard']");
    private By transferMenu = By.xpath("//span[text()='Transfer']");
    private By paymentsMenu = By.xpath("//span[text()='Payments']");
    private By transactionsMenu = By.xpath("//span[text()='Transactions']");
    private By accountsMenu = By.xpath("//span[text()='Accounts']");
    private By settingsMenu = By.xpath("//span[text()='Settings']");
    private By logoutButton = By.xpath("//button[.//span[text()='Log out']]");

    // Logo
    private By logoImage = By.cssSelector("img.logo");

    // Panels & content
    private By statisticsTitle = By.xpath("//h2[text()='Statistics (10 last days)']");
    private By transactionsTitle = By.xpath("//h2[text()='Transactions']");
    private By noTransactionsMessage = By.cssSelector(".transaction-list .no-data");

    // Generic error locator (future-proof)
    private By errorElements = By.cssSelector("[class*='error']");

    // Loading screen
    private By loadingScreen = By.cssSelector(".loading_screen");

    // ==========================
    // Page Actions
    // ==========================

    /**
     * Returns the welcome header text
     */
    public String getWelcomeText() {
        return driver.findElement(welcomeHeader).getText();
    }

    /**
     * Verifies if the dashboard page is loaded
     */
    public boolean isDashboardDisplayed() {
        return driver.findElement(welcomeHeader)
                .getText()
                .contains("Welcome");
    }

    /**
     * Clicks on Logout button
     */
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    /**
     * Checks whether the logo is visible
     */
    public boolean isLogoDisplayed() {
        return driver.findElement(logoImage).isDisplayed();
    }

    /**
     * Checks if the "No Transactions" message is displayed
     */
    public boolean isNoTransactionsMessageDisplayed() {
        return driver.findElement(noTransactionsMessage).isDisplayed();
    }

    // ==========================
    // Error Handling Logic
    // ==========================

    /**
     * Returns all elements that contain 'error' in their class name
     */
    public List<WebElement> getErrorElements() {
        return driver.findElements(errorElements);
    }

    /**
     * Returns true if validation or UI errors are present
     */
    public boolean hasErrors() {
        return !getErrorElements().isEmpty();
    }

    /**
     * Prints all error messages to console
     */
    public void printErrorsToConsole() {
        List<WebElement> errors = getErrorElements();
        for (WebElement error : errors) {
            System.out.println("❌ Error: " + error.getText().trim());
        }
    }

    // ==========================
    // Loading Screen Handling
    // ==========================

    /**
     * Checks whether loading screen is visible
     */
    public boolean isLoadingScreenVisible() {
        List<WebElement> loader = driver.findElements(loadingScreen);
        return !loader.isEmpty() && loader.get(0).isDisplayed();
    }
}