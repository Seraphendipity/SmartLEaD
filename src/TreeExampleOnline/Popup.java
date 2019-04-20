/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  SmartLEaD.Item
 *  javafx.collections.ObservableList
 *  javafx.event.ActionEvent
 *  javafx.event.Event
 *  javafx.event.EventHandler
 *  javafx.geometry.Pos
 *  javafx.scene.Node
 *  javafx.scene.Parent
 *  javafx.scene.Scene
 *  javafx.scene.control.Button
 *  javafx.scene.control.ComboBox
 *  javafx.scene.control.TextField
 *  javafx.scene.control.TreeItem
 *  javafx.scene.layout.VBox
 *  javafx.stage.Modality
 *  javafx.stage.Stage
 */
package TreeExampleOnline;

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

public class Popup extends Controller {
    private static Stage initializePopup(String title) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350.0);
        window.setMinHeight(250.0);
        return window;
    }

    public static String addToGroupBulb(ArrayList<TreeItem<Item>> freeBulbsArr) {
        Stage window = Popup.initializePopup("Add Bulb to Group");
        ComboBox bulbsComboBox = new ComboBox();
        for (int i = 0; i > freeBulbsArr.size(); ++i) {
            bulbsComboBox.getItems().add((Object)((Item)freeBulbsArr.get(i).getValue()).getName());
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


}