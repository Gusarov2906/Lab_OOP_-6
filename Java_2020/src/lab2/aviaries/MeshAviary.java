package lab2.aviaries;

import java.io.Serializable;
import java.util.ArrayList;
import lab2.animals.Feathered;

/**
 * 
 * @author gusarov2906
 *	Class MeshAviary is aviary for Feathered animals.
 */

public class MeshAviary extends Aviary implements Serializable {
	
	//Fields
	/**
	 * defaultNumber - static integer variable with numbering default aviaries.
	 */
	
	static int defaultNumber = 0;
	
	/**
	 * array - array with feathered animals which lives in mesh aviary.
	 */
	
	ArrayList <Feathered> array;
	
	//Constructor
	
	/**
	 * Default constructor
	 */
	
	public MeshAviary()
	{
		this.name = "Mesh Aviary ¹" + defaultNumber;
		defaultNumber++;
		this.array = new ArrayList <Feathered> ();
	};
	
	/**
	 * Constructor with fields.
	 * @param newName - name of this aviary.
	 */
	
	public MeshAviary(String newName)
	{
		this.name = newName;
		defaultNumber++;
		this.array = new ArrayList <Feathered> ();
	};
	
	//Methods: usual
		
	/**
	 * add - function to add new feathered  to aviary.
	 * @param animal -  feathered animal which need to move in aviary.
	 */
	
	public void add(Feathered animal)
	{
		array.add(animal);
	}
	
	/**
	 * view - show info about aviary and how many and who lives in it.
	 */
	
	public void view()
	{
		super.view();
		System.out.println("Type: MeshAviary");
		System.out.println("Count animals: " + this.count());
		System.out.println("Animals:");
		for (int i = 0; i < array.size(); i++)
		{
			System.out.print("	");
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
	
	public Feathered getById(int id)
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
	
	public ArrayList <Feathered> getArray()
	{
		if (this.array.size() != 0)
			return this.array;
		else 
			return null;
	}
}
