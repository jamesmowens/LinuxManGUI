package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by James on 4/24/2017.
 */
public class DataSingleton {

    static DataSingleton data = new DataSingleton();
    private HashMap<String,Section> sections;
    private String currentSection;


    private DataSingleton(){
        sections = new HashMap<>();
        currentSection = null;
    }

    public static DataSingleton getInstance(){
        return data;
    }


    public ArrayList<Page> getPagesForSection(String sectionName){
        return sections.get(sectionName).getPages();
    }

    public void setCurrentSection(String section){
        currentSection = section;
    }

    public String getCurrentSection(){
        return currentSection;
    }

    public ArrayList<Page> getExamplePages(){
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

    }


}
