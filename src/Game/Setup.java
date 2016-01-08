package Game;


import Players.PlayerController;
import desktop_resources.GUI;
import Fields.FieldController;

public class Setup {

	public void runSetup(){
		
		GUIManager GUIManager = new GUIManager();
		FieldController.initializeFieldCreator();
		GUIManager.createFields();
		
		PlayerController createplayer = new PlayerController();
		createplayer.createPlayers();

		GUI.getUserButtonPressed("Start game?", "Start");	
	}
	
}
