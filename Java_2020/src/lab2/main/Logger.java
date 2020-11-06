package lab2.main;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Logger - class realize logger, which write debug information to file.
 * @author gusarov2906
 *
 */

public class Logger {
	    private static String fileName = "Logs.txt";
	    private static ArrayList <Exception> errorList = new ArrayList <Exception>();
	    private static int numErrors = 0;
	    
	   /**
	    * write - function to write message to log file.
	    * @param message - string message.
	    */
	    
	    public static void write(String message) {
	        try 
	        {
	            FileWriter writer = new FileWriter(fileName, true);
	            writer.write(LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("H:mm:ss")) + ":\t" + message + "\n");
	            writer.flush();
	            writer.close();
	        }
	        catch (Exception e) 
	        {
	            System.out.println("Exception: " + e.getMessage());
	        }
	    }
	    
	   /**
	    * write - function to write error to log file.
	    * @param error - Exception.
	    */
	    
	    public static void write(Exception error) {
	        try 
	        {
	            FileWriter writer = new FileWriter(fileName, true);
	            writer.write(LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("H:mm:ss")) + ":\t" + "EXCEPTION: " + error.getMessage() + "\n");
	            writer.flush();
	            writer.close();
	        }
	        catch (Exception e) 
	        {
	            System.out.println("Exception: " + e.getMessage());
	        }
	    }
	    
	    /**
	     * writeToLogAndConsole - function to write to console and to log.
	     * @param message - string message.
	     */
	    
	    public static void writeToLogAndConsole(String message)
	    {
	    	write(message);
	    	System.out.println(message);
	    }
	    
	    /**
	     * writeToLab4Log - function to write log for autotest2.
	     * @param message - string message.
	     */
	    
	    public static void writeToLab4Log(String message) {
	        try 
	        {
	            FileWriter writer = new FileWriter(fileName, true);
	            writer.write(LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("H:mm:ss")) + ":\t" + message + "\n");
	            writer.flush();
	            writer.close();
	            writer = new FileWriter("lab4log.txt", true);
	            writer.write(LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("H:mm:ss")) + ":\t" + message + "\n");
	            writer.flush();
	            writer.close();
	        }
	        catch (Exception e) 
	        {
	            System.out.println("Exception: " + e.getMessage());
	        }
	    }
	    
	    /**
	     * addError - function to save error in Logger.
	     * @param e - Exception.
	     */
	    
	    public static void addError(Exception e)
	    {
	    	 write(e);
	    	 numErrors++;
	    	 errorList.add(e);
	    }
	    
	    /**
	     * finish - final function, write about work program. If there were exceptions, show it. 
	     */
	    
	    public static void finish()
	    {
	    	if (Main.debugMode) {
	    	if (errorList.isEmpty())
	    	{
	    		writeToLogAndConsole("\n\nProgram finished without errors.");
	    	}
	    	else
	    	{
	    		writeToLogAndConsole("\n\nProgram finished with errors:");
	    		for (int i = 0; i < numErrors; i++)
	    		{
	    			writeToLogAndConsole(errorList.get(i).getMessage());
	    		}
	    	}
	    	}
	    }

}
