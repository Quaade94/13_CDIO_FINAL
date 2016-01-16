package Controllers;

import Players.PlayerController;
import desktop_resources.GUI;
import Fields.FieldController;
import Game.Language;

public class PropertyController {

	public void buysellOption(FieldController fC, PlayerController pC){
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
			String playerChoice = GUI.getUserSelection(Language.getLang("WHOBUY"), names);

			if (playerChoice != Language.getLang("CANCEL")){
				int theChosenOneBuy = 0;
				for (int z = 0; z<pC.getPlayers().length; z++){
					if(playerChoice == pC.getPlayers()[z].getName()){
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
				playerChoice = GUI.getUserSelection(Language.getLang("WHICHBUY"), fieldsBuy);
				if (playerChoice != Language.getLang("CANCEL")){

					int fieldBuy = 0;
					for (int p = 0; p<=39; p++){
						if(playerChoice == fC.getName(p)){
							fieldBuy = p;
						}
					}

					if(fC.getHouseAmount(fieldBuy) > 0){
						GUI.showMessage(Language.getLang("CANTBUYWITHHOUSES"));
					}else{

						//Asks the player what he wants to buy it for
						int buyersPrice = GUI.getUserInteger(Language.getLang("WHATBUYPRICE"));
						//Checks if the player can afford it
						if(pC.getCurrentPlayer().getAccount().getBalance() >= buyersPrice){

							//Asks the chosen owner of the property if he wants sell his property
							boolean yesno = GUI.getUserLeftButtonPressed(String.format(Language.getLang("DOWANTSELL"),pC.getPlayers()[theChosenOneBuy].getName(),fC.getName(fieldBuy),buyersPrice), Language.getLang("YES"), Language.getLang("NO"));
							if(yesno){
								pC.getCurrentPlayer().getAccount().updateBalance(-buyersPrice);
								pC.getPlayers()[theChosenOneBuy].getAccount().updateBalance(buyersPrice);
								GUI.setBalance(pC.getCurrentPlayer().getName(), pC.getCurrentPlayer().getAccount().getBalance());
								GUI.setBalance(pC.getPlayers()[theChosenOneBuy].getName(), pC.getPlayers()[theChosenOneBuy].getAccount().getBalance());
								fC.setOwner(fieldBuy, pC.getCurrentPlayer());
								//Updates the both parties fleetOwned
								if (fC.getField(fieldBuy) == "Fleet"){
									pC.getCurrentPlayer().updateFleetOwned();
									pC.getPlayers()[theChosenOneBuy].reduceFleetOwned();
									//Updates the both parties territoryOwned
								} else if (fC.getField(fieldBuy) == "Territory"){
									pC.getCurrentPlayer().addTerColour(fC.getColour(fieldBuy));
									pC.getPlayers()[theChosenOneBuy].removeTerColour(fC.getColour(fieldBuy));
									//Updates the both parties laborcampOwned
								} else if (fC.getField(fieldBuy) == "Laborcamp"){
									pC.getCurrentPlayer().updateLaborOwned();
									pC.getPlayers()[theChosenOneBuy].reduceLaborOwned();
								}
								GUI.removeOwner(fieldBuy+1);
								GUI.setOwner(fieldBuy+1, pC.getCurrentPlayer().getName());
							}
						}else{
							GUI.getUserButtonPressed(Language.getLang("CANTAFFORD"), Language.getLang("OK"));
						}
					}
				}
			}

		}else{
			//Creates an array of the players sellable fields and checks if there's houses on them
			String[] fieldsSell;
			int lenghtOfOwnedFieldsArray = 0;
			for (int l = 0 ; l < 40 ; l++){
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
			//Ads a go back option
			fieldsSell[lenghtOfOwnedFieldsArray] = Language.getLang("CANCEL");

			//Asks the player which field he wants to sell 
			String playerChoice = GUI.getUserSelection(Language.getLang("WHICHSELL"), fieldsSell);	
			if (playerChoice != Language.getLang("CANCEL")){
				int fieldSell = 0;
				for (int p = 0; p<=39; p++){
					if(playerChoice == fC.getName(p)){
						fieldSell = p;
					}
				}
				if(fC.getHouseAmount(fieldSell) > 0){
					GUI.showMessage(Language.getLang("CANTSELLWITHHOUSES"));

				}else{
					//Asks the player who he wants to sell his property to
					playerChoice = GUI.getUserSelection(Language.getLang("WHOSELL"), names);
					if (playerChoice != Language.getLang("CANCEL")){
						int theChosenOneSell = 0;
						for (int z = 0; z<pC.getPlayers().length; z++){
							if(playerChoice == pC.getPlayers()[z].getName()){
								theChosenOneSell = z;
							}
						}

						//Asks the player what amount he wants to sell his property for
						int sellPrice = GUI.getUserInteger(Language.getLang("WHATSELLPRICE"));
						//Checks if the chosen one can afford it
						if (pC.getPlayers()[theChosenOneSell].getAccount().getBalance() >= sellPrice){
							//Asks if the chosen one wants to buy it
							boolean yesno = GUI.getUserLeftButtonPressed(String.format(Language.getLang("DOWANTBUY"), pC.getPlayers()[theChosenOneSell].getName(),fC.getName(fieldSell),sellPrice),Language.getLang("YES"), Language.getLang("NO"));
							if (yesno){
								pC.getCurrentPlayer().getAccount().updateBalance(sellPrice);
								pC.getPlayers()[theChosenOneSell].getAccount().updateBalance(-sellPrice);
								GUI.setBalance(pC.getCurrentPlayer().getName(), pC.getCurrentPlayer().getAccount().getBalance());
								GUI.setBalance(pC.getPlayers()[theChosenOneSell].getName(), pC.getPlayers()[theChosenOneSell].getAccount().getBalance());
								fC.setOwner(fieldSell, pC.getPlayers()[theChosenOneSell]);
								//Updates the both parties fleetOwned
								if (fC.getField(fieldSell) == "Fleet"){
									pC.getPlayers()[theChosenOneSell].updateFleetOwned();
									pC.getCurrentPlayer().reduceFleetOwned();
									//Updates the both parties territoryOwned
								} else if (fC.getField(fieldSell) == "Territory"){
									pC.getPlayers()[theChosenOneSell].addTerColour(fC.getColour(fieldSell));
									pC.getCurrentPlayer().removeTerColour(fC.getColour(fieldSell));
									//Updates the both parties laborcampOwned
								} else if (fC.getField(fieldSell) == "Laborcamp"){
									pC.getPlayers()[theChosenOneSell].updateLaborOwned();
									pC.getCurrentPlayer().reduceLaborOwned();
								}
								GUI.removeOwner(fieldSell+1);
								GUI.setOwner(fieldSell+1, pC.getPlayers()[theChosenOneSell].getName());
							}
						}else{
							GUI.getUserButtonPressed(Language.getLang("CANTAFFORDOFFER"), Language.getLang("OK"));
						}
					}
				}
			}
		}
	}
}
