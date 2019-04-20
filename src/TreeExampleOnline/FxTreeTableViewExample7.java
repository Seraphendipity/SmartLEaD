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
    private String allGroupName = "Misc. Bulbs";
    private final TreeTableView<Item> treeTable = new TreeTableView<>();
    // Create a TextArea
    private final TextArea textarea = new TextArea();

    //ArrayList of Bulbs
    ArrayList<TreeItem<Bulb>> freeBulbsArr = new ArrayList();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create the Root Node
        TreeItem<Item> rootNode = TreeTableUtil.getModel();
        rootNode.setExpanded(true);
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
                            //TODO: Add set color to item
                        }
                    }
                };
                return cell;
            }
        });

        //*******Possibly how to link gui to backend values*************
        ColorColumn.setOnEditCommit(e -> {
            TreeTableViewSelectionModel<Item> sm = treeTable.getSelectionModel();
            TreeItem<Item> selectedItem = getSelectedItem();
            getSelectedItem().getValue().setColor(ColorColumn.getCellData(selectedItem));
        });

        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("On");
        list.add("Off");
        TreeTableColumn<Item, String> ComboColumn = TreeTableUtil.getColumn("State");
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
        TreeItem<Item> sItem = getSelectedItem(); //gets selected item
        int sLevel = this.treeTable.getTreeItemLevel(sItem);
        if (sLevel == 2) {
            //Bulb Selected, add bulb to group/change groups
            String newParent = Popup.addBulbToGroup(getNameList(getGroups()));
            changeBulbParent(getGroupByName(newParent));
            
        } else if (sLevel == 1) {
            //Group Selected
            if ( sItem.getValue().getName().equals(this.allGroupName) ) {
                //Misc. Bulb Group selected, Add bulb to System
                String s = Popup.addBulbToHub();
                this.createItem(s);
            } else {
                //Group selected, add to the group a bulb from misc. bulbs
                String n = Popup.addToGroupBulb(getListNames(getFreeBulbs()));
                this.addBulbToGroup(getItemByName(s));
            }           
        } else if (sLevel == 0) {
            //Root Selected, create new group
            String newGroupName = Popup.createNewGroup();
            this.createItem(newGroupName);
        } else {
            this.log("ERR103: Unknown add case, contact elirose@uab.edu.");
        }
    }
        
    private void createItem() {
        TreeItem<Item> selectedItem = this.getSelectedItem();
        TreeItem item = null;
        switch (this.treeTable.getTreeItemLevel(selectedItem)) {
            case 1: {
                item = new TreeItem((Object)new Bulb());
                break;
            }
            case 0: {
                item = new TreeItem((Object)new Group());
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
        // Add a root Item
        TreeItem<Item> item = new TreeItem<>(new Item("Groups"));
        treeTable.setRoot(item);

        // Edit the item
        this.editItem(item);
    }


    private void addBulbToGroup(TreeItem<Bulb> bulb) {
        TreeItem<Item> group = this.getSelectedItem();
        this.addBulbToGroup(bulb, group);
    }

    private void addBulbToGroup(TreeItem<Bulb> bulb, TreeItem<Group> group) {
        group
        group.getChildren().add(bulb);
        group.setExpanded(true);
    }

    private void changeBulbParent(TreeItem<Bulb> bulb, TreeItem<Group> newParent) {
        this.deleteRow(bulb);
        this.addBulbToGroup(bulb, newParent);
    }

    private void changeBulbParent(TreeItem<Group> newParent) {
        TreeItem<Item> bulb = this.getSelectedItem();
        this.changeBulbParent(bulb, newParent);
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
        TreeItem<Item> selectedItem = this.getSelectedItem();
        this.deleteRow(selectedItem);
    }

    private void deleteRow(TreeItem<Item> selectedItem) {
        if (selectedItem != null) {
            TreeItem parent = selectedItem.getParent();
            Boolean bAllgroup = ((Item)selectedItem.getValue()).getName().equals(this.allGroupName);
            if (parent != null && !bAllgroup.booleanValue()) {
                parent.getChildren().remove(selectedItem);
                this.log(((Item)selectedItem.getValue()).getName() + " successfully deleted.");
            } else if (bAllgroup.booleanValue()) {
                this.log("Cannot delete " + this.allGroupName + ".");
            }
        }
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
        for (int i = 0; i < itemsArr.size(); ++i) {
            if (((Item)itemsArr.get(i).getValue()).getName().equals(name)) {
                return itemsArr.get(i);
            }
            ++i;
        }
        this.log("ERR104: No item by the name " + name + ".");
        return null;
    }
        
    private TreeItem<Bulb> getBulbByName(String name) {
        getItemByName(name, getFreeBulbs());
    }   
       
    private TreeItem<Group> getGroupByName(String name) {
        getItemByName(name, getGroups());
    }   
    
    private ArrayList<String> getNameList(ArrayList<TreeItem<Item>> itemsArr) {
        ArrayList<String> L = new ArrayList();
        for (int i = 0; i > itemsArr.size(); i++) {
            L.add(itemsArr.get(i).getValue().getName());
        }
        return L;
    }
       
    private void log(String message) {
        this.textarea.appendText(message + "\n");
    }
}