/*
 * File: PrintLogger.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  kylerob-P3 - EE333 Spring 2019
 * Vers: 1.1.0 02/19/2019 KAR - finalizing
 * Vers: 1.0.0 02/18/2019 KAR - initial coding
 */

package p5;

/**
 * An I/O class PrintLogger implements the Logger interface and conditionally
 * outputs strings to stdout.
 * @author Kyle A. Roberson kylerob@uab.edu
 */
public class PrintLogger implements Logger {
    private int threshold = 0;
    private int level = -1;
    
    // Constructor
    /** 
     * Create a PrintLogger with specific threshold 
     * @param  threshold   level that has to be met or exceeded for logging 
     * to occur 
     */ 
    public PrintLogger(int threshold) {
        if (threshold >= 0) {
            this.threshold = threshold;
        }
    }
    
    // Commands
    /** 
     * Prints a string to stdout if level is greater than or equal to threshold.   
     * The printing routine will add a newline to the logEntry. 
     * The Logger class defines common values for level. 
     * @param level    value noting the type of the information 
     * @param logEntry text to be part of the printed log 
     */ 
    public void log(int level, String logEntry) {
        if (level >= threshold) {
            if (level < 0 ) {
                // don't print
            }
            else if ( level < 10 ) {
                System.out.println("DEBUG: " + logEntry);
            }
            else if (level < 20) {
                System.out.println("INFO: " + logEntry);
            }
            else if (level < 50) {
                System.out.println("TIMESTAMP: " + logEntry);
            }
            else if (level < 100) {
                System.out.println("WARNING: " + logEntry);
            }
            else if (level < 100000) {
                System.out.println("ERROR: " + logEntry);
            }
            else {
                System.out.println("ALWAYS: " + logEntry);
            }
        }
    }


    /** 
     * Set a new log threshold for actual logging 
     * @param newThreshold level that must be met or exceeded for actual logging  
     * when the logger is asked to log something 
     */ 
    @Override 
    public void setLogThreshold(int newThreshold) {
        
    }
    
    /** 
     * Log a message if `level` is greater than or equal to logger's threshold.   
     * The actual logging routine will add a newline to the logEntry if 
     * appropriate. 
     * @param level    message's level 
     * @param logEntry text to log (a newline will be added if appropriate) 
     */ 
    //@Override
    //public void log(int level, String logEntry) {
        
    //}
    
    /** 
     * Closing the logging on this class.  The use of this log channel is 
     * complete and any closing actions that are necessary should be done.
     */ 
    @Override
    public void close() {
        // does nothing at this point
    }

}
