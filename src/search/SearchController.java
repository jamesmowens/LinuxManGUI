package search;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.DataSingleton;


import java.io.IOException;

/**
 * Created by James on 4/25/2017.
 */
public class SearchController  {
    @FXML
    VBox container;

    /**
     * Transitions the current scene back to the man view (the starting view)
     */
    public void goToManView(){
        Stage stage = (Stage) container.getScene().getWindow();
        DataSingleton.getInstance().setCurrentSection(null);
        try{
            System.out.println("Attempting to change scene!");
            Parent parent = FXMLLoader.load(getClass().getResource("/man/sample.fxml"));
            stage.setScene(new Scene(parent,600,400));

        } catch (IOException e){
            System.err.println("Couldn't find the screen layout.");

        }
    }
}
