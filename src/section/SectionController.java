package section;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.DataSingleton;
import model.Page;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by James on 4/23/2017.
 */
public class SectionController implements Initializable {

    @FXML
    VBox content;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<Page> pages = DataSingleton.getInstance().getExamplePages();
        for(int i =0; i<pages.length){

        }



    }
}
