package lab2.animals;

import lab2.aviaries.InfraredLightedAviary;

/**
 * 
 * @author gusarov2906
 * Class ColdBlooded - class for reptiles, snakes and etc .
 *
 */

public class ColdBlooded extends Animal{
	
	// Fields
	
	private int id;
	private InfraredLightedAviary aviary;
	static public InfraredLightedAviary defInfraredLightedAviary = new InfraredLightedAviary();
	
	// Constructors
	
	/**
	 * Default constructor (aviary is not defined!)
	 */
	
	public ColdBlooded()
	{
		this.name = "NotDifined";
		this.type ="NotDifined";
		this.weight = 0;
		this.age = 0;
		this.id = Animal.id;
		Animal.id +=1;
		this.move(defInfraredLightedAviary);
	};
	
	/**
	 * Constructor with all fields (aviary is not defined!)
	 * @param newName - name of animal.
	 * @param newType - type of animal.
	 * @param newWeight - weight of animal.
	 * @param newAge - age of animal.
	 */
	
	public ColdBlooded(String newName, String newType, float newWeight, int newAge)
	{
		this.name = newName;
		this.type = newType;
		this.weight = newWeight;
		this.age = newAge;
		this.id = Animal.id;
		Animal.id +=1;
		this.move(defInfraredLightedAviary);
	};
	
	/**
	 * FULL constructor
	 * @param newName - name of animal.
	 * @param newType - type of animal.
	 * @param newWeight - weight of animal.
	 * @param newAge - age of animal.
	 * @param newAviary - aviary where animal lives.
	 */
	
	public ColdBlooded(String newName, String newType, float newWeight, int newAge, InfraredLightedAviary newAviary)
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
	
	public void move(InfraredLightedAviary newAviary)
	{
		if (this.aviary != null && this.aviary.getArray() != null)
		{
		this.aviary.remove(id);
		}
		this.aviary = newAviary;
		newAviary.add(this);
		
	}
	
	/**
	 * view - function to output in console all fields of object.
	 */
	
	public void view()
	{
		System.out.println(" Id: " + id + " Name: " + name + " Type: " + type + 
						   " Weight: " + weight + " Age: " + age);
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
