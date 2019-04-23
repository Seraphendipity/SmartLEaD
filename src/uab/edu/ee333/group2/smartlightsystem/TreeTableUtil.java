/*
 * File: TreeTableUtil.java
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

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

public class TreeTableUtil {
    
    //@SuppressWarnings("unchecked")

    public static TreeItem<Item> getModel(String allGroupName) {
                

            //Creates Root
            TreeItem<Item> rootNode = new TreeItem<Item>(new Item("HUB"));

            // Creates Groups
//            Item group1 = new Item("Patio");
//            Item group2 = new Item("Garage");
//            Item group3 = new Item("Den");
//            Item group4 = new Item("Master Bedroom");
//            Item group5 = new Item("Living Room");
            TreeItem<Item> groupMiscBulbs = new TreeItem<Item>(new Item(allGroupName));

            //Creates Bulbs
//            Item bulb1 = new Item("Bulb-1");
//            Item bulb2 = new Item("Bulb-2");
//            Item bulb3 = new Item("Bulb-3");
//            Item bulb4 = new Item("Bulb-4");
//            Item bulb5 = new Item("Bulb-5");


            // Connects everything
//            TreeItem<Item> group1Node = new TreeItem<>(group1);
//            group1Node.getChildren().addAll(new TreeItem<>(bulb1), new TreeItem<>(bulb2));
//
//            TreeItem<Item> group2Node = new TreeItem<>(group2);
//            group2Node.getChildren().addAll(new TreeItem<>(bulb2), new TreeItem<>(bulb3),new TreeItem<>(bulb4));
//
//            TreeItem<Item> group3Node = new TreeItem<>(group3);
//            group3Node.getChildren().addAll(new TreeItem<>(bulb2), new TreeItem<>(bulb3),new TreeItem<>(bulb4));
//
//            TreeItem<Item> group4Node = new TreeItem<>(group4);
//            group4Node.getChildren().addAll(new TreeItem<>(bulb2), new TreeItem<>(bulb4),new TreeItem<>(bulb1));
//
//            TreeItem<Item> group5Node = new TreeItem<>(group5);
//            group5Node.getChildren().addAll(new TreeItem<>(bulb2), new TreeItem<>(bulb1),new TreeItem<>(bulb5));

//            TreeItem<Item> groupMiscBulbsNode = new TreeItem<> (groupMiscBulbs);

            // Create the root node and add children
            rootNode.getChildren().add(groupMiscBulbs);


            return rootNode;
    }
    

    /* Returns Name TreeTableColumn */
    public static TreeTableColumn<Item, String> getColumnString(String s) {
            TreeTableColumn<Item, String> col = new TreeTableColumn<>(s);
            col.setCellValueFactory(new TreeItemPropertyValueFactory<>(s));
            return col;
    }
    
    public static TreeTableColumn<Item, Boolean> getColumnBoolean(String s) {
        TreeTableColumn<Item, Boolean> col = new TreeTableColumn<>(s);
        col.setCellValueFactory(new TreeItemPropertyValueFactory<>(s));
        return col;
    }
    
    public static TreeTableColumn<Item, Integer> getColumnInt(String s) {
        TreeTableColumn<Item, Integer> col = new TreeTableColumn<>(s);
        col.setCellValueFactory(new TreeItemPropertyValueFactory<>(s));
        return col;
    }    
}