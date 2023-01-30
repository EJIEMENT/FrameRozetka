package model;

public class ProductModel {
    private  String item;
    private Integer price;

    public ProductModel(String item, Integer price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }


    public Integer getPrice() {
        return price;
    }

}
