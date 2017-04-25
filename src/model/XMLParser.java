package model;

import model.Page;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jamesowens on 4/11/17.
 */
public class XMLParser {

    Document doc;

    public XMLParser(){

        try {
            doc = this.makeDocBuilder().parse(new File("manpages.xml")); //create the document
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private DocumentBuilder makeDocBuilder(){

        //makes the document builder
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder;
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public ArrayList<Section> parsePages() {
        //get the page entry nodes
        //NodeList pageNodes = doc.getElementsByTagName("entry");
        ArrayList<Section> sectionList = new ArrayList<>();

        NodeList sectionNodes = doc.getElementsByTagName("section");

        for (int h = 0;h<sectionNodes.getLength();h++) {
            Node sNode = sectionNodes.item(h);
            if (sNode.getNodeType() == Node.ELEMENT_NODE) { //should always be true
                Element section = (Element) sNode;
                String sName = ((Element) sNode).getElementsByTagName("name").item(0).getTextContent();
                NodeList pageNodes = section.getElementsByTagName("entry");

                ArrayList<Page> pageList = new ArrayList<>();


                //for each page entry
                for (int i = 0; i < pageNodes.getLength(); i++) {
                    Node pNode = pageNodes.item(i);
                    if (pNode.getNodeType() == Node.ELEMENT_NODE) { //should always be true

                        Element page = (Element) pNode;
                        String pageName = page.getElementsByTagName("name").item(0).getTextContent(); //get the page name

                        String pageSDesc = page.getElementsByTagName("sdesc").item(0).getTextContent(); //get the page short description

                        System.out.println("Title: " + pageName);
                        System.out.println();

                        //get all the page sections
                        NodeList sections = ((Element) pNode).getElementsByTagName("chunk");
                        ArrayList<String> sectionNames = new ArrayList<>();
                        HashMap<String, String> sectionContents = new HashMap<>();
                        //for each page section
                        for (int j = 0; j < sections.getLength(); j++) {
                            Element chunk = (Element) sections.item(j);

                            String sectionName = chunk.getAttribute("name"); //get the name
                            String sectionBody = chunk.getTextContent(); //get the body

                            sectionNames.add(sectionName);
                            sectionContents.put(sectionName, sectionBody);

                            System.out.println("Section Name: " + sectionName);

                            System.out.println("Body: ");
                            System.out.println(chunk.getTextContent());

                            System.out.println();
                        }
                        //create page object and put it in the list
                        pageList.add(new Page(pageName, pageSDesc, sectionContents, sectionNames));
                    }

                }
                sectionList.add(new Section(sName,pageList));
            }
        }

        return sectionList;



    }


}
