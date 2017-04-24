package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jamesowens on 4/24/17.
 */
public class Section {

    String name;
    HashMap<String,ArrayList<Page>> pages;

    public Section(String name){
        this.name = name;
        this.pages = new HashMap<>();
    }

    public ArrayList<Page> getPagesForSection(String sectionName) {
        return pages.get(sectionName);
    }

    public void addPageToSection(String secName, Page page){
        if(pages.containsKey(secName)){
            pages.get(secName).add(page);
        } else {
            ArrayList<Page> newPageList = new ArrayList<>();
            newPageList.add(page);
            pages.put(secName,newPageList);
        }
    }



}
