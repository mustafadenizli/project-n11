package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMinutes(10));
    }
    protected WebElement waitForVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    protected WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    protected List<WebElement> findElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    protected void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
    }
    protected void findElementsClick(By by, String letter) {
        List<WebElement> letters = findElements(by);
        for (WebElement element : letters) {
            if (element.getText().equals(letter)) {
                element.click();
                break;
            }
        }
    }
    public void verifyCommentSorting() {
        By commentAmountsLocator = By.cssSelector("div[class='proDetail']>div>span:nth-of-type(2)");
        List<Integer> commentCountsList = getCommentCounts(commentAmountsLocator);
        List<Integer> sortedCommentCounts = new ArrayList<>(commentCountsList);
        Collections.sort(sortedCommentCounts, Collections.reverseOrder());

        if (commentCountsList.equals(sortedCommentCounts)) {
            System.out.println("Ürünler doğru bir şekilde sıralanmış.");
        } else {
            System.out.println("Ürünler yanlış bir şekilde sıralanmış.");
        }
    }
    private List<Integer> getCommentCounts(By locator) {
        List<WebElement> commentAmounts = findElements(locator);
        List<Integer> commentCountsList = new ArrayList<>();

        for (WebElement commentAmount : commentAmounts) {
            String cleanedText = commentAmount.getText().replaceAll("[^\\d]", "");
            int values = Integer.parseInt(cleanedText);
            commentCountsList.add(values);
        }
        return commentCountsList;
    }
    public void closeAllAcceptPopup() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement acceptButton = (WebElement) js.executeScript("return document.querySelector('efilli-layout-dynamic').shadowRoot.querySelector('div[id=\"480698fc-e6ac-41bc-a722-51059b783200\"]');");
            acceptButton.click();
    }
}
