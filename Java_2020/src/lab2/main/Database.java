package lab2.main;

import java.io.Serializable;
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
 * Class Database is class for storage arrayLists of different types of animal.
 * @author gusarov2906
 * 
 */

public class Database implements Serializable {
		
		private static final long serialVersionUID = 1L;
		public ArrayList<AquariumAviary> arrayAquariumAviary;
		public ArrayList<OpenAirAviary> arrayOpenAirAviary;
		public ArrayList<MeshAviary> arrayMeshAviary;
		public ArrayList<InfraredLightedAviary> arrayInfraredLightedAviary;
		public int maxId = 0;
		
		/**
		 * Default constructor.
		 */
		
		public Database()
		{
			arrayAquariumAviary = new ArrayList<AquariumAviary>();
			arrayOpenAirAviary = new ArrayList<OpenAirAviary>();
			arrayMeshAviary = new ArrayList<MeshAviary>();
			arrayInfraredLightedAviary = new ArrayList<InfraredLightedAviary>();
		}
		
		/**
		 * createDefAviaries - function to fill database with default aviaries.
		 */
		
		public void createDefAviaries()
		{
			
			arrayAquariumAviary.add(Waterfowl.defAquariumAviary);
			arrayOpenAirAviary.add(Ungulates.defOpenAirAviary);
			arrayMeshAviary.add(Feathered.defMeshAviary);
			arrayInfraredLightedAviary.add(ColdBlooded.defInfraredLightedAviary);
		}
		
		
		
}
