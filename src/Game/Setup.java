package Game;

import Boundary.GUIPlayer;
import Players.PlayerCreator;

public class Setup {
	
	private int players = 0;

	public void runSetup(){
		
		//Skal ind når magnus er færdig med price arrays.
//		GUIFieldPrice.GUIOwnablePrice();
		
//		GUIPlayer addplayer = new GUIPlayer();
//		players = addplayer.getPlayerAmount();
		PlayerCreator createplayer = new PlayerCreator(5);
		createplayer.createPlayers();
		
				
	}
	
}
