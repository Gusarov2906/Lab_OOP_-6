package lab2.main;

import java.io.Serializable;
import java.util.ArrayList;

import lab2.animals.ColdBlooded;
import lab2.animals.Feathered;
import lab2.animals.Ungulates;
import lab2.animals.Waterfowl;
import lab2.aviaries.*;

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

		public ArrayList<String> getNamesAquariumList()
		{
			ArrayList<String> res = new ArrayList<String>();
			for(int i =0; i < arrayAquariumAviary.size(); i++)
			{
				res.add(arrayAquariumAviary.get(i).getName());
			}
			return res;
		}

		public ArrayList<String> getNamesOpenAirList()
		{
			ArrayList<String> res = new ArrayList<String>();
			for(int i =0; i < arrayOpenAirAviary.size(); i++)
			{
				res.add(arrayOpenAirAviary.get(i).getName());
			}
			return res;
		}

		public ArrayList<String> getNamesMeshList()
		{
			ArrayList<String> res = new ArrayList<String>();
			for(int i =0; i < arrayMeshAviary.size(); i++)
			{
				res.add(arrayMeshAviary.get(i).getName());
			}
			return res;
		}

		public ArrayList<String> getNamesInfraredLightedList()
		{
			ArrayList<String> res = new ArrayList<String>();
			for(int i =0; i < arrayInfraredLightedAviary.size(); i++)
			{
				res.add(arrayInfraredLightedAviary.get(i).getName());
			}
			return res;
	    }

		public ArrayList<String> getAllNamesAviaries()
		{
			ArrayList<String> res = new ArrayList<String>();
			res = getNamesAquariumList();
			res.addAll(getNamesOpenAirList());
			res.addAll(getNamesMeshList());
			res.addAll(getNamesInfraredLightedList());
			return res;
		}


	    public <T extends Aviary> T getAviary(ArrayList<T> aviariesList, String name)
		{
			for(int i =0; i < aviariesList.size(); i++)
			{
				if(aviariesList.get(i).getName().equals(name))
					return aviariesList.get(i);
			}
			return null;
		}


		
}
