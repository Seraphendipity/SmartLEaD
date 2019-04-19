/*
 * File: Hub.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  kylerob-P5 - EE333 Spring 2019
 * Vers: 1.0.5 04/04/2019 KAR - Javadoc, finalizing
 * Vers: 1.0.4 04/03/2019 KAR - finished coding
 * Vers: 1.0.3 04/02/2019 KAR - quick finish coding
 * Vers: 1.0.2 04/01/2019 KAR - continuing coding
 * Vers: 1.0.1 03/30/2019 KAR - initial coding
 * Vers: 1.0.0 03/29/2019 KAR - initial coding
 */
package p5;
import java.util.ArrayList;

/**
 * Model a Smart Light System's Hub
 * @author Kyle A. Roberson kylerob@uab.edu
 */
public class Hub {
    
    /**
     * Master list of all bulbs in the Hub
     */
    protected ArrayList<Bulb> bulbs   = new ArrayList<>();

    /**
     * List of all groups in the Hub.
     */
    protected ArrayList<Group> groups = new ArrayList<>();

    /**
     * String Title of the Hub
     */
    protected String title;
    private static int hubCount       = 0;

    /**
     * String ID of the Hub
     */
    protected String hubID;
    
    /**
     * Constructs a new Hub
     * @param title String title of the Hub
     */
    public Hub(String title) {
        hubID = "H-" + ++hubCount;
        if (title == null) {
            this.title = hubID;
        } else {
            this.title = title;
        }
    }
    
    
    // Querries

    /**
     * Represent a text description of the Hub like
     *   [ {HubID}:"{title}" List of Groups: [
     *   {groups}]
     *   List of Bulbs: [
     *   {bulbs}]].
     * @return a String representation of a Hub
     */
    @Override
    public String toString() {
        return "\n" + hubID + ":\"" + title + "\" List of Groups: " + groups + 
               "\n" + hubID + ":\"" + title + "\" List of Bulbs: " + bulbs; 
    }
    
    /**
     * Checks if Property is on.
     * @param UID int universal ID of the Property
     * @return Boolean True if on. False if off.
     */
    public boolean isOn(int UID){
        boolean b = false;
        int found = 0;
        for (int i = 0; i < bulbs.size(); i++ ) {
            if ( bulbs.get(i).UID == UID ) {
                b = bulbs.get(i).on;
                found = 1;
                break;
            }
        }
        if ( found == 0 ) {
            for (int i = 0; i < groups.size(); i++ ) {
                if ( groups.get(i).UID == UID ) {
                    b = groups.get(i).on;
                    break;
                }
            }
        }
        return b;
    }
    
    /**
     * Checks if a Bulb is in a Group.
     * @param groupTitle String title of the Group
     * @param bulbID String ID of the Bulb
     * @return boolean True if in group. False if not in group.
     */
    public boolean isInGroup(String groupTitle, String bulbID) {
        boolean r = false;
        
        for (int i = 0; i < groups.size(); i++ ) {
            if (groups.get(i).title == groupTitle) {
                for (int j = 0; j < groups.get(i).bulbs.size(); j++) {
                    if (groups.get(i).bulbs.get(j).componentID.equals(bulbID)) {
                        r = true;
                        break;
                    }
                }
            }
        }
        return r;
    }
    
    /**
     * Gets a Bulb from a Group
     * @param groupTitle String title of the Group.
     * @param bulbID String ID of the Bulb.
     * @return Bulb if found, null if not found.
     */
    public Bulb findInGroup(String groupTitle, String bulbID) {
        Bulb b = null;
        for (int i = 0; i < groups.size(); i++ ) {
            if (groups.get(i).title == groupTitle) {
                for (int j = 0; j < groups.get(i).bulbs.size(); j++) {
                    if (groups.get(i).bulbs.get(j).componentID.equals(bulbID)) {
                        b = groups.get(i).bulbs.get(j);
                        break;
                    }
                }
            }
        }
        return b;
    }
    
    /**
     * Get an existing Bulb from any Hub
     * @param bulbID String ID of Bulb
     * @return Bulb if found, null if not.
     */
    public Bulb getBulb(String bulbID) {
        Bulb b = null;
        for (int i = 0; i < bulbs.size(); i++) {
            if (bulbs.get(i).componentID.equals(bulbID)) {
                b = bulbs.get(i);
                break;
            }
        }
        return b;
    }
    
    /**
     * Get an existing Group. 
     * @param groupTitle String title of the Group
     * @return Group if found, null if not.
     */
    public Group getGroup(String groupTitle) {
        Group g = null;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).title.equals(groupTitle)) {
                g = groups.get(i);
                break;
            }
        }
        return g;
    }
    
    /**
     * Get a Group's color.
     * @param groupTitle String title of Group.
     * @return p5.Controller.Color if found, null if not.
     */
    public p5.Controller.Color getGroupColor(String groupTitle){
        p5.Controller.Color c = null;
        for (int i = 0; i < groups.size(); i++ ) {
            if (groups.get(i).title.equals(groupTitle)) {
                c = groups.get(i).color;
                break;
            }
        }
        return c;
    }
    
    /**
     * Get a Bulb's color.
     * @param bulbID String ID of the Bulb
     * @return p5.Controller.Color if found, null if not.
     */
    public p5.Controller.Color getBulbColor(String bulbID){
        p5.Controller.Color c = null;
        for (int i = 0; i < bulbs.size(); i++ ) {
            if (bulbs.get(i).componentID.equals(bulbID)) {
                c = bulbs.get(i).color;
                break;
            }
        }
        return c;
    }
    
    /**
     * Get a Group's brightness
     * @param groupTitle String title of the Group
     * @return int the brightness of the group
     */
    public int getGroupBrightness(String groupTitle) {
        int b = 0;
        for (int i = 0; i < groups.size(); i++ ) {
            if (groups.get(i).title.equals(groupTitle)) {
                b = groups.get(i).brightness;
                break;
            }
        }
        return b;
    }
    
    /**
     * Get a Bulb's brightness.
     * @param bulbID String ID of the Bulb.
     * @return int brightness of the Bulb
     */
    public int getBulbBrightness(String bulbID) {
        int b = 0;
        for (int i = 0; i < groups.size(); i++ ) {
            if (groups.get(i).title.equals(bulbID)) {
                b = groups.get(i).brightness;
                break;
            }
        }
        return b;
    }
    
    /**
     * Get the brightness of a Property
     * @param UID int universal ID of the Property
     * @return int the brightness of the Property
     */
    public int getBrightness(int UID) {
        int b = 0;
        for (int i = 0; i < groups.size(); i++ ) {
            if (groups.get(i).UID == UID ) {
                b = groups.get(i).brightness;
                break;
            }
        }
        if (b == 0) {
            for (int i = 0; i < bulbs.size(); i++ ) {
                if (bulbs.get(i).UID == UID ) {
                    b = bulbs.get(i).brightness;
                    break;
                }
            }
        }
        return b;
    }
}
