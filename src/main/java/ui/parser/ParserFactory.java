package ui.parser;

public class ParserFactory {
    public Parser getParser(String parserType){
        if(parserType.equalsIgnoreCase("JSON")){
            return new JsonParser();
        } else if (parserType.equalsIgnoreCase("XML")) {
            return new XmlParser();
        }
        return null;
    }
}
