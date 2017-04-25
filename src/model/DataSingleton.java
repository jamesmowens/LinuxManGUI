package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by James on 4/24/2017.
 * This class holds all of the data and state for the applcation. This way it is insure that these things are
 * kept constant
 */
public class DataSingleton {

    static DataSingleton data = new DataSingleton();

    //Data for the app
    private ArrayList<Section> sections;

    //State for the app
    private Section currentSection;
    private Page currentPage;


    private DataSingleton(){
        XMLParser parser = new XMLParser();
        sections = parser.parsePages();
        currentSection = null;
        currentPage = null;
    }

    /**
     * rovides an entry points for interacting with the singleton
     */
    public static DataSingleton getInstance(){
        return data;
    }

    /**
     * Gets the pages for the currently selected section
     * @return A list of pages that are in the currently selected section
     */
    public ArrayList<Page> getPagesForCurrentSection(){
        return currentSection.getPages();
    }

    /**
     * Sets the current section to the one at a given index
     * @param index The index of the section to set
     */
    public void setCurrentSection(Integer index) {
        if (index ==  null || index>=sections.size()) {
            currentSection = null;
        } else {
            currentSection = sections.get(index);
        }
    }

    /**
     * Getter for the current sectio0n
     * @return The current section
     */
    public Section getCurrentSection(){
        return currentSection;
    }



    /**
     * Getter for current section's name
     * @return The name of the current section
     */
    public String getCurrentSectionName() {
       return currentSection.getName();
    }


    /**
     * Getter for the current page
     * @return The current page
     */
    public Page getCurrentPage(){
        return currentPage;
    }

    /**
     * Setter for current page
     * @param page the new current page
     */
    public void setCurrentPage(Page page){
        currentPage = page;
    }




}
