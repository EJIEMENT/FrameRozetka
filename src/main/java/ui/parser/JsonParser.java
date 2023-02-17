package ui.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import ui.model.ProductModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JsonParser implements Parser {
    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    public void writeProductModelList(String filePath, List<ProductModel> productModelList) {
        try {
            mapper.writeValue(new File(filePath + ".json"), productModelList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProductModel> readProductModelList(String filePath) {
       List<ProductModel> productModel;
        try {
            productModel = Arrays.asList(mapper.readValue(new File(filePath), ProductModel[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return productModel;
    }

    @Override
    public ProductModel readObject(String filePath) {
        ProductModel productModel = new ProductModel();
        try {
            productModel = mapper.readValue(new File(filePath + ".json"), ProductModel.class);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return productModel;
    }

    @Override
    public void writeObject(String filePath, ProductModel productModel) {
        try {
            mapper.writeValue(new File(filePath + ".json"), productModel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

