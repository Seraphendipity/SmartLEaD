/*
 * File: Group.java
 * Author: Elijah Rose elirose@uab.edu
 * Assignment:  GroupProject - EE333 Spring 2019
 * Vers: 1.0.0 04/19/2019 ETR - initial coding
 */

package TreeExampleOnline;

import java.util.ArrayList;

/**
 *
 * @author Elijah Rose elirose@uab.edu
 */
public class Group extends Item {
    ArrayList<Bulb> bulbsArr = new ArrayList(3);
    private static int gSerialCounter = -1;

    public Group() {
        this.uid = gSerialCounter--;
        this.name = "Group_" + this.uid;
    }

    public String toString() {
        String s = super.toString();
        ((String)s).substring(0, ((String)s).length() - 1);
        s = (String)s + ", bulbsArr=" + this.bulbsArr + "}";
        return s;
    }

    public void turnOn() {
        this.bOn = true;
        for (int i = 0; i < this.bulbsArr.size(); ++i) {
            this.bulbsArr.get(i).turnOn();
        }
    }

    public void turnOff() {
        this.bOn = false;
        for (int i = 0; i < this.bulbsArr.size(); ++i) {
            this.bulbsArr.get(i).turnOff();
        }
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness = brightness > 100 ? 100 : (brightness < 0 ? 0 : brightness);
        for (int i = 0; i < this.bulbsArr.size(); ++i) {
            this.bulbsArr.get(i).setBrightness(brightness);
        }
    }

    public void setColor(String color) {
        this.color = color;
        for (int i = 0; i < this.bulbsArr.size(); ++i) {
            this.bulbsArr.get(i).setColor(color);
        }
    }

    public void addBulb(Bulb bulb) {
        this.bulbsArr.add(bulb);
    }

    public void removeBulb(Bulb bulb) {
        this.bulbsArr.remove((Object)bulb);
    }
}