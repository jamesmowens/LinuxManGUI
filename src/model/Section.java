package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jamesowens on 4/24/17.
 */
public class Section {

    String name;
    ArrayList<Page> pages;

    public Section(String name){
        this.name = name;
        this.pages = new ArrayList<>();
    }

    public Section(String name,ArrayList<Page> pages) {
        this.name = name;
        this.pages = pages;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void addPageToSection(Page page){
        pages.add(page);
    }

    public String getName() {
        return name;
    }


}
