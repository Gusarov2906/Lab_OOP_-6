package lab2.main;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger - class realize logger, which write debug information to file.
 * @author gusarov2906
 *
 */

public class Logger {
	    private static String fileName = "Logs.txt";

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
	    
	    public static void write(Exception error) {
	        try 
	        {
	            FileWriter writer = new FileWriter(fileName, true);
	            writer.write(LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("H:mm:ss")) + ":\t" + error.getMessage() + "\n");
	            writer.flush();
	            writer.close();
	        }
	        catch (Exception e) 
	        {
	            System.out.println("Exception: " + e.getMessage());
	        }
	    }
	    
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
	    

}
