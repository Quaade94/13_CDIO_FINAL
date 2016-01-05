package Players;

import Cars.Cars;
import Fields.Fleet;
import Fields.Laborcamp;
import Fields.Territory;
import desktop_codebehind.Car;

public class Player {
	
	private Territory TerrOwned;
	private Fleet FleeOwned;
	private Laborcamp LabOwned;
	private static String Name;
	private static int Balance;
	private static Car PlayerCar;
	
	public Player (int StartingCapitalC, String NameC, Car PlayerCarC, Territory TerrOwnedC, Fleet FleeOwnedC, Laborcamp LabOwnedC){
		
		TerrOwned = TerrOwnedC;
		FleeOwned = FleeOwnedC;
		LabOwned = LabOwnedC;
		Name = NameC;
		Balance = StartingCapitalC;
		PlayerCar = PlayerCarC;
		
	}
	
	
	public static Car getCar(){
		
		return PlayerCar;
		
	}
	public static String getName(){
		
		return Name;
		
	}
	public static int getBalnce(){
		
		return Balance;
		
	}
	
	
	
	

}
