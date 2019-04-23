/*
 * File: Controller.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  Controller - EE333 Spring 2019
 * Vers: 1.
 *       1.0.0 04/20/2019 KAR - initial coding
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
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class Controller extends Application {
    
/*______________________________________________________________________________
    _ _  _ _ ___ _ ____ _    _ ___  ____ ___ _ ____ _  _ 
    | |\ | |  |  | |__| |    |   /  |__|  |  | |  | |\ | 
    | | \| |  |  | |  | |___ |  /__ |  |  |  | |__| | \| 
______________________________________________________________________________*/

    private final TreeTableView<Item> treeTable = new TreeTableView<>();
    
    private Label dirLabel; // Displays directions up top.
    private Label logLabel; //Displays log at bottom.
    private Button addButton;
    private Button delButton;
    
    private TreeItem<Item> allGroup;
    private String allGroupName;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Initialize treeTable, Root and Misc. Group
        TreeItem<Item> rootNode = new TreeItem<>(new Item("HUB"));
        allGroupName = "MISC. BULBS";
        allGroup = new TreeItem<>(new Item(allGroupName));
        rootNode.getChildren().add(allGroup);
        
        treeTable.setRoot(rootNode);
        rootNode.setExpanded(true);
        treeTable.setPrefWidth(480);
        treeTable.setEditable(true);
        treeTable.getSelectionModel().selectFirst();
        /*---------------------------------
        __ _ ____ _  _ ____
        | \| |--| |\/| |===
        ----------------------------------*/        
        TreeTableColumn<Item, String> nameCol = getColumnString("Name");
        nameCol.setCellFactory(
                TextFieldTreeTableCell.<Item>forTreeTableColumn());
        nameCol.setEditable(false);

        
        /*---------------------------------
        ____ ____ _    ____ ____
        |___ [__] |___ [__] |--<
        ----------------------------------*/
        TreeTableColumn<Item, Color> colorCol = getColumnColor("Color");
        colorCol.setCellFactory((TreeTableColumn<Item, Color> param) -> {
             return new ColorPickerCellTreeTable(colorCol);});
        /*---------------------------------
        ____ ___ ____ ___ _  _ ____
        ====  |  |--|  |  |__| ====
        ----------------------------------*/
        TreeTableColumn<Item, Boolean> statusCol = getColumnBoolean("Status");
        statusCol.setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(statusCol));
        //STATECOLUMN
//        ObservableList<String> list = FXCollections.observableArrayList();
//        String sOff = "Off";
//        String sOn = "On ";
//        //Image imgOff = new Image("/bulbOff.png");
//        //Image imgOn = new Image("/bulbOn.png");
//        //ImageView img = new ImageView(imgOff);
//        //C:\Users\Elijah\Documents\CoolBeansProjects\SmartLEaD\src
//        statusCol.setCellFactory((TreeTableColumn<Item, Boolean> param) -> {
//            
//            TreeTableCell<Item, Boolean> cell = new TreeTableCell<Item, Boolean>() {
//                
//                
//                private ToggleButton tButton = new ToggleButton(sOff);
//                @Override
//                protected void updateItem(Boolean item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (empty) {
//                        setGraphic(null);
//                    } else {
//                        setGraphic(tButton);
//                        tButton.setSelected(true);
//                    }
//                }
//            };
//            
//            
//            return cell;
//        });
        
//        statusCol.setOnEditCommit(e ->{
//            TreeItem<Item> sItem = getSelectedItem();
//            sItem.getValue().setStatus(statusCol.getCellData(sItem));
//            //if (statusCol.getCellData(sItem) == true) {
//            //}
//        });
  
        /*---------------------------------
        ___  ____ _ ____ _  _ ___ __ _ ____ ____ ____
        |==] |--< | |__, |--|  |  | \| |=== ==== ====
        ----------------------------------*/
    
        //BRIGHTNESS
        ObservableList<Integer> listBrightness = FXCollections.observableArrayList();
        for (int i = 1; i <= 10; i++) {
            listBrightness.add(i);
        }
        TreeTableColumn<Item, Integer> BrightnessColumn = getColumnInt("Brightness");
        BrightnessColumn.setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(listBrightness));
//        BrightnessColumn.setCellFactory((TreeTableColumn<Item, Integer> p) -> {
//            TreeTableCell<Item, Integer> cell = new TreeTableCell<Item, Integer>() {
//                private ComboBox comboBrightnessbox = new ComboBox(listBrightness);
//                
//                @Override
//                protected void updateItem(Integer item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (empty) {
//                        setGraphic(null);
//                    } else {
//                        setGraphic(comboBrightnessbox);
//                        comboBrightnessbox.setValue(5);
//                        
//                    }
//                }
//            };
//            return cell;
//        });
        
//        BrightnessColumn.setOnEditCommit(e ->{
//            TreeItem<Item> sItem = getSelectedItem();
//            sItem.getValue().setBrightness(BrightnessColumn.getCellData(sItem));
//        
//        });
        
        /*---------------------------------
        ____ ___ _  _ ____ ____
        [__]  |  |--| |=== |--<
        ----------------------------------*/
        //Selection Model Observation Setup
        treeTable.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldSelection, newSelection) -> {
            if (newSelection != null) {updateButtons();}                });

        // Add Columns to The TreeTableView
        treeTable.getColumns().addAll(nameCol, 
                                      colorCol, 
                                      statusCol, 
                                      BrightnessColumn);

        // Create the Label
        dirLabel = new Label("  Please select a group or bulb to add/delete.");

        // Organizing Boxes
        HBox hbox = this.getButtons();
        VBox root = new VBox(dirLabel, hbox, treeTable);
        root.setSpacing(10);

        
        Scene scene = new Scene(root);  // Create the Scene
        stage.setScene(scene);          // Add the Scene to the Stage
        stage.setResizable(false);      // Set Unsizable
        stage.setTitle("SmartLEaD");    // Set title
        
        String s = "\" Group 2 - Caleb Rudolph, Kyle Roberson, Elijah Rose\"";
        logLabel = new Label(s);
        root.getChildren().add(logLabel);
        // Display the Stage
        stage.show();
    }
    
        /*---------------------------------
        ____ ____ ___ ____ ____ _    _  _ _  _ __ _
        |__, |===  |  |___ [__] |___ |__| |\/| | \|
        ----------------------------------*/
    
        private static TreeTableColumn<Item, String> getColumnString(String s) {
            TreeTableColumn<Item, String> col = new TreeTableColumn<>(s);
            col.setCellValueFactory(new TreeItemPropertyValueFactory<>(s.toLowerCase()));
            return col;
        }
        
        private static TreeTableColumn<Item, Color> getColumnColor(String s) {
            TreeTableColumn<Item, Color> col = new TreeTableColumn<>(s);
            col.setCellValueFactory(new TreeItemPropertyValueFactory<>(s.toLowerCase()));
            return col;
        }

        private static TreeTableColumn<Item, Boolean> getColumnBoolean(String s) {
            TreeTableColumn<Item, Boolean> col = new TreeTableColumn<>(s);
            col.setCellValueFactory(new TreeItemPropertyValueFactory<>(s.toLowerCase()));
            return col;
        }

        private static TreeTableColumn<Item, Integer> getColumnInt(String s) {
            TreeTableColumn<Item, Integer> col = new TreeTableColumn<>(s);
            col.setCellValueFactory(new TreeItemPropertyValueFactory<>(s.toLowerCase()));
            return col;
        }   
    
    /*__________________________________________________________________________
    ___  _  _ ___ ___ ____ _  _ ____          _  _ ____ _ _  _ 
    |__] |  |  |   |  |  | |\ | [__     __    |\/| |__| | |\ | 
    |__] |__|  |   |  |__| | \| ___]          |  | |  | | | \|
    __________________________________________________________________________*/
    
    //Initializes Buttons
    private HBox getButtons() {
        // Starting Button State
        addButton = new Button("        N / A         "); 
        addButton.setDisable(true);
        delButton = new Button("        N / A         "); 
        delButton.setDisable(true);
        
        Button helpButton = new Button("?");

        // Create EventHandler for the Buttons
        addButton.setOnAction((ActionEvent e) -> {addRow();});
        delButton.setOnAction((ActionEvent e) -> { deleteRow(); });
        helpButton.setOnAction((ActionEvent e) -> { Popup.help(); });

        Insets buttonInset = new Insets(0, 0, 0, 6.5);
        HBox hb = new HBox(20, addButton, delButton, helpButton);
        hb.setPadding(buttonInset);
        return hb;
    }

    // Handles Button Text and Disables
    private void updateButtons(){
        String  sAdd;   String  sDel; 
        Boolean bAdd;   Boolean bDel;
        TreeItem<Item> sItem = getSelectedItem(); //gets selected item
        if(sItem == null) {
                sAdd = "        N / A         ";    bAdd = true; 
                sDel = "        N / A         ";    bDel = true;
        } else {
        int sLevel = this.treeTable.getTreeItemLevel(sItem);
        //System.out.println( sItem.getValue().toString()); // DEBUG
        if (sLevel == 2) {
            //Bulb Selected
            if (sItem.getParent().getValue().getName().equals(allGroupName)) {
                //+ Add Bulb to Hub | - Remove Bulb from Hub 
                sAdd = "        N / A         ";    bAdd = true; 
                sDel = " Remove Bulb from Hub ";    bDel = false;
            } else {
                //+ Greyed Out | - Remove Bulb from Group
                sAdd = "        N / A         ";    bAdd = true; 
                sDel = "Remove Bulb from Group";    bDel = false;
            }
        } else if (sLevel == 1) {
            //Group Selected
            if ( sItem.getValue().getName().equals(this.allGroupName) ) {
                //+ Add Bulb to System |- N/A
                sAdd = " Connect Bulb to Hub  ";    bAdd = false; 
                sDel = "        N / A         ";    bDel = true; 
            } else {
                //+ Add Bulb to Group | - Delte Group
                sAdd = "  Add Bulb to Group   ";    bAdd = false; 
                sDel = "     Delete Group     ";    bDel = false;  
            }           
        } else if (sLevel == 0) {
            //Root Selected: + Add New Group | Disconnect from HUB
                sAdd = "    Add New Group     ";    bAdd = false; 
                sDel = " Disconnect from HUB  ";    bDel = true;  
        } else {
                sAdd = "        N / A         ";    bAdd = true; 
                sDel = "        N / A         ";    bDel = true; 

            // +  ADD | - DELETE
        }
        addButton.setText(sAdd);
        addButton.setDisable(bAdd);
        delButton.setText(sDel);
        delButton.setDisable(bDel);
        }
    }

    // Handles Addition Button
    private void addRow() {
        TreeItem<Item> sItem = getSelectedItem(); //gets selected item
        int sLevel = this.treeTable.getTreeItemLevel(sItem);
                        //System.out.println("YESSH" + sItem.getParent());

        if (sLevel == 2) {
            //Bulb Selected, add bulb to group/change groupsArr
            String newParent = Popup.addBulbToGroup(getNameList(getGroups()));
            changeBulbParent(getItemByName(newParent, getGroups()));
            
        } else if (sLevel == 1) {
            //Group Selected
            if ( sItem.getValue().getName().equals(this.allGroupName) ) {
                //Misc. Bulb Group selected, Add bulb to System
                String s = Popup.addBulbToHub();
                this.createItem(s);
            } else {
                //Group selected, add to the group a bulb from misc. bulbs
                //System.out.println(freeBulbsArr);
                String n = Popup.addToGroupBulb(getNameList(getFreeBulbs()));
                this.changeBulbParent(getItemByName(n, getFreeBulbs()), sItem);
            }           
        } else if (sLevel == 0) {
            //Root Selected, create new group
            String newGroupName = Popup.createNewGroup();
            this.createItem(newGroupName);
        } else {
            this.log("ERR103: Unknown add case, contact elirose@uab.edu.");
        }
    }
        
    // Handles Deletion Button
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
                int x = sItem.getChildren().size();
                for (int i = 0; i < x; i++) {
                    deleteRow(sItem.getChildren().get(0));
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
    
    /*__________________________________________________________________________
    ___  _  _ ___ ___ ____ _  _ ____          ____ _  _ _  _ 
    |__] |  |  |   |  |  | |\ | [__     __    |__| |  |  \/  
    |__] |__|  |   |  |__| | \| ___]          |  | |__| _/\_ 
    __________________________________________________________________________*/
    // Auxillary Button functions, used to add, create, edit, etc.
    
    //Notes on Editing Functions
    //Add and Remove are PURE functions; use change in most cases, which uses
    //Remove and Add
    //addRow | deleteRow -> changeBulbParen -> addBulbToGroup | removeBulbFrom-
    
    private void addBulbToGroup(TreeItem<Item> bulb, TreeItem<Item> group) {
        group.getChildren().add(bulb);      // Front-end add bulb
        (group.getValue()).addBulb((Bulb)bulb.getValue());  // Back-end add bulb
        editItem(bulb);                     // Selects bulbs
    }
    private void addBulbToGroup(TreeItem<Item> bulb) {
        TreeItem<Item> group = this.getSelectedItem();
        this.addBulbToGroup(bulb, group);
    }
    
    private void removeBulbFromGroup(TreeItem<Item> bulb) {
        TreeItem<Item> parent = bulb.getParent();
        (parent.getValue()).removeBulb((Bulb)bulb.getValue()); //Backend
        parent.getChildren().remove(bulb);  //Frontend
    }
    private void removeBulbFromGroup() {
        removeBulbFromGroup(getSelectedItem());
    }
    
    private void changeBulbParent(TreeItem<Item> bulb, TreeItem<Item>newParent){
        removeBulbFromGroup(bulb);
        this.addBulbToGroup(bulb, newParent);
    }
    private void changeBulbParent(TreeItem<Item> newParent) {
        this.changeBulbParent(getSelectedItem(), newParent);
    }
    
    private void createItem() {
        TreeItem<Item> selectedItem = this.getSelectedItem();
        TreeItem<Item> item = null;
        switch (this.treeTable.getTreeItemLevel(selectedItem)) {
            case 1: {
                item = new TreeItem(new Bulb());
                addBulbToGroup(item, allGroup);
                break;
            }
            case 0: {
                item = new TreeItem(new Group());
                selectedItem.getChildren().add(item);
                break;
            }
            default: {
                this.log("ERR101: Invalid command, contact elirose@uab.edu.");
            }
        }
        
        editItem(item);
    }
    private void createItem(String name) {
        this.createItem();
        ((Item)this.getSelectedItem().getValue()).setName(name);
    }


    /*__________________________________________________________________________
    ____ ___ _  _ ____ ____ 
    |  |  |  |__| |___ |__/ 
    |__|  |  |  | |___ |  \ 
    __________________________________________________________________________*/ 

    // ITEM MANAGEMENT--------------------------
    
    // Serves to "Focus" on Items
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

    // Simplifies logic in many parts of the code
    private TreeItem<Item> getSelectedItem() {
        TreeTableView.TreeTableViewSelectionModel sm = 
                this.treeTable.getSelectionModel();
        if (sm.isEmpty()) {
            this.log("Select a row.");
            return null;
        }
        return (TreeItem)sm.getSelectedItem();
    }

    // Names are unique; may be replaced with getItemByUid in the future
    private TreeItem<Item> getItemByName(String name, List<TreeItem<Item>> 
            itemsArr) {
        for (int i = 0; i < itemsArr.size(); i++) {
            if ((itemsArr.get(i).getValue()).getName().equals(name)) {
                return itemsArr.get(i);
            }
            i++;
        }
        this.log("ERR104: No item by the name " + name + ".");
        return null;
    }
    
    //LIST MANAGEMENT------------------------
    
    private ArrayList<String> getNameList(List<TreeItem<Item>> itemsArr) {
        ArrayList<String> L = new ArrayList();
        for (int i = 0; i < itemsArr.size(); i++) {
            L.add(itemsArr.get(i).getValue().getName());
        }
        return L;
    }
    
    private List<TreeItem<Item>> getFreeBulbs() {
        return allGroup.getChildren();
    }
    
    private List<TreeItem<Item>> getGroups() {
        return treeTable.getRoot().getChildren();
    }
    
    //LOG--------------------------------
    
    private void log(String message) {
       logLabel.setText(message + "\n");
    }
}//_____________________________________________________________________________
//===========================THE_END============================================
