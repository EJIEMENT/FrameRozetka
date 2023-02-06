package ui.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import logger.TestLogger;
import ui.database.DbHandler;
import ui.model.ProductModel;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Parser {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        TestLogger.logInfo(readProductFromFile().toString());
        TestLogger.logInfo(convertObjectToJson());
        TestLogger.logInfo(readProductFromDb());
    }

    public static String readProductFromDb() throws JsonProcessingException {
        List<ProductModel> products = DbHandler.getProductItems();
        return mapper.writeValueAsString(products);

    }

    public static String convertObjectToJson() throws JsonProcessingException {
        return mapper.writeValueAsString(new ProductModel("powerstation", 2000, "yes"));

    }

    public static List<ProductModel> readProductFromFile() throws IOException {
        return Arrays.asList(mapper.readValue(new File("src/main/resources/productModel.json"), ProductModel[].class));
    }
}

