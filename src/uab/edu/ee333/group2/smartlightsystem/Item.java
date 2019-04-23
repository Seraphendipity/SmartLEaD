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

import java.util.ArrayList;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.beans.value.ObservableValue;


/**
 *
 * @author Elijah Rose elirose@uab.edu
 */
public class Item {
    protected int uid;
    protected SimpleStringProperty name;
    protected SimpleBooleanProperty status;
    protected SimpleIntegerProperty brightness;
    protected SimpleStringProperty color;
    protected static int serialCounter = 0;
    ArrayList<Bulb> bulbsArr = new ArrayList();


    public Item() {
        this("");
    }

    public Item(String newName) {
        this.uid = serialCounter++;
        if ( (newName.isEmpty()) || (newName.trim().length() <= 0) ) {
            this.name = getDefaultName();
        } else {
            this.name = new SimpleStringProperty(newName);
        }
        this.color = new SimpleStringProperty("black");
        this.status = new SimpleBooleanProperty(false);
        this.brightness = new SimpleIntegerProperty(5);
    }

    public SimpleStringProperty getDefaultName() {
        return new SimpleStringProperty("Item_" + uid);
    }
    
    public String toString() {
        return "Bulb{uid=" + getUid() + ", name=" + getName() + ", bOn=" + getStatus() + ", brightness=" + getBrightness() + ", color=" + getColor() + "}";
    }
    
    public String toCsv(String parent) {
        char c = ','; //delimiter
        return (getName() + c + getUid() + c + getStatus() + c + getBrightness() + c + getColor() + c + parent);
    }

    public int getUid() {
        return this.uid;
    }

    public String getName() {
        return this.name.get();
    }

    public Boolean getStatus() {
        return this.status.get();
    }

    public int getBrightness() {
        return this.brightness.get();
    }

    public String getColor() {
        return this.color.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setStatus(Boolean status) {
        this.status.set(status);
    }
    
    public void turnOn() {
        setStatus(true);
    }

    public void turnOff() {
        setStatus(false);
    }

    public void setBrightness(int brightness) {
        this.brightness.set(brightness);
    }
   

    public void setColor(String color) {
        this.color.set(color);
    }
    
    public void addBulb(Bulb bulb) {
        this.bulbsArr.add(bulb);
    }

    public void removeBulb(Bulb bulb) {
        this.bulbsArr.remove((Object)bulb);
    }
    
    public StringProperty nameProperty() {
        return this.name;
    }
    public StringProperty colorProperty() {
        return this.color;
    }
    public IntegerProperty brightnessProperty() {
        return this.brightness;
    }
    public BooleanProperty statusProperty() {
        return this.status;
    }
    
    
    
    
//    public ObservableStringValue<> colorProperty() {
////        ObservableStringValue oColor = new ObservableStringValue();
//        return ObservableStringValue(color);
//    }
}


