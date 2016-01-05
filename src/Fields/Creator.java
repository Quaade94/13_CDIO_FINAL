package Fields;

public class Creator {
	
	public static void createFields(){
		
		createTerritory();
		createFleet();
		createLaborcamp();
		
		

	}
	
	static Territory rødovrevej;
	static Territory hvidovrevej;
	static Territory valbylanggade;
	static Territory roskildevej;
	static Territory allegade;
	static Territory frederiksbergalle;
	static Territory glkongevej;
	

	private static void createTerritory(){
		
		rødovrevej = new Territory(0, 0, 0, "Rødovrevej");
		hvidovrevej = new Territory(0, 0, 0, "Hvidovrevej");
		valbylanggade = new Territory(0, 0, 0, "Valbylanggade");
		roskildevej = new Territory(0, 0, 0, "Roskildevej");
		allegade = new Territory(0, 0, 0, "Allegade");
		frederiksbergalle = new Territory(0, 0, 0, "Frederiksbergalle");
		glkongevej = new Territory(0, 0, 0, "Gl. Kongevej");
		
	}
	@SuppressWarnings("unused")
	private static void createFleet(){
		
		Fleet rederi1 = new Fleet(0, 0, 0, "Rederi1");
		Fleet rederi2 = new Fleet(0, 0, 0, "Rederi2");
		Fleet rederi3 = new Fleet(0, 0, 0, "Rederi3");
		Fleet rederi4 = new Fleet(0, 0, 0, "Rederi4");
		
	}
	@SuppressWarnings("unused")
	private static void createLaborcamp(){
		
		Laborcamp tuborg = new Laborcamp(0, 0, 0, "Tuborg");
		Laborcamp cola = new Laborcamp(0, 0, 0, "CocaCola");
		
	}
	

	
	
	
	

}
