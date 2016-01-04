package Fields;

public class Creator {
	
	public void createFields(){
		
		createTerritory();
		createFleet();
		createLaborcamp();
		
		

	}
	
	
	@SuppressWarnings("unused")
	private static void createTerritory(){
		
		Territory rødovrevej = new Territory(0, 0, 0, "Rødovrevej");
		Territory hvidovrevej = new Territory(0, 0, 0, "Hvidovrevej");
		Territory valbylanggade = new Territory(0, 0, 0, "Valbylanggade");
		Territory roskildevej = new Territory(0, 0, 0, "Roskildevej");
		Territory allegade = new Territory(0, 0, 0, "Allegade");
		Territory frederiksbergalle = new Territory(0, 0, 0, "Frederiksbergalle");
		Territory glkongevej = new Territory(0, 0, 0, "Gl. Kongevej");
		
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
