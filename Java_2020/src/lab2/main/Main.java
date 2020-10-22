package lab2.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
*
* @author Gusarov2906
* @version 0.0.1
*/

public class Main {
	
	public static Database loadFromFile(String fileName, Database db)
	{
		 try 
		 {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			db = (Database) ois.readObject();
			ois.close();
			fis.close();
		 } 
		 catch (FileNotFoundException e) 
		 {
			System.out.println("Exception: " + e.getMessage());
		 }
		 catch (IOException e) 
		 {
			System.out.println("Exception: " + e.getMessage());
		 } 
		 catch (ClassNotFoundException e) 
		 {
			System.out.println("Exception: " + e.getMessage());
		 }
		 return db;
	}
	
	public static void saveToFile(String fileName, Database db)
	{
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(db);
			oos.close();
			fos.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Exception: " + e.getMessage());
		} 
		catch (IOException e) 
		{
			System.out.println("Exception: " + e.getMessage());
		}
		
	}
	
	/**
	 * Method 'show_start_info' show info about work and author in console.
	 */
	
	public static void showStartInfo()
	{
		System.out.println("Lab:     Java Lab 2");
		System.out.println("Author:  Gusarov Andrey");
		System.out.println("Group:   PIN-34");
		System.out.println("Variant: 6");
		System.out.println("Num PC:  14");
		System.out.println();
	}
	
	/**
	 * From 'main' program run.
	 * @param args - There is no parameter handler from the console right now.
	 */
	public static void main(String[] args)
	{
		Menu menu = new Menu();
		
		menu.clearConsole();
		
		Main.showStartInfo();
		
		Database db = new Database();
		db.createDefAviaries();
		db = loadFromFile("database.txt", db);
		try {
		db = menu.run(db);
		saveToFile("database.txt", db);
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
	}
}