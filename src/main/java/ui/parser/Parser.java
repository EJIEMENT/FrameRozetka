package ui.parser;

import ui.model.ProductModel;

import java.util.List;

public interface Parser {
    void writeProductModelList(String filePath, List<ProductModel> productModelList);

    List<ProductModel> readProductModelList(String filePath);

    ProductModel readObject(String filePath);

    void writeObject(String filePath, ProductModel productModel);

}
