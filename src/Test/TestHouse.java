package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.GameController;
import Players.PlayerController;
import Fields.FieldController;

public class TestHouse {

	GameController gC = new GameController();
	PlayerController pC = new PlayerController();
	FieldController fC = new FieldController();
	
	@Test
	public void testSetHouse() {
		fC.setHouseAmount(5, 1);
		int actualHouseAmount = fC.getHouseAmount(5);
		int expectedHouseAmount = 1;
		
		assertEquals(expectedHouseAmount, actualHouseAmount);
	}

}
