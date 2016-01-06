package Game;


import Players.PlayerController;

import Fields.FieldController;

public class Setup {
	
	private int players = 0;

	public void runSetup(){
		
		GUIController GUIController = new GUIController();
		FieldController.initializeFieldCreator();
		GUIController.GUINonoOwnable();		
		
//		GUIPlayer addplayer = new GUIPlayer();
//		players = addplayer.getPlayerAmount();
		PlayerController createplayer = new PlayerController();
		createplayer.createPlayers();
		
				
	}
	
}
