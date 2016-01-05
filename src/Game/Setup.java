package Game;

import Boundary.GUIFieldPrice;
import Boundary.GUIGameboard;
import Boundary.GUIPlayer;

public class Setup {

	public void runSetup(){
		
		GUIGameboard GUIGameboard = new GUIGameboard();
		GUIFieldPrice GUIFieldPrice = new GUIFieldPrice();
		GUIGameboard.setGameBoard();
		GUIFieldPrice.setPrice();
		
		GUIPlayer addplayer = new GUIPlayer();
		
		
	}
	
}
