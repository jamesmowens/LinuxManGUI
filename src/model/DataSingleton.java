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



   /* public Section getExampleSection(){
        return new Section("User Commands",getExamplePages());
    }*/

    public String getCurrentSectionName() {
       return currentSection.getName();
    }

   /* public ArrayList<Page> getExamplePages(){
        Page p1 = new Page("Page 1",new HashMap<>(),new ArrayList<>());
        Page p2 = new Page("Page 2",new HashMap<>(),new ArrayList<>());
        Page p3 = new Page("Page 3",new HashMap<>(),new ArrayList<>());
        Page p4 = new Page("Page 4",new HashMap<>(),new ArrayList<>());

        ArrayList<Page> pages =  new ArrayList<>();
        pages.add(p1);
        pages.add(p2);
        pages.add(p3);
        pages.add(p4);

        return pages;
    }*/

    public Page getCurrentPage(){
        return currentPage;
    }

    public void setCurrentPage(Page page){
        currentPage = page;
    }




}
