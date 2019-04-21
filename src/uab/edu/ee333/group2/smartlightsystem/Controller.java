/*
 * File: Controller.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  Controller - EE333 Spring 2019
 * Vers: 
 * 1.0.0 04/20/2019 KAR - initial coding
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
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
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

public class Controller extends Application {
    // Create the TreeTableView
    private String allGroupName = "Misc. Bulbs";
    private TreeItem<Item> allGroup;

    private final TreeTableView<Item> treeTable = new TreeTableView<>();
    // Create a TextArea
    private final TextArea textarea = new TextArea();

    // ArrayList of the free Bulbs
    ArrayList<TreeItem<Item>> freeBulbsArr = new ArrayList();
    // ArrayList of the groupsArr
    ArrayList<TreeItem<Item>> groupsArr = new ArrayList<>();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create the Root Node
        TreeItem<Item> rootNode = TreeTableUtil.getModel(allGroupName);
        rootNode.setExpanded(true);
        treeTable.setRoot(rootNode);
        rootNode.setExpanded(true);
        treeTable.setPrefWidth(480);
        treeTable.setEditable(true);
        treeTable.getSelectionModel().selectFirst();
        
        for (int i = 0; i < treeTable.getRoot().getChildren().size(); i++) {
            groupsArr.add(treeTable.getRoot().getChildren().get(i));
        }
        
        this.allGroup = getItemByName(allGroupName, groupsArr);
        
        // NAME
//        ObservableList<Item> data = 
        TreeTableView<Item> tableView = new TreeTableView<>();
        
        TreeTableColumn<Item, String> NameColumn = TreeTableUtil.getColumnString("Name");
        NameColumn.setCellFactory(TextFieldTreeTableCell.<Item>forTreeTableColumn());
        NameColumn.setEditable(false);

       
        
        TreeTableColumn<Item, String> ColorColumn = TreeTableUtil.getColumnString("Color");
        ColorColumn.setCellFactory((TreeTableColumn<Item, String> param) -> {
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
                        
                        //TODO: Add set color to item
                    }
                }
            };
            return cell;
        });

        //*******Possibly how to link gui to backend values*************
        ColorColumn.setOnEditCommit(e -> {
            TreeItem<Item> sItem = getSelectedItem();
            sItem.getValue().setColor(ColorColumn.getCellData(sItem));
        });

        //STATECOLUMN
//        ObservableList<String> list = FXCollections.observableArrayList();
        String sOn = "On ";
        String sOff = "Off";
        
        TreeTableColumn<Item, Boolean> StateColumn = TreeTableUtil.getColumnBoolean("Status");
        StateColumn.setCellFactory((TreeTableColumn<Item, Boolean> param) -> {
            TreeTableCell<Item, Boolean> cell = new TreeTableCell<Item, Boolean>() {
                private final ToggleButton tButton = new ToggleButton(sOn);
                
                @Override
                protected void updateItem(Boolean item, boolean empty) {
                    
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(tButton);
                        tButton.setSelected(true);
                        
                    }
                }
                
            };
            return cell;
        });
        
        StateColumn.setOnEditCommit(e ->{
            TreeItem<Item> sItem = getSelectedItem();
            sItem.getValue().setStatus(StateColumn.getCellData(sItem));
        });
        
        
        
        
        //BRIGHTNESS
        ObservableList<String> listBrightness = FXCollections.observableArrayList();
        for (int i = 1; i <= 10; i++) {
            listBrightness.add(Integer.toString(i));
        }
        TreeTableColumn<Item, Integer> BrightnessColumn = TreeTableUtil.getColumnInt("Brightness");
        BrightnessColumn.setCellFactory((TreeTableColumn<Item, Integer> param) -> {
            TreeTableCell<Item, Integer> cell = new TreeTableCell<Item, Integer>() {
                private ComboBox comboBrightnessbox = new ComboBox(listBrightness);
                
                @Override
                protected void updateItem(Integer item, boolean empty) {
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
        });
        
        BrightnessColumn.setOnEditCommit(e ->{
            TreeItem<Item> sItem = getSelectedItem();
            sItem.getValue().setBrightness(BrightnessColumn.getCellData(sItem));
        
        });
        
        
        

        // Add Columns to The TreeTableView
        treeTable.getColumns().add(NameColumn);
        treeTable.getColumns().add(ColorColumn);
        treeTable.getColumns().add(StateColumn);
        treeTable.getColumns().add(BrightnessColumn);

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
        Button helpButton = new Button("Help");

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
        
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Popup.help();
            }
        });

        Insets buttonInset = new Insets(0, 0, 0, 6.5);
        HBox hb = new HBox(20, addButton, deleteButton,helpButton);
        hb.setPadding(buttonInset);
        return hb;
    }


    private void addRow() {
        TreeItem<Item> sItem = getSelectedItem(); //gets selected item
        int sLevel = this.treeTable.getTreeItemLevel(sItem);
        if (sLevel == 2) {
            //Bulb Selected, add bulb to group/change groupsArr
            String newParent = Popup.addBulbToGroup(getNameList(groupsArr));
            changeBulbParent(getItemByName(newParent, groupsArr));
            
        } else if (sLevel == 1) {
            //Group Selected
            if ( sItem.getValue().getName().equals(this.allGroupName) ) {
                //Misc. Bulb Group selected, Add bulb to System
                String s = Popup.addBulbToHub();
                this.createItem(s);
            } else {
                //Group selected, add to the group a bulb from misc. bulbs
                System.out.println(freeBulbsArr);
                String n = Popup.addToGroupBulb(getNameList(freeBulbsArr));
                this.addBulbToGroup(getItemByName(n, freeBulbsArr));
            }           
        } else if (sLevel == 0) {
            //Root Selected, create new group
            String newGroupName = Popup.createNewGroup();
            this.createItem(newGroupName);
        } else {
            this.log("ERR103: Unknown add case, contact elirose@uab.edu.");
        }
    }
        
    private void deleteRow(TreeItem<Item> sItem) {
        int sLevel = this.treeTable.getTreeItemLevel(sItem);
        if (sLevel == 2) {
            //Bulb Selected, add bulb to group/change groupsArr
            if (sItem.getParent().getValue().getName().equals(allGroupName)) {
                //Remove from system; let Java GC take care of it
                log(sItem.getValue().getName() + " successfully deleted.");
                removeBulbFromGroup(sItem);
            } else {
                //remove from group but add it to allGroup
                String parentName = sItem.getParent().getValue().getName();
                changeBulbParent(sItem, allGroup);
                log(sItem.getValue().getName() + " removed from " +
                       parentName + " group." );
            }
        } else if (sLevel == 1) {
            //Group Selected
            if ( sItem.getValue().getName().equals(this.allGroupName) ) {
                //Misc. Bulb Group selected, cannot remove
                log("Cannot remove the " + allGroupName + '.');
            } else {
                //Group selected, remove all bulbs then remove group, Java GC
                //RECURSIVEEEEEE YESSSS
                for (int i = 0; i < sItem.getChildren().size(); i++) {
                    deleteRow(sItem.getChildren().get(i));
                }
                sItem.getParent().getChildren().remove(sItem);
            }           
        } else if (sLevel == 0) {
            //Root Selected, Cannot delete; possibly "Add Hulb" button?
            log("Cannot remove the " + treeTable.getRoot().getValue().getName()+
                    " master.");
        } else {
            this.log("ERR103: Unknown delete case, contact elirose@uab.edu.");
        }
    }
    
    private void deleteRow() {
        TreeItem<Item> selectedItem = this.getSelectedItem();
        this.deleteRow(selectedItem);
    }
    
    private void createItem() {
        TreeItem<Item> selectedItem = this.getSelectedItem();
        TreeItem item = null;
        switch (this.treeTable.getTreeItemLevel(selectedItem)) {
            case 1: {
                item = new TreeItem((Object)new Bulb());
                freeBulbsArr.add(item);
                break;
            }
            case 0: {
                item = new TreeItem((Object)new Group());
                groupsArr.add(item);
                break;
            }
            default: {
                this.log("ERR101: Invalid command, contact elirose@uab.edu.");
            }
        }
        selectedItem.getChildren().add(item);
        this.editItem(item);
    }
        
    private void createItem(String name) {
        this.createItem();
        ((Item)this.getSelectedItem().getValue()).setName(name);
    }

    private void addNewRootItem() {
        TreeItem<Item> item = new TreeItem<>(new Item("Groups"));
        treeTable.setRoot(item);
        this.editItem(item);
    }
//Add and Remove are PURE functions; use change in most cases, which uses
    //Remove and Add
    //addRow | deleteRow -> changeBulbParen -> addBulbToGroup | removeBulbFrom-
    
    private void removeBulbFromGroup(TreeItem<Item> bulb) {
        TreeItem<Item> parent = bulb.getParent();
        ((Group)parent.getValue()).removeBulb((Bulb)bulb.getValue()); //Backend
        parent.getChildren().remove(bulb);                           //Frontend
    }
    
    private void removeBulbFromGroup() {
        removeBulbFromGroup(getSelectedItem());
    }

    private void addBulbToGroup(TreeItem<Item> bulb, TreeItem<Item> group) {
        group.getChildren().add(bulb);      // Front-end add bulb
        ((Group)group.getValue()).addBulb((Bulb)bulb.getValue());   // Back-end add bulb
        editItem(bulb);                     // Selects bulbs
    }
    
    private void addBulbToGroup(TreeItem<Item> bulb) {
        TreeItem<Item> group = this.getSelectedItem();
        this.addBulbToGroup(bulb, group);
    }

    private void changeBulbParent(TreeItem<Item> bulb, TreeItem<Item> newParent) {
        removeBulbFromGroup(bulb);
        this.addBulbToGroup(bulb, newParent);
    }

    private void changeBulbParent(TreeItem<Item> newParent) {
        this.changeBulbParent(getSelectedItem(), newParent);
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
    

    
    private TreeItem<Item> getSelectedItem() {
        TreeTableView.TreeTableViewSelectionModel sm = this.treeTable.getSelectionModel();
        if (sm.isEmpty()) {
            this.log("Select a row.");
            return null;
        }
        return (TreeItem)sm.getSelectedItem();
    }

    private TreeItem<Item> getItemByName(String name, ArrayList<TreeItem<Item>> itemsArr) {
        for (int i = 0; i < itemsArr.size(); i++) {
            if ((itemsArr.get(i).getValue()).getName().equals(name)) {
                return itemsArr.get(i);
            }
            i++;
        }
        this.log("ERR104: No item by the name " + name + ".");
        return null;
    }
    
    private ArrayList<String> getNameList(ArrayList<TreeItem<Item>> itemsArr) {
        ArrayList<String> L = new ArrayList();
        for (int i = 0; i < itemsArr.size(); i++) {
            L.add(itemsArr.get(i).getValue().getName());
        }
        return L;
    }
    
    private void log(String message) {
        this.textarea.appendText(message + "\n");
    }
}
