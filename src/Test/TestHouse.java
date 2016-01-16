package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Game.GameController;
import Players.Player;
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
	public void resetPlayer(){
		//Resets the player to initial values
		
		
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
	//Tests if the setHouse method works
	public void testSetHouse() {
		fC.setHouseAmount(39, 1);
		
		int expectedHouseAmount = 1;
		int actualHouseAmount = fC.getHouseAmount(39);
		
		assertEquals(expectedHouseAmount, actualHouseAmount);
	}
	
	@Test
	//Tests if the house price is correct (in this case for rådhuspladsen)
	public void testBuyHouse(){
		
		int expectedHousePrice = 4000;
		int actualHousePrice = fC.getHousePrice(39);
		
		assertEquals(expectedHousePrice, actualHousePrice);
	}
	
	@Test
	//Tests the rent after one house is on the property
	public void testRentWith1House(){
		
		Player currentPlayer = pC.getCurrentPlayer();
		fC.setOwner(39, currentPlayer);
		fC.setHouseAmount(39, 1);
		
		pC.endTurn();
		
		currentPlayer = pC.getCurrentPlayer();
		
		currentPlayer.setPlace(39);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		
		int expectedBalanceSecond = 30000-fC.getRent(39);
		int actualBalanceSecond = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedBalanceSecond, actualBalanceSecond);
	}
	
	@Test
	//Test the rent after 5 houses is on the property
	public void testRentWith5Houses(){

		Player currentPlayer = pC.getCurrentPlayer();
		fC.setOwner(39, currentPlayer);
		fC.setHouseAmount(39, 5);
		
		pC.endTurn();
		
		currentPlayer = pC.getCurrentPlayer();
		
		//The player who will land on the field gets 20000 extra, since the rent is 40000 for a hotel on field 39, and the player starts with 30000
		currentPlayer.getAccount().updateBalance(20000);
		
		currentPlayer.setPlace(39);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		
		int expectedBalanceSecond = 50000-fC.getRent(39);
		int actualBalanceSecond = pC.getPlayers()[1].getAccount().getBalance();
		
		assertEquals(expectedBalanceSecond, actualBalanceSecond);
	}
	
	@Test
	//Test if the price is right for selling a house
	public void testSellableHouse(){
		
		Player currentPlayer = pC.getCurrentPlayer();
		fC.setOwner(39, currentPlayer);
		fC.setHouseAmount(39, 1);
		
		fC.sellHouse(pC, 39);
		
		int expectedBalance = 30000+2000;
		int actualBalance = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedBalance, actualBalance);
	}
	
}
