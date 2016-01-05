package Boundary;

import desktop_resources.GUI;
import Players.Player;

public class GUIPlayer {
	
	public void createPlayers(){
	
	GUI.addPlayer(Player.getName(), Player.getBalnce(), Player.getCar());
	
	}
}
