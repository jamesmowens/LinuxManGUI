package model; /**
 * Created by James on 4/13/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;
public class Page {

    String title;
    String sdesc;
    HashMap<String,String> sections;
    ArrayList<String> sectionNames;

    public Page(String title, String sDesc, HashMap<String,String> sections,ArrayList<String> sectionNames) {
        this.title = title;
        this.sdesc = sDesc;
        this.sections = sections;
        this.sectionNames =sectionNames;
    }

    public String getTitle(){
        return title;
    }

    public String getSdesc(){return sdesc; }

    public ArrayList<String> getChunkNames() {
        return sectionNames;
    }

    public String getChunkText(String key) {
        return sections.get(key);
    }



}
