package lab2.random;
import java.util.Random;
/**
 * Class with methods to fill fields with random values.
 * @author gusarov2906
 *
 */
public class Generator {
	
	/**
	 * names - array with names.
	 */
	
	private static final String[] names = {
			"Delmar",
			"Irvin",
			"Milford",
			"Heriberto",
			"Delbert",
			"Vance",
			"Korey",
			"Jeromy",
			"Garth",
			"Efrain",
			"Ellis",
			"Roberto",
			"Neil",
			"Cletus",
			"Duane",
			"Adrian",
			"Julius",
			"Fernando",
			"Glen",
			"Percy",
			"Buck",
			"Carrol",
			"Harold",
			"Mario",
			"Harland",
			"Dirk",
			"Christopher",
			"Leopoldo",
			"Carey",
			"Marcos",
			"Ken",
			"Freddie",
			"Fredrick",
			"Peter",
			"Maurice",
			"Jacques",
			"Harris",
			"Rey",
			"Titus",
			"Elliott",
			"Garret",
			"Stuart",
			"Gordon",
			"Ike",
			"Bryant",
			"Malcolm",
			"Stan",
			"Beau",
			"Tommie",
			"Lynwood",
			"Min",
			"Crysta",
			"Nannie",
			"Priscilla",
			"Venetta",
			"Rochell",
			"Neoma",
			"Nelia",
			"Tracee",
			"Clarine",
			"Olivia",
			"Margurite",
			"Leana",
			"Shayla",
			"Patrice",
			"Marylee",
			"Myriam",
			"Sherrill",
			"Brianne",
			"Leeanna",
			"Loria",
			"Angeles",
			"Janene",
			"Kyra",
			"Roxie",
			"Johanne",
			"Leona",
			"Lisa",
			"Paola",
			"Ayako",
			"Amberly",
			"Lynsey",
			"Christel",
			"Deane",
			"Jocelyn",
			"Earlean",
			"Delaine",
			"Shasta",
			"Corene",
			"Kiana",
			"Dann",
			"Kam",
			"Maura",
			"Fidela",
			"Nobuko",
			"Earline",
			"Rafaela",
			"Elizabeth",
			"Francisca",
			"Eleni"
	};
	
	/**
	 * types - array with types of waterfowl animals.
	 */
	private static final String[] types= {
			"Crab",
			"Fish",
			"Seal",
			"Octopus",
			"Shark",
			"Walrus",
			"Starfish",
			"Whale",
			"Penguin",
			"Jellyfish",
			"Squid",
			"Lobster",
			"Pelican",
			"Shrimp",
			"Oyster",
			"Clams",
			"Seagull",
			"Dolphin",
			"Shells",
			"SeaUrchin",
			"Cormorant",
			"Otter",
			"Sea Anemone",
			"Sea Turtle",
			"Sea Lion",
			"Coral",
			"Angelfish",
			"Barb",
			"Barracuda",
			"Blobfish",
			"Butterfly Fish",
			"Cichlid",
			"Clown Fish",
			"Discus",
			"Electric Eel",
			"Flounder",
			"FlukeFish",
			"Gar",
			"Guppy",
			"Lionfish",
			"Molly",
			"Monkfish",
			"Moray Eel",
			"Pike",
			"Piranha",
			"Puffer Fish",
			"Scorpion Fish",
			"Sea Dragon",
			"Sea horse",
			"Siamese Fighting Fish",
			"Silver Dollar",
			"Sucker Fish",
			"Tang",
			"Tetra",
			"Wrasse",
			"X-Ray Tetra"
		};
	private static final Random random = new Random();
	
	/**
	 * randomName - function to get random name.
	 * @return name - string name.
	 */
	
	public static String randomName()
	{
		return names[random.nextInt(names.length)];
	}
	
	/**
	 * randomType - function to get random type of waterfowl animal.
	 * @return type - type of waterfowl animal.
	 */
	
	public static String randomType()
	{
		return types[random.nextInt(types.length)];
	}
	
	/**
	 * randomInt - function to get random int.
	 * @return - random int less 100000000.
	 */
	
	public static int randomInt()
	{
		return random.nextInt(100000000);
	}
	
	/**
	 * randomInt - function to get random int.
	 * @param size - max size of random int.
	 * @return - random int less param.
	 */
	
	public static int randomInt(int size)
	{
		return random.nextInt(size);
	}
	
	/**
	 * randomAge - function to get random age.
	 * @return - age (less 10)
	 */
	
	public static int randomAge()
	{
		return random.nextInt(10);
	}
	
	/**
	 * randomWeight - function to get random weight.
	 * @return - weight (less 10)
	 */
	
	public static double randomWeight()
	{
		return 10 * random.nextDouble();
	}

	
	
}
