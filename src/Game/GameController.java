package Game;

import desktop_resources.GUI;
import Players.PlayerController;
import Players.Player;
import Fields.FieldController;
import Game.Language;

public class GameController {

	private int chances;
	private boolean gotLoose;
	private boolean choiceJail;
	private String choice;
	private int playerPosition;
	private int newPosition;
	private Player currentPlayer;
	Die die = new Die();
	private PlayerController playerController;
	private FieldController fieldController;
	
	
	public void runGame(){
		//TODO add comments
		//Setup Fields
		fieldController = new FieldController();
		//Setup GUI - use nice setup delegate
		new GUISetupManager(fieldController);
		//Tell playercontroller to setup
		playerController = new PlayerController();
		//GameLoop
		while(playerController.getPlayers().length>1){
			currentPlayer = playerController.getNextPlayer();
			//JailTurn
			if (currentPlayer.getJailed()){
				jailTurn();
			} else if (!(currentPlayer.getJailed())){
				standardTurn();
			} else{
				System.out.println("Fejl i jailcheck!");
			}
			
		}
	}

	private void standardTurn() {
		choice = GUI.getUserSelection(currentPlayer.getName() + Language.getLang("STURN"), Language.getLang("ROLL"), Language.getLang("BUYHOUSE"), Language.getLang("PLEDGE"));
		if(choice == Language.getLang("ROLL")){
			//Player wants to roll the die
			playerPosition = currentPlayer.getPlace();
			die.roll();
			//Setting position
			newPosition = playerPosition + die.getDiceSum();
			if(newPosition >= 40){
				newPosition = newPosition-40;
				fieldController.landOnField(0, playerController);
			}
			currentPlayer.setPlace(newPosition);
			System.out.println("Nye " + newPosition+1);
			//Communicating with GUI
			GUI.removeCar(playerPosition+1, currentPlayer.getName());
			GUI.setCar(newPosition+1, currentPlayer.getName());
			GUI.showMessage(Language.getLang("ROLLED") + " " + die.getDiceSum());
			//Interacting with the field
			if(playerPosition != 0){
				fieldController.landOnField(newPosition, playerController);
			}
			playerController.endTurn();
		} else if (choice == Language.getLang("BUYHOUSE")){
			//Player wants to buy houses
			GUI.getUserSelection(Language.getLang("HOUSECHOICE"), "y0uR muM!?!");
			
		} else if (choice == Language.getLang("PLEDGE")){
			//Player wants to pledge properties
		} else {
			System.out.println("Fejl i player choice!");
		}
	}

	private void jailTurn() {
		choiceJail = GUI.getUserLeftButtonPressed(Language.getLang("ROLLPAY"), Language.getLang("ROLL"), Language.getLang("PAY"));
		if(choiceJail){
			chances = 3;
			gotLoose = false;
			while(chances > 0){
				die.roll();
				if(die.getDice1() == die.getDice2()){
					gotLoose = true;
					chances = 0;
				}else if(die.getDice1() != die.getDice2()){
					chances--;
					GUI.showMessage(Language.getLang("ROLLED")+ " " + die.getDiceSum());
				}
			}
			if(gotLoose){
				currentPlayer.setJail(false);
				playerPosition = currentPlayer.getPlace();
				newPosition = playerPosition + die.getDiceSum();
				if(newPosition >= 40) newPosition = newPosition-40;
				currentPlayer.setPlace(newPosition);
				GUI.removeCar(playerPosition+1, currentPlayer.getName());
				GUI.setCar(newPosition+1, currentPlayer.getName());
				GUI.showMessage(Language.getLang("ROLLED") + " " + die.getDiceSum());
				playerController.endTurn();
			}
			playerController.endTurn();
		}else {
			currentPlayer.getAccount().updateBalance(-1000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			currentPlayer.setJail(false);
			playerController.endTurn();
		}
	}
}
