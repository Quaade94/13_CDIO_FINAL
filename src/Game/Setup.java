package Game;

import Boundary.GUIFieldPrice;
import Boundary.GUIGameboard;
import Boundary.GUIPlayer;
import Boundary.GUIChanceCard;

public class Setup {

	public void runSetup(){
		
		GUIGameboard GUIGameboard = new GUIGameboard();
		GUIFieldPrice GUIFieldPrice = new GUIFieldPrice();
		GUIGameboard.setGameBoard();
		GUIFieldPrice.GUIOwnablePrice();
		
		GUIPlayer addplayer = new GUIPlayer();
		
		GUIChanceCard.card();
		
	}
	
}
