package Controllers;

import Game.Die;
import Game.GameController;
import Players.PlayerController;
import Fields.FieldController;

import Game.Language;
import desktop_resources.GUI;

public class DiceRollController {
	
	private int playerPosition;
	private int newPosition;
	private int turns = 0;

	public void rollOption(FieldController fC, PlayerController pC, Die die){
			playerPosition = pC.getCurrentPlayer().getPlace();
			die.roll();
			// Creates Dice on GUI
			GameController.dicePlace(Die.getDice1(), Die.getDice2());
			//Extra turn on identical faces // also jail on 3rd identical faces
			if(Die.getDice1()==Die.getDice2()){turns++;}
			if(Die.getDice1()!=Die.getDice2()){turns = 0;}
			if(turns == 1 || turns == 2){GUI.showMessage(Language.getLang("ROLLEDD"));}
			if(turns==3){
				GUI.showMessage(Language.getLang("ROLLEDJ"));
				GameController.movement(pC.getCurrentPlayer().getPlace()+1, 11, pC.getCurrentPlayer());
				pC.getCurrentPlayer().setPlace(10);
				pC.getCurrentPlayer().setJail(true);
				turns = 0;
			}else {
				//Setting position
				newPosition = playerPosition + Die.getDiceSum();
				if(newPosition >= 40){
					newPosition = newPosition-40;
				}
				pC.getCurrentPlayer().setPlace(newPosition);
				//Communicating with GUI
				GameController.movement(playerPosition+1,newPosition+1,pC.getCurrentPlayer());
				GUI.showMessage(Language.getLang("ROLLED") + " " + Die.getDiceSum());
				//Interacting with the field
				if(newPosition != 0){
					fC.landOnField(newPosition, pC, fC);
				}}
			if(turns==0){
				pC.endTurn();
			}
		}
}
