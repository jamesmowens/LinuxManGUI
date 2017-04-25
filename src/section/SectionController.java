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

    //FXML outlets
    @FXML
    VBox container;
    @FXML
    Label titleLabel;

    //The pages in the section
    ArrayList<Page> pages;


    /**
     * Sets up all the parts of the screen that need to be setup when loaded
     * Specifically creates, formats, and displays all the page cells for the section that was just selected
     */
    public void initialize(URL location, ResourceBundle resources) {
        titleLabel.setText(DataSingleton.getInstance().getCurrentSectionName());

        pages = DataSingleton.getInstance().getPagesForCurrentSection();
        for(int i =0; i<pages.size();i++){

            HBox hbox = new HBox();
            //hbox.setPadding(new Insets(15, 12, 15, 12));
            hbox.setSpacing(10);
            hbox.setStyle("-fx-border-color: lightgray");
            hbox.setPadding(new Insets(0,0,0,10));
            hbox.setPrefSize(600,100);
            hbox.setAlignment(Pos.CENTER_LEFT);
            final int index = i;
            hbox.setOnMouseClicked(e->selectRowAtIndex(index));


            Label title = new Label(pages.get(i).getTitle());
            hbox.getChildren().add(title);
            title.setFont(Font.font(24));

            Label desc = new Label(pages.get(i).getSdesc());
            desc.setFont(Font.font(18));
            desc.setTextFill(Color.web("#d3d3d3"));

            hbox.getChildren().add(desc);

            container.getChildren().add(hbox);
            container.requestLayout();
        }

    }

    /**
     * Called by the cell when it is clicked this sets the current page to the one that was just sleected
     * @param index The index of the cell that was selected
     */
    private void selectRowAtIndex(int index){

        System.out.println(index);
        DataSingleton.getInstance().setCurrentPage(pages.get(index));

        goToPageView();
    }


    /**
     * Goes back to the man veiew
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

    /**
     * When a page in selected this transitions the current scene to the page view for the selected page
     */
    public void goToPageView(){
        Stage stage = (Stage) container.getScene().getWindow();
        try{
            System.out.println("Attempting to change scene!");
            Parent parent = FXMLLoader.load(getClass().getResource("/page/page.fxml"));
            stage.setScene(new Scene(parent,600,400));

        } catch (IOException e){
            System.err.println("Couldn't find the screen layout.");

        }
    }

}
