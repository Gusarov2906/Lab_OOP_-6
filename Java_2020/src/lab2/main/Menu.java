package lab2.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import lab2.animals.ColdBlooded;
import lab2.animals.Feathered;
import lab2.animals.Ungulates;
import lab2.animals.Waterfowl;

import lab2.aviaries.AquariumAviary;
import lab2.aviaries.Aviary;
import lab2.aviaries.InfraredLightedAviary;
import lab2.aviaries.MeshAviary;
import lab2.aviaries.OpenAirAviary;


public final class Menu {
	
	//Fields
	
	static private String name;
	static private String type;
	static private float weight;
	static private int age;
	
	private int cmd = -1;
	private int id = 0;
	private int moveTo = 0;
	
	//Methods
	
	/**
	 * NegIntException - exception for checking integer number bigger or equal 0.
	 */
	
	public class NegIntException extends Exception { 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public NegIntException(String errorMessage) {
	        super(errorMessage);
	    }
	    
	}
	
	/**
	 * MaxIntException - exception for checking integer number bigger than something.
	 */
	
	public class MaxIntException extends Exception { 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MaxIntException(String errorMessage) {
	        super(errorMessage);
	    }
	    
	}
	
	/**
	 * readPosInt - safety analog Scanner.nextInt() (checking 2 exceptions).
	 * @param scanner - object type Scanner from where you get integer number.
	 * @return Function returns positive or null integer number, which get from scanner or close program with exception.
	 */
	
	public int readPosInt(Scanner scanner) {
		int num = -1;
		while(num < 0)
		{
		  try {
			num = scanner.nextInt();
			if (num < 0)
			{
				throw new NegIntException("Number shouldn't be less then null!");
			}
		  }
		  catch (java.util.InputMismatchException e) {
		    String token = scanner.next();
		    System.out.println("EXCEPTION: not int was readen - " + token + " !");
		    Logger.write("EXCEPTION: not int was readen - " + token + " !");
			System.out.print("Write cmd again: ");
		    Logger.addError(e);
		    num = -1;
		  }
		  catch (java.util.NoSuchElementException e) {
			System.out.println("EXCEPTION: no int nums ! ");
			Logger.write("EXCEPTION: no int nums ! ");
			Logger.addError(e);
			num = -1;
		  }
		  catch (NegIntException e) {
			System.out.println("EXCEPTION: negative int was readen - " + num + " !");
			Logger.write("EXCEPTION: negative int was readen - " + num + " !");
			System.out.print("Write cmd again: ");
			Logger.addError(e);
			num = -1;
		  }
		}
	    return num;
	}
	
	/**
	 * readCmd -  function to read command from user.
	 * @param scanner - object type Scanner from where you get integer number.
	 * @param maxNumCmd - number of max command which can be readen.
	 * @return Function returns real command for menu.
	 */
	
	public int readCmd(Scanner scanner, int maxNumCmd)
	{
		int cmd = -1;
		while (cmd == -1)
		{
		try {
		cmd = readPosInt(scanner);
		if (cmd > maxNumCmd)
		{
			MaxIntException e = new MaxIntException("Number shouldn't be begger then " + maxNumCmd + " !");
			throw e;
		}
		}
		catch (MaxIntException e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.print("Write cmd again: ");
			Logger.addError(e);
		    cmd = -1;
		}
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.print("Write cmd again: ");
			Logger.addError(e);
			cmd = -1;
		}
		}
		return cmd;
	}
	
	/**
	 * arrayView - function to output array.
	 * @param array - array with items.
	 */
	
	public void arrayView(ArrayList<? extends Aviary> array)
	{
		for(int i = 0; i < array.size(); i++)
		{
			System.out.print(i+ ": ");
			array.get(i).view();
			System.out.println();
		}
	}
	
	/**
	 * getFields - function to get some variables from user.
	 * @param scanner - object type Scanner from where you get integer number.
	 */
	
	private void getFields(Scanner scanner)
	{
		System.out.print("Write name: ");
		name = scanner.next();
		System.out.print("Write type(rank, class or something): ");
		type = scanner.next();
		System.out.print("Write weight: ");
		weight = scanner.nextFloat();
		System.out.print("Write age: ");
		age = readPosInt(scanner);	
	}
	
	/**
	 * getMoveCmd - function to get some variables from user for animal to move.
	 * @param scanner
	 */
	private void getMoveCmd(Scanner scanner)
	{
		System.out.print("Write number of aviary, from where you want to move: ");
		cmd = readCmd(scanner,100);
		System.out.print("Write id animal, which you want to move: ");
		id = readCmd(scanner,100);
		System.out.print("Write number of aviary, where you want to move: ");
		moveTo = readCmd(scanner,100);
	}
	
	/**
	 * getRemoveCmd - function to get some variables from user for animal to remove.
	 * @param scanner
	 */
	private void getRemoveCmd(Scanner scanner)
	{
		System.out.print("Write number of aviary, from where you want to remove: ");
		cmd = readCmd(scanner,100);
		System.out.print("Write id animal, which you want to remove: ");
		id = readCmd(scanner,100);
	}
	
	/**
	 * clearConsole - function to clear console window.
	 */
	
	public final void clearConsole() 
	{
		try {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (Exception e)
		{
			Logger.addError(e);
		}
	}  
	
	
	/**
	 * run - start menu.
	 * @param db - Database.
	 * @param group - root or user.
	 * @return db - Database.
	 */
	public Database run(Database db, Group group)
	{
		Main.logsWrite("Menu: start run");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to ZOO!");
		while(true)
		{
		System.out.println();
		System.out.println("What you want to do?");
		System.out.println("1: Show aviaries");
		System.out.println("2: Create animal");
		System.out.println("3: Create aviary");
		System.out.println("4: Move animal");
		System.out.println("5: Remove animal");
		System.out.println("6: Save to file");
		System.out.println("7: Load from file");
		if (group.equals(Group.root))
		{
			System.out.println("8: Autotests");
			System.out.println("9: Dubug logs");
		}
		System.out.println("0: Exit");
		System.out.print("Your cmd: ");
		if (group.equals(Group.root))
		{
		cmd = readCmd(scanner,9);
		}
		else
		{
		cmd = readCmd(scanner,7);
		}
		switch (cmd) {
			case 1:
				clearConsole();
				System.out.println("AVIARIES LIST");
				System.out.println("What type of aviaries you want to look?");
				System.out.println("1: Aquarium");
				System.out.println("2: Open Air");
				System.out.println("3: Mesh");
				System.out.println("4: Infrared Lighted");
				System.out.println("5: All");
				System.out.print("Your cmd: ");
				cmd = readCmd(scanner,5);
				clearConsole();
				System.out.println("AVIARIES LIST");
				switch (cmd) {
					case 1:
						System.out.println("AQUARIUM: \n");
						arrayView(db.arrayAquariumAviary);
						break;
					case 2:
						System.out.println("OPEN AIR: \n");
						arrayView(db.arrayOpenAirAviary);
						break;
					case 3:
						System.out.println("MESH: \n");
						arrayView(db.arrayMeshAviary);
						break;
					case 4:
						System.out.println("INFRARED LIGHTED: \n");
						arrayView(db.arrayInfraredLightedAviary);
						break;
					case 5:
						System.out.println("AQUARIUM:\n");
						arrayView(db.arrayAquariumAviary);
						System.out.println("OPEN AIR:\n");
						arrayView(db.arrayOpenAirAviary);
						System.out.println("MESH:\n");
						arrayView(db.arrayMeshAviary);
						System.out.println("INFRARED LIGHTED:\n");
						arrayView(db.arrayInfraredLightedAviary);
						break;
					default:
						break;
				}
				System.out.println("\nWrite any key to continue:");
				scanner.nextLine();
				scanner.nextLine();
				clearConsole();
				break;
			case 2:
				clearConsole();
				System.out.println("CREATING ANIMAL");
				System.out.println("What type of animal you want to create?");
				System.out.println("1: Waterfowl");
				System.out.println("2: Ungulates");
				System.out.println("3: Feathered");
				System.out.println("4: Cold blooded");
				System.out.print("Your cmd: ");
				cmd = readCmd(scanner,4);
				System.out.println("CREATING ANIMAL");
				clearConsole();
				getFields(scanner);
				switch(cmd) {
					case 1:
						if (Waterfowl.defAquariumAviary != db.arrayAquariumAviary.get(0))
							Waterfowl.defAquariumAviary = db.arrayAquariumAviary.get(0);
						Waterfowl tmp1 = new Waterfowl(name,type,weight,age);
						Main.logsWrite("Menu: created new Waterfowl animal: " + tmp1.getId());
						break;
					case 2:
						if (Ungulates.defOpenAirAviary != db.arrayOpenAirAviary.get(0))
							Ungulates.defOpenAirAviary = db.arrayOpenAirAviary.get(0);
						Ungulates tmp2 = new Ungulates(name,type,weight,age);
						Main.logsWrite("Menu: created new Waterfowl animal: " + tmp2.getId());
						break;
					case 3:
						if (Feathered.defMeshAviary != db.arrayMeshAviary.get(0))
							Feathered.defMeshAviary = db.arrayMeshAviary.get(0);
						Feathered tmp3 = new Feathered(name,type,weight,age);
						Main.logsWrite("Menu: created new Waterfowl animal: " + tmp3.getId());
						
						break;
					case 4:
						if(ColdBlooded.defInfraredLightedAviary != db.arrayInfraredLightedAviary.get(0))
							ColdBlooded.defInfraredLightedAviary = db.arrayInfraredLightedAviary.get(0);
						ColdBlooded tmp4 = new ColdBlooded(name,type,weight,age);
						Main.logsWrite("Menu: created new Waterfowl animal: " + tmp4.getId());
						break;
					default:
						break;
				}
				System.out.println("\nWrite any key to continue:");
				scanner.nextLine();
				scanner.nextLine();
				clearConsole();
				
				break;
			case 3:
				clearConsole();
				System.out.println("CREATING AVIARY");
				System.out.println("What type of aviary you want to create?");
				System.out.println("1: Aquarium");
				System.out.println("2: Open Air");
				System.out.println("3: Mesh");
				System.out.println("4: Infrared Lighted");
				System.out.print("Your cmd: ");
				cmd = readCmd(scanner,4);
				clearConsole();
				System.out.println("CREATING AVIARY");
				System.out.print("Write name: ");
				scanner.nextLine();
				name = scanner.nextLine();
				switch (cmd) {
					case 1:
						db.arrayAquariumAviary.add(new AquariumAviary(name));
						Main.logsWrite("Menu: created new AquariumAviary aviary: " + name);
						break;
					case 2:
						db.arrayOpenAirAviary.add(new OpenAirAviary(name));
						Main.logsWrite("Menu: created new OpenAirAviary aviary: " + name);
						break;
					case 3:
						db.arrayMeshAviary.add(new MeshAviary(name));
						Main.logsWrite("Menu: created new MeshAviary aviary: " + name);
						break;
					case 4:
						db.arrayInfraredLightedAviary.add(new InfraredLightedAviary(name));
						Main.logsWrite("Menu: created new InfraredLightedAviary aviary: " + name);
						break;
				}
				System.out.println("\nWrite any key to continue:");
				scanner.nextLine();
				clearConsole();
				break;
				
			case 4:
				clearConsole();
				System.out.println("From what type of aviary you want to move animal?");
				System.out.println("1: Aquarium");
				System.out.println("2: Open Air");
				System.out.println("3: Mesh");
				System.out.println("4: Infrared Lighted");
				System.out.print("Your cmd: ");
				cmd = readCmd(scanner,4);
				clearConsole();
				System.out.println("MOVE ANIMAL FROM WHERE");
				switch (cmd) {
				case 1:
					System.out.println("AQUARIUM: \n");
					arrayView(db.arrayAquariumAviary);
					getMoveCmd(scanner);
					try {
						db.arrayAquariumAviary.get(cmd).getById(id).move(db.arrayAquariumAviary.get(moveTo));
						Main.logsWrite("Menu: Waterfowl animal with id " + id + " moved to " + db.arrayAquariumAviary.get(moveTo).getName());
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
						Main.logsWrite("Menu: Waterfowl animal not moved!");
						Logger.addError(e);
					}
					
					break;
				case 2:
					System.out.println("OPEN AIR: \n");
					arrayView(db.arrayOpenAirAviary);
					getMoveCmd(scanner);
					try {
						db.arrayOpenAirAviary.get(cmd).getById(id).move(db.arrayOpenAirAviary.get(moveTo));
						Main.logsWrite("Menu: Ungulates animal with id " + id + " moved to " + db.arrayOpenAirAviary.get(moveTo).getName());
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
						Main.logsWrite("Menu: Ungulates animal not moved!");
						Logger.addError(e);
					}
					break;
				case 3:
					System.out.println("MESH: \n");
					arrayView(db.arrayMeshAviary);
					getMoveCmd(scanner);
					try {
						db.arrayMeshAviary.get(cmd).getById(id).move(db.arrayMeshAviary.get(moveTo));
						Main.logsWrite("Menu: Feathered animal with id " + id + " moved to " + db.arrayMeshAviary.get(moveTo).getName());
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
						Main.logsWrite("Menu: Feathered animal not moved!");
						Logger.addError(e);
					}
					break;
				case 4:
					System.out.println("INFRARED LIGHTED: \n");
					arrayView(db.arrayInfraredLightedAviary);
					getMoveCmd(scanner);
					try {
						db.arrayInfraredLightedAviary.get(cmd).getById(id).move(db.arrayInfraredLightedAviary.get(moveTo));
						Main.logsWrite("Menu: ColdBlooded animal with id " + id + " moved to " + db.arrayInfraredLightedAviary.get(moveTo).getName());
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
						Main.logsWrite("Menu: ColdBlooded animal not moved!");
						Logger.addError(e);
					}
					break;
				default:
					break;
				}
				System.out.println("\nWrite any key to continue:");
				scanner.nextLine();
				scanner.nextLine();
				clearConsole();
				break;
				
			case 5:
				clearConsole();
				System.out.println("From what type of aviary you want to remove animal?");
				System.out.println("1: Aquarium");
				System.out.println("2: Open Air");
				System.out.println("3: Mesh");
				System.out.println("4: Infrared Lighted");
				System.out.print("Your cmd: ");
				cmd = readCmd(scanner,4);
				clearConsole();
				System.out.println("REMOVE ANIMAL FROM WHERE");
				switch (cmd) {
				case 1:
					System.out.println("AQUARIUM: \n");
					arrayView(db.arrayAquariumAviary);
					getRemoveCmd(scanner);
					try {
						db.arrayAquariumAviary.get(cmd).remove(id);
						Main.logsWrite("Menu: removed Waterfowl animal: " + id);
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
						Main.logsWrite("Menu: Waterfowl animal not removed!");
						Main.logsWrite(e.getMessage());
					}
					
					break;
				case 2:
					System.out.println("OPEN AIR: \n");
					arrayView(db.arrayOpenAirAviary);
					getRemoveCmd(scanner);
					try {
						db.arrayOpenAirAviary.get(cmd).remove(id);
						Main.logsWrite("Menu: removed Ungulates animal: " + id);
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
						Main.logsWrite("Menu: Ungulates animal not removed!");
						Main.logsWrite(e.getMessage());
					}
					break;
				case 3:
					System.out.println("MESH: \n");
					arrayView(db.arrayMeshAviary);
					getRemoveCmd(scanner);
					try {
						db.arrayMeshAviary.get(cmd).remove(id);
						Main.logsWrite("Menu: removed Feathered animal: " + id);
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
						Main.logsWrite("Menu: Feathered animal not removed!");
					}
					break;
				case 4:
					System.out.println("INFRARED LIGHTED: \n");
					arrayView(db.arrayInfraredLightedAviary);
					getRemoveCmd(scanner);
					try {
						db.arrayInfraredLightedAviary.get(cmd).remove(id);
						Main.logsWrite("Menu: removed Coldlooded animal: " + id);
					}
					catch (Exception e)
					{
						System.out.println("Exception: " + e.getMessage());
						Main.logsWrite("Menu: Coldblooded animal not removed!");
						Main.logsWrite(e.getMessage());
					}
					break;
				default:
					break;
				}
				break;
			case 6:
				Main.saveToFile("database.txt", db);
				break;
			case 7:
				db = Main.loadFromFile("database.txt", db);
				break;
			case 8:
				clearConsole();
				System.out.println("Now autotestsMode is " + Main.autotestsMode );
				System.out.println("1: Switch state");
				System.out.println("0: Back");
				cmd = readCmd(scanner,4);
				if (cmd == 1)
				{
					Main.autotestsMode = !Main.autotestsMode;
					Main.saveSettings();
					Main.logsWrite("Menu: autotestMode changed to: " + Main.autotestsMode);
				}
				clearConsole();
				break;
			case 9:
				clearConsole();
				System.out.println("Now debugMode is " + Main.debugMode );
				System.out.println("1: Switch state");
				System.out.println("0: Back");
				cmd = readCmd(scanner,1);
				if (cmd == 1)
				{
					Main.debugMode = !Main.debugMode;
					Main.saveSettings();
					Main.logsWrite("Menu: debugMode changed to: " + Main.debugMode);
				}
				clearConsole();
				break;
			case 0:
				Main.logsWrite("Menu: exit");
				return db;
				//break;
			default:
				break;
		}
	}
	}

	/**
	 * authorize - function to check if user is registered.
	 * @param userList - list of users.
	 * @return User - current user or null if not authorized.
	 */
	
	public User authorize(HashMap<String, User> userList)
	{
		User user = null;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
		System.out.print("Write login: ");
		String name = scanner.nextLine();
		Main.logsWrite("Menu: get login from keyboard: " + name);
		System.out.print("Write password: ");
		String password = scanner.nextLine();
		Main.logsWrite("Menu: get password from keyboard: " + password);
		if (userList.containsKey(name)){
		if (userList.get(name).getPassword().equals(password)){
				user = userList.get(name);
				Main.logsWrite("Menu: login and password correct");
				break;}
		else {System.out.print("Not correct login or password. Please try again.\n");
				Main.logsWrite("Menu: login and password not correct!");}}
		else {System.out.print("Not correct login or password. Please try again.\n");
		Main.logsWrite("Menu: login and password not correct!");}
		}
		return user;
	}

}
