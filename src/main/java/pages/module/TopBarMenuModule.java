package pages.module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class TopBarMenuModule extends BasePage {
    public TopBarMenuModule(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class=\"header-actions__item header-actions__item--comparison\"]")
    private WebElement buttonCompareItem;
    @FindBy(xpath = "//a[@class='comparison-modal__link']")
    private WebElement compareLink;
    @FindBy(xpath = "//button[contains(@class, \"comparison-modal__remove\")]//*[local-name()='svg']")
    private WebElement buttonDeleteFromWishList;
    @FindBy(xpath = "//div[@class= \"comparison-modal__dummy ng-star-inserted\"]")
    private WebElement emptyMessageWishList;


    public void openWishList(){
        buttonCompareItem.click();
        compareLink.click();
    }
    public void clickOnButtonDeleteFromWishList(){
        buttonCompareItem.click();
        waitVisibilityOfElement(10,buttonDeleteFromWishList);
        buttonDeleteFromWishList.click();
    }
    public boolean isEmptyMessagePresent(){
        return emptyMessageWishList.isDisplayed();
    }
}
