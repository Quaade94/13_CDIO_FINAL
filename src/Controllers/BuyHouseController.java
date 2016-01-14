package Controllers;

import Fields.Field;
import Fields.FieldController;
import Game.Die;
import Game.Language;
import desktop_resources.GUI;

import Players.PlayerController;

public class BuyHouseController {

	public void buyHouseOption(FieldController fC, PlayerController pC) {
		//Puts the different colored ownable fields in to an array
		String[] territoryColours = pC.getCurrentPlayer().getTerColour();
		int[] numberTerritories = new int[8];
		for (int i = 0; i<8; i++){
			numberTerritories[i] = 0;
		}

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
				buildables = buildablesArray(buildables, 1, 3, 0, fC);
			}
			if (numberTerritories[7] == 2){
				buildables = buildablesArray(buildables, 37, 39, 0, fC);
			}
			if (numberTerritories[1] == 3){
				buildables = buildablesArray(buildables, 6, 8, 9, fC);
			}
			if (numberTerritories[2] == 3){
				buildables = buildablesArray(buildables, 11, 13, 14, fC);
			}
			if (numberTerritories[3] == 3){
				buildables = buildablesArray(buildables, 16, 18, 19, fC);
			}
			if (numberTerritories[4] == 3){
				buildables = buildablesArray(buildables, 21, 23, 24, fC);
			}
			if (numberTerritories[5] == 3){
				buildables = buildablesArray(buildables, 26, 27, 29, fC);
			}
			if (numberTerritories[6] == 3){
				buildables = buildablesArray(buildables, 31, 32, 34, fC);
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
			if(GUI.getUserLeftButtonPressed(Language.getLang("SURE") + " " + housePrice + ",-", Language.getLang("YES"), Language.getLang("NO"))){
				if (housePrice <= pC.getCurrentPlayer().getAccount().getBalance()){
					if (fC.getHouseAmount(place) < 5){
						pC.getCurrentPlayer().getAccount().updateBalance(-housePrice);
						GUI.setBalance(pC.getCurrentPlayer().getName(), pC.getCurrentPlayer().getAccount().getBalance());
						fC.setHouseAmount(place, fC.getHouseAmount(place)+1);
						if(fC.getHouseAmount(place) == 5){
							GUI.setHotel(place+1, true);
						} else{
							GUI.setHouses(place+1, fC.getHouseAmount(place));
						}
					}else{
						GUI.showMessage(Language.getLang("NOMOREHOUSE"));
					}
				} else {
					GUI.showMessage(Language.getLang("CANTAFFORDHOUSE"));
				}
			}
		} else {
			//If the player doesnt have any buildable territories
			GUI.showMessage(Language.getLang("NOBUILDABLES"));
		}
	}
	
	public void sellHouseOption(FieldController fC, PlayerController pC) {
		
		int amountOfHouses = 0;
		for (int i = 0 ; i < 40; i++){
			if (fC.getOwner(i) == pC.getCurrentPlayer()){
				if (fC.getHouseAmount(i) > 0){
					amountOfHouses++;
				}
			}
		Field[] fieldsWithHousesArray;	
		fieldsWithHousesArray = new Field[amountOfHouses];
			 
			
			
			
			
		}

		
		
		
		
		
		
		
		
	}

	
	public String[] buildablesArray(String[] array, int index1, int index2, int index3, FieldController fC){
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
