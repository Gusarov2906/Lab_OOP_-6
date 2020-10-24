package lab2.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import lab2.animals.Animal;
import lab2.animals.Waterfowl;
import lab2.aviaries.AquariumAviary;

/**
*
* @author Gusarov2906
* @version 0.0.1
*/

/**
 * Main - main class of program.
 * @author Gusarov2906
 *
 */

public class Main {
	
	public static boolean autotestsMode = false;
	public static boolean debugMode = true;
	public static HashMap<String, User> users = new HashMap<String, User>();
	
	/**
	 * createUsers - function to fill field users by these users.
	 */
	
	public static void createUsers()
	{
		logsWrite("Main: call createUsers");
		users.put("admin", new User("admin", "admin",Group.root));
		users.put("crazyfrog", new User("crazyfrog", "1234",Group.user));
		users.put("user", new User("user", "user",Group.user));
		logsWrite("Main: createUsers succesfully ended");
	}
	
	/**
	 * loadSettings - function to load configuration file.
	 */
	
	public static void loadSettings() {
		//logsWrite("Main: call loadSettings");
        try (FileReader reader = new FileReader("Settings.txt")) 
        {
            BufferedReader read = new BufferedReader(reader);
            debugMode = Boolean.parseBoolean(read.readLine());
            autotestsMode = Boolean.parseBoolean(read.readLine());
            read.close();
        } 
        catch (Exception e) 
        {
        	logsWrite(e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }
        //logsWrite("Main: loadSettings succesfully ended");
    }

	/**
	 * saveSettings - function to save configuration file.
	 */
	
    public static void saveSettings() {
    	logsWrite("Main: call saveSettings");
        try (FileWriter writer = new FileWriter("Settings.txt", false)) {
            writer.write(debugMode + "\n");
            writer.write(autotestsMode + "\n");
            writer.flush();
            writer.close();
        } catch (Exception e) {
        	logsWrite(e.getMessage());
            System.out.println("Exception: " + e.getMessage());
        }
        logsWrite("Main: saveSettings succesfully ended");
    }
    
    /**
     * loadFromFile - function load database from file.
     * @param fileName - name of database file.
     * @param db - current database.
     * @return - changed database.
     */
    
	public static Database loadFromFile(String fileName, Database db)
	{
		logsWrite("Main: call loadFromFile");
		 try 
		 {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			db = (Database) ois.readObject();
			Animal.id = db.maxId;
			ois.close();
			fis.close();
		 } 
		 catch (FileNotFoundException e) 
		 {
			logsWrite(e.getMessage());
			System.out.println("Exception: " + e.getMessage());
		 }
		 catch (IOException e) 
		 {
			logsWrite(e.getMessage());
			System.out.println("Exception: " + e.getMessage());
		 } 
		 catch (ClassNotFoundException e) 
		 {
			logsWrite(e.getMessage());
			System.out.println("Exception: " + e.getMessage());
		 }
		 logsWrite("Main: loadFormFile succefully ended");
		 return db;
	}
	
	/**
	 * saveToFile - save database to file.
	 * @param fileName - name of file.
	 * @param db - current database.
	 */
	
	public static void saveToFile(String fileName, Database db)
	{
		logsWrite("Main: call saveToFile"); 
		db.maxId = Animal.id;
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
			logsWrite(e.getMessage());
			System.out.println("Exception: " + e.getMessage());
		} 
		catch (IOException e) 
		{
			logsWrite(e.getMessage());
			System.out.println("Exception: " + e.getMessage());
		}
		logsWrite("Main: saveToFile succefully ended");
		
	}
	
	/**
	 * logsWrite - function to write logs if debugMode true.
	 * @param str - message to logs.
	 */
	
	public static void logsWrite(String str)
	{
		if (debugMode) Logger.write(str);
	}
	
	/**
	 * autotest1 - first autotest to check efficiency.
	 * @param db - current database.
	 * @param menu - menu to get from it default aviary.
	 */
	
	public static void autotest1(Database db, Menu menu)
	{
		Logger.write("Main: Autotest: start");
		System.out.println("Autotest1:");
		System.out.println();
		Waterfowl fish1 = new Waterfowl("Petr", "Fish", 1.23f, 1);
		System.out.println("\n#Created Petr\n");
		Logger.write("Main: Autotest: created Waterfowl animal named Petr");
		db.arrayAquariumAviary.get(0).view();
		Waterfowl fish2 = new Waterfowl("Vasia", "Fish", 2.67f, 2);
		System.out.println("\n#Created Vasia\n");
		Logger.write("Main: Autotest: created Waterfowl animal named Vasia");
		db.arrayAquariumAviary.get(0).view();
		System.out.println();
		AquariumAviary aviary1 = new AquariumAviary("SwimmingPool");
		System.out.println("#Created SwimmingPool\n");
		Logger.write("Main: Autotest: created AquariumAviary SwimmingPool");
		db.arrayAquariumAviary.get(0).view();
		aviary1.view();
		System.out.println();
		fish1.move(aviary1);
		System.out.println("\n#Moved Petr to SwimmingPool\n");
		Logger.write("Main: Autotest: moved Petr to SwimmingPool");
		db.arrayAquariumAviary.get(0).view();
		System.out.println();
		aviary1.view();
		System.out.println();
		fish2.remove();
		System.out.println("\n#Removed Vasia from default aviary\n");
		Logger.write("Main: Autotest: removed Vasia from default aviary");
		db.arrayAquariumAviary.get(0).view();
		System.out.println();
		aviary1.view();
		fish1.remove();
		System.out.println("\n#Removed Petr from SwimmingPool\n");
		Logger.write("Main: Autotest: removed Petr from default aviary");
		db.arrayAquariumAviary.get(0).view();
		System.out.println();
		aviary1.view();
		System.out.println();
		System.out.println();
		Logger.write("Main: Autotest: finish");
	}
	
	/**
	 * Method 'show_start_info' show info about work and author in console.
	 */
	
	public static void showStartInfo()
	{
		logsWrite("Main: Call func showStartInfo");
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
		loadSettings();
		
		logsWrite("Main: Start programm");
		Menu menu = new Menu();
		User currentUser;
		
		menu.clearConsole();
		Main.showStartInfo();
		
		createUsers();
		currentUser = menu.authorize(users);
		
		Database db = new Database();
		db.createDefAviaries();
		
		if (autotestsMode)
		{
			autotest1(db, menu);
		}

		db = loadFromFile("database.txt", db);
		
		try {
		db = menu.run(db, currentUser.getGroup());
		//saveToFile("database.txt", db);
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
		
		
	}
}