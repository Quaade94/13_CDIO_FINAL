package Fields;

import Game.GameController;
import Fields.FieldController;
import Game.Language;
import Players.Player;
import Players.PlayerController;
import desktop_resources.GUI;

public class TryLuck extends ParkChance {

	private static String card[] = {Language.getLang("CARD1"),Language.getLang("CARD2"),Language.getLang("CARD3"),Language.getLang("CARD4"),Language.getLang("CARD5"),Language.getLang("CARD6"),Language.getLang("CARD7"),Language.getLang("CARD8"),Language.getLang("CARD9"),Language.getLang("CARD10"),Language.getLang("CARD11"),Language.getLang("CARD12"),Language.getLang("CARD13")};

	public TryLuck(int FieldNumberC, String SubC, String DesC){

		FieldNumber = FieldNumberC;

		SubText = SubC;
		Description = DesC;
	}

	@Override
	public int getFieldNumber(){
		return FieldNumber;
	}

	public String getChanceMessage(){	
		return card[((int) (Math.random() * card.length))];
	}

	@Override
	public String getSubText(){
		return SubText;
	}

	@Override
	public String getDescription(){
		return Description;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public void landOnField(PlayerController playerController, FieldController fieldController) {

		Player currentPlayer = playerController.getCurrentPlayer();
		Player allPlayers[] = playerController.getPlayers();

		GUI.displayChanceCard();
		String getCard = getChanceMessage();
		GUI.displayChanceCard(getCard);
		if (getCard == Language.getLang("CARD1")){
			GUI.showMessage(Language.getLang("CARD1"));
			GameController.movement(currentPlayer.getPlace()+1, 1, currentPlayer, fieldController, playerController);
			currentPlayer.setPlace(0);
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD2")){
			GUI.showMessage(Language.getLang("CARD2"));
			currentPlayer.getAccount().updateBalance(-2000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD3")){
			GUI.showMessage(Language.getLang("CARD3"));
			for (int i = 0; i < allPlayers.length; i++){
				if (allPlayers[i] != currentPlayer && allPlayers[i].isPlayerBankrupt() == false){
					allPlayers[i].getAccount().updateBalance(-100);
					currentPlayer.getAccount().updateBalance(100);
					GUI.setBalance(allPlayers[i].getName(), allPlayers[i].getAccount().getBalance());
					GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
				}
			}
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD4")){
			GUI.showMessage(Language.getLang("CARD4"));
			currentPlayer.getAccount().updateBalance(-1000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD5")){
			GUI.showMessage(Language.getLang("CARD5"));
			currentPlayer.getAccount().updateBalance(1000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD6")){
			GUI.showMessage(Language.getLang("CARD6"));
			GameController.movement(currentPlayer.getPlace()+1, 24, currentPlayer, fieldController, playerController);
			currentPlayer.setPlace(23);
			fieldController.landOnField(currentPlayer.getPlace(), playerController, fieldController);
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD7")){
			GUI.showMessage(Language.getLang("CARD7"));
			GameController.movement(currentPlayer.getPlace()+1, 40, currentPlayer, fieldController, playerController);
			currentPlayer.setPlace(39);
			fieldController.landOnField(currentPlayer.getPlace(), playerController, fieldController);
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD8")){
			GUI.showMessage(Language.getLang("CARD8"));
			currentPlayer.setJail(true);
			GameController.movement(currentPlayer.getPlace()+1, 11, currentPlayer, fieldController, playerController);
			currentPlayer.setPlace(10);
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD9")){
			GUI.showMessage(Language.getLang("CARD9"));
			currentPlayer.getAccount().updateBalance(-3000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD10")){
			GUI.showMessage(Language.getLang("CARD10"));
			currentPlayer.getAccount().updateBalance(1000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD11")){
			GUI.showMessage(Language.getLang("CARD11"));
			currentPlayer.getAccount().updateBalance(1000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD12")){
			GUI.showMessage(Language.getLang("CARD12"));
			currentPlayer.getAccount().updateBalance(1000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
			GUI.displayChanceCard();
		} else if (getCard == Language.getLang("CARD13")){
			GUI.showMessage(Language.getLang("CARD13"));
			int goToFleet = 0;
			if(currentPlayer.getPlace()+1 == 37 || currentPlayer.getPlace()+1 == 3 ){
				goToFleet = 6;
			}else if(currentPlayer.getPlace()+1 == 8 ){
				goToFleet = 16;
			}else if(currentPlayer.getPlace()+1 == 18 || currentPlayer.getPlace()+1 == 23 ){
				goToFleet = 26;
			}else if(currentPlayer.getPlace()+1 == 34 ){
				goToFleet = 36;
			}else{
				System.out.println("Something went wrong in Class: TryLuck");
			}
			GameController.movement(currentPlayer.getPlace()+1, goToFleet, currentPlayer, fieldController, playerController);
			currentPlayer.setPlace(goToFleet-1);
			fieldController.landOnField(currentPlayer.getPlace(), playerController, fieldController);
			GUI.displayChanceCard();
		}
	}
}