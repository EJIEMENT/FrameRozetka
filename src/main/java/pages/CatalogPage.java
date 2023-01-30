package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends BasePage{
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = \"goods-tile__inner\"]")
    private List<WebElement> productList;
    @FindBy(xpath = "//button[@class='compare-button ng-star-inserted']")
    private List<WebElement> compareButton;

    public void clickOnFirstProduct(){
        productList.get(4).click();
    }
    public void addItemToWishList(){
        compareButton.stream().findFirst().get().click();
        compareButton.get(1).click();
    }

}
