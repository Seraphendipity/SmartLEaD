/*
 * File: .java
 * Author: Caleb J Rudolph rudolph2@uab.edu
 * Assignment:  - EE333 Spring 2019
 * Vers: 1.0.0 01/14/2019 cjr - initial coding
 */
package TreeExampleOnline;




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
