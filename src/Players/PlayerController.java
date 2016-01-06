package Players;

import java.sql.Blob;

import desktop_resources.GUI;

public class PlayerController {
	
	private int playerAmount;
	private Player[] players;
	private boolean Bleh;

	
	/**
	 * Opretter et spillerarray af spillerne
	 * @param playerAmount Antallet af spillere
	 */
	public PlayerController(){
		playerAmount = GUI.getUserInteger("How many players?", 2, 6);
		players = new Player[playerAmount];
		
	}
	

	
	public void createPlayers(){
		
		for (int x = 0; x < playerAmount; x++){
			String name;
			boolean nameExists = false;
			do{
				nameExists = false;
				name = GUI.getUserString("Enter your name: ");
				for(int i = 0; i < x; i++){
					if(players[i].getName().equals(players[x].getName())){
						nameExists = true;
					GUI.getUserButtonPressed("You can't be named the same as someone else!", "Type new name");
					}
				}
				if(players[x].getName() == null){
					nameExists = true;
					GUI.getUserButtonPressed("You have a name idiot", "Type new name");
				}	
				if(players[x].getName().length() < 3 && players[x].getName().length() > 17){	
					nameExists = true;
					GUI.getUserButtonPressed("Your name needs to be minimum 3 characters short and 17 characters long", "Type new name");
				}
		
			}while(nameExists);

			Player player = new Player();
			player.setName(name);
			players[x] = player;
		}
	}
	private boolean checkName(b names){
		boolean output = false;
	}
	
}