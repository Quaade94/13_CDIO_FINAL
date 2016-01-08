package Game;


import Players.PlayerController;
import desktop_resources.GUI;
import Fields.FieldController;
import Game.Language;

public class Setup {

	public void runSetup(){
		
		FieldController.initializeFieldCreator();
		GUIManager.createFields();
		
		PlayerController createplayer = new PlayerController();
		createplayer.createPlayers();

		GUI.getUserButtonPressed(Language.getLang("STARTMSG"), Language.getLang("START"));	
	}
	
}
