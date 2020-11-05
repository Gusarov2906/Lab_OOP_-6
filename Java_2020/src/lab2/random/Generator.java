package lab2.random;
import java.util.Random;
public class Generator {

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
	
	public static String randomName()
	{
		return names[random.nextInt(names.length)];
	}
	
	public static String randomType()
	{
		return types[random.nextInt(types.length)];
	}
	
	public static int randomInt()
	{
		return random.nextInt(100000000);
	}
	
	public static int randomInt(int size)
	{
		return random.nextInt(size);
	}
	
	public static int randomAge()
	{
		return random.nextInt(10);
	}
	
	public static double randomWeight()
	{
		return 10 * random.nextDouble();
	}

	
	
}
