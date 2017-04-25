package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jamesowens on 4/24/17.
 *
 * This class represents a Section of the manual
 */
public class Section {

    String name; //the section name
    ArrayList<Page> pages; //the pages contained in the section


    public Section(String name){
        this.name = name;
        this.pages = new ArrayList<>();
    }

    public Section(String name,ArrayList<Page> pages) {
        this.name = name;
        this.pages = pages;
    }

    /**
     * Getter for the pages in the section
     * @return A list of pages in the section
     */
    public ArrayList<Page> getPages() {
        return pages;
    }

    /**
     * Adds a page to the section
     * @param page The page to add
     */
    public void addPageToSection(Page page){
        pages.add(page);
    }

    /**
     * Getter for the name
     * @return the name of the section
     * @return the name of the section
     */
    public String getName() {
        return name;
    }


}
