package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[contains(@class, \"product-prices__big\")]")
    private WebElement priceField;

    public String  getPrice(){
        String str = priceField.getText();
        return str.substring(0, str.length() - 1).replaceAll(" ","");
    }
}
