package Fields;

import Game.Language;

public class Creator {
	
	static Territory roedovrevej;
	static Territory hvidovrevej;
	static Territory valbylanggade;
	static Territory roskildevej;
	static Territory allegade;
	static Territory frederiksbergalle;
	static Territory bulowsvej;
	static Territory glkongevej;
	static Territory bernstoffsvej;
	static Territory hellerupvej;
	static Territory strandvejern;
	static Territory oesterbrogade;
	static Territory trianglen;
	static Territory groenningen;
	static Territory bredgade;
	static Territory kgsNytov;
	static Territory oestergade;
	static Territory vimmelskaftet;
	static Territory amagertov;
	static Territory nygade;
	static Territory fredderiksbergade;
	static Territory raadhuspladsen;
	
	static Fleet roedPut;
	static Fleet helHel;
	static Fleet gedRos;
	static Fleet mols;
	
	static Laborcamp squash;
	static Laborcamp cola;
	
	static TryLuck Luck1;
	static TryLuck Luck2;
	static TryLuck Luck3;
	static TryLuck Luck4;
	static TryLuck Luck5;
	static TryLuck Luck6;
	
	static Prison prison;
	static Jail jail;
	
	static Start start;
	
	static Park park;
	
	static TaxA taxA;
	static TaxB taxB;
	
	//Factory method for board
	public Field[] createFields(){
		
		createTerritory();
		createFleet();
		createLaborcamp();
		createChanceCard();
		createJail();
		createStart();
		createPark();
		createTax();
		
		Field[] fields = new Field[]{start, roedovrevej, Luck1, hvidovrevej, taxA, gedRos, valbylanggade, Luck2, roskildevej, allegade, jail, frederiksbergalle, squash, bulowsvej, glkongevej, mols, bernstoffsvej,
				Luck3, hellerupvej, strandvejern, park, oesterbrogade, Luck4, trianglen, groenningen, helHel, bredgade, kgsNytov, cola, oestergade, prison, vimmelskaftet, amagertov, Luck5, nygade, 
				roedPut, Luck6, fredderiksbergade, taxB, raadhuspladsen};
		
		return fields;
	}
	
	private static void createTerritory(){
		// Blue Fields
		roedovrevej = new Territory(1200, 50, 250, 750, 2250, 4000, 6000, 1000, 600, 2, "BLUE", "Rødovrevej");
		hvidovrevej = new Territory(1200, 50, 250, 750, 2250, 4000, 6000, 1000, 600, 4, "BLUE", "Hvidovrevej");
		// Orange Fields		
		valbylanggade = new Territory(2000, 100, 600, 1800, 5400, 8000, 11000, 1000, 1000, 7, "ORANGE", "Valbylanggade");
		roskildevej = new Territory(2000, 100, 600, 1800, 5400, 8000, 11000, 1000, 1000, 9, "ORANGE", "Roskildevej");
		allegade = new Territory(2400, 150, 600, 1800, 5400, 8000, 11000, 1000, 1000, 10, "ORANGE", "Allegade");
		// Green Fields
		frederiksbergalle = new Territory(2800, 200, 1000, 3000, 9000, 12500, 15000, 2000, 1400, 12, "GREEN", "Frederiksberg Allé");
		bulowsvej = new Territory(2800, 200, 1000, 3000, 9000, 12500, 15000, 2000, 1400, 14, "GREEN", "Bülowsvej");
		glkongevej = new Territory(3200, 250, 1250, 3750, 10000, 14000, 18000, 2000, 1600, 15, "GREEN", "Gl. Kongevej");
		// Gray Fields
		bernstoffsvej = new Territory(3600, 300, 1400, 4000, 11000, 15000, 19000, 2000, 1800, 17, "GREY", "Bernstoffsvej");
		hellerupvej = new Territory(3600, 300, 1400, 4000, 11000, 15000, 19000, 2000, 1800, 19, "GREY", "Hellerupvej");
		strandvejern = new Territory(4000, 350, 1600, 4400, 12000, 16000, 20000, 2000, 2000, 20, "GREY", "Strandvejen");
		// Red Fields
		oesterbrogade = new Territory(4400, 350, 1800, 5000, 14000, 17500, 21000, 3000, 2200, 22, "RED", "Østerbrogade");
		trianglen = new Territory(4400, 350, 1800, 5000, 14000, 17500, 21000, 3000, 2200, 24, "RED", "Trianglen");
		groenningen = new Territory(4800, 400, 2000, 6000, 15000, 18500, 2200, 3000, 2400, 25, "RED", "Grønningen");
		// White Fields
		bredgade = new Territory(5200, 450, 2200, 6600, 16000, 19500, 23000, 3000, 2600, 27, "WHITE", "Bredgade");
		kgsNytov = new Territory(5200, 450, 2200, 6600, 16000, 19500, 23000, 3000, 2600, 28, "WHITE", "Kgs. Nytov");
		oestergade = new Territory(5600, 500, 2400, 7200, 17000, 20500, 24000, 3000, 2800, 30, "WHITE", "Østergade");
		// Yellow Fields
		vimmelskaftet = new Territory(6000, 550, 2600, 7800, 18000, 22000, 25000, 4000, 3000, 32, "YELLOW", "Vimmelskaftet");
		amagertov = new Territory(6000, 550, 2600, 7800, 18000, 22000, 25000, 4000, 3000, 33, "YELLOW", "Amagertov");
		nygade = new Territory(6400, 600, 3000, 9000, 20000, 24000, 28000, 4000, 3200, 35, "YELLOW", "Nygade");
		// Purple Fields
		fredderiksbergade = new Territory(7000, 700, 3500, 10000, 22000, 26000, 30000, 4000, 3500, 38, "PURPLE", "Frederiksberg- gade");
		raadhuspladsen = new Territory(8000, 1000, 4000, 12000, 28000, 34000, 40000, 4000, 4000, 40, "PURPLE", "Rådhusplad- sen");

	}

	private static void createFleet(){
		
		roedPut = new Fleet(4000, 500, 1000, 2000, 4000, 2000, 36, "Rød - Putt");
		helHel = new Fleet(4000, 500, 1000, 2000, 4000, 2000, 26, "Hel - Hel");
		gedRos = new Fleet(4000, 500, 1000, 2000, 4000, 2000, 6, "Ged - Ros");
		mols= new Fleet(4000, 500, 1000, 2000, 4000, 2000, 16, "Mols-Linjen");
		
	}
	private static void createLaborcamp(){
		
		squash = new Laborcamp(3000, 100, 13, 1500, "Squash");
		cola = new Laborcamp(3000, 100, 29, 1500, "CocaCola");
		
	}
	
	private static void createChanceCard(){
		
		Luck1 = new TryLuck(3, Language.getLang("LUCK"),Language.getLang("CARD"));
		Luck2 = new TryLuck(8, Language.getLang("LUCK"),Language.getLang("CARD"));
		Luck3 = new TryLuck(18, Language.getLang("LUCK"),Language.getLang("CARD"));
		Luck4 = new TryLuck(23, Language.getLang("LUCK"),Language.getLang("CARD"));
		Luck5 = new TryLuck(34, Language.getLang("LUCK"),Language.getLang("CARD"));
		Luck6 = new TryLuck(37, Language.getLang("LUCK"),Language.getLang("CARD"));
		
	}
	private static void createJail(){
		prison = new Prison(31, "Jail", "PrisonSubText");
		jail = new Jail(11, "Jail", "JailSubText");
		
	}
	
	private static void createStart(){
		start = new Start(1, 4000, "Start", "StartSubText");
	}
	
	private static void createPark(){
		park = new Park(21, "ParkName", "ParkSubText", "ParkDescription");
	}
	
	private static void createTax(){
		
		taxA = new TaxA(5, 4000, "Tax After Start", "TaxA SubText", "TaxA Description");
		taxB = new TaxB(39, 4000, "Tax After Before", "TaxB SubText", "TaxB Description");
		
	}
	
	
	
	
}
