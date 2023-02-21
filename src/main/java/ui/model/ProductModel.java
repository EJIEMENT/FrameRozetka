package ui.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "productModel")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ProductModel {
    private String item;
    private Integer price;
    private String isAvailable;

    public ProductModel(String item, Integer price, String isAvailable) {
        this.item = item;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public ProductModel() {
    }

    public ProductModel(String item, Integer price) {
        this.item = item;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "item='" + item + '\'' +
                ", price=" + price +
                ", isAvailable='" + isAvailable + '\'' +
                '}';
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getItem() {
        return item;
    }

    public Integer getPrice() {
        return price;
    }

    public String getIsAvailable() {
        return isAvailable;
    }
}
