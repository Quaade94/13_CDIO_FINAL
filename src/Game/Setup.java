package Game;


import Players.PlayerController;
import desktop_resources.GUI;
import Fields.FieldController;

public class Setup {

	public void runSetup(){
		
		GUIController GUIController = new GUIController();
		FieldController.initializeFieldCreator();
		GUIController.GUINonoOwnable();
		GUIController.GUIOwnable();
		
		PlayerController createplayer = new PlayerController();
		createplayer.createPlayers();

		GUI.getUserButtonPressed("Start game?", "Start");	
	}
	
}
