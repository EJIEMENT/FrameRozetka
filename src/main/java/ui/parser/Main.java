package ui.parser;

import ui.model.Delivery;
import ui.model.LombokProduct;

public class Main {
    public static void main(String[] args) {
        JsonParser jsonParser = new JsonParser();
//        Parser parser = new ParserFactory().getParser("json");
//        ProductModel product = parser.readObject("src/main/resources/productModel");
//        System.out.println(product);
//        parser.writeObject("src/main/resources/productModelNew2",product);
//        List<ProductModel> productModelList = parser.readProductModelList("src/main/resources/productsModel.json");
//        System.out.println(productModelList);
//        parser.writeProductModelList("src/main/resources/productsModelNew",productModelList);
        jsonParser.writeLombokObject("src/main/resources/LombokProductDelivery",
                new LombokProduct("Phone", 778, "no",new Delivery(true,"Ukraine")));
        System.out.println(jsonParser.readLombokObject("src/main/resources/LombokProductDelivery"));
   }
}
