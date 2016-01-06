package Game;


import Boundary.GUINonOwnable;
import Boundary.GUIOwnable;
import Players.PlayerController;

public class Setup {
	
	private int players = 0;

	public void runSetup(){
		
		GUINonOwnable GUINonOwnable = new GUINonOwnable();
		GUIOwnable GUIOwnable = new GUIOwnable();
		GUINonOwnable.setGameBoard();
		//Skal ind når magnus er færdig med price arrays.
//		GUIFieldPrice.GUIOwnablePrice();
		
		
//		GUIPlayer addplayer = new GUIPlayer();
//		players = addplayer.getPlayerAmount();
		PlayerController createplayer = new PlayerController(5);
		createplayer.createPlayers();
		
				
	}
	
}
