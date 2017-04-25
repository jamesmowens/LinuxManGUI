package man;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.DataSingleton;

import java.io.IOException;

public class Controller {

    @FXML
    BorderPane root;

    public void usrCmdsSelected(){
        System.out.println("User Commands!");
        DataSingleton.getInstance().setCurrentSection(0);
        goToSectionView();
    }

    public void sysCmdsSelected(){
        DataSingleton.getInstance().setCurrentSection(1);
        System.out.println("System Commands!");
    }
    public void cLibsSelected() {
        DataSingleton.getInstance().setCurrentSection(2);
        System.out.println("C Library Functions!");
    }

    public void goToSectionView(){
        Stage stage = (Stage) root.getScene().getWindow();
        try{
            System.out.println("Attempting to change scene!");
            Parent parent = FXMLLoader.load(getClass().getResource("/section/section.fxml"));
            stage.setScene(new Scene(parent,600,400));

        } catch (IOException e){
            System.err.println("Couldn't find the screen layout.");

        }
    }

}
