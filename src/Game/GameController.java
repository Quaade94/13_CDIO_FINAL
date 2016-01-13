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
	private PlayerController pC;
	private FieldController fC;
	private int turns = 0;
	
	Die die = new Die();
	
	public void runGame(){
		//Setup Fields
		fC = new FieldController();
		//Setup GUI
		new GUISetupManager(fC);
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

	private void standardTurn() {
		//Asks the player what they want to do in beginning of their turn
		choice = GUI.getUserSelection(currentPlayer.getName() + Language.getLang("STURN"), Language.getLang("ROLL"), Language.getLang("BUYHOUSE"), Language.getLang("PLEDGE"), Language.getLang("BUYSELL"));

		//Player wants to roll the die
		if(choice == Language.getLang("ROLL")){
			playerPosition = currentPlayer.getPlace();
			die.roll();
			// Creates Dice on GUI
			GameController.dicePlace(Die.getDice1(), Die.getDice2());
			//Extra turn on identical faces // also jail on 3rd identical faces
			if(Die.getDice1()==Die.getDice2()){turns++;}
			if(Die.getDice1()!=Die.getDice2()){turns = 0;}
			if(turns == 1 || turns == 2){GUI.showMessage(Language.getLang("ROLLEDD"));}
			if(turns==3){
				GUI.showMessage(Language.getLang("ROLLEDJ"));
				GameController.movement(currentPlayer.getPlace()+1, 11, currentPlayer.getName());
				currentPlayer.setPlace(10);
				currentPlayer.setJail(true);
				turns = 0;
			}else {
				//Setting position
				newPosition = playerPosition + die.getDiceSum();
				if(newPosition >= 40){
					newPosition = newPosition-40;
					fC.landOnField(0, pC, fC);
				}
				currentPlayer.setPlace(newPosition);
				//Communicating with GUI
				GameController.movement(playerPosition+1,newPosition+1,currentPlayer.getName());
				GUI.showMessage(Language.getLang("ROLLED") + " " + die.getDiceSum());
				//Interacting with the field
				if(newPosition != 0){
					fC.landOnField(newPosition, pC, fC);
				}}
			if(turns==0){
				pC.endTurn();
			}

		//Player wants to buy houses
		} else if (choice == Language.getLang("BUYHOUSE")){
			//Puts the different colored ownable fields in to an array
			String[] territoryColours = currentPlayer.getTerColour();
			int[] numberTerritories = new int[8];
			numberTerritories[0] = 0;
			numberTerritories[1] = 0;
			numberTerritories[2] = 0;
			numberTerritories[3] = 0;
			numberTerritories[4] = 0;
			numberTerritories[5] = 0;
			numberTerritories[6] = 0;
			numberTerritories[7] = 0;
			boolean buildable = false;
			for (int i = 0; i < 8; i++){
				for (int j = 0; j < territoryColours.length; j++){
					if (i == 0 && territoryColours[j] == "BLUE"){
						numberTerritories[0]++;
					} else if (i == 1 && territoryColours[j] == "ORANGE"){
						numberTerritories[1]++;
					} else if (i == 2 && territoryColours[j] == "GREEN"){
						numberTerritories[2]++;
					} else if (i == 3 && territoryColours[j] == "GREY"){
						numberTerritories[3]++;
					} else if (i == 4 && territoryColours[j] == "RED"){
						numberTerritories[4]++;
					} else if (i == 5 && territoryColours[j] == "WHITE"){
						numberTerritories[5]++;
					} else if (i == 6 && territoryColours[j] == "YELLOW"){
						numberTerritories[6]++;
					} else if (i == 7 && territoryColours[j] == "PURPLE"){
						numberTerritories[7]++;
					}
				}
				if (numberTerritories[0] == 2 || numberTerritories[1] == 3 || 
					numberTerritories[2] == 3 || numberTerritories[3] == 3 || 
					numberTerritories[4] == 3 || numberTerritories[5] == 3 || 
					numberTerritories[6] == 3 || numberTerritories[7] == 2){
					buildable = true;
				}

			}
			//Puts the buildable territories for the current player into an array
			if (buildable){
				String[] buildables;
				int arrayLength = 0;
				
				for(int i = 0; i < numberTerritories.length; i++){
					if (i == 0 || i == 7){
						if (numberTerritories[i] == 2) {
							arrayLength = arrayLength+2;
						}
					}else if (numberTerritories[i] == 3){
						arrayLength = arrayLength+3;
					}
				}
				
				buildables = new String[arrayLength+1];

				if (numberTerritories[0] == 2){
					buildables = buildablesArray(buildables, 1, 3, 0);
				}
				if (numberTerritories[7] == 2){
					buildables = buildablesArray(buildables, 37, 39, 0);
				}
				if (numberTerritories[1] == 3){
					buildables = buildablesArray(buildables, 6, 8, 9);
				}
				if (numberTerritories[2] == 3){
					buildables = buildablesArray(buildables, 11, 13, 14);
				}
				if (numberTerritories[3] == 3){
					buildables = buildablesArray(buildables, 16, 18, 19);
				}
				if (numberTerritories[4] == 3){
					buildables = buildablesArray(buildables, 21, 23, 24);
				}
				if (numberTerritories[5] == 3){
					buildables = buildablesArray(buildables, 26, 27, 29);
				}
				if (numberTerritories[6] == 3){
					buildables = buildablesArray(buildables, 31, 32, 34);
				}
				buildables[arrayLength] = Language.getLang("CANCEL");

				//Asks the player which property they want to buy houses on
				String playerChoice = GUI.getUserSelection(Language.getLang("CHOOSEPROPERTYBUY"), buildables);
		
				int housePrice = 0;
				int place = 0;
				for (int i = 0; i < 40; i++){
					if(fC.getName(i) == playerChoice){
						place = i;
						fC.getFieldNumber(i);
						housePrice = fC.getHousePrice(i);
					}
				}
				//Checks if the player can afford the house
				if (housePrice <= currentPlayer.getAccount().getBalance()){
					if (fC.getHouseAmount(place) <= 5){
						currentPlayer.getAccount().updateBalance(-housePrice);
						GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
						fC.setHouseAmount(place, fC.getHouseAmount(place)+1);
						if(fC.getHouseAmount(place) == 5){
							GUI.setHotel(place+1, true);
						} else{
							GUI.setHouses(place+1, fC.getHouseAmount(place));
						}
					}
				} else {
					GUI.showMessage(Language.getLang("CANTAFFORDHOUSE"));
				}

			} else {
				//If the player doesnt have any buildable territories
				GUI.showMessage(Language.getLang("NOBUILDABLES"));
			}
			
		//If the player wants to buy or sell properties to other players
		} else if (choice == Language.getLang("BUYSELL")){
			//Creates an array of the playernames
			String[] names;
			names = new String[pC.getPlayers().length];
			int nameAddedToDD = 0;
			for (int i=0; i<pC.getPlayers().length-1; i++){
				if (pC.getPlayers()[nameAddedToDD].getName()!=pC.getCurrentPlayer().getName()){
					names[i] = pC.getPlayers()[nameAddedToDD].getName();
					nameAddedToDD++;
				}
				else {
					names[i] = pC.getPlayers()[nameAddedToDD+1].getName();
					nameAddedToDD = nameAddedToDD+2;
				}
			}	
			//Adds a go back option to the name array 
			names[pC.getPlayers().length-1] = Language.getLang("CANCEL");

			//The player chooses whether he wants to buy or sell
			boolean buysell = GUI.getUserLeftButtonPressed(Language.getLang("BUYSELLBUTTON"), Language.getLang("BUY"), Language.getLang("SELL"));			
			
			//If the player wants to buy a property from another player
			if(buysell){
				//The player choses who he wants to buy from
				this.choice = GUI.getUserSelection(Language.getLang("WHOBUY"), names);

				if (choice != Language.getLang("CANCEL")){
					int theChosenOneBuy = 0;
					for (int z = 0; z<pC.getPlayers().length; z++){
						if(choice == pC.getPlayers()[z].getName()){
							theChosenOneBuy = z;
						}
					}

					//Creates an array of the fields the player can buy from the player he chose 
					String[] fieldsBuy;
					int lenghtOfOwnedFieldsArray = 0;
					for (int l=0; l<=39; l++){
						if (fC.getOwner(l)!=null){
							if (fC.getOwner(l) == pC.getPlayers()[theChosenOneBuy]){
								lenghtOfOwnedFieldsArray++;
							}
						}
					}
					fieldsBuy = new String[lenghtOfOwnedFieldsArray+1];

					int q = 0;
					for (int t=0; t<=39; t++){
						if (fC.getOwner(t)!=null){
							if (fC.getOwner(t)==pC.getPlayers()[theChosenOneBuy]){
								fieldsBuy[q] = fC.getName(t);
								q++;
							}
						}
					}
					fieldsBuy[lenghtOfOwnedFieldsArray] = Language.getLang("CANCEL");					
					
					//Asks the player which field he wants to buy
					this.choice = GUI.getUserSelection(Language.getLang("WHICHBUY"), fieldsBuy);

					if (choice != Language.getLang("CANCEL")){

						int fieldPurchase = 0;
						for (int p = 0; p<=39; p++){
							if(choice == fC.getName(p)){
								fieldPurchase = p;
							}
						}

						//Asks the player what he wants to buy it for
						int buyersPrice = GUI.getUserInteger(Language.getLang("WHATBUYPRICE"));
						//Asks the chosen owner of the property if he wants sell his property
						boolean yesno = GUI.getUserLeftButtonPressed(String.format(Language.getLang("DOWANTSELL"),pC.getPlayers()[theChosenOneBuy].getName(),fC.getName(fieldPurchase),buyersPrice), Language.getLang("YES"), Language.getLang("NO"));
						if(yesno){
							pC.getCurrentPlayer().getAccount().updateBalance(-buyersPrice);
							pC.getPlayers()[theChosenOneBuy].getAccount().updateBalance(buyersPrice);
							GUI.setBalance(pC.getCurrentPlayer().getName(), pC.getCurrentPlayer().getAccount().getBalance());
							GUI.setBalance(pC.getPlayers()[theChosenOneBuy].getName(), pC.getPlayers()[theChosenOneBuy].getAccount().getBalance());
							fC.setOwner(fieldPurchase, currentPlayer);
							currentPlayer.addTerColour(fC.getColour(fieldPurchase));
							pC.getPlayers()[theChosenOneBuy].removeTerColour(fC.getColour(fieldPurchase));
							GUI.removeOwner(fieldPurchase+1);
							GUI.setOwner(fieldPurchase+1, pC.getCurrentPlayer().getName());
						}
					}
				}

			}
			else{
				//Creates an array of the players sellable fields
				String[] fieldsSell;
				int lenghtOfOwnedFieldsArray = 0;
				for (int l=0; l<40; l++){
					if (fC.getOwner(l)!=null){
						if (fC.getOwner(l) == pC.getCurrentPlayer()){
							lenghtOfOwnedFieldsArray++;
						}
					}
				}
				fieldsSell = new String[lenghtOfOwnedFieldsArray+1];

				int q = 0;
				for (int t=0; t<=39; t++){
					if (fC.getOwner(t)!=null){
						if (fC.getOwner(t) == pC.getCurrentPlayer()){
							fieldsSell[q] = fC.getName(t);
							q++;
						}
					}
				}
				fieldsSell[lenghtOfOwnedFieldsArray] = Language.getLang("CANCEL");

				//Asks the player which field he wants to sell 
				this.choice = GUI.getUserSelection(Language.getLang("WHICHSELL"), fieldsSell);	

				if (choice != Language.getLang("CANCEL")){
					int fieldSell = 0;
					for (int p = 0; p<=39; p++){
						if(choice == fC.getName(p)){
							fieldSell = p;
						}
					}
					
					//Asks the player who he wants to sell his property to
					this.choice = GUI.getUserSelection(Language.getLang("WHOSELL"), names);

					if (choice != Language.getLang("CANCEL")){
						int theChosenOneSell = 0;
						for (int z = 0; z<pC.getPlayers().length; z++){
							if(choice == pC.getPlayers()[z].getName()){
								theChosenOneSell = z;
							}
						}
						//Asks the player what amount he wants to sell his property for
						int sellPrice = GUI.getUserInteger(Language.getLang("WHATSELLPRICE"));
						boolean yesno = GUI.getUserLeftButtonPressed(String.format(Language.getLang("DOWANTBUY"), pC.getPlayers()[theChosenOneSell].getName(),fC.getName(fieldSell),sellPrice),Language.getLang("YES"), Language.getLang("NO"));
						if (yesno){
							pC.getCurrentPlayer().getAccount().updateBalance(sellPrice);
							pC.getPlayers()[theChosenOneSell].getAccount().updateBalance(-sellPrice);
							GUI.setBalance(pC.getCurrentPlayer().getName(), pC.getCurrentPlayer().getAccount().getBalance());
							GUI.setBalance(pC.getPlayers()[theChosenOneSell].getName(), pC.getPlayers()[theChosenOneSell].getAccount().getBalance());
							fC.setOwner(fieldSell, pC.getPlayers()[theChosenOneSell]);
							pC.getPlayers()[theChosenOneSell].addTerColour(fC.getColour(fieldSell));
							currentPlayer.removeTerColour(fC.getColour(fieldSell));
							GUI.removeOwner(fieldSell+1);
							GUI.setOwner(fieldSell+1, pC.getPlayers()[theChosenOneSell].getName());
						}

					}

				}
			}

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
				playerPosition = currentPlayer.getPlace();
				newPosition = playerPosition + die.getDiceSum();
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
	
	public String[] buildablesArray(String[] array, int index1, int index2, int index3){
		for (int i = 0; i < array.length; i++){
			if(array[i] == null){
				array[i] = fC.getName(index1);
				break;
			}
		}
		for (int i = 0; i < array.length; i++){
			if(array[i] == null){
				array[i] = fC.getName(index2);
				break;
			}
		}
		for (int i = 0; i < array.length; i++){
			if(index3 != 0 && array[i] == null){
				array[i] = fC.getName(index3);
				break;
			}
		}
		return array;
	}
}
