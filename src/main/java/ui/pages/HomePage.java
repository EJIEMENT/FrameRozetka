package ui.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name = \"search\"]")
    private WebElement searchField;

    public void searchItemModel(String itemModel){
        searchField.sendKeys(itemModel);
        searchField.sendKeys(Keys.RETURN);
    }
}
