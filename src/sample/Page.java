package sample; /**
 * Created by James on 4/13/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;
public class Page {

    String title;
    HashMap<String,String> sections;
    ArrayList<String> sectionNames;

    public Page(String title, HashMap<String,String> sections,ArrayList<String> sectionNames) {
        this.title = title;
        this.sections = sections;
        this.sectionNames =sectionNames;
    }

}
