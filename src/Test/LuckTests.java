package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Fields.FieldController;
import Game.GameController;
import Players.Player;
import Players.PlayerController;

public class LuckTests {
	GameController gC = new GameController();
	PlayerController pC = new PlayerController();
	FieldController fC = new FieldController();
	LuckTestClass lTC = new LuckTestClass(3, "Test", "Test");
	Player currentPlayer = pC.getCurrentPlayer();
	Player[] players = pC.getPlayers();


	int expectedOutcomeInt;
	int actualOutcomeInt;

	@Test
	public void testCard1(){
		lTC.setChanceCard(0);
		
		currentPlayer.setPlace(10);
		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 0;
		actualOutcomeInt = currentPlayer.getPlace();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard2(){
		lTC.setChanceCard(1);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 28000;
		actualOutcomeInt = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard3(){
		lTC.setChanceCard(2);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 30000+(100*(players.length-1));
		actualOutcomeInt = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard4(){
		lTC.setChanceCard(3);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 29000;
		actualOutcomeInt = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard5(){
		lTC.setChanceCard(4);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 31000;
		actualOutcomeInt = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard6(){
		lTC.setChanceCard(5);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 23;
		actualOutcomeInt = currentPlayer.getPlace();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard7(){
		lTC.setChanceCard(6);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 39;
		actualOutcomeInt = currentPlayer.getPlace();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard8Jail(){
		lTC.setChanceCard(7);

		lTC.landOnField(pC, fC);
		
		boolean expectedOutcome = true;
		boolean actualOutcome = currentPlayer.getJailed();
		
		assertEquals(expectedOutcome, actualOutcome);
	}
	@Test
	public void testCard8Place(){
		lTC.setChanceCard(7);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 10;
		actualOutcomeInt = currentPlayer.getPlace();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard9(){
		lTC.setChanceCard(8);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 27000;
		actualOutcomeInt = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard10(){
		lTC.setChanceCard(9);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 31000;
		actualOutcomeInt = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCar11(){
		lTC.setChanceCard(10);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 31000;
		actualOutcomeInt = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard12(){
		lTC.setChanceCard(11);

		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 31000;
		actualOutcomeInt = currentPlayer.getAccount().getBalance();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
	@Test
	public void testCard13(){
		lTC.setChanceCard(12);

		currentPlayer.setPlace(7);
		lTC.landOnField(pC, fC);
		
		expectedOutcomeInt = 15;
		actualOutcomeInt = currentPlayer.getPlace();
		
		assertEquals(expectedOutcomeInt, actualOutcomeInt);
	}
}
