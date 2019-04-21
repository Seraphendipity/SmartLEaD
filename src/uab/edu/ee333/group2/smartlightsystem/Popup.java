/*
 * File: Popups.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  SmartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 04/20/2019 KAR - initial coding
 *
 * Credits:  (if any for sections of code)
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uab.edu.ee333.group2.smartlightsystem;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Popup extends Controller {
    private static Stage initializePopup(String title) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350.0);
        window.setMinHeight(250.0);
        return window;
    }

    public static String addToGroupBulb(ArrayList<String> bulbsList) {
        Stage window = Popup.initializePopup("Add Bulb to Group");
        ComboBox bulbsComboBox = new ComboBox();
        System.out.println(bulbsList);
        for (int i = 0; i < bulbsList.size(); i++) {
            bulbsComboBox.getItems().add(bulbsList.get(i));
        }
        bulbsComboBox.setPromptText("Bulbs Connected to Hub");
        Button closeButton = new Button("Add");
        closeButton.setOnAction(e -> window.close());
        VBox layout = new VBox(10.0);
        layout.getChildren().addAll(bulbsComboBox, closeButton);

        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene((Parent)layout);
        window.setScene(scene);
        window.showAndWait();
        return bulbsComboBox.getValue().toString();
    }

    public static String addBulbToHub() {
        Stage window = Popup.initializePopup("Add Bulb to Hub");
        TextField name = new TextField();
        name.setEditable(true);
        name.setPromptText("Name for Bulb");
        TextField factoryId = new TextField();
        factoryId.setEditable(true);
        factoryId.setPromptText("UID on Bulb Base");
        Button closeButton = new Button("Add");
        closeButton.setOnAction(e -> window.close());
        VBox layout = new VBox(10.0);
        layout.getChildren().addAll(name, closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene((Parent)layout);
        window.setScene(scene);
        window.showAndWait();
        String newname = name.getText();
        return newname;
    }

    public static String createNewGroup() {
        Stage window = Popup.initializePopup("Create New Group");
        TextField name = new TextField();
        name.setEditable(true);
        name.setPromptText("Name for Group");
        Button closeButton = new Button("Add Group");
        closeButton.setOnAction(e -> window.close());
        VBox layout = new VBox(10.0);
        layout.getChildren().addAll(name, closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene((Parent)layout);
        window.setScene(scene);
        window.showAndWait();
        String newname = name.getText();
        return newname;
    }
    
    public static String addBulbToGroup(List listofgroups) {
        //Manually sets the stage    
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add Bulb to Group");
        window.setMinWidth(350);
        window.setMinHeight(250);

        Label label1 = new Label();
        label1.setText("Can not create a group from a bulb.");
        
        Label label2 = new Label();
        label2.setText("Would you like to add this bulb to another group?");
        
        ComboBox allGroupsInSystemComboBox = new ComboBox();
        allGroupsInSystemComboBox.getItems().addAll(listofgroups);
        allGroupsInSystemComboBox.setPromptText("Groups");
        
        
        
        //Add button closes the window
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1,label2,allGroupsInSystemComboBox,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); 
        
        String newname= allGroupsInSystemComboBox.getValue().toString();
        return newname;
    }

    public static void help (){
      Stage window = new Stage();
      window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Help");
        window.setMinWidth(350);
        window.setMinHeight(250);
        
        TextArea helpArea = new TextArea();
        helpArea.setText("\n"
                + "Find the action you are trying to perform and read the instructions.\n"
                + "\n"
                + "Editing\n"
                + "============================================================================\n"
                + "To change the Color, State, or Brightness of a Bulb or Group- Click on the item you\n"
                + "are wanting to change and highlight it. Then in the corresponding column of the property\n"
                + "you wish to change use the selection box to change it.\n"
                + "\n"
                + "Adding\n"
                + "============================================================================\n"
                + "To Add a Bulb to the Smart Bulb System- Click and highlight the All Bulbs item\n"
                + "then press the Add button. You will be given a popup to fill out information about\n"
                + "the new bulb.\n"
                + "\n"
                + "To Add a Bulb to a group- Click and highlight the group you wish to add a bulb to\n"
                + "then press the Add button. You will be given a popup to select the bulb you wish to\n"
                + "add to the group.\n"
                + "\n"
                + "To Add a Group to the Smart Bulb System- Click and highlight the Groups item at the top\n"
                + "of the table then press the Add button. You will be given a popup to create your new group\n"
                + "followed by an additional popup to add the first bulb to the group.\n"
                + "\n"
                + "Deleting\n"
                + "============================================================================\n"
                + "To Delete a Bulb from a group- Click and expand the Group that contains the bulb you wish to remove\n"
                + "then click and highlight the bulb you wish to remove and press the Delete button.\n"
                + "\n"
                + "To Delete a Group from the System- Click and highlight the group you wish to delete and press the\n"
                + "Delete button.\n"
                + "");
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(helpArea);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait(); 
           
    }


}