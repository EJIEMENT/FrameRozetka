import logger.TestLogger;
import manager.DriverManager;
import model.ProductModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CatalogPage;
import pages.HomePage;
import pages.ProductPage;
import pages.WishListPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RozetkaTest {
    TestLogger logger = new TestLogger();
    DriverManager driverManager = new DriverManager();
    HomePage homePage = new HomePage(driverManager.getDriver());
    CatalogPage catalogPage = new CatalogPage(driverManager.getDriver());
    ProductPage productPage = new ProductPage(driverManager.getDriver());
    WishListPage wishListPage = new WishListPage(driverManager.getDriver());
    ProductModel powerStation = new ProductModel("powerstation", 100000);

    @BeforeEach
    public void startDriver() {
        TestLogger.logInfo("driver start successes");
        driverManager.startDriver();
    }

    @Test
    public void itemTest() {
        TestLogger.logInfo("Start ItemTest test");
        homePage.searchItemModel(powerStation.getItem());
        catalogPage.clickOnFirstProduct();
        assertTrue(Integer.parseInt(productPage.getPrice()) < powerStation.getPrice());
    }

    @Test
    public void checkCountItemInWishlist() {
        TestLogger.logInfo("Start checkCountItemInWishlist test");
        homePage.searchItemModel(powerStation.getItem());
        catalogPage.addItemToWishList();
        catalogPage.getTopBarMenuModule().openWishList();
        assertEquals(2, wishListPage.getWishListSize());
    }

    @AfterEach
    public void closeDriver() {
        driverManager.closeDriver();
        TestLogger.logInfo("Driver close");
    }


}
