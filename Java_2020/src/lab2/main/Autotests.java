package lab2.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import lab2.animals.Waterfowl;
import lab2.aviaries.AquariumAviary;
import lab2.random.Generator;

public class Autotests {
	
	/**
	 * autotest1 - first autotest to check efficiency.
	 * @param db - current database.
	 * @param menu - menu to get from it default aviary.
	 */
	
	public static void autotest1(Database db)
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
	
	public static void runTestWithArrayList(int size)
	{
		System.out.println("\nArrayList n = " + size + "\n");
		Logger.writeToLab4Log("ARRAYLIST n = " + size);
		long oneOperationTime;
		long totalTime = 0;
		ArrayList<AquariumAviary> arrList = new ArrayList<AquariumAviary>();
		for (int i = 0; i < size; i++)
		{
			AquariumAviary tmpAviary = new AquariumAviary();
			Waterfowl tmpAnimal = new Waterfowl();
			tmpAnimal.move(tmpAviary);
			oneOperationTime = System.nanoTime();
			arrList.add(tmpAviary);
			oneOperationTime = System.nanoTime() - oneOperationTime;
			totalTime += oneOperationTime;
			Logger.writeToLab4Log("add, ID = " + i + ", " + oneOperationTime);
		}
		Logger.writeToLab4Log("addTotalCount = " + size);
		Logger.writeToLab4Log("addTotalTime = " + totalTime);
		Logger.writeToLab4Log("addMedianTime = " + totalTime/size);
		System.out.println("addTotalCount = " + size);
		System.out.println("addTotalTime = " + totalTime);
		System.out.println("addMedianTime = " + totalTime/size);
		
		oneOperationTime = 0;
		int count = arrList.size() / 10;
		for (int i = 0; i < count; i++)
		{
			oneOperationTime = System.nanoTime();
			arrList.remove(Generator.randomInt(arrList.size()));
			oneOperationTime = System.nanoTime() - oneOperationTime;
			Logger.writeToLab4Log("remove, ID = " + i + ", " + oneOperationTime);
			totalTime += oneOperationTime;
		}
		Logger.writeToLab4Log("removeTotalCount = " + count);
		Logger.writeToLab4Log("removeTotalTime = " + totalTime);
		Logger.writeToLab4Log("removeMedianTime = " + totalTime/count);
		System.out.println("removeTotalCount = " + count);
		System.out.println("removeTotalTime = " + totalTime);
		System.out.println("removeMedianTime = " + totalTime/count);
	}
	
	public static void runTestWithLinkedList(int size)
	{
		System.out.println("Linked list n = " + size + "\n");
		Logger.writeToLab4Log("LINKEDLIST n = " + size);
		long oneOperationTime;
		long totalTime = 0;
		LinkedList<AquariumAviary>linkList = new LinkedList<AquariumAviary>();
		for (int i = 0; i < size; i++)
		{
			AquariumAviary tmpAviary = new AquariumAviary();
			Waterfowl tmpAnimal = new Waterfowl();
			tmpAnimal.move(tmpAviary);
			oneOperationTime = System.nanoTime();
			linkList.add(tmpAviary);
			oneOperationTime = System.nanoTime() - oneOperationTime;
			totalTime += oneOperationTime;
			Logger.writeToLab4Log("add, ID = " + i + ", " + oneOperationTime);
		}
		Logger.writeToLab4Log("addTotalCount = " + size);
		Logger.writeToLab4Log("addTotalTime = " + totalTime);
		Logger.writeToLab4Log("addMedianTime = " + totalTime/size);
		System.out.println("addTotalCount = " + size);
		System.out.println("addTotalTime = " + totalTime);
		System.out.println("addMedianTime = " + totalTime/size);
		
		oneOperationTime = 0;
		int count = linkList.size() / 10;
		for (int i = 0; i < count; i++)
		{
			oneOperationTime = System.nanoTime();
			linkList.remove(Generator.randomInt(linkList.size()));
			oneOperationTime = System.nanoTime() - oneOperationTime;
			Logger.writeToLab4Log("remove, ID = " + i + ", " + oneOperationTime);
			totalTime += oneOperationTime;
		}
		Logger.writeToLab4Log("removeTotalCount = " + count);
		Logger.writeToLab4Log("removeTotalTime = " + totalTime);
		Logger.writeToLab4Log("removeMedianTime = " + totalTime/count);
		System.out.println("removeTotalCount = " + count);
		System.out.println("removeTotalTime = " + totalTime);
		System.out.println("removeMedianTime = " + totalTime/count);
	}
	
	public static void autotest2()
	{
		Logger.writeToLab4Log("Main: Autotest: start");
		System.out.println("Autotest2:");
		System.out.println();
		for (int i = 10; i <1000000;i*=10)
		{
			
			runTestWithArrayList(i);
			
			runTestWithLinkedList(i);
			
		}
		Logger.writeToLab4Log("Main: Autotest: finish");
	}
}
