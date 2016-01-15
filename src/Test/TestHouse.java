package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Game.GameController;
import Players.PlayerController;
import Fields.FieldController;

public class TestHouse {

	static FieldController fC;
	static PlayerController pC;
	static GameController gC;
	
	@BeforeClass
	public static void init(){
		gC = new GameController();
		pC = new PlayerController();
		fC = new FieldController();
	}
	
	@Before 
	public void resetBalance(){
		//Resets the players balance
		
		
		//Resets the fields ownership to null
		for (int i = 0 ; i <= 39 ; i++){
			if (fC.getOwner(i)!=null){
				fC.resetOwner(i);
			}
			if (fC.getHouseAmount(i)>0){
				fC.resetHouses(i);
			}
		}
		
		//Resets the players position to 0 (start) and resets their jail status and balance
		for (int i = 0 ; i < pC.getPlayers().length ; i++){
			if (pC.getPlayers()[i].getPlace()!=0){
				pC.getPlayers()[i].setPlace(0);
			}
			if (pC.getPlayers()[i].getJailed()==true){
				pC.getPlayers()[i].setJail(false);
			}
			pC.getPlayers()[i].getAccount().resetBalance();
		}
	}
	
	
	@Test
	public void testSetHouseTrue() {
		//Checks if you can put houses in the program
		
		fC.setHouseAmount(39, 1);
		
		int expectedHouseAmount = 1;
		int actualHouseAmount = fC.getHouseAmount(39);
		
		assertEquals(expectedHouseAmount, actualHouseAmount);
	}
	
	@Test
	public void testSetHouseFalse(){
		//Tests if house can be put on property, where the player does not own all the colors
		fC.setHouseAmount(39, 1);
		
		int expectedHouseAmount = -1;
		int actualHouseAmount = fC.getHouseAmount(39);
		
		assertEquals(expectedHouseAmount, actualHouseAmount);
	}

}
