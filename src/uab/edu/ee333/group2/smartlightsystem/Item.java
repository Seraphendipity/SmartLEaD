/*
 * File: Item.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  SmartLightSystem - EE333 Spring 2019
 * Vers: 1.0.0 04/20/2019 KAR - initial coding
 *
 * Credits:  (if any for sections of code)
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uab.edu.ee333.group2.smartlightsystem;
//import javafx.beans.ObservableValue;

import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;


/**
 *
 * @author Elijah Rose elirose@uab.edu
 */
public class Item {
    protected int uid;
    protected String name;
    protected Boolean status = false;
    protected int brightness = 5;
    protected String color = "White";
    protected static int serialCounter = 0;

    public Item() {
        this.uid = serialCounter++;
        this.name = "Item_" + this.uid;
    }

    public Item(String newName) {
        new Item();
        this.name = newName;
    }

    public String toString() {
        return "Bulb{uid=" + this.uid + ", name=" + this.name + ", bOn=" + this.status + ", brightness=" + this.brightness + ", color=" + this.color + "}";
    }
    
    public String toCsv(String parent) {
        char c = ','; //delimiter
        return (this.name + c + this.uid + c + this.status + c + this.brightness + c + this.color + c + parent);
    }

    public int getUid() {
        return this.uid;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public int getBrightness() {
        return this.brightness;
    }

    public String getColor() {
        return this.color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public void turnOn() {
        setStatus(true);
    }

    public void turnOff() {
        setStatus(false);
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
   

    public void setColor(String color) {
        System.out.println("MY COLOR IS " + color);
        this.color = color;
    }
    
//    public ObservableStringValue<> colorProperty() {
////        ObservableStringValue oColor = new ObservableStringValue();
//        return ObservableStringValue(color);
//    }
}


