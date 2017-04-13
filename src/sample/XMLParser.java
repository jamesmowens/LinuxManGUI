package sample;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by jamesowens on 4/11/17.
 */
public class XMLParser {

    Document doc;

    public XMLParser(){

        try {
            doc = this.makeDocBuilder().parse(new File("manpages.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private DocumentBuilder makeDocBuilder(){
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
        ArrayList<Page> pageList = new ArrayList<>();

        for(int i = 0; i<pageNodes.getLength();i++){
            Node pNode = pageNodes.item(i);
            if(pNode.getNodeType() == Node.ELEMENT_NODE){ //should always be true

                Element page = (Element) pNode;
                String pageName = page.getElementsByTagName("name").item(0).getTextContent();

                System.out.println("Title: "+pageName);
                System.out.println();

                NodeList sections = ((Element) pNode).getElementsByTagName("section");
                ArrayList<String> sectionNames = new ArrayList<>();
                HashMap<String,String> sectionContents = new HashMap<>();
                for(int j = 0; j<sections.getLength();j++){
                    Element section = (Element) sections.item(j);

                    String sectionName = section.getAttribute("name");
                    String sectionBody = section.getTextContent();

                    sectionNames.add(sectionName);
                    sectionContents.put(sectionName,sectionBody);

                    System.out.println("Section Name: " + sectionName);

                    System.out.println("Body: ");
                    System.out.println(section.getTextContent());

                    System.out.println();
                }
                pageList.add(new Page(pageName,sectionContents,sectionNames));
            }

        }

        return pageList;

    }


}
