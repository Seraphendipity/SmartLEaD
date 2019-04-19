package TreeExampleOnline;

import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author caleb
 */
public class AllPopUps extends FxTreeTableViewExample7 {

    public static String PopupAddBulbToGroup(String title, List<String> listofbulbs) {

        //Manually sets the stage    
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);
        window.setMinHeight(250);
        

        //Combo box for adding a new bulb to the system
        ComboBox allBulbsInSystemComboBox = new ComboBox();
        allBulbsInSystemComboBox.getItems().addAll(listofbulbs);
        allBulbsInSystemComboBox.setPromptText("Bulbs Connected to Hub");

        //Add button closes the window
        Button closeButton = new Button("Add");
        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(allBulbsInSystemComboBox, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        //returns the string of the name of the bulb wanting to be added to the group
        String newname = allBulbsInSystemComboBox.getValue().toString();
        return newname;
    }

    public static String PopupAddNewBulbToSystem(String title) {

        //Manually sets the stage    
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);
        window.setMinHeight(250);

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
        Button closeButton = new Button("Add");
        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(name, factoryId, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        //returns the string of the name of the new bulb
        String newname = name.getText();
        return newname;
    }

    public static String PopupNewGroup(String title) {

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
        Button closeButton = new Button("Add Group");
        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(name, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        //returns the string of the name of the bulb wanting to be added to the group
        String newname = name.getText();
        return newname;
    }

    public static String PopupPromptToAddNewBulbToNewGroup(String title, List listofbulbs) {

        //Manually sets the stage    
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);
        window.setMinHeight(250);

        Label mustadd = new Label();
        mustadd.setText("Add a Bulb to your new Group");

        //Combo box for adding a new bulb to the system
        ComboBox allBulbsInSystemComboBox = new ComboBox();
        allBulbsInSystemComboBox.getItems().addAll(listofbulbs);
        allBulbsInSystemComboBox.setPromptText("Bulbs Connected to Hub");

        //Add button closes the window
        Button closeButton = new Button("Add");
        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(mustadd, allBulbsInSystemComboBox, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        //returns the string of the name of the bulb wanting to be added to the group
        String newname = allBulbsInSystemComboBox.getValue().toString();
        return newname;
    }

}
