package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.GameController;
import Players.PlayerController;
import Fields.FieldController;
import Players.Player;
import Test.TestDie;

public class FieldsTests {
	
	GameController gC = new GameController();
	PlayerController pC = new PlayerController();
	FieldController fC = new FieldController();
	/*
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
	}*/
	@Test
	public void testTaxB(){
		Player currentPlayer = pC.getCurrentPlayer();
		currentPlayer.setPlace(38);
		fC.landOnField(currentPlayer.getPlace(), pC, fC);
		
		int expectedBalance = 29000;
		int actualBalance = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedBalance, actualBalance);
	}
	
}