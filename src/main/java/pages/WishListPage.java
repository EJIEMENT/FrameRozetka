package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage{
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class=\"products-grid__cell ng-star-inserted\"]")
    private List<WebElement> wishList;

    public int getWishListSize(){
        return wishList.size();
    }
}
