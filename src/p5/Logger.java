/*
 * File: Logger.java
 * Author: Kyle A. Roberson kylerob@uab.edu
 * Assignment:  kylerob-P3 - EE333 Spring 2019
 * Vers: 1.0.0 02/18/2019 KAR - initial coding
 */

package p5;

/**
 * Generalizes conditional logging. Nothing will print if level of request does
 * does not equal or exceeds the level at which the logger is operating.
 * @author Kyle A. Roberson kylerob@uab.edu
 */
public interface Logger {
    /** 
     * Set a new log threshold for actual logging 
     * @param newThreshold level that must be met or exceeded for actual logging  
     * when the logger is asked to log something 
     */ 
    public void setLogThreshold(int newThreshold);

    /** 
     * Log a message if `level` is greater than or equal to logger's threshold.   
     * The actual logging routine will add a newline to the logEntry if 
     * appropriate. 
     * @param level    message's level 
     * @param logEntry text to log (a newline will be added if appropriate) 
     */ 
    public void log(int level, String logEntry);

    /** 
     * Closing the logging on this class.  The use of this log channel is 
     * complete and any closing actions that are necessary should be done.
     */ 
    public void close();

}
