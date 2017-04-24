package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Page;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Bolier plate javafx code not relevent to checkpoint
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        XMLParser parser = new XMLParser();
        //--------------------------------------------------

        //create parser object and parse xml
        ArrayList<Page> pages = parser.parsePages();
        Page pageToDisplay = pages.get(0); //when the GUI is implemented

    }


    public static void main(String[] args) {
        launch(args);
    }
}
