/*
 * File: .java
 * Author: Caleb J Rudolph rudolph2@uab.edu
 * Assignment:  - EE333 Spring 2019
 * Vers: 1.0.0 01/14/2019 cjr - initial coding
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
		Item person1 = new Item("Groups", "");

		// Creates Groups
		Item group1 = new Item("Patio", "White");
		Item group2 = new Item("Garage", "White");
		Item group3 = new Item("Den", "White");
		Item group4 = new Item("Master Bedroom", "White");
                Item group5 = new Item("Living Room", "White");
                Item groupAllBulbs = new Item ("All Bulbs" , "White");

		//Creates Bulbs
		Item bulb1 = new Item("Bulb-1", "White");
		Item bulb2 = new Item("Bulb-2", "White");
		Item bulb3 = new Item("Bulb-3", "White");
		Item bulb4 = new Item("Bulb-4", "White");
		Item bulb5 = new Item("Bulb-5", "White");

		

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
                
                TreeItem<Item> groupAllBulbsNode = new TreeItem<> (groupAllBulbs);

		// Create the root node and add children
		TreeItem<Item> rootNode = new TreeItem<>(person1);
		rootNode.getChildren().addAll(group1Node, group2Node, group3Node,group4Node, group5Node,groupAllBulbsNode);
                

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

        /* Returns Color Name TreeTableColumn */
	public static TreeTableColumn<Item, String> getComboColumn()
	{
		TreeTableColumn<Item, String> ComboCol = new TreeTableColumn<>("On/Off");
		ComboCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("On/Off"));
		return ComboCol;
	}
        
        
         /* Returns Color Name TreeTableColumn */
	public static TreeTableColumn<Item, String> getComboColumnBrightness()
	{
		TreeTableColumn<Item, String> ComboBrightnessCol = new TreeTableColumn<>("Brightness");
		ComboBrightnessCol.setCellValueFactory(new TreeItemPropertyValueFactory<>("Brightness"));
		return ComboBrightnessCol;
	}
	

}
