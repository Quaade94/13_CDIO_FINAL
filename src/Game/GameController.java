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

	private void standardTurn() {

		choice = GUI.getUserSelection(currentPlayer.getName() + Language.getLang("STURN"), Language.getLang("ROLL"), Language.getLang("BUYHOUSE"), Language.getLang("PLEDGE"), Language.getLang("BUYSELL"));

		if(choice == Language.getLang("ROLL")){
			//Player wants to roll the die
			playerPosition = currentPlayer.getPlace();
			die.roll();
			// Creates Dice on GUI
			GameController.dicePlace(Die.getDice1(), Die.getDice2());
			//Setting position
			newPosition = playerPosition + die.getDiceSum();
			if(newPosition >= 40){
				newPosition = newPosition-40;
				fC.landOnField(0, pC, fC);
			}
			currentPlayer.setPlace(newPosition);
			System.out.println("Nye " + newPosition+1);
			//Communicating with GUI
			GameController.movement(playerPosition+1,newPosition+1,currentPlayer.getName());
			GUI.showMessage(Language.getLang("ROLLED") + " " + die.getDiceSum());
			//Interacting with the field
			if(newPosition != 0){
				fC.landOnField(newPosition, pC, fC);
			}
			pC.endTurn();

		} else if (choice == Language.getLang("BUYHOUSE")){
			//Player wants to buy houses
			GUI.getUserSelection(Language.getLang("HOUSECHOICE"), "y0uR muM!?!");

		} else if (choice == Language.getLang("PLEDGE")){
			//Player wants to pledge properties

		} else if (choice == Language.getLang("BUYSELL")){
			for (int i=0; i<pC.getPlayers().length; i++){
				
			}
			//Adds a go back option to the name array 
			pC.names[pC.getPlayers().length] = "Fortryd";
			//The player chooses whether he wants to buy or sell
			boolean buysell = GUI.getUserLeftButtonPressed("Buying or selling?", "buying", "selling");
			
				if(buysell)
					this.choice = GUI.getUserSelection("Who do you want to buy from?", pC.names);
					System.out.println(choice);
						

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
	//makes the cars move from field to field
	public static void movement(int startPos, int finishPos, String name){
		int position = startPos;
		while(position != finishPos){
			GUI.removeCar(position, name);
			position++;
			if(position==41){
				position=1;
			}
			GUI.setCar(position, name);
			try {
				Thread.sleep(75);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

		return;
	}
	//Sets the GUI dice randomly within a specific area
	public static void dicePlace(int dice1, int dice2){
		int diceplacex1 = (int)(Math.random()*3+4);
		int diceplacey1 = (int)(Math.random()*2+2);
		int diceplacex2 = diceplacex1;
		int diceplacey2 = diceplacey1;
		while(diceplacex1 == diceplacex2){diceplacex2 =(int)(Math.random()*3+4);}
		while(diceplacey1 == diceplacey2){diceplacey2 =(int)(Math.random()*2+2);}
		GUI.setDice(dice1, diceplacex1, diceplacey1, dice2, diceplacex2, diceplacey2);
	}
}
