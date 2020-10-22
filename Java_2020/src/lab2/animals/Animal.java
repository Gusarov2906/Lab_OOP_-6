package lab2.animals;

import java.io.Serializable;

import lab2.aviaries.Aviary;

/**
 * 
 * @author gusarov2906
 * Abstract class Animal - parent of classes "Waterfowl", "Feathered", "Ungulates" and "ColdBlooded" 
 *
 */
public abstract class Animal implements Serializable{
	
	//Fields
	
	/**
	 * name - name of animal.
	 * type - type of animal.
	 * weight - weight of animal.
	 * age - age of animal.
	 * id - integer number max current id.
	 * aviary - aviary where animal live.
	 */
	
	protected String name;
	protected String type;
	protected float weight;
	protected int age;
	protected static int id;
	Aviary aviary;
	
	// Methods: usual
	
	/**
	 * view - function to output in console all fields of object.
	 */
	
	public void view()
	{
		System.out.println(" Name: " + name + " Type: " + type + 
						   " Weight: " + weight + " Age: " + age);
	}
	
	
	// Methods: setters and getters
	
	/**
	 * setName - setter for field "name".
	 * @param newName - new name for animal.
	 */
	
	public void setName(String newName)
	{
		name = newName;
	}
	
	/**
	 * setType - setter for field "type".
	 * @param newType - new type for animal.
	 */
	
	public void setType(String newType)
	{
		type = newType;
	}
	
	/**
	 * setWeight - setter for field field "weight".
	 * @param newWeight - new weight for animal.
	 */
	
	public void setWeight(float newWeight)
	{
		weight = newWeight;
	}
	
	/**
	 * setAge - setter for field "age".
	 * @param newAge - new age for animal.
	 */
	
	public void setAge(int newAge)
	{
		age = newAge;
	}
	
	/**
	 * setId - setter for field "id".
	 * @param newId - new id for animal.
	 */
	
	public void setId(int newId)
	{
		id = newId;
	}
	
	/**
	 * getName - getter for filed "name".
	 * @return - returns field "name".
	 */
	
	public String getName()
	{
		return name;
	}
	
	/**
	 * getType - getter for filed "type".
	 * @return - returns field "type".
	 */
	
	public String getType()
	{
		return type;
	}
	
	/**
	 * getWeight - getter for filed "weight".
	 * @return - returns field "weight".
	 */
	
	public float getWeight()
	{
		return weight;
	}
	
	/**
	 * getAge - getter for filed "age".
	 * @return - returns field "age".
	 */
	
	public int getAge()
	{
		return age;
	}
	
	
}
