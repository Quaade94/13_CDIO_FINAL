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
	private PlayerController pC;
	private FieldController fC;
	
	
	public void runGame(){
		//TODO add comments
		//Setup Fields
		fC = new FieldController();
		//Setup GUI - use nice setup delegate
		new GUISetupManager(fC);
		//Tell playercontroller to setup
		pC = new PlayerController();
		//GameLoop
		while(pC.getPlayers().length>1){
			currentPlayer = pC.getNextPlayer();
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
	
	public static void movement(int startPos, int finishPos, String name){
		int p1 = startPos;
		while(p1 != finishPos){
			GUI.removeCar(p1, name);
			p1++;
			GUI.setCar(p1, name);
			try {
			    Thread.sleep(100);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		
		return;
	}

	private void standardTurn() {
		System.out.println("Spiller 1 ejer: "+fC.getOwner(16));
		choice = GUI.getUserSelection(currentPlayer.getName() + Language.getLang("STURN"), Language.getLang("ROLL"), Language.getLang("BUYHOUSE"), Language.getLang("PLEDGE"), Language.getLang("BUYSELL"));
		
		if(choice == Language.getLang("ROLL")){
			//Player wants to roll the die
			playerPosition = currentPlayer.getPlace();
			die.roll();
			//Setting position
			newPosition = playerPosition + die.getDiceSum();
			if(newPosition >= 40){
				newPosition = newPosition-40;
				fC.landOnField(0, pC);
			}
			currentPlayer.setPlace(newPosition);
			System.out.println("Nye " + newPosition+1);
			//Communicating with GUI
			GameController.movement(playerPosition+1,newPosition+1,currentPlayer.getName());
//			GUI.removeCar(playerPosition+1, currentPlayer.getName());
//			GUI.setCar(newPosition+1, currentPlayer.getName());
			GUI.showMessage(Language.getLang("ROLLED") + " " + die.getDiceSum());
			//Interacting with the field
			if(playerPosition != 0){
				fC.landOnField(newPosition, pC);
			}
			pC.endTurn();
			
		} else if (choice == Language.getLang("BUYHOUSE")){
			//Player wants to buy houses
			GUI.getUserSelection(Language.getLang("HOUSECHOICE"), "y0uR muM!?!");
			
		} else if (choice == Language.getLang("PLEDGE")){
			//Player wants to pledge properties
			
		} else if (choice == Language.getLang("BUYSELL")){
			fC.setOwner(16, pC.getNextPlayer());
			System.out.println(fC.getOwner(16));
			this.choice = GUI.getUserSelection("What do you want to sell?", "Fortryd");
			if (choice == "Fortryd");
				System.out.println("Fuccka you gaybooi");
			
		} else {
			System.out.println("Fejl i player choice!");
		}
//		for (int i=0; i<40; i++){
//			fC.getOwner(i);
//		}
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
				pC.endTurn();
			}
			pC.endTurn();
		}else {
			currentPlayer.getAccount().updateBalance(-1000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			currentPlayer.setJail(false);
			pC.endTurn();
		}
		
	}
}
