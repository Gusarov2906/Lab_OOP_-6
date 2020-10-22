package lab2.aviaries;

import java.io.Serializable;
import java.util.ArrayList;

import lab2.animals.ColdBlooded;

/**
 * 
 * @author gusarov2906
 *	Class InfraredLightedAviary is aviary for ColdBlooded animals.
 */

public class InfraredLightedAviary extends Aviary  implements Serializable {
	
	//Fields
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * defaultNumber - static integer variable with numbering default aviaries.
	 */
	
	static int defaultNumber = 0;
	/**
	 * array - array with coldblooded animals which lives in infrared lighted aviary.
	 */
	
	private ArrayList <ColdBlooded> array = null;
	
	//Constructor
	
	/**
	 * Default constructor
	 */
	
	public InfraredLightedAviary()
	{
		this.name = "Infrared Lighted Aviary ¹" + defaultNumber;
		defaultNumber++;
		this.array = new ArrayList <ColdBlooded> ();
	};
	
	/**
	 * Constructor with fields.
	 * @param newName - name of this aviary.
	 */
	
	public InfraredLightedAviary(String newName)
	{
		this.name = newName;
		defaultNumber++;
		this.array = new ArrayList <ColdBlooded> ();
	};
	
	//Methods: usual
		
	/**
	 * add - function to add new coldblooded animal to aviary.
	 * @param animal -  coldblooded animal which need to move in aviary.
	 */
	
	public void add(ColdBlooded animal)
	{
		array.add(animal);
	}
	
	/**
	 * view - show info about aviary and how many and who lives in it.
	 */
	
	public void view()
	{
		super.view();
		System.out.println("Type: InfraredLightedAviary");
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
	
	public ColdBlooded getById(int id)
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
	 * getter for array.
	 * @return array with animals from this aviary.
	 */
	
	public ArrayList <ColdBlooded> getArray()
	{
		if (this.array.size() != 0)
			return this.array;
		else 
			return null;
	}
}
