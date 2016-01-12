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
	private int turns = 0;

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

		choice = GUI.getUserSelection(currentPlayer.getName() + Language.getLang("STURN"), Language.getLang("ROLL"), Language.getLang("BUYHOUSE"), Language.getLang("PLEDGE"), Language.getLang("BUYSELL"));

		if(choice == Language.getLang("ROLL")){
			//Player wants to roll the die
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

		} else if (choice == Language.getLang("BUYHOUSE")){
			//Player wants to buy houses
			String[] territoryColours = currentPlayer.getTerColour();
			int blue = 0;
			int purple = 0;
			int orange = 0;
			int green = 0;
			int grey = 0;
			int red = 0;
			int white = 0;
			int yellow = 0;
			boolean buildable = false;
			for (int i = 0; i < 8; i++){
				for (int j = 0; j < territoryColours.length; j++){
					if (i == 0 && territoryColours[j] == "BLUE"){
						blue++;
					} else if (i == 1 && territoryColours[j] == "ORANGE"){
						orange++;
					} else if (i == 2 && territoryColours[j] == "GREEN"){
						green++;
					} else if (i == 3 && territoryColours[j] == "GREY"){
						grey++;
					} else if (i == 4 && territoryColours[j] == "RED"){
						red++;
					} else if (i == 5 && territoryColours[j] == "WHITE"){
						white++;
					} else if (i == 6 && territoryColours[j] == "YELLOW"){
						yellow++;
					} else if (i == 7 && territoryColours[j] == "Purple"){
						purple++;
					}
				}
				if (blue == 2 || purple == 2 || orange == 3 || green == 3 || grey == 3 || red == 3 || white == 3 || yellow == 3){
					buildable = true;
				}
				
			}
			if (buildable){
				String[] buildables;
				int arrayLength = blue + orange + green + grey + red + white + yellow + purple;
				buildables = new String[arrayLength];
				
					if (blue == 2){
						buildables = buildablesArray(buildables, 1, 3, 0);
					}
					if (purple == 2){
						buildables = buildablesArray(buildables, 37, 39, 0);
					}
					if (orange == 3){
						buildables = buildablesArray(buildables, 6, 8, 9);
					}
					if (green == 3){
						buildables = buildablesArray(buildables, 11, 13, 14);
					}
					if (grey == 3){
						buildables = buildablesArray(buildables, 16, 18, 19);
					}
					if (red == 3){
						buildables = buildablesArray(buildables, 21, 23, 24);
					}
					if (white == 3){
						buildables = buildablesArray(buildables, 26, 27, 29);
					}
					if (yellow == 3){
						buildables = buildablesArray(buildables, 31, 32, 34);
					}
					
					String playerChoice = GUI.getUserSelection("Choose the property you want to buy house on", buildables);
					System.out.println("playerChoice: " + playerChoice);
					int housePrice = 0;
					int place = 0;
					for (int i = 0; i < 39; i++){
						if(fC.getName(i) == playerChoice){
							System.out.println("i: " + i);
							place = i;
							fC.getFieldNumber(i);
							housePrice = fC.getHousePrice(i);
							System.out.println("housePrice" + housePrice);
						}
					}
					if (housePrice <= currentPlayer.getAccount().getBalance()){
						if (fC.getHouseAmount(place) <= 5){
							currentPlayer.getAccount().updateBalance(-housePrice);
							GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
							fC.setHouseAmount(place, fC.getHouseAmount(place)+1);
							System.out.println("getHouseAmount: " + fC.getHouseAmount(place));
							if(fC.getHouseAmount(place) == 5){
								GUI.setHotel(place+1, true);
							} else{
								GUI.setHouses(place+1, fC.getHouseAmount(place));
							}
						}
					} else {
						GUI.showMessage("You can't afford any houses on this property");
					}
					
			} else {
				GUI.showMessage("You don't own any properties you can build houses on!");
			}

		} else if (choice == Language.getLang("PLEDGE")){
			//Player wants to pledge properties

		} else if (choice == Language.getLang("BUYSELL")){
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
			names[pC.getPlayers().length-1] = "Fortryd";

			//The player chooses whether he wants to buy or sell
			boolean buysell = GUI.getUserLeftButtonPressed("Buying or selling?", "buying", "selling");			
			if(buysell){
				this.choice = GUI.getUserSelection("Who do you want to buy from?", names);

				if (choice != "Fortryd"){

					int theChosenOneBuy = 0;
					for (int z = 0; z<pC.getPlayers().length; z++){
						if(choice == pC.getPlayers()[z].getName()){
							theChosenOneBuy = z;
						}
					}

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
					fieldsBuy[lenghtOfOwnedFieldsArray] = "Fortryd";					

					this.choice = GUI.getUserSelection("Which property do you wish to purchase", fieldsBuy);

					if (choice != "Fortryd"){

						int fieldPurchase = 0;
						for (int p = 0; p<=39; p++){
							if(choice == fC.getName(p)){
								fieldPurchase = p;
							}
						}

						int buyersPrice = GUI.getUserInteger("What would you pay for it?");
						boolean yesno = GUI.getUserLeftButtonPressed("Do "+pC.getPlayers()[theChosenOneBuy].getName()+" want to sell "+fC.getName(fieldPurchase)+ " for the price of "+buyersPrice  , "Yes", "No");
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
				String[] fieldsSell;
				int lenghtOfOwnedFieldsArray = 0;
				for (int l=0; l<39; l++){
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
				fieldsSell[lenghtOfOwnedFieldsArray] = "Fortryd";

				this.choice = GUI.getUserSelection("What do you want to sell?", fieldsSell);	

				if (choice != "Fortryd"){
					int fieldSell = 0;
					for (int p = 0; p<=39; p++){
						if(choice == fC.getName(p)){
							fieldSell = p;
						}
					}
					this.choice = GUI.getUserSelection("Who do you want to sell to?", names);

					if (choice != "Fortryd"){
						int theChosenOneSell = 0;
						for (int z = 0; z<pC.getPlayers().length; z++){
							if(choice == pC.getPlayers()[z].getName()){
								theChosenOneSell = z;
							}
						}
						int sellPrice = GUI.getUserInteger("What do you want to sell it for?");
						boolean yesno = GUI.getUserLeftButtonPressed(pC.getPlayers()[theChosenOneSell].getName()+" , do you want to buy "+fC.getName(fieldSell)+" for "+sellPrice, "Yes", "No");
						if (yesno){
							pC.getCurrentPlayer().getAccount().updateBalance(sellPrice);
							pC.getPlayers()[theChosenOneSell].getAccount().updateBalance(-sellPrice);
							GUI.setBalance(pC.getCurrentPlayer().getName(), pC.getCurrentPlayer().getAccount().getBalance());
							GUI.setBalance(pC.getPlayers()[theChosenOneSell].getName(), pC.getPlayers()[theChosenOneSell].getAccount().getBalance());
							fC.setOwner(fieldSell, pC.getPlayers()[theChosenOneSell]);
							currentPlayer.addTerColour(fC.getColour(fieldSell));
							pC.getPlayers()[theChosenOneSell].removeTerColour(fC.getColour(fieldSell));
							GUI.removeOwner(fieldSell+1);
							GUI.setOwner(fieldSell+1, pC.getPlayers()[theChosenOneSell].getName());
						}

					}

				}
			


		}

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
