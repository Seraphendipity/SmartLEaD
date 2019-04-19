/*
 * File: TreeTableUtil.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  GroupProject - EE333 Spring 2019
 * Vers: 1.2.0 04/16/2019 KAR - initial coding
 *
 * Credits:  (if any for sections of code)
 */

package TreeExampleOnline;


import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

public class TreeTableUtil
{
	@SuppressWarnings("unchecked")
	public static TreeItem<Item> getModel()
	{
            
		//Creates Root
		Item person1 = new Item("Groups", "", "", "");

		// Creates Groups
		Item group1 = new Item("Patio", "White","On","5");
		Item group2 = new Item("Garage", "White","On","5");
		Item group3 = new Item("Den", "White","On","5");
		Item group4 = new Item("Master Bedroom", "White","On","5");
                Item group5 = new Item("Living Room", "White","On","5");
                Item groupAllBulbs = new Item("All Bulbs","","","");
                
		//Creates Bulbs
		Item bulb1 = new Item("Bulb-1", "White","On","5");
		Item bulb2 = new Item("Bulb-2", "White","On","5");
		Item bulb3 = new Item("Bulb-3", "White","On","5");
		Item bulb4 = new Item("Bulb-4", "White","On","5");
		Item bulb5 = new Item("Bulb-5", "White","On","5");

		

		// Connects everything
		TreeItem<Item> group1Node = new TreeItem<>(group1);
		group1Node.getChildren().addAll(new TreeItem<>(bulb1), new TreeItem<>(bulb2));

		TreeItem<Item> group2Node = new TreeItem<>(group2);
                group2Node.getChildren().addAll(new TreeItem<>(bulb2), new TreeItem<>(bulb3),new TreeItem<>(bulb4));
                
                TreeItem<Item> group3Node = new TreeItem<>(group3);
                group3Node.getChildren().addAll(new TreeItem<>(bulb2), new TreeItem<>(bulb3),new TreeItem<>(bulb4));
                
                TreeItem<Item> group4Node = new TreeItem<>(group4);
                group4Node.getChildren().addAll(new TreeItem<>(bulb2), new TreeItem<>(bulb4),new TreeItem<>(bulb1));
                
                TreeItem<Item> group5Node = new TreeItem<>(group5);
                group5Node.getChildren().addAll(new TreeItem<>(bulb2), new TreeItem<>(bulb1),new TreeItem<>(bulb5));
                
                TreeItem<Item> groupAllBulbsNode = new TreeItem<>(groupAllBulbs);
                
		// Create the root node and add children
		TreeItem<Item> rootNode = new TreeItem<>(person1);
		rootNode.getChildren().addAll(group1Node, group2Node, group3Node,group4Node, group5Node, groupAllBulbsNode);
                

		return rootNode;
	}

	

	/* Returns Name TreeTableColumn */
	public static TreeTableColumn<Item, String> getNameColumn()
	{
		TreeTableColumn<Item, String> NameCol = new TreeTableColumn<>("Name");
		NameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("Name"));
		return NameCol;
	}

	/* Returns Color Name TreeTableColumn */
	public static TreeTableColumn<Item, String> getColorColumn()
	{
		TreeTableColumn<Item, String> ColorCol = new TreeTableColumn<>("Color");
		ColorCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("Color"));
		return ColorCol;
	}
	/* Returns State Name TreeTableColumn */
	public static TreeTableColumn<Item, String> getStateColumn()
	{
		TreeTableColumn<Item, String> StateCol = new TreeTableColumn<>("State");
		StateCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("State"));
		return StateCol;
	}

        /* Returns Color Name TreeTableColumn */
	public static TreeTableColumn<Item, String> getBrightnessColumn()
	{
		TreeTableColumn<Item, String> BrightnessCol = new TreeTableColumn<>("Color");
		BrightnessCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("Color"));
		return BrightnessCol;
	}
	

    }