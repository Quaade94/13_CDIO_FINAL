package Players;

import Boundary.GUIPlayer;
import desktop_resources.GUI;

public class PlayerController {
	
	private int playerAmount;
	private Player[] players;
	private GUIPlayer guiplayer;
	
	/**
	 * Opretter et spillerarray af spillerne
	 * @param playerAmount Antallet af spillere
	 */
	public PlayerController(){
		playerAmount = GUI.getUserInteger("How many players?", 2, 6);
		players = new Player[playerAmount];
		
		for (int i = 0; i < playerAmount; i++){
			players[i] = new Player();
		}
	}
	

	
	public void createPlayers(){
		
		for (int x = 0; x < playerAmount; x++){
			
			String name = GUI.getUserString("Enter your name: ");
			players[x].setName(name);
				if (players[x].getName().equals(players[x].getName()) ){
					name = GUI.getUserString("Enter your name");
			}
			
			
		}
	}
	
}