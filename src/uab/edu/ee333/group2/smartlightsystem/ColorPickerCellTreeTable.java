/*
 * File: ColorPickerCellTreeTableView.java
 * Author: Elijah Rose elirose@uab.edu
 * Assignment:  SmartLEaD - EE333 Spring 2019
 * Vers: 1.0.0 04/23/2019 ETR - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package uab.edu.ee333.group2.smartlightsystem;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.paint.Color;

/**
 *
 * @author Elijah Rose elirose@uab.edu
 */
public class ColorPickerCellTreeTable<Item> extends TreeTableCell<Item, Color> {    
    private final ColorPicker colorPicker;

    public ColorPickerCellTreeTable(TreeTableColumn<Item, Color> column) {
        this.colorPicker = new ColorPicker();
        this.colorPicker.editableProperty().bind(column.editableProperty());
        this.colorPicker.disableProperty().bind(column.editableProperty().not());
        this.colorPicker.setOnShowing(event -> {
            final TreeTableView<Item> tableView = getTreeTableView();
            tableView.getSelectionModel().select(getTreeTableRow().getIndex());
            tableView.edit (tableView.getSelectionModel().getSelectedIndex(), column);       
        });
        this.colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(isEditing()) {
                commitEdit(newValue);
            }
        });     
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }

    @Override
    protected void updateItem(Color item, boolean empty) {
        super.updateItem(item, empty);  

        setText(null);  
        if(empty) {     
            setGraphic(null);
        } else {        
            this.colorPicker.setValue(item);
            this.setGraphic(this.colorPicker);
        } 
    }
}
