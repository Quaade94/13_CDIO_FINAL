package Boundary;

import desktop_resources.GUI;

public class GUIPlayer {
	
	
	private int amountPlayers = GUI.getUserInteger("How many players?", 3, 6);
	
	public int getPlayerAmount(){
		return amountPlayers;
	
	}
	
	
	public String enterName(){
		String n = GUI.getUserString("Enter your name, bitch: ");
		return n;
	}
}
