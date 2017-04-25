package model; /**
 *
 *
 * This class represents a single man page
 */

import java.util.ArrayList;
import java.util.HashMap;
public class Page {

    //Basic indentifying characteristics
    String title;
    String sdesc;

    //the chunks of information
    HashMap<String,String> sections;
    ArrayList<String> sectionNames;

    public Page(String title, String sDesc, HashMap<String,String> sections,ArrayList<String> sectionNames) {
        this.title = title;
        this.sdesc = sDesc;
        this.sections = sections;
        this.sectionNames =sectionNames;
    }

    /**
     * Getter for the title
     * @return The title of the page
     */
    public String getTitle(){
        return title;
    }

    /**
     * Getter for the short description
     * @return The short description for the page
     */
    public String getSdesc(){return sdesc; }

    /**
     * Getter for the chunk names
     * @return A list of all the chunk names
     */
    public ArrayList<String> getChunkNames() {
        return sectionNames;
    }

    /**
     * Gets chunk text for a specific chunk name
     * @param key The name of the chunk
     * @return the text for the provided chunk
     */
    public String getChunkText(String key) {
        return sections.get(key);
    }



}
