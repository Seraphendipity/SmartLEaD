/*
 * File: Controller.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  kylerob-P5 - EE333 Spring 2019
 * Vers: 1.0.5 04/04/2019 KAR - Javadoc, finalizing
 * Vers: 1.0.4 04/03/2019 KAR - finished coding
 * Vers: 1.0.3 04/02/2019 KAR - quick finish coding.. see Controller_vs_1.txt
 * Vers: 1.0.2 04/01/2019 KAR - continuing coding
 * Vers: 1.0.1 03/30/2019 KAR - initial coding
 * Vers: 1.0.0 03/29/2019 KAR - initial coding
 *
 */
package p5;

import java.util.ArrayList;

/**
 * Model a Smart Light System's controller
 * @author Kyle A. Roberson kylerob@uab.edu
 */
public class Controller {
    /**
     * Enum of colors to choose from.
     */
    public enum Color {

        /**
         * Color chosen is White
         */
        White,

        /**
         *Color chosen is Red
         */
        Red,

        /**
         * Color chosen is Orange
         */
        Orange,

        /**
         * Color chosen is Yellow
         */
        Yellow,

        /**
         * Color chosen is Green
         */
        Green,

        /**
         * Color chosen is Blue
         */
        Blue,

        /**
         * Color chosen is Indigo
         */
        Indigo,

        /**
         * Color chosen is Violet
         */
        Violet
    }
    protected String         title;
    protected ArrayList<Hub> hubs         = new ArrayList<>();
    private int              numberHubs   = 0;
    private int              numberGroups = 0;
    private int              numberBulbs  = 0;
   
    /**
     * Constructs a new Controller
     * @param title The title of the controller
     */
    public Controller(String title) {
         if (title == null) {
            this.title = "Unnamed";
        } else {
            this.title = title;
        }
    }
    
    // Querries

    /**
     * Represent a text description of the controller like
     *   {title} with {#hubs} Hubs, {#goups} Groups, and {#bulbs} Bulbs. 
     *   {List of hubs with the list groups and bulbs contained in each hub}
     * @return a String representation of the Smart Light System
     */
    @Override
    public String toString() {
        return title + " with " + hubs.size()   + " Hubs, " +
                                  numberGroups + " Groups, and " +
                                  numberBulbs  + " Bulbs.\n" + "Hubs: " + hubs 
                                  + ".";
    }

    /**
     * Get an existing Hub
     * @param hubTitle the Title of the Hub wanted
     * @return The Hub with the name of hubTitle
     */
    public Hub getHub(String hubTitle) {
        Hub h = null;
        if (!hubs.isEmpty()) {
            for (int i = 0; i < hubs.size(); i++) {
                if (hubs.get(i).title.equals(hubTitle)){
                    h = hubs.get(i);
                    break;
                }
            }
        }    
        return h;
    }
    
    // Commands

    /**
     * Create a new Hub and adds it to ArrayList hubs
     * @param title The name by which the Hub is known
     */
    
    public void newHub(String title) {
        addHub(new Hub(title));
    }
    
    /**
     * Add a Hub to ArrayList hubs
     * @param hub the Hub object to add 
     */
    public void addHub(Hub hub) {
        if (hub != null && getHub(hub.title) == null) {
            hubs.add(hub); 
            numberHubs++;
        }
    }
    
    /**
     * Remove a hub from ArrayList hubs
     * @param hubTitle The title of the Hub to be removed
     */
    public void removeHub(String hubTitle) {
        removeHub(getHub(hubTitle));
    }

    /**
     * Remove a hub from ArrayList hubs
     * @param hub The Hub to be removed 
     */
    public void removeHub(Hub hub) {
        if (hub != null && hubs.contains(hub)) {
            numberGroups = numberGroups - hub.groups.size();
            hub.groups.clear();
            numberBulbs = numberBulbs - hub.bulbs.size();
            hub.bulbs.clear();
            hubs.remove(hub); 
            numberHubs--;
        }
    }
    
    /**
     * Create a new bulb and adds it to the System
     *  Assumes there is only one hub declared in ArrayList hubs
     * @param title The title of the bulb to be created and added
     */
    public void newBulb(String title) {
        addBulb(new Bulb(title));
    }
    
    /**
     * Create a new bulb and adds it to the specified hub.
     * @param bulbTitle The title of the bulb to be created and added
     * @param hubTitle The title of the hub the new bulb will be added to
     */
    public void newBulb(String bulbTitle, String hubTitle) {
        addBulb(new Bulb(bulbTitle), hubTitle);
    }
    
    /**
     * Add an existing bulb to the system. Assumes there is 
     * only one hub declared in ArrayList hubs.
     * @param bulb The bulb to be added.
     */
    private void addBulb(Bulb bulb) {
        if (!hubs.isEmpty() && !hubs.get(0).bulbs.contains(bulb)) {
            hubs.get(0).bulbs.add(bulb);
            numberBulbs++;
        }
    }
    
    /**
     * Add an existing bulb to the existing hub. 
     * @param bulb Bulb being added
     * @param hub Hub the bulb is added to
     */
    private void addBulb(Bulb bulb, Hub hub) {
        if (hubs.contains(hub) && hub.getBulb(bulb.componentID) == null) {
            hub.bulbs.add(bulb);
            numberBulbs++;
        }
    }
   
    /**
     * Add a bulb to the specified hub.
     * @param bulb the Bulb being added.
     * @param hubTitle String title of the Hub the bulb is being added to.
     */
    public void addBulb(Bulb bulb, String hubTitle) {
        if (getHub(hubTitle) != null && 
                getHub(hubTitle).getBulb(bulb.componentID) == null) { 
            getHub(hubTitle).bulbs.add(bulb);
            numberBulbs++;
        }
    }
    
    /**
     * Removes the bulb from each hub it exists in.
     * @param bulbID String ID of the bulb to be removed.
     */
    public void removeBulb(String bulbID) {
        for (int i = 0; i < hubs.size(); i++) {
                if (hubs.get(i).getBulb(bulbID) != null) {
                    hubs.get(i).bulbs.remove(hubs.get(i).getBulb(bulbID));
                    numberBulbs--;
                }
        }
    }
    
    /**
     * Removes the bulb from each hub it exists in.
     * @param bulb The Bulb to be removed.
     */
    private void removeBulb(Bulb bulb) {
        for (int i = 0; i < hubs.size(); i++) {
                if (hubs.get(i).bulbs.contains(bulb)) {
                    hubs.get(i).bulbs.remove(bulb);
                    numberBulbs--;
                }
        }
    }
    
//    /**
//     * Removes the specified bulb from the specified hub.
//     * @param bulbID String Bulb ID that is to be removed.
//     * @param hubTitle String title of the Hub from which to remove the bulb.
//     */
//    public void removeBulb(String bulbID, String hubTitle) {
//        if (getHub(hubTitle) != null && hubs.get(hubs.indexOf(getHub(hubTitle))).getBulb(bulbID) != null) {
//            hubs.get(hubs.indexOf(getHub(hubTitle))).bulbs.remove(hubs.indexOf(getHub(hubTitle).getBulb(bulbID)));
//            numberBulbs--;
//        }   
//    }
    /**
     * Removes the specified bulb from the specified hub.
     * @param bulbID String Bulb ID that is to be removed.
     * @param hubTitle String title of the Hub from which to remove the bulb.
     */
    public void removeBulb(String bulbID, String hubTitle) {
        if (getHub(hubTitle) != null && 
                getHub(hubTitle).getBulb(bulbID) != null) {
            getHub(hubTitle).bulbs.remove(getHub(hubTitle).getBulb(bulbID));
            numberBulbs--;
        }   
    }
    
    /**
     * Removes the specified bulb from the specified hub.
     * @param bulb Bulb that is to be removed.
     * @param hub Hub that the bulb is to be removed from.
     */
    private void removeBulb(Bulb bulb, Hub hub) {
        if (hubs.contains(hub) && hubs.get(hubs.indexOf(hub)).bulbs.contains(bulb)) {
            hubs.get(hubs.indexOf(hub)).bulbs.remove(bulb);
            numberBulbs--;
        }
    }
    
    /**
     * Creates a new Group and adds it to the System. Assumes there is 
     * only one Hub in the system.
     * @param groupTitle String title of the group being created/added.
     */
    public void newGroup(String groupTitle) {
        addGroup(new Group(groupTitle));
    }

    /**
     * Creates a new Group and adds it to the specified hub.
     * @param groupTitle String title of the group being created/added.
     * @param hubTitle String title of the Hub the Group is being added.
     */
    public void newGroup(String groupTitle, String hubTitle) {
        addGroup(new Group(groupTitle), hubTitle);
    }
    
    private void addGroup(Group group) {
        if (!hubs.isEmpty() && !hubs.get(0).groups.contains(group)) {
            hubs.get(0).groups.add(group);
            numberGroups++;
        }
    }
    private void addGroup(Group group, String hubTitle) {
        //if (!hubs.isEmpty() && !hubs.get(hubs.indexOf(getHub(hubTitle))).groups.contains(group))
        if (getHub(hubTitle) != null) {
            getHub(hubTitle).groups.add(group);
            numberGroups++;
        }
    }
    
    /**
     * Removes the specified group from the system. Assumes there is only
     * one Hub in the System.
     * @param groupTitle String title of the group to be removed.
     */
    public void removeGroup(String groupTitle) {
        if (!hubs.isEmpty())
            removeGroup(groupTitle, hubs.get(0).title);
    }
    
    /**
     * Remove the specified group from the specified hub.
     * @param groupTitle String title of the group to be removed
     * @param hubTitle String title of the Hub to remove the group from.
     */
    public void removeGroup(String groupTitle, String hubTitle) {
        if (getHub(hubTitle) != null && getHub(hubTitle).getGroup(groupTitle) != null) {
            getHub(hubTitle).groups.remove(getHub(hubTitle).getGroup(groupTitle));
            numberGroups--;
        }
    }
    /**
     * Adds the bulb to the specified group. Since no Hub is passed, it is 
     * assumed that the hub specified is the first hub in the system.
     * @param bulbID String ID of the bulb being added
     * @param groupTitle String title of the group the bulb is being added to.
     */
    public void addToGroup(String bulbID, String groupTitle) {
        if (!hubs.isEmpty())
            addToGroup(bulbID, groupTitle, hubs.get(0).title);
    }

    /**
     * Adds a specified Bulb to a specified Group in a specified Hub.
     * @param bulbID String Bulb ID of existing Bulb to be added.
     * @param groupTitle String title of the group to add the Bulb.
     * @param hubTitle String title of the Hub the group is in.
     */
    public void addToGroup(String bulbID, String groupTitle, String hubTitle) {
        if (getHub(hubTitle) != null && getHub(hubTitle).getGroup(groupTitle) != null 
                && getHub(hubTitle).getBulb(bulbID) != null
                //&& !getHub(hubTitle).getGroup(groupTitle).bulbs.contains(getHub(hubTitle).getBulb(bulbID)))
                && !getHub(hubTitle).isInGroup(groupTitle, bulbID))
            getHub(hubTitle).getGroup(groupTitle).bulbs.add(getHub(hubTitle).getBulb(bulbID));
    }
    
    /**
     * Removes a bulb from a group. Assumes only one Hub in the System.
     * @param bulbID String ID of the Bulb being removed.
     * @param groupTitle String title of the group.
     */
    public void removeFromGroup(String bulbID, String groupTitle) {
        if (!hubs.isEmpty())
            removeFromGroup(bulbID, groupTitle, hubs.get(0).title);
    }

    /**
     * Remove a bulb from a group in a specified hub.
     * @param bulbID String ID of the Bulb being removed.
     * @param groupTitle String title of the group.
     * @param hubTitle String title of the Hub.
     */
    public void removeFromGroup(String bulbID, String groupTitle, String hubTitle) {
        if (getHub(hubTitle) != null && getHub(hubTitle).getGroup(groupTitle) != null 
                && getHub(hubTitle).getBulb(bulbID) != null
                //&& getHub(hubTitle).getGroup(groupTitle).bulbs.contains(getHub(hubTitle).getBulb(bulbID)))
                && getHub(hubTitle).isInGroup(groupTitle, bulbID))
            getHub(hubTitle).getGroup(groupTitle).bulbs.remove(getHub(hubTitle).getBulb(bulbID));
    }
    
    /**
     * Turn on a Bulb
     * @param bulbID String ID of the bulb 
     */
    public void turnOnBulb(String bulbID) {
        if (!hubs.isEmpty()) {
            for (int i = 0; i < hubs.size();i++) {
                if (hubs.get(i).getBulb(bulbID) != null 
                    && !hubs.get(i).getBulb(bulbID).on) {
                    hubs.get(i).getBulb(bulbID).on = true;
                    break;
                    
                }
            }
        }
    }
    
    /**
     * Turn off a Bulb
     * @param bulbID String ID of the bulb
     */
    public void turnOffBulb(String bulbID) {
        if (!hubs.isEmpty()) {
            for (int i = 0; i < hubs.size();i++) {
                if (hubs.get(i).getBulb(bulbID) != null
                    && hubs.get(i).getBulb(bulbID).on) {
                    hubs.get(i).getBulb(bulbID).on = false;
                    break;
                }
            }
        }
    }
    
    /**
     * Turn on a Group in a specified Hub.
     * @param groupTitle String title of the group
     * @param hubTitle String title of the Hub
     */
    public void turnOnGroup(String groupTitle, String hubTitle) {
        if (getHub(hubTitle) != null && getHub(hubTitle).getGroup(groupTitle) != null 
            && !getHub(hubTitle).getGroup(groupTitle).bulbs.isEmpty() && 
             !getHub(hubTitle).isOn(getHub(hubTitle).getGroup(groupTitle).UID)) 
        {
            getHub(hubTitle).getGroup(groupTitle).on = true;
            for (int i = 0; i < getHub(hubTitle).getGroup(groupTitle).bulbs.size(); i++) {
                if (!getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).on) 
                    getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).on = true;
                if ( getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).brightness 
                     != getHub(hubTitle).getGroupBrightness(groupTitle))
                    getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).brightness 
                          = getHub(hubTitle).getGroupBrightness(groupTitle);
                if (getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).color 
                        != getHub(hubTitle).getGroupColor(groupTitle))
                    getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).color 
                          = getHub(hubTitle).getGroupColor(groupTitle);
            }
            
        }
    }
    
    /**
     * Turn off a Group in a specified Hub
     * @param groupTitle String title of the Group.
     * @param hubTitle String title of the Hub.
     */
    public void turnOffGroup(String groupTitle, String hubTitle) {
        if (getHub(hubTitle) != null && getHub(hubTitle).getGroup(groupTitle) != null
            && !getHub(hubTitle).getGroup(groupTitle).bulbs.isEmpty() 
            && getHub(hubTitle).isOn(getHub(hubTitle).getGroup(groupTitle).UID)) 
        {
            getHub(hubTitle).getGroup(groupTitle).on = false;
            for (int i = 0; i < getHub(hubTitle).getGroup(groupTitle).bulbs.size(); i++) {
                if (getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).on) 
                    getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).on = false;
            }
        }
    }
    
    /**
     * Set the color of a Bulb.
     * @param bulbID String ID of the bulb.
     * @param color p5.Controller.Color color to be set
     */
    public void setColorBulb(String bulbID, Color color) {
        if (!hubs.isEmpty()) {
            for (int i = 0; i < hubs.size();i++) {
                if (hubs.get(i).getBulb(bulbID) != null
                    && hubs.get(i).getBulbColor(bulbID) != color)
                {
                    hubs.get(i).getBulb(bulbID).color = color;
                    break;
                }
            }
        }
    }
    
    /**
     * Set the color of a Group in a specified Hub.
     * @param groupTitle String title of the group.
     * @param color p5.Controller.Color color to be set.
     * @param hubTitle String title of the hub.
     */
    public void setColorGroup(String groupTitle, Color color, String hubTitle) {
        if (getHub(hubTitle) != null && getHub(hubTitle).getGroup(groupTitle) != null
            && !getHub(hubTitle).getGroup(groupTitle).bulbs.isEmpty() 
            && getHub(hubTitle).getGroupColor(groupTitle) != color) 
        {
            getHub(hubTitle).getGroup(groupTitle).color = color;
            if (getHub(hubTitle).isOn(getHub(hubTitle).getGroup(groupTitle).UID)){
                for (int i = 0; i < getHub(hubTitle).getGroup(groupTitle).bulbs.size(); i++){
                    if (getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).color != color)
                        getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).color = color;
                }
            }
        }
    }
    
    /**
     * Set the brightness of a Bulb. Proper range is 1 - 10. 
     * @param bulbID String ID of the bulb.
     * @param brightness int brightness of the bulb. Will be auto-ranged if incorrect
     */
    public void setBrightnessBulb(String bulbID, int brightness) {
        if (brightness < 1) {
            brightness = 1;
        }
        else if (brightness > 10) {
            brightness = 10;
        }
        
        if (!hubs.isEmpty()) {
            for (int i = 0; i < hubs.size();i++) {
                if (hubs.get(i).getBulb(bulbID) != null &&
                    hubs.get(i).getBulbBrightness(bulbID) != brightness) {
                    hubs.get(i).getBulb(bulbID).brightness = brightness;
                    break;
                }
            }
        }
    }
    
    /**
     * Set the brightness of a Group. Proper range is 1 - 10. 
     * @param groupTitle String title of the Group
     * @param brightness int brightness to be set. Will auto-range 
     * @param hubTitle String title of the hub
     */
    public void setBrightnessGroup(String groupTitle, int brightness, String hubTitle) {
        if (brightness < 1) {
            brightness = 1;
        }
        else if (brightness > 10) {
            brightness = 10;
        }
        
        if (getHub(hubTitle) != null && getHub(hubTitle).getGroup(groupTitle) != null
            && !getHub(hubTitle).getGroup(groupTitle).bulbs.isEmpty() && 
                getHub(hubTitle).getGroupBrightness(groupTitle) != brightness) 
        {
            getHub(hubTitle).getGroup(groupTitle).brightness = brightness;
            if (getHub(hubTitle).isOn(getHub(hubTitle).getGroup(groupTitle).UID)){
                for (int i = 0; i < getHub(hubTitle).getGroup(groupTitle).bulbs.size(); i++) {
                    if (getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).brightness != brightness)
                        getHub(hubTitle).getGroup(groupTitle).bulbs.get(i).brightness = brightness;
                }
            }
        }
    }
    
    /**
     * Set the title of the Hub
     * @param newHubTitle String new title 
     * @param currentHubTitle String current title of the Hub
     */
    public void setTitleHub(String newHubTitle, String currentHubTitle) {
        if (getHub(currentHubTitle) != null) {
            if (newHubTitle != null)
                getHub(currentHubTitle).title = newHubTitle;
        }
    }
    
    /**
     * Set the title of the Group.
     * @param newGroupTitle String new title
     * @param currentGroupTitle String current title of Group
     * @param hubTitle String Hub title where group is located
     */
    public void setTitleGroup(String newGroupTitle, String currentGroupTitle, 
            String hubTitle) {
        if (getHub(hubTitle) != null && 
                getHub(hubTitle).getGroup(currentGroupTitle) != null) {
            if (newGroupTitle == null)
                newGroupTitle = getHub(hubTitle).getGroup(currentGroupTitle).componentID;
            getHub(hubTitle).getGroup(currentGroupTitle).title = newGroupTitle;
        }
    }
    
    /**
     * Set the title of the Bulb
     * @param newBulbTitle String new title
     * @param bulbID String ID of the bulb
     * @param hubTitle String Hub title where Bulb is located
     */
    public void setTitleBulb(String newBulbTitle, String bulbID, String hubTitle)
    {
        if (getHub(hubTitle) != null && 
                getHub(hubTitle).getBulb(bulbID) != null) {
            if (newBulbTitle == null)
                newBulbTitle = getHub(hubTitle).getBulb(bulbID).componentID;
            getHub(hubTitle).getBulb(bulbID).title = newBulbTitle;
        }
    }
    
    /**
     * Set the title of the Controller
     * @param newControllerTitle String new title
     * @param currentTitle String current title of the Controller
     */
    public void setTitleController(String newControllerTitle, String currentTitle)
    {
        if (this.title == currentTitle && newControllerTitle != null) {
            this.title = newControllerTitle;
        }
    }
    
}
