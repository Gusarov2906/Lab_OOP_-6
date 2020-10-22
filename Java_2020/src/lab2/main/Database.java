package lab2.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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

public class Database implements Serializable {
		
		public ArrayList<AquariumAviary> arrayAquariumAviary;
		public ArrayList<OpenAirAviary> arrayOpenAirAviary;
		public ArrayList<MeshAviary> arrayMeshAviary;
		public ArrayList<InfraredLightedAviary> arrayInfraredLightedAviary;
		
		public Database()
		{
			arrayAquariumAviary = new ArrayList<AquariumAviary>();
			arrayOpenAirAviary = new ArrayList<OpenAirAviary>();
			arrayMeshAviary = new ArrayList<MeshAviary>();
			arrayInfraredLightedAviary = new ArrayList<InfraredLightedAviary>();
		}
		
		public void createDefAviaries()
		{
			
			arrayAquariumAviary.add(Waterfowl.defAquariumAviary);
			arrayOpenAirAviary.add(Ungulates.defOpenAirAviary);
			arrayMeshAviary.add(Feathered.defMeshAviary);
			arrayInfraredLightedAviary.add(ColdBlooded.defInfraredLightedAviary);
		}
		
		
		
}
