/*
 * File: .java
 * Author: Caleb J Rudolph rudolph2@uab.edu
 * Assignment:  - EE333 Spring 2019
 * Vers: 1.0.0 01/14/2019 cjr - initial coding
 */
package TreeExampleOnline;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TreeTableView.TreeTableViewSelectionModel;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeTableCell;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.geometry.Insets;

public class FxTreeTableViewExample7 extends Application {
    // Create the TreeTableView

    private final TreeTableView<Item> treeTable = new TreeTableView<>();
    // Create a TextArea
    private final TextArea textarea = new TextArea();

    //ArrayList of Bulbs
    List<String> allbulbs = new ArrayList();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create the Root Node
        TreeItem<Item> rootNode = TreeTableUtil.getModel();
        rootNode.setExpanded(true);

        // Set the Properties of the Root Node
        treeTable.setRoot(rootNode);
        rootNode.setExpanded(true);
        treeTable.setPrefWidth(480);
        treeTable.setEditable(true);
        treeTable.getSelectionModel().selectFirst();

        // Create Columns with Cell Factories
        TreeTableColumn<Item, String> NameColumn = TreeTableUtil.getNameColumn();
        NameColumn.setCellFactory(TextFieldTreeTableCell.<Item>forTreeTableColumn());
        NameColumn.setEditable(false);

        TreeTableColumn<Item, String> ColorColumn = TreeTableUtil.getColorColumn();
        ColorColumn.setCellFactory(new Callback<TreeTableColumn<Item, String>, TreeTableCell<Item, String>>() {
            public TreeTableCell<Item, String> call(TreeTableColumn<Item, String> param) {
                TreeTableCell<Item, String> cell = new TreeTableCell<Item, String>() {
                    private ColorPicker colorPicker = new ColorPicker();

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {

                            setGraphic(colorPicker);
                            colorPicker.setValue(Color.WHITE);

                        }

                    }
                };
                return cell;
            }
        });

        //*******Possibly how to link gui to backend values*************
        ColorColumn.setOnEditCommit(e -> {
            TreeTableViewSelectionModel<Item> sm = treeTable.getSelectionModel();
            int rowIndex = sm.getSelectedIndex();
            TreeItem<Item> selectedItem = sm.getModelItem(rowIndex);
            sm.getSelectedItem().getValue().setColor(ColorColumn.getCellData(selectedItem));
        });

        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("On");
        list.add("Off");
        TreeTableColumn<Item, String> ComboColumn = TreeTableUtil.getStateColumn();
        ComboColumn.setCellFactory(new Callback<TreeTableColumn<Item, String>, TreeTableCell<Item, String>>() {
            public TreeTableCell<Item, String> call(TreeTableColumn<Item, String> param) {
                TreeTableCell<Item, String> cell = new TreeTableCell<Item, String>() {
                    private ComboBox combobox = new ComboBox(list);

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(combobox);
                            combobox.setValue("On");

                        }
                    }

                };
                return cell;
            }
        });
        
        ComboColumn.setOnEditCommit(e ->{
        TreeTableViewSelectionModel<Item> sm = treeTable.getSelectionModel();
            int rowIndex = sm.getSelectedIndex();
            TreeItem<Item> selectedItem = sm.getModelItem(rowIndex);
            sm.getSelectedItem().getValue().setState(ComboColumn.getCellData(selectedItem));
        
        });
        
        
        
        

        ObservableList<String> listBrightness = FXCollections.observableArrayList();
        listBrightness.add("1");
        listBrightness.add("2");
        listBrightness.add("3");
        listBrightness.add("4");
        listBrightness.add("5");
        listBrightness.add("6");
        listBrightness.add("7");
        listBrightness.add("8");
        listBrightness.add("9");
        listBrightness.add("10");
        TreeTableColumn<Item, String> ComboBrightnessColumn = TreeTableUtil.getBrightnessColumn();
        ComboBrightnessColumn.setCellFactory(new Callback<TreeTableColumn<Item, String>, TreeTableCell<Item, String>>() {
            public TreeTableCell<Item, String> call(TreeTableColumn<Item, String> param) {
                TreeTableCell<Item, String> cell = new TreeTableCell<Item, String>() {
                    private ComboBox comboBrightnessbox = new ComboBox(listBrightness);

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(comboBrightnessbox);
                            comboBrightnessbox.setValue("5");

                        }
                    }
                };
                return cell;
            }
        });
        
        ComboBrightnessColumn.setOnEditCommit(e ->{
        TreeTableViewSelectionModel<Item> sm = treeTable.getSelectionModel();
            int rowIndex = sm.getSelectedIndex();
            TreeItem<Item> selectedItem = sm.getModelItem(rowIndex);
            sm.getSelectedItem().getValue().setBrightness(ComboBrightnessColumn.getCellData(selectedItem));
        
        });
        
        
        

        // Add Columns to The TreeTableView
        treeTable.getColumns().add(NameColumn);
        treeTable.getColumns().add(ColorColumn);
        treeTable.getColumns().add(ComboColumn);
        treeTable.getColumns().add(ComboBrightnessColumn);

        // Add a placeholder to the TreeTableView.
        // It is displayed when the root node is deleted.
        treeTable.setPlaceholder(new Label("Click the Add button to add a row."));

        // Create the Label
        Label label = new Label("  Please select a group or bulb to add/delete.");

        // Create the HBox
        HBox hbox = this.getButtons();

        // Create the VBox
        VBox root = new VBox(label, hbox, treeTable);
        root.setSpacing(10);

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the Scene to the Stage
        stage.setScene(scene);
        // set unsizable
        stage.setResizable(false);
        // Set the Title
        stage.setTitle("Smart Bulb System");
        // display group members
        Label groupLabel = new Label(" Group 2 - Caleb Rudolph, Kyle Roberson, Elijah Rose");
        root.getChildren().add(groupLabel);
        // Display the Stage
        stage.show();

    }

    private HBox getButtons() {
        // Create the Buttons
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");

        // Create EventHandler for the Buttons
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                addRow();
            }

        });

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deleteRow();
            }
        });

        Insets buttonInset = new Insets(0, 0, 0, 6.5);
        HBox hb = new HBox(20, addButton, deleteButton);
        hb.setPadding(buttonInset);
        return hb;
    }

    private void addRow() {
        if (treeTable.getExpandedItemCount() == 0) {
            // There is no row in the TreeTableView
            addNewRootItem();
        } else if (treeTable.getSelectionModel().isEmpty()) {
            logging("Select a row to add.");

        } else if (treeTable.getTreeItemLevel(treeTable.getSelectionModel().getSelectedItem()) == 2) {
            //Bulb level item selected, do nothing, items cannot be added to bulbs

        } else if (treeTable.getTreeItemLevel(treeTable.getSelectionModel().getSelectedItem()) == 1
                && treeTable.getSelectionModel().getSelectedItem().getValue().getName().equals("All Bulbs")) {
            //Item Selescted is the All Bulbs Group 
            //Adding a bulb to the system by displaying a pop up where the user gives the name of bulb and the 
            //UID of the bulb. Returns a String of the name and adds that to the All Bulbs Group and also
            //adds the name to a list of strings that is used for the add to group combobox
            String n = AllPopUps.PopupAddNewBulbToSystem("Add New Bulb");
            if ("".equals(n)) {
                //do nothing
            } else {
                addNewToSystemChildItemBulb(n);
                allbulbs.add(n);
            }
        } else if (treeTable.getTreeItemLevel(treeTable.getSelectionModel().getSelectedItem()) == 1) {
            //Item Selected is a Group
            //Adding a Bulb to a group by giving a popup to the user with all the bulbs in the system. This is
            //done by passing the list allbulbs as on of parameters of the argument for the popup method, that way
            //an up to date list is generated in the combobox, Then creates a tree item using the string name of the bulb selected
            String n = AllPopUps.PopupAddBulbToGroup("Add Bulb to Group", allbulbs);
            addBulbToGroupChildItem(n);
            allbulbs.remove(n);
            //also remove bulb from "all bulb"

        } else if (treeTable.getTreeItemLevel(treeTable.getSelectionModel().getSelectedItem()) == 0) {
            //Item Selected is Groups (Root)
            //Prompts the User with one popup for creating a group by giving a name for the group
            //if they enter nothing it does nothing
            //If they enter a name they are further prompted to add a bulb to the system by selecting on
            //from a combobox
            String n = AllPopUps.PopupNewGroup("Add Group");
            if ("".equals(n)) {
                //do nothing
            } else {
                addGroupToRootChildItemBulb(n);
                String x = AllPopUps.PopupPromptToAddNewBulbToNewGroup("Add Bulb to New Group", allbulbs);
                allbulbs.remove(x);
                addBulbToGroupChildItem(x);

            }

        } else {
            // Add Child
            addNewChildItem();
        }
    }

    private void addNewRootItem() {
        // Add a root Item
        TreeItem<Item> item = new TreeItem<>(new Item("Groups", "", "", ""));
        treeTable.setRoot(item);

        // Edit the item
        this.editItem(item);
    }

    private void addNewChildItem() {

        // Prepare a new TreeItem with a new Item object
        TreeItem<Item> item = new TreeItem<>(new Item("New", "", "", ""));
        // Get the selection model
        TreeTableViewSelectionModel<Item> sm = treeTable.getSelectionModel();
        // Get the selected row index
        int rowIndex = sm.getSelectedIndex();
        // Get the selected TreeItem
        TreeItem<Item> selectedItem = sm.getModelItem(rowIndex);
        // Add the new item as children to the selected item
        selectedItem.getChildren().add(item);
        // Make sure the new item is visible
        selectedItem.setExpanded(true);
        // Edit the item
        this.editItem(item);
    }

    private void addNewToSystemChildItemBulb(String Name) {

        // Prepare a new TreeItem with a new Item object
        TreeItem<Item> item = new TreeItem<>(new Item(Name, "", "", ""));
        // Get the selection model
        TreeTableViewSelectionModel<Item> sm = treeTable.getSelectionModel();
        // Get the selected row index
        int rowIndex = sm.getSelectedIndex();
        // Get the selected TreeItem
        TreeItem<Item> selectedItem = sm.getModelItem(rowIndex);
        // Add the new item as children to the selected item
        selectedItem.getChildren().add(item);
        // Make sure the new item is visible
        selectedItem.setExpanded(true);
        // Edit the item
        this.editItem(item);
    }

    private void addGroupToRootChildItemBulb(String Name) {

        // Prepare a new TreeItem with a new Item object
        TreeItem<Item> item = new TreeItem<>(new Item(Name, "", "", ""));
        // Get the selection model
        TreeTableViewSelectionModel<Item> sm = treeTable.getSelectionModel();
        // Get the selected row index
        int rowIndex = sm.getSelectedIndex();
        // Get the selected TreeItem
        TreeItem<Item> selectedItem = sm.getModelItem(rowIndex);
        // Add the new item as children to the selected item
        selectedItem.getChildren().add(item);
        // Make sure the new item is visible
        selectedItem.setExpanded(true);
        // Edit the item
        this.editItem(item);
    }

    private void addBulbToGroupChildItem(String Name) {

        // Prepare a new TreeItem with a new Item object
        TreeItem<Item> item = new TreeItem<>(new Item(Name, "", "", ""));
        // Get the selection model
        TreeTableViewSelectionModel<Item> sm = treeTable.getSelectionModel();
        // Get the selected row index
        int rowIndex = sm.getSelectedIndex();
        // Get the selected TreeItem
        TreeItem<Item> selectedItem = sm.getModelItem(rowIndex);
        // Add the new item as children to the selected item
        selectedItem.getChildren().add(item);
        // Make sure the new item is visible
        selectedItem.setExpanded(true);
        // Edit the item
        this.editItem(item);
    }

    private void editItem(TreeItem<Item> item) {
        // Scroll to the new item
        int newRowIndex = treeTable.getRow(item);
        treeTable.scrollTo(newRowIndex);

        // Put the first column in editing mode
        TreeTableColumn<Item, ?> firstCol = treeTable.getColumns().get(0);
        treeTable.getSelectionModel().select(item);
        treeTable.getFocusModel().focus(newRowIndex, firstCol);
        treeTable.edit(newRowIndex, firstCol);
    }

    private void deleteRow() {
        // Get the selection model
        TreeTableViewSelectionModel<Item> sm = treeTable.getSelectionModel();
        if (sm.isEmpty()) {
            logging("Select a row to delete.");
            return;
        }

        // Get the selected Entry
        int rowIndex = sm.getSelectedIndex();
        TreeItem<Item> selectedItem = sm.getModelItem(rowIndex);
        TreeItem<Item> parent = selectedItem.getParent();

        if (sm.getTreeTableView().getTreeItemLevel(selectedItem) == 1 && !sm.getSelectedItem().getValue().getName().equals("All Bulbs")) {
            // If you have selected a group that is not the All Bulb group
            //Delete the group
            parent.getChildren().remove(selectedItem);
        } else if (sm.getTreeTableView().getTreeItemLevel(selectedItem) == 2 && sm.getSelectedItem().getParent().getValue().getName().equals("All Bulbs")) {
            //If you have selected a bulb in all bulbs remove all other instances
            //Delete the bulb but add 
            parent.getChildren().remove(selectedItem);
            allbulbs.remove(selectedItem.getValue().getName());
        } else if(sm.getTreeTableView().getTreeItemLevel(selectedItem) == 2 && !sm.getSelectedItem().getParent().getValue().getName().equals("All Bulbs")) {
            parent.getChildren().remove(selectedItem);
            allbulbs.add(selectedItem.getValue().getName());
            
        }
    }

    private void logging(String message) {
        this.textarea.appendText(message + "\n");
    }
}