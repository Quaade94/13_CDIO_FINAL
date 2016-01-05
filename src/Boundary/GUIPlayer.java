package Boundary;

import desktop_resources.GUI;
import Players.Player;

public class GUIPlayer {
	
	int amountPlayers = GUI.getUserInteger("How many players?", 2, 6);
	
	public int getPlayerAmount(){
		return amountPlayers;
	}
	
	public String enteredName(){
		String n = GUI.getUserString("Enter your name, bitch: ");
		return n;
	}
}
