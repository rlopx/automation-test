package testsSemCucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPositiveTests {
    @Test
    public void testLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://monetis-delta.vercel.app/login");

        LoginPage login = new LoginPage(driver);

//      WebElement emailInput = driver.findElement(By.name("email"));
//      emailInput.sendKeys("email@nttdata.com");
        login.enterEmail("email@nttdata.com");
//      WebElement passwordInput = driver.findElement(By.name("password"));
//      passwordInput.sendKeys("mYpassw0rd");
        login.enterPassword("mYpas$w0rd");
//      WebElement loginButton = driver.findElement(By.tagName("button"));
//      loginButton.click();
        login.clickLogin();

        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }
}
