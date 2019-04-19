/*
 * File: Properties.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  kylerob-P5 - EE333 Spring 2019
 * Vers: 1.0.5 04/04/2019 KAR - Javadoc, finalizing
 * Vers: 1.0.2 04/01/2019 KAR - finished coding
 * Vers: 1.0.1 03/30/2019 KAR - initial coding
 * Vers: 1.0.0 03/29/2019 KAR - initial coding
 */
package p5;

/**
 * Defines an abstract class that captures structure behavior of Bulb and Group
 * @author Kyle A. Roberson kylerob@uab.edu
 */
public abstract class Properties {

    /**
     * Color of the Property. 
     * Set by the Enum of colors Defined in Controller class
     */
    protected p5.Controller.Color color;
    
    /**
     * Power state of the Property. True if on, False if off.
     */
    protected boolean     on;

    /**
     * Brightness of the Property. Ranges from 1-10.
     */
    protected int         brightness;

    /**
     * Title of the Property
     */
    protected String      title;

    /**
     * ID specific to the Property type.
     */
    protected String      componentID;
    private static int    propertyCount = 0;

    /**
     * Universal ID of the Property.
     */
    protected int         UID;
    
    /**
     * Super Constructor of a Property. Creates a new Property.
     * A Property can either be a Bulb or a Group.
     * @param title String title of the Property
     */
    public Properties(String title) {
        UID         = ++propertyCount;
        componentID = getComponentPrefix() + getComponentCount();
        on          = false;
        brightness  = 10;
        color       = p5.Controller.Color.White;
        if (title == null) {
            this.title = componentID;
        } else {
            this.title = title;
        }
    }
    
    // Querries 
    
    /**
     * Get the universal Property UID
     * @return int UID
     */
    public int getUID() {
        return UID;
    }
    
    
    /**
     * Get component prefix
     * @return String prefix
     */
    public abstract String getComponentPrefix();

    /**
     * Get component ID number
     * @return int representing number of the Property
     */
    public abstract int getComponentCount();
    
    /**
     * Get title of the Property
     * @return String title of the Property
     */
    public String getTitle() {
        return title;
    }

    /**
     * Represent a text description of the Property like
     * {componentID}:{UID} "{title}" with brightness: {brightness}, color: 
     * {color}, and On/Off = {on}
     * @return a formatted String representing a Property.
     */
    @Override
    public String toString() {
        return "\n" + componentID + ":(" + UID + ") \"" + title + 
                "\" with brightness: " + brightness + ", color: " + color + 
                ", and On/Off = " + on; 
    }
    
}
