package lab2.aviaries;

import java.util.ArrayList;
import lab2.animals.Waterfowl;


/**
 * 
 * @author gusarov2906
 *	Class AquariumAviary is aviary for Waterfowl animals.
 */


public class AquariumAviary extends Aviary{


	
	//Fields
	
	static int defaultNumber = 0;
	/**
	 * array - array with waterfowl which lives in aquarium aviary.
	 */
	
	ArrayList <Waterfowl> array;
	
	//Constructor
	
	/**
	 * Default constructor
	 */
	
	public AquariumAviary()
	{
		this.name = "Aquarium Aviary ¹" + defaultNumber;
		defaultNumber++;
		this.array = new ArrayList <Waterfowl> ();
	};
	
	/**
	 * Constructor with fields
	 * @param newName - name of this aviary.
	 */
	
	public AquariumAviary(String newName)
	{
		this.name = newName;
		defaultNumber++;
		this.array = new ArrayList <Waterfowl> ();
	};
	
	//Methods: usual
		
	/**
	 * add - function to add new waterfowl to aviary.
	 * @param animal -  waterfowl  which need to move in aviary.
	 */
	
	public void add(Waterfowl animal)
	{
		array.add(animal);
	}
	
	/**
	 * view - show info about aviary and how many and who lives in it.
	 */
	
	public void view()
	{
		super.view();
		System.out.println("Type         : AquariumAviary");
		System.out.println("Count animals: " + this.count());
		System.out.println("Animals:");
		for (int i = 0; i < array.size(); i++)
		{
			array.get(i).view();
		}
	}
	
	/**
	 * remove - fuction to delete animal from aviary.
	 * @param id - id of  animal in aviary.
	 */
	
	public void remove(int id)
	{
		for (int i = 0; i < array.size(); i++)
		{
			if (array.get(i).getId() == id)
			{
				array.remove(i);
			}
		}
	}
	
	/**
	 * getById - fuction to get animal from array by id.
	 * @param id - id of  animal in aviary.
	 * @return Function returns animal with id from param.
	 */
	
	public Waterfowl getById(int id)
	{
		for (int i = 0; i < array.size(); i++)
		{
			if (array.get(i).getId() == id)
			{
				return array.get(i);
			}
		}
		return null;
	}
	
	/**
	 * getArray - getter for array.
	 * @return array with animals from this aviary.
	 */
	
	public ArrayList <Waterfowl> getArray()
	{
		if (this.array.size() != 0)
			return this.array;
		else 
			return null;
	}
}
