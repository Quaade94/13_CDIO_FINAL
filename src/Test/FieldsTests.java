package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Game.GameController;
import Players.PlayerController;
import Fields.FieldController;
import Players.Player;
import Test.TestDie;
import Game.Die;

public class FieldsTests {
	
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
		pC.getCurrentPlayer().getAccount().resetBalance();
		
		//Resets the fields ownership to null
		for (int i = 0 ; i <= 39 ; i++){
			if (fC.getOwner(i)!=null){
				fC.resetOwner(i);
			}
		}
		
		//Resets the players position to 0 (start) and resets their jail status
		for (int i = 0 ; i < pC.getPlayers().length ; i++){
			if (pC.getPlayers()[i].getPlace()!=0){
				pC.getPlayers()[i].setPlace(0);
			}
			if (pC.getPlayers()[i].getJailed()==true){
				pC.getPlayers()[i].setJail(false);
			}
		}
	}

	
	@Test
	public void testTerritoryNotOwned(){
		Player currentPlayer = pC.getCurrentPlayer();
		int playerPosition = currentPlayer.getPlace();
		TestDie die = new TestDie(2, 1);
		die.roll();
		
		int newPosition = playerPosition+TestDie.getDiceSum();
		currentPlayer.setPlace(newPosition);
		
		Player expectedOwner = null;
		Player actualOwner = fC.getOwner(newPosition);
		
		assertEquals(expectedOwner, actualOwner);	
	}
	
	@Test
	public void testTerritoryOwned(){
		Player currentPlayer = pC.getCurrentPlayer();
		int playerPosition = currentPlayer.getPlace();
		TestDie die = new TestDie(2, 1);
		die.roll();
		
		int newPosition = playerPosition+TestDie.getDiceSum();
		currentPlayer.setPlace(newPosition);
		
		fC.setOwner(newPosition, currentPlayer);
		
		Player expectedOwner = currentPlayer;
		Player actualOwner = fC.getOwner(newPosition);
		
		assertEquals(expectedOwner, actualOwner);
	}
	
	@Test
	public void testPlayerJailedAndPlace(){
		Player currentPlayer = pC.getCurrentPlayer();
		currentPlayer.setPlace(30);
		int playerPosition = currentPlayer.getPlace();
		fC.landOnField(playerPosition, pC, fC);
		
		int expectedPlace = 10;
		int actualPlace = currentPlayer.getPlace();
		
		assertEquals(expectedPlace, actualPlace);
		
		boolean expectedJailStatus = true;
		boolean actualJailStatus = currentPlayer.getJailed();
		
		assertEquals(expectedJailStatus, actualJailStatus);
	}
	
	@Test
	public void testStart(){
		Player currentPlayer = pC.getCurrentPlayer();
		currentPlayer.setPlace(0);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		
		int expectedMoney = 34000;
		int actualMoney = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedMoney, actualMoney);
	}
	
	@Test
	public void testTaxA(){
		Player currentPlayer = pC.getCurrentPlayer();
		currentPlayer.setPlace(4);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		
		int expectedBalance1 = 30000 - (int)(30000 * 0.1);
		int expectedBalance2 = 26000;
		int actualBalance = currentPlayer.getAccount().getBalance();
		
		assertTrue(expectedBalance1 == actualBalance || expectedBalance2 == actualBalance);
	}
	
	@Test
	public void testTaxB(){
		Player currentPlayer = pC.getCurrentPlayer();
		currentPlayer.setPlace(38);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		
		int expectedBalance = 29000;
		int actualBalance = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedBalance, actualBalance);
	}
	
	@Test
	public void testLaborCampOwn1(){
		Player[] players = pC.getPlayers();
		Player currentPlayer = pC.getCurrentPlayer();
		Player otherPlayer = null;
		for (int i = 0; i < players.length; i++){
			if (players[i] != currentPlayer){
				otherPlayer = players[i];
				break;
			}
		}
		Die die = new Die();
		die.roll();
		
		currentPlayer.setPlace(12);
		fC.setOwner(currentPlayer.getPlace(), otherPlayer);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		System.out.println("LaborCamp: " + currentPlayer.getAccount().getBalance());
		
		int expectedBalance = 30000-Die.getDiceSum()*100;
		int actualBalance = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedBalance, actualBalance);
	}
	
	@Test
	public void testLaborCampOwn2(){
		Player[] players = pC.getPlayers();
		Player currentPlayer = pC.getCurrentPlayer();
		for (int i = 0; i < players.length; i++){
			if (players[i] != currentPlayer){
				break;
			}
		}

		Die die = new Die();
		die.roll();
		
		currentPlayer.setPlace(12);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		currentPlayer.setPlace(28);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);

		pC.endTurn();
		currentPlayer = pC.getCurrentPlayer();
		
		currentPlayer.setPlace(12);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		
		int expectedBalance = 30000-Die.getDiceSum()*200;
		int actualBalance = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedBalance, actualBalance);
	}
	@Test
	public void testFleetOwn1(){
		Player[] players = pC.getPlayers();
		Player currentPlayer = pC.getCurrentPlayer();
		Player otherPlayer = null;
		for (int i = 0; i < players.length; i++){
			if (players[i] != currentPlayer){
				otherPlayer = players[i];
				break;
			}
		}
		
		fC.setOwner(5, otherPlayer);
		otherPlayer.updateFleetOwned();
		
		currentPlayer.setPlace(5);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		
		int expectedBalance = 29500;
		int actualBalance = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedBalance, actualBalance);
	}
	
	@Test
	public void testFleetOwnAll(){
		Player[] players = pC.getPlayers();
		Player currentPlayer = pC.getCurrentPlayer();
		Player otherPlayer = null;
		for (int i = 0; i < players.length; i++){
			if (players[i] != currentPlayer){
				otherPlayer = players[i];
				break;
			}
		}
		
		fC.setOwner(5, otherPlayer);
		otherPlayer.updateFleetOwned();
		fC.setOwner(15, otherPlayer);
		otherPlayer.updateFleetOwned();
		fC.setOwner(25, otherPlayer);
		otherPlayer.updateFleetOwned();
		fC.setOwner(35, otherPlayer);
		otherPlayer.updateFleetOwned();
		
		currentPlayer.setPlace(5);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		
		int expectedBalance = 26000;
		int actualBalance = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedBalance, actualBalance);
	}
}