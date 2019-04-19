/*
 * File: AddBulbToSystemPopup.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  HelloJDK - EE333 Spring 2019
 * Vers: 1.0.0 04/15/2019 KAR - initial coding
 *
 * Credits:  (if any for sections of code)
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uab.ee333.group2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddBulbToSystemPopup {
    
    public static String display(String title ){
        
    //Manually sets the stage    
    Stage window = new Stage();
    
    window.initModality(Modality.APPLICATION_MODAL); // 
    window.setTitle(title);
    window.setMinWidth(350);
   
    //TextField for inputting the name
    TextField name = new TextField();
    name.setEditable(true);
    name.setPromptText("Name for Bulb");
   
    //TextField for inputting the factoryID of the bulb
    //Does nothing with it "It is not accessable to the user to avoid them from tampering"
    //if we reformat we can add a section where this will be saved somehow
    TextField factoryId = new TextField();
    factoryId.setEditable(true);
    factoryId.setPromptText("UID on Bulb Base");
    
    //Add button closes the window
    Button closeButton = new Button ("Add");
    closeButton.setOnAction(e -> {
        window.close();
    });
    
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(name,factoryId,closeButton);
    layout.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
    
    //returns the string of the name of the new bulb
    String newname = name.getText();
    return newname;
    }
    
}