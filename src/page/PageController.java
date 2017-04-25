package page;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.DataSingleton;
import model.Page;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by James on 4/24/2017.
 */
public class PageController implements Initializable {

    @FXML
    Label titleLabel;
    @FXML
    VBox container;

    Page page;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        page = DataSingleton.getInstance().getCurrentPage();
        ArrayList<String> chunkNames = page.getChunkNames();

        titleLabel.setText(page.getTitle());

        for(String chunkName: chunkNames) {
            Label chunkLabel = new Label(chunkName);
            chunkLabel.setFont(Font.font(24));

            Text chunkText = new Text(page.getChunkText(chunkName));
            chunkText.setWrappingWidth(550);
            container.getChildren().addAll(chunkLabel,chunkText);
        }

    }

    public void goBackToSectionView(){
        Stage stage = (Stage) container.getScene().getWindow();
        DataSingleton.getInstance().setCurrentPage(null);
        if(DataSingleton.getInstance().getCurrentSection() == null){
            System.out.println("well that makes sense!");
        }
        try{
            System.out.println("Attempting to change scene!");
            Parent parent = FXMLLoader.load(getClass().getResource("/section/section.fxml"));
            stage.setScene(new Scene(parent,600,400));

        } catch (IOException e){
            System.err.println("Couldn't find the screen layout.");

        }
    }

}
