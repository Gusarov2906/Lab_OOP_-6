package lab2.aviaries;

import java.util.ArrayList;
import lab2.animals.Ungulates;

/**
 * 
 * @author gusarov2906
 *	Class OpenAirAviary is aviary for Ungilates animals
 */

public class OpenAirAviary extends Aviary {

	
	//Fields
	
	/**
	 * defaultNumber - static integer variable with numbering default aviaries
	 */
	
	static int defaultNumber = 0;
	/**
	 * array - array with ungulates which lives in open air aviary
	 */
	
	ArrayList <Ungulates> array;
	
	//Constructor
	
	/**
	 * Default constructor
	 */
	
	public OpenAirAviary()
	{
		this.name = "Open Air Aviary ¹" + defaultNumber;
		defaultNumber++;
		this.array = new ArrayList <Ungulates> ();
	};
	
	/**
	 * Constructor with fields
	 * @param newName - name of this aviary
	 */
	
	public OpenAirAviary(String newName)
	{
		this.name = newName;
		defaultNumber++;
		this.array = new ArrayList <Ungulates> ();
	};
	
	//Methods: usual
		
	/**
	 * add - function to add new ungulates to aviary
	 * @param animal -  ungulates  which need to move in aviary
	 */
	
	public void add(Ungulates animal)
	{
		array.add(animal);
	}
	
	/**
	 * view - show info about aviary and how many and who lives in it
	 */
	
	public void view()
	{
		super.view();
		System.out.println("Type         : OpenAirAviary");
		System.out.println("Count animals: " + this.count());
		System.out.println("Animals:");
		for (int i = 0; i < array.size(); i++)
		{
			array.get(i).view();
		}
	}
	
	/**
	 * remove - fuction to delete animal from aviary
	 * @param id - id of  animal in aviary
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
	 * getById - fuction to get animal from array by id
	 * @param id - id of  animal in aviary
	 * @return Function returns animal with id from param
	 */
	
	public Ungulates getById(int id)
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
	 * getter for array
	 * @return array with animals from this aviary
	 */
	
	public ArrayList <Ungulates> getArray()
	{
		if (this.array.size() != 0)
			return this.array;
		else 
			return null;
	}
}
