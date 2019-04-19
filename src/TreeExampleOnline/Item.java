/*
 * File: Item.java
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
import java.time.LocalDate;


public class Item
{
	// Declaring the attributes page 424
	private String Name;
	private String Color;
       
       

	

	public Item(String Name, String Color)
	{
		this.Name = Name;
		this.Color = Color;
             
	}

	public String getName()
	{
		return Name;
	}

	public void setName(String Name)
	{
		this.Name = Name;
	}

	public String getColor()
	{
		return Color;
	}

	public void setColor(String Color)
	{
		this.Color = Color;
	}

	@Override
	public String toString()
	{
		return Name + " " + Color + ", " ;
	}

	
}

