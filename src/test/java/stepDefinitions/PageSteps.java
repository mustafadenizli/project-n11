package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.time.Duration;
import java.util.Set;

public class PageSteps {
    private StoresPage storesPage;
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private BasketPage basketPage;
    private LoginPage loginPage;
    public WebDriver driver;
    @Before
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    // stores
    @Given("user on the stores page")
    public void user_on_the_stores_page() throws InterruptedException {
        storesPage = new StoresPage(driver);
        storesPage.open();
    }
    @When("user click on the all stores button")
    public void user_click_on_the_all_stores_button() {
        storesPage.clickAllStoresButton();
    }
    @And("user choose the store that starts with the letter {string}")
    public void user_choose_the_store_that_starts_with_the_letter(String letter) {
        storesPage.selectLetter(letter);
    }
    @When("user click on a random store")
    public void user_click_on_a_random_store() {
        storesPage.clickRandomStore();
    }
    @Then("user view the referred store")
    public void user_view_the_referred_store() {
        storesPage.checkReferredStore();
    }

    //Homepage
    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        homePage = new HomePage(driver);
        homePage.open();
    }
    @When("user searches for {string}")
    public void user_searches_for(String telephone) {
        homePage.searchKey(telephone);
    }

    //SearchResultPage
    @Then("user search results should contain {string}")
    public void user_is_on_the_home_page(String result) {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.checkResultSearch(result);
    }
    @When("user adds the first product to the cart")
    public void user_adds_the_first_product_to_the_cart() throws InterruptedException {
        searchResultPage.addFirstProduct();
    }
    @And("user adds the last product to the cart")
    public void user_adds_the_last_product_to_the_cart() {
        searchResultPage.addLastProduct();
    }
    @And("user goes to the shopping cart")
    public void user_goes_to_the_shopping_cart() {
        searchResultPage.goBasket();
    }

    //basketpage
    @And("user proceeds to checkout as a guest")
    public void user_proceeds_to_checkout_as_a_guest() {
        basketPage = new BasketPage(driver);
        basketPage.clickBuyButton();
    }

    //loginpage
    @Then("user is redirected to the payment page")
    public void user_is_redirected_to_the_payment_page() {
        loginPage = new LoginPage(driver);
        loginPage.checkLoginPage();
    }
    @When("user selects the second brand")
    public void user_selects_the_second_brand() {
        searchResultPage.addSecondBrand();
    }
    @When("user sorts the results by review count")
    public void user_sorts_the_results_by_review_count() {
        searchResultPage.selectSorting();
    }
    @Then("user sorting is correct")
    public void user_sorting_is_correct() {
        searchResultPage.checkSortingCorrect();
    }
    @When("user filters for free shipping")
    public void user_filters_for_free_shipping() {
        searchResultPage.selectFreeShipping();
    }
    @Then("user results should only contain products with free shipping")
    public void user_results_should_only_contain_products_with_free_shipping() {
        searchResultPage.checkFreeShippingProducts();
    }




}
