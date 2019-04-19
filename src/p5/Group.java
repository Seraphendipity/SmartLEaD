/*
 * File: Group.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  kylerob-P5 - EE333 Spring 2019
 * Vers: 1.0.5 04/04/2019 KAR - Javadoc, finalizing
 * Vers: 1.0.2 04/01/2019 KAR - finished coding
 * Vers: 1.0.1 03/30/2019 KAR - initial coding
 * Vers: 1.0.0 03/29/2019 KAR - initial coding
 */

package p5;

import java.util.ArrayList;

/**
 * Model a group of Bulbs
 * @author Kyle A. Roberson kylerob@uab.edu
 */
public class Group extends Properties {

    /**
     * The list of Bulbs in the Group
     */
    protected ArrayList<Bulb> bulbs = new ArrayList<>();
    private static int groupCount   = 1;
    
    /**
     * Constructs a new Group.
     * @param title String title of the Group
     */
    public Group(String title) {
        super(title);
        groupCount++;
    }
    
    // Querries
    /**
     * Get the Group prefix "G-" to allow construction of Group componentID.
     * @return "G-"
     */
    @Override
    public String getComponentPrefix() {
        return "G-";
    }
    
    /**
     * Get the Group count to allow construction of Group component ID.
     * @return int number of Groups
     */
    @Override
    public int getComponentCount() {
        return groupCount;
    }

}
