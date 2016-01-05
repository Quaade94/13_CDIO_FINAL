package Boundary;

import desktop_resources.GUI;
import Players.Player;

public class GUIPlayer {
	
	int amountPlayers = GUI.getUserInteger("How many players?", 2, 6);
	
	public int getAmountPlayers(){
		return amountPlayers;
	}
	
	public void createPlayers(){
	
		
	
//	GUI.addPlayer(Player.getName(), Player.getBalnce(), Player.getCar());
	
	}
}
