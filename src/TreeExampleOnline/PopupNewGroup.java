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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author caleb
 */
public class PopupNewGroup extends FxTreeTableViewExample7 {
    
    
   public static String display(String title ){
        
    //Manually sets the stage    
    Stage window = new Stage();
    
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(350);
    window.setMinHeight(250);
   
    //TextField for inputting the name
    TextField name = new TextField();
    name.setEditable(true);
    name.setPromptText("Name for Group");
    
    
    
    //Add button closes the window
    Button closeButton = new Button ("Add Group");
    closeButton.setOnAction(e -> {
        window.close();
    });
    
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(name,closeButton);
    layout.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
       
    
    //returns the string of the name of the bulb wanting to be added to the group
    String newname = name.getText();
    return newname;
    }
    
    
}