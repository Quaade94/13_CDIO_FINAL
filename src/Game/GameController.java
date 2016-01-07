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
			if (playerTurn.getJailed()){
				Boolean choice = GUI.getUserLeftButtonPressed("Roll or Pay?", "Roll", "Pay");
				if(choice){
					int chances = 3;
					boolean gotLoose = false;
					while(chances > 0){
						die.roll();
						if(die.getDice1() == die.getDice2()){
							gotLoose = true;
							chances = 0;
						}else if(die.getDice1() != die.getDice2()){
							chances--;
							GUI.showMessage("You rolled " + die.getDiceSum());
						}
					}
					if(gotLoose){
						playerTurn.setJail(false);
						int playerPosition = playerTurn.getPlace();
						int newPosition = playerPosition + die.getDiceSum();
						playerTurn.setPlace(newPosition);
						GUI.removeCar(playerPosition+1, playerTurn.getName());
						GUI.setCar(newPosition+1, playerTurn.getName());
						GUI.showMessage("You rolled " + die.getDiceSum());
						TurnSwitcher.endTurn();
					}
				}else if(!(choice)){
					playerTurn.getAccount().updateBalance(-1000);
					GUI.setBalance(playerTurn.getName(), playerTurn.getAccount().getBalance());
					playerTurn.setJail(false);
					TurnSwitcher.endTurn();
				}
			} else if (!(playerTurn.getJailed())){
				String choice = GUI.getUserSelection(playerTurn.getName() + "'s turn", "Roll", "Buy houses", "Pledge");
				if(choice == "Roll"){
					//Player wants to roll the die
					int playerPosition = playerTurn.getPlace();
					die.roll();
					//Setting position
					int newPosition = playerPosition + die.getDiceSum();
					if(newPosition > 40) newPosition = newPosition-40;
					playerTurn.setPlace(newPosition);
					//Communicating with GUI
					GUI.removeCar(playerPosition+1, playerTurn.getName());
					GUI.setCar(newPosition+1, playerTurn.getName());
					GUI.showMessage("You rolled " + die.getDiceSum());
					//Ending turn
					TurnSwitcher.endTurn();
				} else if (choice == "Buy houses"){
					//Player wants to buy houses
					GUI.getUserSelection("Which properties do you want to build houses on?", "Your mom");
					
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
