package lab2.animals;

import java.io.Serializable;

import lab2.aviaries.MeshAviary;

/**
 * 
 * @author gusarov2906
 * Class Feathered - class for birds and etc .
 *
 */

public class Feathered extends Animal implements Serializable{
	
	// Fields
	
	/**
	 * id - integer number to identify animal.
	 * aviary - current aviary.
	 * defOpenAirAviary - default aviary.
	 */
	
	private int id;
	private MeshAviary aviary = null;
	static public MeshAviary defMeshAviary = new MeshAviary();
	// Constructors
	
	/**
	 * Default constructor (aviary is not defined!)
	 */
	
	public Feathered()
	{
		this.name = "NotDifined";
		this.type ="NotDifined";
		this.weight = 0;
		this.age = 0;
		this.id = Animal.id;
		Animal.id +=1;
		this.move(defMeshAviary);
	};
	
	/**
	 * Constructor with all fields (aviary is not defined!)
	 * @param newName - name of animal.
	 * @param newType - type of animal.
	 * @param newWeight - weight of animal.
	 * @param newAge - age of animal.
	 */
	
	public Feathered(String newName, String newType, float newWeight, int newAge)
	{
		this.name = newName;
		this.type = newType;
		this.weight = newWeight;
		this.age = newAge;
		this.id = Animal.id;
		Animal.id +=1;
		this.move(defMeshAviary);
	};
	
	/**
	 * FULL constructor
	 * @param newName - name of animal.
	 * @param newType - type of animal.
	 * @param newWeight - weight of animal.
	 * @param newAge - age of animal.
	 * @param newAviary - aviary where animal lives.
	 */
	
	public Feathered(String newName, String newType, float newWeight, int newAge, MeshAviary newAviary)
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
	
	public void move(MeshAviary newAviary)
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
