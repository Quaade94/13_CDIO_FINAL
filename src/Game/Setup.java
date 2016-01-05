package Game;

import Boundary.GUIFieldPrice;
import Boundary.Gameboard;
import Boundary.GUIPlayer;

public class Setup {

	public void runSetup(){
		
		Gameboard Gameboard = new Gameboard();
		GUIFieldPrice GUIFieldPrice = new GUIFieldPrice();
		Gameboard.setGameBoard();
		GUIFieldPrice.setPrice();
		
		GUIPlayer addplayer = new GUIPlayer();
		
	}
	
}
