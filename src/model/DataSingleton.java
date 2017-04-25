package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by James on 4/24/2017.
 */
public class DataSingleton {

    static DataSingleton data = new DataSingleton();
    //private HashMap<String,Section> sections;
    private ArrayList<Section> sections;
    private Section currentSection;
    private Page currentPage;


    private DataSingleton(){
        XMLParser parser = new XMLParser();
        sections = parser.parsePages();
        currentSection = null;
        currentPage = null;
        //currentPage = new XMLParser().parsePages().get(0);
    }

    public static DataSingleton getInstance(){
        return data;
    }

    public ArrayList<Page> getPagesForCurrentSection(){
        return currentSection.getPages();
    }

    public void setCurrentSection(Integer index) {
        if (index == null) {
            currentSection = null;
        } else {
            currentSection = sections.get(index);
        }
    }

    public Section getCurrentSection(){
        return currentSection;
    }




    public String getCurrentSectionName() {
       return currentSection.getName();
    }


    public Page getCurrentPage(){
        return currentPage;
    }

    public void setCurrentPage(Page page){
        currentPage = page;
    }




}
