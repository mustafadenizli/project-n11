package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage{
    private By loginModalLocator = By.cssSelector("div[class='login-modal']");

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void checkLoginPage() {
        WebElement okeyButton = findElement(loginModalLocator);
        Assert.assertTrue(okeyButton.isDisplayed(),"login page görünmüyor.");
    }
}
