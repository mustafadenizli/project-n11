package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {

    private By buyButtonLocator = By.cssSelector("span[class='btn btnPrimary mb2']");
    private By okeyButtonLocator = By.cssSelector("span[class='btn btnBlack']");

    public WebDriver driver;
    public BasketPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickBuyButton() {
        findElement(okeyButtonLocator).click();
        findElement(buyButtonLocator).click();
    }

}
