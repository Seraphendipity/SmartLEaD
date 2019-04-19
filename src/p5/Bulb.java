/*
 * File: Bulb.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  kylerob-P5 - EE333 Spring 2019
 * Vers: 1.0.5 04/04/2019 KAR - Javadoc, finalizing
 * Vers: 1.0.2 04/01/2019 KAR - finished coding
 * Vers: 1.0.1 03/30/2019 KAR - initial coding
 * Vers: 1.0.0 03/29/2019 KAR - initial coding
 */
package p5;

/**
 * Models a Smart Light (Bulb)
 * @author Kyle A. Roberson kylerob@uab.edu
 */
public class Bulb extends Properties {
    private static int bulbCount = 1;
    
    /**
     * Constructs a new Bulb.
     * @param title String title of the Bulb.
     */
    public Bulb(String title) {
        super(title);
        bulbCount++;
    }
    
    // Querries
    /**
     * Get the Bulb prefix "B-" to allow construction of Group component ID.
     * @return "B-"
     */
    @Override
    public String getComponentPrefix() {
        return "B-";
    }
    
    /**
     * Get the Bulb count to allow construction of Group component ID.
     * @return int number of groups
     */
    @Override
    public int getComponentCount() {
        return bulbCount;
    }
    
}
