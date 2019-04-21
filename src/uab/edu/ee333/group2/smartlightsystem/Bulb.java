/*
 * File: Bulb.java
 * Author: Elijah Rose elirose@uab.edu
 * Assignment:  GroupProject - EE333 Spring 2019
 * Vers: 1.0.0 04/19/2019 ETR - initial coding
 *
 * Credits:  (if any for sections of code)
 */

package uab.edu.ee333.group2.smartlightsystem;

/**
 *
 * @author Elijah Rose elirose@uab.edu
 */
public class Bulb extends Item {
    public Bulb() {
        this.uid = serialCounter++;
        this.name = "Bulb_" + this.uid;
    }

    public Bulb(String newName) {
        new Bulb();
        this.name = newName;
    }
}
