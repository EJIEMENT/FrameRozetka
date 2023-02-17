package ui.parser;

import ui.model.ProductModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class XmlParser implements Parser {

    @Override
    public void writeProductModelList(String filePath, List<ProductModel> productModelList) {
    }

    @Override
    public List<ProductModel> readProductModelList(String filePath) {
        return null;
    }

    @Override
    public ProductModel readObject(String filePath) {
        File xmlFile = new File(filePath + ".xml");
        ProductModel productModel = null;
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(ProductModel.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            productModel = (ProductModel) jaxbUnmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return productModel;
    }

    @Override
    public void writeObject(String filePath, ProductModel productModel) {
        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(ProductModel.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File(filePath + ".xml");

            //Writes XML file to file-system
            jaxbMarshaller.marshal(productModel, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}