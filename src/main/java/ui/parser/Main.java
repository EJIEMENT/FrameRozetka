package ui.parser;

import ui.model.ProductModel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parser parser = new ParserFactory().getParser("json");
        ProductModel product = parser.readObject("src/main/resources/productModel");
        System.out.println(product);
        parser.writeObject("src/main/resources/productModelNew2",product);
        List<ProductModel> productModelList = parser.readProductModelList("src/main/resources/productsModel.json");
        System.out.println(productModelList);
        parser.writeProductModelList("src/main/resources/productsModelNew",productModelList);
    }
}
