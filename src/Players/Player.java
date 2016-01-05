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
	private String Name;
	private int Balance;
	private Car PlayerCar;
	
	public Player (int StartingCapitalC, String NameC, Car PlayerCarC, Territory TerrOwnedC, Fleet FleeOwnedC, Laborcamp LabOwnedC){
		
		TerrOwned = TerrOwnedC;
		FleeOwned = FleeOwnedC;
		LabOwned = LabOwnedC;
		Name = NameC;
		Balance = StartingCapitalC;
		PlayerCar = PlayerCarC;
		
	}
	
	
	public Car getCar(){
		
		return PlayerCar;
		
	}
	public String getName(){
		
		return Name;
		
	}
	public int getBalnce(){
		
		return Balance;
		
	}
	
	
	
	

}
