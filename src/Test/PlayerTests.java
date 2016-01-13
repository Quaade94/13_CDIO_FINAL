package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.GameController;
import Players.PlayerController;
import Players.Player;
import Test.TestDie;

public class PlayerTests {
	
	GameController gC = new GameController();
	PlayerController pC = new PlayerController();
	TestDie die = new TestDie(3, 3);
	
//	@Test
//	public void playerTests() {
//		gC.runGame();
//		fail("Not yet implemented");
//	}
	
	//Player Position tests
	@Test
	public void playerPositionTestMin(){
		Player currentPlayer = pC.getCurrentPlayer();
		int playerPosition = currentPlayer.getPlace();
		int newPosition;
		die.roll();
		newPosition = playerPosition + TestDie.getDiceSum();
		currentPlayer.setPlace(newPosition);
		System.out.println(newPosition);
		System.out.println(TestDie.getDiceSum());
		
		int expectedNewPosition = 6;
		int actualNewPosition = currentPlayer.getPlace();
		
		assertEquals(expectedNewPosition, actualNewPosition);
		
	}
	@Test
	public void playerPositionTestMax(){
		Player currentPlayer = pC.getCurrentPlayer();
		currentPlayer.setPlace(33);
		int playerPosition = currentPlayer.getPlace();
		int newPosition;
		die.roll();
		newPosition = playerPosition + TestDie.getDiceSum();
		currentPlayer.setPlace(newPosition);
		System.out.println(newPosition);
		System.out.println(TestDie.getDiceSum());
		
		int expectedNewPosition = 39;
		int actualNewPosition = currentPlayer.getPlace();
		
		assertEquals(expectedNewPosition, actualNewPosition);
		
	}
	@Test
	public void playerPositionTestPassStart(){
		Player currentPlayer = pC.getCurrentPlayer();
		currentPlayer.setPlace(35);
		int playerPosition = currentPlayer.getPlace();
		int newPosition;
		die.roll();
		newPosition = playerPosition + TestDie.getDiceSum();
		if (newPosition >= 40) newPosition = newPosition-40;
		currentPlayer.setPlace(newPosition);
		System.out.println(newPosition);
		System.out.println(TestDie.getDiceSum());
		
		int expectedNewPosition = 1;
		int actualNewPosition = currentPlayer.getPlace();
		
		assertEquals(expectedNewPosition, actualNewPosition);
		
	}
	//AccountTests
	@Test
	public void playerAccountTest(){
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
		System.out.println("CP: " + actualNewBalanceCP);
		System.out.println("OP: " + actualNewBalanceOP);
		
		assertEquals(expectedNewBalanceCP, actualNewBalanceCP);
		assertEquals(expectedNewBalanceOP, actualNewBalanceOP);

	}
	
}
