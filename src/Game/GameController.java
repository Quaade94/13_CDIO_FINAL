package Game;

import desktop_resources.GUI;
import Players.PlayerController;
import Players.Player;
import Fields.FieldController;
import Controllers.BuyHouseController;
import Controllers.BuySellPropertyController;
import Controllers.DiceRollController;
import Game.Language;

public class GameController {

	private int chances;
	private boolean gotLoose;
	private boolean choiceJail;
	private String choice;
	private Player currentPlayer;
	private PlayerController pC;
	private FieldController fC;
	private BuyHouseController bhC;
	private BuySellPropertyController bspC;
	private DiceRollController dC;
	private GameController gC;

	Die die = new Die();

	public void runGame(){
		//Setup Fields
		fC = new FieldController();
		//Setup GUI
		new GUISetupManager(fC);
		//Setup buy sell house option
		bhC = new BuyHouseController();
		//Setup buy sell property option
		bspC = new BuySellPropertyController();
		//Setup dice roll option
		dC = new DiceRollController();
		//Tell playercontroller to setup
		pC = new PlayerController();
		//GameLoop
		while(pC.getPlayers().length>1){
			currentPlayer = pC.getCurrentPlayer();
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

	public void winCondition(){
		Player[] players = pC.getPlayers();
		for(int i=0 ; i < players.length; i++){
			if(players[i].getAccount().getBalance() < 0){
				GUI.showMessage(players[i].getName() + Language.getLang("DEATH"));
				GUI.removeCar(players[i].getPlace(), players[i].getName());
				for(int j = 0 ; j < 39 ; j++){
					if(fC.getOwner(j) == players[i]){
						fC.resetOwner(j);
						GUI.removeOwner(j+1);
						fC.resetHouses(j);
					}
				}

			}
		}
	}
	

	private void standardTurn() {
		//Asks the player what they want to do in beginning of their turn
		choice = GUI.getUserSelection(currentPlayer.getName() + Language.getLang("STURN"), Language.getLang("ROLL"), Language.getLang("BUYHOUSE"), Language.getLang("BUYSELL"));

		//Player wants to roll the die
		if(choice == Language.getLang("ROLL")){
			dC.rollOption(fC, pC, die);

			//Player wants to buy houses
		} else if (choice == Language.getLang("BUYHOUSE")){
			bhC.buyHouseOption(fC, pC, die);

			//If the player wants to buy or sell properties to other players
		} else if (choice == Language.getLang("BUYSELL")){
			bspC.buysellOption(fC, pC, die);

		} else {
			System.out.println("Fejl i player choice!");
		}
	}

	//This turn is run, when the player is in jail
	private void jailTurn() {
		//Asks the player if he wants to roll or pay to get out
		choiceJail = GUI.getUserLeftButtonPressed(Language.getLang("ROLLPAY"), Language.getLang("ROLL"), Language.getLang("PAY"));
		//If the player chose roll
		if(choiceJail){
			chances = 3;
			gotLoose = false;
			while(chances > 0){
				die.roll();
				// Creates Dice on GUI
				GameController.dicePlace(Die.getDice1(), Die.getDice2());
				if(die.getDice1() == die.getDice2()){
					gotLoose = true;
					chances = 0;
				}else if(die.getDice1() != die.getDice2()){
					chances--;
					GUI.showMessage(Language.getLang("ROLLED")+ " " + die.getDiceSum());
				}
			}
			//If the player got out
			if(gotLoose){
				currentPlayer.setJail(false);
				int playerPosition = currentPlayer.getPlace();
				int newPosition = playerPosition + die.getDiceSum();
				if(newPosition >= 40) newPosition = newPosition-40;
				currentPlayer.setPlace(newPosition);
				GUI.removeCar(playerPosition+1, currentPlayer.getName());
				GUI.setCar(newPosition+1, currentPlayer.getName());
				GUI.showMessage(Language.getLang("ROLLED") + " " + die.getDiceSum());
				fC.landOnField(newPosition, pC, fC);
				pC.endTurn();
			}
			pC.endTurn();
			//If the player decided to pay
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
				Thread.sleep(75);                 //75 milliseconds is one second.
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
