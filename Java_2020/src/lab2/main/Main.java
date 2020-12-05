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

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lab2.animals.Animal;

import javafx.application.Application;


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

public class Main extends Application {
	
	public static boolean autotestsMode = false;
	public static boolean debugMode = true;
	public static HashMap<String, User> users = new HashMap<String, User>();
	public static boolean exit = false;
	public static Database db = new Database();
	
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
			Logger.addError(e);
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
			Logger.addError(e);
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
			Logger.addError(e);
			System.out.println("Exception: " + e.getMessage());
		 }
		 catch (IOException e) 
		 {
			Logger.addError(e);
			System.out.println("Exception: " + e.getMessage());
		 } 
		 catch (ClassNotFoundException e) 
		 {
			Logger.addError(e);
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
			Logger.addError(e);
			System.out.println("Exception: " + e.getMessage());
		} 
		catch (IOException e) 
		{
			Logger.addError(e);
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
	 * Method 'show_start_info' show info about work and author in console.
	 */
	
	public static void showStartInfo()
	{
		logsWrite("Main: Call func showStartInfo");
		System.out.println("Lab:     Java Lab 5");
		System.out.println("Author:  Gusarov Andrey");
		System.out.println("Group:   PIN-34");
		System.out.println("Variant: 6");
		System.out.println("Num PC:  14");
		System.out.println();
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("../app/MainWindow.fxml"));
		primaryStage.setTitle("MyZooDatabase");
		primaryStage.getIcons().add(new Image("file:icon.png"));
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	/**
	 * From 'main' program run.
	 * @param args - There is no parameter handler from the console right now.
	 */
	
	public static void main(String[] args)
	{
		//GraphCreator.create(TypeOfGraph.AddMedianTime);

		loadSettings();
		logsWrite("Main: Start program");
		Menu menu = new Menu();
		User currentUser;
		
		//menu.clearConsole();
		//Main.showStartInfo();
		
		createUsers();
		//currentUser = menu.authorize(users);
		
		db = new Database();
		db.createDefAviaries();
		/*
		if (autotestsMode)
		{
			Logger.clear("lab4log.txt");
			Logger.clear("lab5log.txt");
			Autotests.autotest2();
			//Autotests.autotest1(db);
		}
		*/
		//db = loadFromFile("database.txt", db);

		launch(args);

		//db = menu.run(db, currentUser.getGroup());
		Logger.finish();
		
		//saveToFile("database.txt", db);
	}
}