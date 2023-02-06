package ui;

import logger.TestLogger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.database.DbHandler;
import ui.manager.DriverManager;
import ui.model.ProductModel;
import ui.pages.CatalogPage;
import ui.pages.HomePage;
import ui.pages.ProductPage;
import ui.pages.WishListPage;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class RozetkaTest {
    TestLogger logger = new TestLogger();
    List<ProductModel> products = DbHandler.getProductItems();
    DriverManager driverManager = new DriverManager();
    HomePage homePage = new HomePage(driverManager.getDriver());
    CatalogPage catalogPage = new CatalogPage(driverManager.getDriver());
    ProductPage productPage = new ProductPage(driverManager.getDriver());
    WishListPage wishListPage = new WishListPage(driverManager.getDriver());
    ProductModel powerStation = new ProductModel("powerstation", 100000);

    @BeforeMethod
    public void startDriver() {
        TestLogger.logInfo("driver start successes");
        driverManager.startDriver();
    }

    @Test
    public void itemTest() {
        TestLogger.logInfo("Start ItemTest test");
        homePage.searchItemModel(products.get(0).getItem());
        catalogPage.clickOnFirstProduct();
        assertTrue(Integer.parseInt(productPage.getPrice()) < products.get(0).getPrice());
    }

    @Test
    public void checkCountItemInWishlist() {
        TestLogger.logInfo("Start checkCountItemInWishlist test");
        homePage.searchItemModel(products.get(1).getItem());
        catalogPage.addItemToWishList();
        catalogPage.getTopBarMenuModule().openWishList();
        assertEquals(2, wishListPage.getWishListSize());
    }

    @AfterMethod
    public void closeDriver() {
        driverManager.closeDriver();
        TestLogger.logInfo("Driver close");
    }


}
