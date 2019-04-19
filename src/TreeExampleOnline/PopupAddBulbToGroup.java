/*
 * File: .java
 * Author: Caleb J Rudolph rudolph2@uab.edu
 * Assignment:  - EE333 Spring 2019
 * Vers: 1.0.0 01/14/2019 cjr - initial coding
 */
package TreeExampleOnline;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author caleb
 */
public class PopupAddBulbToGroup extends FxTreeTableViewExample7 {
    
    public static String display(String title, List<String> listofbulbs ){
        
    //Manually sets the stage    
    Stage window = new Stage();
    
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(350);
    window.setMinHeight(250);
   

    
    //Combo box for adding a new bulb to the system
    ComboBox allBulbsInSystemComboBox = new ComboBox ();
    allBulbsInSystemComboBox.getItems().addAll(listofbulbs);
    allBulbsInSystemComboBox.setPromptText("Bulbs Connected to Hub");
    
    //Add button closes the window
    Button closeButton = new Button ("Add");
    closeButton.setOnAction(e -> {
        window.close();
    });
    
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(allBulbsInSystemComboBox,closeButton);
    layout.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
       
    
    //returns the string of the name of the bulb wanting to be added to the group
    String newname = allBulbsInSystemComboBox.getValue().toString();
    return newname;
    }
    
    
}