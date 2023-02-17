package ui.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import ui.manager.DriverManager;
import ui.pages.CatalogPage;
import ui.pages.HomePage;
import ui.pages.ProductPage;
import ui.pages.WishListPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MyStepDefinitions {
    DriverManager driverManager = new DriverManager();
    private HomePage homePage = new HomePage(driverManager.getDriver());
    private CatalogPage catalogPage = new CatalogPage(driverManager.getDriver());
    private WishListPage wishListPage = new WishListPage(driverManager.getDriver());
    private ProductPage productPage = new ProductPage(driverManager.getDriver());

    @Given("User open rozetka home page")
    public void openRozetkaHomePage() {
        driverManager.startDriver();

    }

    @And("User search item by {string}")
    public void inputInSearchFieldItem(String item) {
        homePage.searchItemModel(item);
    }

    @And("User add two product to wish list")
    public void addTwoProductInWishList() {
        catalogPage.addItemToWishList();
    }

    @And("User is navigate to wish list")
    public void openWishList() {
        catalogPage.getTopBarMenuModule().openWishList();
    }

    @And("User choose first product")
    public void getFirstProduct() {
        catalogPage.clickOnFirstProduct();
    }

    @Then("There should be the price less than {string}")
    public void checkProductPrice(String price) {
        assertTrue(Integer.parseInt(productPage.getPrice()) < Integer.parseInt(price));
    }

    @Then("There should be two products in wish list")
    public void checkCountOfProductInWishList() {
        assertEquals(2, wishListPage.getWishListSize());
    }

    @After
    public void closeDriver() {
        driverManager.closeDriver();
    }
}
