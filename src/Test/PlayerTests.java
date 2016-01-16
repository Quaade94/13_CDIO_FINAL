package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Fields.FieldController;
import Game.GameController;
import Players.PlayerController;
import Players.Player;
import Test.TestDie;

public class PlayerTests {
	
	static FieldController fC;
	static PlayerController pC;
	static GameController gC;
	
	@BeforeClass
	public static void init(){
		gC = new GameController();
		pC = new PlayerController();
		fC = new FieldController();
	}
	
	TestDie die = new TestDie(3, 3);
	
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
	public void testPlayerPositionMin(){
		Player currentPlayer = pC.getCurrentPlayer();
		int playerPosition = currentPlayer.getPlace();
		System.out.println(currentPlayer.getPlace());
		int newPosition;
		die.roll();
		System.out.println(TestDie.getDiceSum());
		newPosition = playerPosition + TestDie.getDiceSum();
		currentPlayer.setPlace(newPosition);
		System.out.println(TestDie.getDiceSum());

		int expectedNewPosition = 6;
		int actualNewPosition = currentPlayer.getPlace();

		assertEquals(expectedNewPosition, actualNewPosition);
	}

	@Test
	public void testPlayerPositionMax(){
		Player currentPlayer = pC.getCurrentPlayer();
		currentPlayer.setPlace(33);
		int playerPosition = currentPlayer.getPlace();
		int newPosition;
		die.roll();
		newPosition = playerPosition + TestDie.getDiceSum();
		currentPlayer.setPlace(newPosition);

		int expectedNewPosition = 39;
		int actualNewPosition = currentPlayer.getPlace();

		assertEquals(expectedNewPosition, actualNewPosition);
	}

	@Test
	public void testPlayerPositionPassStart(){
		Player currentPlayer = pC.getCurrentPlayer();
		currentPlayer.setPlace(35);
		int playerPosition = currentPlayer.getPlace();
		int newPosition;
		die.roll();
		newPosition = playerPosition + TestDie.getDiceSum();
		if (newPosition >= 40) newPosition = newPosition-40;
		currentPlayer.setPlace(newPosition);

		int expectedNewPosition = 1;
		int actualNewPosition = currentPlayer.getPlace();

		assertEquals(expectedNewPosition, actualNewPosition);
	}

	//AccountTests
	@Test
	public void testPlayerAccount(){
		Player[] players = pC.getPlayers();
		Player currentPlayer = pC.getCurrentPlayer();
		Player otherPlayer = null;
		for (int i = 0; i < players.length; i++){
			if (players[i] != currentPlayer){
				otherPlayer = players[i];
				break;
			}
		}

		int payAmount = 1500;
		currentPlayer.getAccount().updateBalance(-payAmount);
		otherPlayer.getAccount().updateBalance(payAmount);

		int expectedNewBalanceCP = 28500;
		int expectedNewBalanceOP = 31500;
		int actualNewBalanceCP = currentPlayer.getAccount().getBalance();
		int actualNewBalanceOP = otherPlayer.getAccount().getBalance();

		assertEquals(expectedNewBalanceCP, actualNewBalanceCP);
		assertEquals(expectedNewBalanceOP, actualNewBalanceOP);
	}	
}
