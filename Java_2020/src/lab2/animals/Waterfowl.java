package lab2.animals;

import java.io.Serializable;

import lab2.aviaries.AquariumAviary;
import lab2.random.Generator;

/**
 * 
 * @author gusarov2906
 * Class Waterfowl - class for fishes and etc .
 *
 */

public class Waterfowl extends Animal implements Serializable {

	// Fields
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id - integer number to identify animal.
	 * aviary - current aviary.
	 * defOpenAirAviary - default aviary.
	 */
	
	private int id;
	private AquariumAviary aviary = null;
	static public AquariumAviary defAquariumAviary = new AquariumAviary();
	// Constructors
	
	/**
	 * Default constructor (aviary is not defined!)
	 */
	
	public Waterfowl()
	{
		this.name = Generator.randomName();
		this.type = Generator.randomType();
		this.weight = (float)Generator.randomWeight();
		this.age = Generator.randomAge();
		this.id = Animal.id;
		Animal.id +=1;
		this.move(defAquariumAviary);
	};
	
	/**
	 * Constructor with all fields (aviary is not defined!).
	 * @param newName - name of animal.
	 * @param newType - type of animal.
	 * @param newWeight - weight of animal.
	 * @param newAge - age of animal.
	 */
	
	public Waterfowl(String newName, String newType, float newWeight, int newAge)
	{
		this.name = newName;
		this.type = newType;
		this.weight = newWeight;
		this.age = newAge;
		this.id = Animal.id;
		Animal.id +=1;
		this.move(defAquariumAviary);
	};
	
	/**
	 * FULL constructor
	 * @param newName - name of animal.
	 * @param newType - type of animal.
	 * @param newWeight - weight of animal.
	 * @param newAge - age of animal.
	 * @param newAviary - aviary where animal lives.
	 */
	
	public Waterfowl(String newName, String newType, float newWeight, int newAge, AquariumAviary newAviary)
	{
		this.name = newName;
		this.type = newType;
		this.weight = newWeight;
		this.age = newAge;
		this.id = Animal.id;
		Animal.id +=1;
		this.move(newAviary);
	};
	
	// Methods: usual
	
	/**
	 * move - function to move from one aviary to another.
	 * @param newAviary - destination aviary.
	 */
	
	public void move(AquariumAviary newAviary)
	{
		if (this.aviary != null && this.aviary.getArray() != null)
		{
		this.aviary.remove(id);
		}
		this.aviary = newAviary;
		newAviary.add(this);
		
	}
	
	/**
	 * remove - function to remove from aviary.
	 */
	
	public void remove()
	{
		if (this.aviary != null && this.aviary.getArray() != null)
		{
		this.aviary.remove(id);
		}	
	}
	
	/**
	 * view - function to output in console all fields of object.
	 */
	
	public void view()
	{
		System.out.print(" Id: " + id);
		super.view();
	}
	
	/**
	 * getId - getter for filed "id".
	 * @return - returns field "id".
	 */
	
	public int getId()
	{
		return id;
	}
}
