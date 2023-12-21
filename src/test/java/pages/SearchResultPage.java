package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class SearchResultPage extends BasePage {
    public WebDriver driver;

    private By searchResultLocator = By.cssSelector("div[class='resultText ']>h1");
    private By addBasketIconLocator = By.cssSelector(" span[class='btnBasket']");
    private By colorsLocator = By.cssSelector("div[id='skus-807542307']>label");
    private By internalMemoryLocator = By.cssSelector("div[id=\"skus-807542306\"]>label");
    private By addBasketButtonLocator = By.cssSelector("span[id='js-addBasketSku']");
    private By myBasketLocator = By.cssSelector("a[class='myBasket basket-icon custom-icon']");

    private By brandsLocator = By.cssSelector("div[class='filterItem customCheckWrap  wl']>a");
    private By sortSelectLocator = By.cssSelector("div[class='custom-select']");
    private By numberOfCommentsLocator = By.cssSelector("div[class='item i4']");
    private By commentAmountsLocator = By.cssSelector("div[class='proDetail']>div>span:nth-of-type(2)");

    private By shippingOptionsLocator = By.xpath("/html/body/div[1]/div[4]/div/div[2]/div[1]/section[15]");
    private By freeShippingLocator = By.cssSelector("label[id='freeShipmentOption']");
    private By freeShippingProductsLocator = By.cssSelector("span[class='cargoBadgeText']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void checkResultSearch(String result) {
        WebElement searchResult = findElement(searchResultLocator);
        Assert.assertEquals(searchResult.getText(), result);
    }

    public void addFirstProduct() throws InterruptedException {
        scroll();
        findElements(addBasketIconLocator).get(0).click();
        findElements(colorsLocator).get(0).click();
        findElements(internalMemoryLocator).get(0).click();
        Thread.sleep(500);
        findElement(addBasketButtonLocator).click();
    }

    public void addLastProduct() {
       findElements(addBasketIconLocator).get(20).click();
    }

    public void goBasket() {
        findElement(myBasketLocator).click();
    }

    public void addSecondBrand() {
        findElements(brandsLocator).get(1).click();
    }

    public void selectSorting() {
        findElement(sortSelectLocator).click();
        findElement(numberOfCommentsLocator).click();
    }

    public void checkSortingCorrect() {
        verifyCommentSorting();
    }

    public void selectFreeShipping() {
        findElement(shippingOptionsLocator).click();
        findElement(freeShippingLocator).click();
    }
    public void checkFreeShippingProducts() {
        List<WebElement> freeShippingProducts = findElements(freeShippingProductsLocator);
        Assert.assertTrue(freeShippingProducts.size() > 0, "Ücretsiz kargo olan ürün bulunamadı.");
    }
}


