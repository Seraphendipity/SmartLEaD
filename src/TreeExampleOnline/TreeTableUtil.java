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
		Item person1 = new Item("Groups");

		// Creates Groups
		Item group1 = new Item("Patio");
		Item group2 = new Item("Garage");
		Item group3 = new Item("Den");
		Item group4 = new Item("Master Bedroom");
                Item group5 = new Item("Living Room");
                Item groupAllBulbs = new Item ("All Bulbs");

		//Creates Bulbs
		Item bulb1 = new Item("Bulb-1");
		Item bulb2 = new Item("Bulb-2");
		Item bulb3 = new Item("Bulb-3");
		Item bulb4 = new Item("Bulb-4");
		Item bulb5 = new Item("Bulb-5");

		

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
	public static TreeTableColumn<Item, String> getColumn(String s) {
		TreeTableColumn<Item, String> NameCol = new TreeTableColumn<>(s);
		NameCol.setCellValueFactory(new TreeItemPropertyValueFactory<>(s));
		return NameCol;
	}
}
