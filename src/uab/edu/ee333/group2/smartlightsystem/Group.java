/*
 * File: Group.java
 * Author: Elijah Rose elirose@uab.edu
 * Assignment:  GroupProject - EE333 Spring 2019
 * Vers: 1.0.0 04/19/2019 ETR - initial coding
 */

package uab.edu.ee333.group2.smartlightsystem;
/**
 *
 * @author Elijah Rose elirose@uab.edu
 */
public class Group extends Item {

    public Group () {
        super(); 
    }
    
    public Group(String name) {
        super(name);
    }

    public String toString() {
        String s = super.toString();
        ((String)s).substring(0, ((String)s).length() - 1);
        s = (String)s + ", bulbsArr=" + this.bulbsArr + "}";
        return s;
    }

    public void turnOn() {
        super.turnOn();
        for (int i = 0; i < this.bulbsArr.size(); ++i) {
            this.bulbsArr.get(i).turnOn();
        }
    }

    public void turnOff() {
        super.turnOff();
        for (int i = 0; i < this.bulbsArr.size(); ++i) {
            this.bulbsArr.get(i).turnOff();
        }
    }

    public void setBrightness(int brightness) {
        super.setBrightness(brightness);
        for (int i = 0; i < this.bulbsArr.size(); ++i) {
            this.bulbsArr.get(i).setBrightness(brightness);
        }
    }

    
    @Override
    public void setColor(String color) {
        super.setColor(color);
        for (int i = 0; i < this.bulbsArr.size(); ++i) {
            System.out.println(bulbsArr.get(i));
            this.bulbsArr.get(i).setColor(color);
        }
    }


}
