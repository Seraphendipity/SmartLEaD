/*
 * File: FxTreeTableViewExample7.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  GroupProject - EE333 Spring 2019
 * Vers: 1.0.0 04/16/2019 KAR - initial coding
 *
 * Credits:  (if any for sections of code)
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeExampleOnline;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
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
import javafx.stage.Stage;
import javafx.util.Callback;

public class FxTreeTableViewExample7 extends Application {
    // Create the TreeTableView

    private final TreeTableView<Item> treeTable = new TreeTableView<>();
    // Create a TextArea
    private final TextArea textarea = new TextArea();

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
        treeTable.setPrefWidth(400);
        treeTable.setEditable(true);
        treeTable.getSelectionModel().selectFirst();

        // Create Columns with Cell Factories
        TreeTableColumn<Item, String> NameColumn = TreeTableUtil.getNameColumn();
        NameColumn.setCellFactory(TextFieldTreeTableCell.<Item>forTreeTableColumn());

        TreeTableColumn<Item, String> ColorColumn = TreeTableUtil.getColorColumn();
        //ColorColumn.setCellFactory(TextFieldTreeTableCell.<Item>forTreeTableColumn());

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
                            
                        }
                    }
                };
                return cell;
            }
        });
        
      
        

        // Add Columns to The TreeTableView
        treeTable.getColumns().add(NameColumn);
        treeTable.getColumns().add(ColorColumn);

        // Add a placeholder to the TreeTableView.
        // It is displayed when the root node is deleted.
        treeTable.setPlaceholder(new Label("Click the Add button to add a row."));

        // Create the Label
        Label label = new Label("Please select a group or bulb to add/delete.");

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

        // Create and return the HBox
        return new HBox(20, addButton, deleteButton);
    }

    private void addRow() {
        if (treeTable.getExpandedItemCount() == 0) {
            // There is no row in the TreeTableView
            addNewRootItem();
        } else if (treeTable.getSelectionModel().isEmpty()) {
            logging("Select a row to add.");
            return;
        } else if (treeTable.getTreeItemLevel(treeTable.getSelectionModel().getSelectedItem()) == 2) {
            //bulb do nothing
        } else if (treeTable.getTreeItemLevel(treeTable.getSelectionModel().getSelectedItem()) == 1) {
            //a group add new bulb
            addNewChildItemBulb();
        } else if (treeTable.getTreeItemLevel(treeTable.getSelectionModel().getSelectedItem()) == 0) {
            //root add new group
            addNewChildItemGroup();
        } else {
            // Add Child
            addNewChildItem();
        }
    }

    private void addNewRootItem() {
        // Add a root Item
        TreeItem<Item> item = new TreeItem<>(new Item("Groups", ""));
        treeTable.setRoot(item);

        // Edit the item
        this.editItem(item);
    }

    private void addNewChildItem() {

        // Prepare a new TreeItem with a new Item object
        TreeItem<Item> item = new TreeItem<>(new Item("New", "New"));
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

    private void addNewChildItemGroup() {

        // Prepare a new TreeItem with a new Item object
        TreeItem<Item> item = new TreeItem<>(new Item("New Group", "White"));
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

    private void addNewChildItemBulb() {

        // Prepare a new TreeItem with a new Item object
        TreeItem<Item> item = new TreeItem<>(new Item("New Bulb", "White"));
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

        if (parent != null) {
            // Remove the Item
            parent.getChildren().remove(selectedItem);
        } else {
            // Must be deleting the Root Item
            treeTable.setRoot(null);
        }
    }

    private void logging(String message) {
        this.textarea.appendText(message + "\n");
    }
}

