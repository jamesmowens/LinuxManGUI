package sample;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

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

    public ArrayList<Page> parsePages() {
        NodeList pageNodes = doc.getElementsByTagName("entry");
        for(int i = 0; i<pageNodes.getLength();i++){
            Node pNode = pageNodes.item(i);
            if(pNode.getNodeType() == Node.ELEMENT_NODE){ //should always be true
                Element page = (Element) pNode;

                System.out.println("Title: "+
                page.getElementsByTagName("name").item(0).getTextContent());
                System.out.println();

                NodeList sections = ((Element) pNode).getElementsByTagName("section");
                for(int j = 0; j<sections.getLength();j++){
                    Element section = (Element) sections.item(j);

                    System.out.println("Section Name: " + section.getAttribute("name"));

                    System.out.println("Body: ");
                    System.out.println(section.getTextContent());

                    System.out.println();
                }
            }

        }
        return null;

    }


}
