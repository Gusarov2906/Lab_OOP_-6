package lab2.main;

import java.util.ArrayList;

import lab2.animals.ColdBlooded;
import lab2.animals.Feathered;
import lab2.animals.Ungulates;
import lab2.animals.Waterfowl;
import lab2.aviaries.AquariumAviary;
import lab2.aviaries.InfraredLightedAviary;
import lab2.aviaries.MeshAviary;
import lab2.aviaries.OpenAirAviary;

/**
*
* @author Gusarov2906
* @version 0.0.1
*/

public class Main {
	
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
		
		ArrayList<AquariumAviary> arrayAquariumAviary = new ArrayList<AquariumAviary>();
		ArrayList<OpenAirAviary> arrayOpenAirAviary = new ArrayList<OpenAirAviary>();
		ArrayList<MeshAviary> arrayMeshAviary = new ArrayList<MeshAviary>();
		ArrayList<InfraredLightedAviary> arrayInfraredLightedAviary = new ArrayList<InfraredLightedAviary>();
		
		arrayAquariumAviary.add(Waterfowl.defAquariumAviary);
		arrayOpenAirAviary.add(Ungulates.defOpenAirAviary);
		arrayMeshAviary.add(Feathered.defMeshAviary);
		arrayInfraredLightedAviary.add(ColdBlooded.defInfraredLightedAviary);
		
		try {
		menu.run(arrayAquariumAviary,arrayOpenAirAviary, arrayMeshAviary, arrayInfraredLightedAviary);
		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
	}
}