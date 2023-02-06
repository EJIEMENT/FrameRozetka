package ui.database;

import ui.model.ProductModel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DbHandler.getDbConnection();
//        DbHandler.executeSecondTask();
//        DbHandler.executeThirdTask();
       List<ProductModel> productModels = DbHandler.getProductItems();
        System.out.println(productModels);
    }

}
