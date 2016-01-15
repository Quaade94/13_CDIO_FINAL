package Players;

import desktop_resources.GUI;
import desktop_codebehind.Car;

import Game.Language;

public class PlayerController {
	
	private int playerAmount;
	private Player[] players;
	private int currentPlayer = 1;
	
	/**
	 * Opretter et spillerarray af spillerne
	 * @param playerAmount Antallet af spillere
	 */
	public PlayerController(){
		playerAmount = GUI.getUserInteger(Language.getLang("PLAYERNO"), 2, 6);
		players = new Player[playerAmount];
		createPlayers();		
	}
	
	/**
	 * Opretter spillerne (Spiller objekter, spillerbiler mm.)
	 */
	public void createPlayers(){
		
		Car[] cars = CarBuilder.getCar();
		for (int x = 0; x < playerAmount; x++){
			String name;
			boolean nameExists = false;
			do{
				//Checks if the playerss name follows a certain criteria
				nameExists = false;
				name = GUI.getUserString(Language.getLang("WHATSNAME"));
				for(int i = 0; i < x; i++){
					if(players[i].getName().equals(name)){
						nameExists = true;
					GUI.getUserButtonPressed(Language.getLang("NAMEERRORSAME"), Language.getLang("TYPENEW"));
					}
				}
				if(name.length() < 3 || name.length() > 17){	
					nameExists = true;
					GUI.getUserButtonPressed(Language.getLang("NAMEERRORSHORTLONG"), Language.getLang("TYPENEW"));
				}
		
			}while(nameExists);
			//Makes the first letter in the name uppercase
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
			
			//Creates the player and puts him into an array
			Player player = new Player();
			player.setName(name);
			players[x] = player;
			//Creates the player on the board
			GUI.addPlayer(players[x].getName(), players[x].getAccount().getBalance(), cars[x]);
			GUI.setCar(players[x].getPlace()+1, players[x].getName());
 		}
	}
	
	/**
	 * A method to get the playerarray for use in other classes
	 * @return An array of players
	 */
	public Player[] getPlayers(){
		return players;
	}
	
	/**
	 * Ends the turn for the current player and makes the next one currentPlayer
	 */
	public void endTurn(){
		if(currentPlayer < players.length){			
			currentPlayer++;			
		}else if(currentPlayer >= players.length){	
			currentPlayer = 1;
		}else{
			System.out.println("Fejl i endTurn metode");
		}
	}

	/**
	 * A method to get the current player
	 * @return The player who has his turn
	 */
	public Player getCurrentPlayer() {
		return players[currentPlayer-1];
	}	
}
