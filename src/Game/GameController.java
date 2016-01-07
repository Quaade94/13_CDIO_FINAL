package Game;

import desktop_resources.GUI;
import Game.TurnSwitcher;
import Players.PlayerController;
import Players.Player;

public class GameController {

	Die die = new Die();
	
	public void runGame(){
		while(PlayerController.getPlayers().length>1){
			Player playerTurn = TurnSwitcher.getPlayerTurn();
			//GUI.getUserLeftButtonPressed(TurnSwitcher.getPlayerTurn() + "'s turn", "Roll", "Buy");
			if (playerTurn.getJailed()){
				
			} else if (!(playerTurn.getJailed())){
				String choice = GUI.getUserSelection(playerTurn.getName() + "'s turn", "Roll", "Buy houses", "Pledge");
				if(choice == "Roll"){
					//Player wants to roll the die
					int playerPosition = playerTurn.getPlace();
					System.out.println(playerTurn.getName() + " placering " + playerTurn.getPlace());
					die.roll();
					GUI.showMessage("You rolled " + die.getDiceSum());
					int newPosition = playerPosition + die.getDiceSum();
					playerTurn.setPlace(newPosition);
					GUI.removeCar(playerPosition+1, playerTurn.getName());
					GUI.setCar(newPosition+1, playerTurn.getName());
					TurnSwitcher.endTurn();
				} else if (choice == "Buy houses"){
					//Player wants to buy houses
				} else if (choice == "Pledge"){
					//Player wants to pledge properties
				} else {
					System.out.println("Fejl i player choice!");
				}
			} else{
				System.out.println("Fejl i jailcheck!");
			}
			
		}
	}
}
