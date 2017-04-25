package section;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.DataSingleton;
import model.Page;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by James on 4/23/2017.
 */
public class SectionController implements Initializable {

    @FXML
    VBox container;
    @FXML
    Label titleLabel;

    ArrayList<Page> pages;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleLabel.setText(DataSingleton.getInstance().getCurrentSectionName());

        pages = DataSingleton.getInstance().getExamplePages();
        for(int i =0; i<pages.size();i++){
            System.out.println("Hello");

            HBox hbox = new HBox();
            //hbox.setPadding(new Insets(15, 12, 15, 12));
            hbox.setSpacing(10);
            hbox.setStyle("-fx-border-color: lightgray");
            //hbox.setStyle("-fx-background-color: #336699;");
            hbox.setPadding(new Insets(0,0,0,10));
            hbox.setPrefSize(600,100);
            hbox.setAlignment(Pos.CENTER_LEFT);
            final int index = i;
            hbox.setOnMouseClicked(e->selectRowAtIndex(index));


            Label title = new Label(pages.get(i).getTitle());
            hbox.getChildren().add(title);
            title.setFont(Font.font(24));

            Label desc = new Label("This is a decription");
            desc.setFont(Font.font(18));
            desc.setTextFill(Color.web("#d3d3d3"));

            hbox.getChildren().add(desc);

            container.getChildren().add(hbox);
            System.out.println("Goods");
            container.requestLayout();
        }

    }

    private void selectRowAtIndex(int index){
        System.out.println(index);
    }

    public void tester(){
        System.out.println("Called");
        if(container!=null){
            System.out.println("Works");
        }
    }

    public void goBackToSectionView(){
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
