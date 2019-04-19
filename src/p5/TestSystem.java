/*
 * File: TestSystem.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  kylerob-P5 - EE333 Spring 2019
 * Vers: 1.0.1 04/04/2019 KAR - Finalizing
 * Vers: 1.0.0 04/03/2019 KAR - initial coding
 *
 */

package p5;

/**
 * Basic testing of models in P5
 * @author Kyle A. Roberson kylerob@uab.edu
 */
public class TestSystem {
    
    /**
     * Starting point for testing the Smart Light System
     * @param args unused
     */
    public static void main(String[] args) {
        
        System.out.println("Kyle A. Roberson kylerob");
        System.out.println("-------------------------");
        System.out.println();
        
        Controller c1 = new Controller("My Controller");
        
        c1.newHub(null);
        
        for ( int i = 0 ; i < 20; i++) {
            c1.newBulb(null);
        }
        
        c1.newGroup("Kitchen");
        c1.newGroup("Living Room");
        c1.newGroup("Bed Room");
        c1.newGroup("Bathroom");
        
        for ( int i = 1 ; i < 20; i++) {
            if (i < 5) {
                c1.addToGroup("B-"+i, "Kitchen");
            }
            else if (i < 11) {
                c1.addToGroup("B-"+i, "Living Room");
            }
            else if (i < 16) {
                c1.addToGroup("B-"+i, "Bed Room");
            }
            else if (i < 18) {
                c1.addToGroup("B-"+i, "Bathroom");
            }
        }
        
        c1.setColorGroup("Kitchen", Controller.Color.Yellow, "H-1");
        c1.setBrightnessGroup("Kitchen", 5, "H-1");
        c1.turnOnGroup("Kitchen", "H-1");
        
        System.out.println("First Print of the System");
        System.out.println(c1);
        System.out.println("---------------------------------------------------"
                + "------------------------");
        System.out.println();
        
        c1.newHub("House 2");
        
        for ( int i = 1 ; i < 21; i++) {
            c1.newBulb("House 2 Bulb-" + i, "House 2");
        }
        
        c1.newGroup("Kitchen2","House 2");
        c1.newGroup("Living Room2","House 2");
        c1.newGroup("Bed Room2","House 2");
        c1.newGroup("Bathroom2","House 2");
        
        // These 3 group based commands won't since bulbs list is empty.
        c1.setBrightnessGroup("Kitchen2", 5,"House 2");
        c1.setColorGroup("Kitchen2", p5.Controller.Color.Yellow,"House 2");
        c1.turnOnGroup("Kitchen2","House 2");
        
        for ( int i = 21 ; i < 40; i++) {
            if (i < 25) {
                c1.addToGroup("B-"+i, "Kitchen2",    "House 2");
            }
            else if (i < 31) {
                c1.addToGroup("B-"+i, "Living Room2","House 2");
            }
            else if (i < 36) {
                c1.addToGroup("B-"+i, "Bed Room2",   "House 2");
            }
            else if (i < 38) {
                c1.addToGroup("B-"+i, "Bathroom2",   "House 2");
            }
        }
        
        c1.setColorGroup("Living Room2", p5.Controller.Color.Blue,  "House 2");
        c1.setColorGroup("Bed Room2",    p5.Controller.Color.Red,   "House 2");
        c1.setColorGroup("Bathroom2",    p5.Controller.Color.Orange,"House 2");
        
        c1.setBrightnessGroup("Living Room2", 0,"House 2");
        c1.setBrightnessGroup("Bed Room2",   11,"House 2");
        c1.setBrightnessGroup("Bathroom2",    2,"House 2");
        
        c1.turnOnGroup("Living Room2","House 2");
        c1.turnOnGroup("Bed Room2",   "House 2");
        c1.turnOnGroup("Bathroom2",   "House 2");
        
        c1.setBrightnessBulb("B-21", 9);
        c1.setBrightnessBulb("B-38", 0);
        c1.setBrightnessBulb("B-39", 2);
        c1.setBrightnessBulb("B-40", 3);
        
        c1.turnOnBulb("B-21");
        c1.turnOnBulb("B-38");
        c1.turnOnBulb("B-39");
        c1.turnOnBulb("B-40");
        
        c1.setColorBulb("B-38", Controller.Color.Green);
        c1.setColorBulb("B-39", Controller.Color.Indigo);
        c1.setColorBulb("B-40", Controller.Color.Violet);
        
        c1.setTitleHub("First Hub", "H-1");
        c1.setTitleController("Controller 1", "My Controller");
        c1.setTitleGroup("Bed Room1", "Bed Room2", "House 2");
        c1.setTitleBulb("Mood Light", "B-40", "House 2");
        
        c1.removeFromGroup("B-1", "Kitchen", "First Hub");
        c1.turnOffBulb("B-1");
        c1.turnOnBulb("B-1");
        
        c1.setColorGroup("Kitchen", Controller.Color.Blue, "First Hub");
        c1.setBrightnessGroup("Kitchen", 2, "First Hub");
        c1.turnOffGroup("Kitchen", "First Hub");
        
        System.out.println("Second print of the System.");
        System.out.println(c1);
        System.out.println("---------------------------------------------------"
                + "-------------------------------");
        System.out.println();
        
        c1.removeBulb("B-22", "House 2");
        c1.removeHub("First Hub");
        c1.removeFromGroup("B-24", "Kitchen2");
        
        c1.setBrightnessBulb("B-10", 0);
        c1.setColorGroup("Bathroom",Controller.Color.Violet, "First Hub");
        
        c1.newBulb("Kitchen2 Oven Light");
        c1.addToGroup("B-41", "Kitchen2");  //This will be good enough for a GUI
        c1.setColorGroup("Kitchen2", Controller.Color.Green, null); // should work
        c1.turnOnGroup("Kitchen2", "House 2");
        
        System.out.println("Third print of the System.");
        System.out.println(c1);
        System.out.println("---------------------------------------------------"
                + "-------------------------------------");
        System.out.println();
        
    }

}
