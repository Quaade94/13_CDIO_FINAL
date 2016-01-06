package Game;


import Boundary.GUINonOwnable;
import Boundary.GUIOwnable;
import Players.PlayerController;

import Fields.FieldController;

public class Setup {
	
	private int players = 0;

	public void runSetup(){
		
		GUINonOwnable GUINonOwnable = new GUINonOwnable();
		GUIOwnable GUIOwnable = new GUIOwnable();
		FieldController.initializeFieldCreator();
		GUINonOwnable.setGameBoard();
		GUIOwnable.GUIOwnablePrice();
		
		
		
//		GUIPlayer addplayer = new GUIPlayer();
//		players = addplayer.getPlayerAmount();
		PlayerController createplayer = new PlayerController();
		createplayer.createPlayers();
		
				
	}
	
}
