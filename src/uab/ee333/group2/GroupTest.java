package uab.ee333.group2;
import p5.Controller;
import p5.Hub;
import p5.Properties;
import p5.Group;
import p5.Bulb;

import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class GroupTest extends Application {
    Controller c1 = new Controller("My Controller");
        
        c1.newHub(null);
        
        for ( int i = 0 ; i < 20; i++) {
            c1.newBulb(null);
        }
        
        c1.newGroup("Kitchen");
        c1.newGroup("Living Room");
        c1.newGroup("Bed Room");
        c1.newGroup("Bathroom");
        
        for ( int i = 1 ; i < 20; i++) {
            if (i < 5) {
                c1.addToGroup("B-"+i, "Kitchen");
            }
            else if (i < 11) {
                c1.addToGroup("B-"+i, "Living Room");
            }
            else if (i < 16) {
                c1.addToGroup("B-"+i, "Bed Room");
            }
            else if (i < 18) {
                c1.addToGroup("B-"+i, "Bathroom");
            }
        }
//    List<Bulb> employees = Arrays.<Bulb>asList(new Bulb("Bulb-2", "Garage"),
//            new Bulb("Bulb-3", "Patio"),
//            new Bulb("Bulb-4", "Patio"),
//            new Bulb("Bulb-1","Den"),
//            new Bulb("Bulb-4","All Bulbs"),
//            new Bulb("Bulb-3","All Bulbs"),
//            new Bulb("Bulb-1","All Bulbs"),
//            new Bulb("Bulb-2","All Bulbs")
//    
//    );
    TreeItem<String> rootNode = 
        new TreeItem<>("Groups");
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        rootNode.setExpanded(true);
        for (Bulb employee : employees) {
            TreeItem<String> empLeaf = new TreeItem<>(employee.getName());
            boolean found = false;
            for (TreeItem<String> depNode : rootNode.getChildren()) {
                if (depNode.getValue().contentEquals(employee.getDepartment())){
                    depNode.getChildren().add(empLeaf);
                    found = true;
                    break;
                }
            }
            if (!found) {
                TreeItem depNode = new TreeItem(employee.getDepartment());
                rootNode.getChildren().add(depNode);
                depNode.getChildren().add(empLeaf);
            }
        }
 
        stage.setTitle("Smart Bulb System");
        Label groupLabel = new Label(" Group 2 - Caleb Rudolph, Kyle Roberson, Elijah Rose");
        VBox box = new VBox();
        final Scene scene = new Scene(box, 500, 200);
 
        TreeView<String> treeView = new TreeView<>(rootNode);
        treeView.setEditable(true);
        treeView.setCellFactory((TreeView<String> p) -> 
            new TextFieldTreeCellImpl());
            
        box.getChildren().add(treeView);
        box.getChildren().add(groupLabel);
        stage.setScene(scene);
        stage.setResizable(false);
        
        stage.show();
    }
 
    private final class TextFieldTreeCellImpl extends TreeCell<String> {
 
        private TextField textField;
        private final ContextMenu RootMenu = new ContextMenu();
        private final ContextMenu GroupMenu = new ContextMenu();
        private final ContextMenu BulbMenu = new ContextMenu();
        private final ContextMenu AllBulbsMenu = new ContextMenu();
 
        public TextFieldTreeCellImpl() {
            //RootMenu options        
//============================================================================
                MenuItem addGroupItem = new MenuItem("Add Group");

            //BulbMenu options
//============================================================================ 
                Menu bulbSettings = new Menu("Bulb Settings");
  
                //onoff ToggleGroup
                RadioMenuItem on = new RadioMenuItem("On");
                RadioMenuItem off = new RadioMenuItem("Off");
                ToggleGroup onoffgroup = new ToggleGroup();
           
                on.setToggleGroup(onoffgroup);
                off.setToggleGroup(onoffgroup);
                off.setSelected(true);
           
                //Brightness Slider
                Slider slider = new Slider(1, 10, 1);
                slider.setShowTickMarks(true);
                slider.setShowTickLabels(true);
                slider.setMajorTickUnit(1.0f);
                slider.snapToTicksProperty();
                slider.setBlockIncrement(1.0f);
                CustomMenuItem customSliderItem = new CustomMenuItem();
                customSliderItem.setContent(slider);
                customSliderItem.setHideOnClick(false);
                
          
                ColorPicker BulbColor = new ColorPicker();
                CustomMenuItem customColorPicker = new CustomMenuItem();
                customColorPicker.setContent(BulbColor);
                customColorPicker.setHideOnClick(false);
                
           
                //Separators
                SeparatorMenuItem BulbSettingsSeparator1 = new SeparatorMenuItem();
                SeparatorMenuItem BulbSettingsSeparator2 = new SeparatorMenuItem();
                
                //adds all created items to bulbSettings item
                bulbSettings.getItems().add(on);
                bulbSettings.getItems().add(off);
                bulbSettings.getItems().add(BulbSettingsSeparator1);
                bulbSettings.getItems().add(customColorPicker);
                bulbSettings.getItems().add(BulbSettingsSeparator2); 
                bulbSettings.getItems().add(customSliderItem);
                
                
                
            
            
            //GroupMenu
//============================================================================
            Menu groupSettings = new Menu("Group Settings");
            
            
                RadioMenuItem onG = new RadioMenuItem("On");
                RadioMenuItem offG = new RadioMenuItem("Off");
                ToggleGroup onoffgroupG = new ToggleGroup();
           
                onG.setToggleGroup(onoffgroupG);
                offG.setToggleGroup(onoffgroupG);
                offG.setSelected(true);
           
                //Brightness Slider
                Slider sliderG = new Slider(1, 10, 1);
                sliderG.setShowTickMarks(true);
                sliderG.setShowTickLabels(true);
                sliderG.setMajorTickUnit(1.0f);
                sliderG.snapToTicksProperty();
                sliderG.setBlockIncrement(1.0f);
                CustomMenuItem customSliderItemG = new CustomMenuItem();
                customSliderItemG.setContent(sliderG);
                customSliderItemG.setHideOnClick(false);
                
          
                ColorPicker GroupColor = new ColorPicker();
                CustomMenuItem customGroupColorPicker = new CustomMenuItem();
                customGroupColorPicker.setContent(GroupColor);
                customGroupColorPicker.setHideOnClick(false);
                
           
           
                //Separators
                SeparatorMenuItem GSettingsSeparator1 = new SeparatorMenuItem();
                SeparatorMenuItem GSettingsSeparator2 = new SeparatorMenuItem();
                
                //adds all created items to bulbSettings item
                groupSettings.getItems().add(onG);
                groupSettings.getItems().add(offG);
                groupSettings.getItems().add(GSettingsSeparator1);
                groupSettings.getItems().add(customGroupColorPicker);
                groupSettings.getItems().add(GSettingsSeparator2); 
                groupSettings.getItems().add(customSliderItemG);
            

            
            MenuItem addBulbItem = new MenuItem("Add Bulb");
            
              //add bulbs to system choicebox
                ObservableList<String> allbulbs = 
                FXCollections.observableArrayList( );

           ComboBox AllBulbsComboBox = new ComboBox(allbulbs);
                AllBulbsComboBox.setPromptText("Add Bulb to Group");
                CustomMenuItem customBulbsComboBox = new CustomMenuItem();
                customBulbsComboBox.setContent(AllBulbsComboBox);
                customBulbsComboBox.setHideOnClick(false); 
            
            
            
            //AllBulbs
//============================================================================            
            MenuItem addBulbToSystem = new MenuItem("Add Bulb To System");
            
            
            //Add items to menus
//============================================================================
         
            AllBulbsMenu.getItems().add(addBulbToSystem);
            GroupMenu.getItems().add(groupSettings);
            GroupMenu.getItems().add(customBulbsComboBox);
            RootMenu.getItems().add(addGroupItem);
            BulbMenu.getItems().add(bulbSettings);
           
            //setOnAction
//============================================================================            
            addBulbItem.setOnAction((ActionEvent t) -> {
                TreeItem newEmployee = new TreeItem<>("New Bulb");
                getTreeItem().getChildren().add(newEmployee);
            });
            
            
            addGroupItem.setOnAction((ActionEvent t) -> {
                TreeItem newEmployee = new TreeItem<>("New Group");
                rootNode.getChildren().add(newEmployee);
            });
            
            addBulbToSystem.setOnAction(e -> {
              
              TreeItem newEmployee = new TreeItem<>(AddBulbToSystemPopup.display("Add Bulb"));  
               getTreeItem().getChildren().add(newEmployee);
               employees.add (new Bulb(newEmployee.getValue().toString(),"All Bulbs"));
             // employees.add( new Bulb ( AddBulbToSystemPopup.display("Add Bulb","")  ,  "All Bulbs"));
                for (Bulb employee : employees) {
                   
                    if(employee.getDepartment().contentEquals("All Bulbs")){
                     allbulbs.add(employee.getName());
                }else{}
              
                }

            });
            
            
            customBulbsComboBox.setOnAction(e ->{
                 for (Bulb employee : employees) {
                   
                    if(employee.getDepartment().contentEquals("All Bulbs")){
                     allbulbs.add(employee.getName());
                }else{}
              
                }
                     
            });
                          
        }
 
        @Override
        public void startEdit() {
            super.startEdit();
 
            if (textField == null) {
                createTextField();
            }
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }
 
        @Override
        public void cancelEdit() {
            super.cancelEdit();
 
            setText((String) getItem());
            setGraphic(getTreeItem().getGraphic());
        }
 
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
 
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(getTreeItem().getGraphic());
                    if (  getTreeItem().getParent()==rootNode  ){
                        if("All Bulbs".equals(getTreeItem().getValue())){
                         setContextMenu(AllBulbsMenu);
                         
                        }else{
                         setContextMenu(GroupMenu);
                        }
                       
                    }
                    else if( getTreeItem().getParent()!= null ){
                            setContextMenu(BulbMenu);
                            }
                    else{
                        setContextMenu(RootMenu);
                    }
                }
            }
        }
        
        private void createTextField() {
            textField = new TextField(getString());
            textField.setOnKeyReleased((KeyEvent t) -> {
                if (t.getCode() == KeyCode.ENTER) {
                    commitEdit(textField.getText());
                } else if (t.getCode() == KeyCode.ESCAPE) {
                    cancelEdit();
                }
            });  
            
        }
 
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
 
//    public static class Bulb {
// 
//        private final SimpleStringProperty name;
//        private final SimpleStringProperty department;
// 
//        private Bulb(String name, String department) {
//            this.name = new SimpleStringProperty(name);
//            this.department = new SimpleStringProperty(department);
//        }
// 
//        public String getName() {
//            return name.get();
//        }
// 
//        public void setName(String fName) {
//            name.set(fName);
//        }
// 
//        public String getDepartment() {
//            return department.get();
//        }
// 
//        public void setDepartment(String fName) {
//            department.set(fName);
//        }
//    }
}