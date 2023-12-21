package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;

public class StoresPage extends BasePage {
    private By allStoresLocator = By.cssSelector("div[class='tab']>ul>li>div>h3");
    private By lettersLocator = By.cssSelector("div[class='letters']>span");
    private By storesLocator = By.cssSelector("div[class='tabPanel allSellers']>div:nth-of-type(2)>ul>li>a");
    private By searchResultLocator = By.cssSelector("div[class='resultText ']>h1");
    public StoresPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.n11.com/magazalar");
        closeAllAcceptPopup();
    }

    public void clickAllStoresButton() {
        scroll();
        findElements(allStoresLocator).get(3).click();
    }
    public void selectLetter(String letter) {
        findElementsClick(lettersLocator,letter);
    }

    public void clickRandomStore() {
        List<WebElement> stores = findElements(storesLocator);
        int randomIndex = new Random().nextInt(stores.size());
        stores.get(randomIndex).click();
    }
    public void checkReferredStore() {
        WebElement expected = driver.findElement(searchResultLocator);
        Assert.assertTrue(driver.getTitle().contains(expected.getText()));
    }
}
