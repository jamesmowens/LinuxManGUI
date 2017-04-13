package sample;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 * Created by jamesowens on 4/11/17.
 */
public class XMLParser {

    Document doc;

    public XMLParser(){

        try {
            doc = this.makeDocBuuilder().parse(new File("manpages.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private DocumentBuilder makeDocBuuilder(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }


}
