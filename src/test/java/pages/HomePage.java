package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import java.security.Key;

public class HomePage extends BasePage {

    private By searchLocator = By.cssSelector("input[id='searchData']");
    public WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void open() {
        driver.get("https://www.n11.com/");
    }
    public void searchKey(String telephone) {
        closeAllAcceptPopup();
        WebElement search = driver.findElement(searchLocator);
        search.click();
        search.sendKeys(telephone);
        search.sendKeys(Keys.ENTER);
    }


}
