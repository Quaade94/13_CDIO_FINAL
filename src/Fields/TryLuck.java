package Fields;

import Game.GameController;
import Fields.FieldController;
import Game.Language;
import Players.Player;
import Players.PlayerController;
import desktop_resources.GUI;

public class TryLuck extends ParkChance {
	
	
	private static String card[] = {Language.getLang("CARD1"),Language.getLang("CARD2"),Language.getLang("CARD3"),Language.getLang("CARD4"),Language.getLang("CARD5"),Language.getLang("CARD6"),Language.getLang("CARD7"),Language.getLang("CARD8")};

	// Messages
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void landOnField(PlayerController playerController, FieldController fieldController) {
		
		Player currentPlayer = playerController.getNextPlayer();
		Player allPlayers[] = playerController.getPlayers();
		
		
		
		GUI.displayChanceCard();
		String getCard = getChanceMessage();
		GUI.displayChanceCard(getCard);
		if (getCard == Language.getLang("CARD1")){
			GameController.movement(currentPlayer.getPlace()+1, 1, currentPlayer.getName());
			currentPlayer.setPlace(0);
			
			

		
		} else if (getCard == Language.getLang("CARD2")){
			currentPlayer.getAccount().updateBalance(-1000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
		} else if (getCard == Language.getLang("CARD3")){
			for (int i = 0; i < allPlayers.length; i++){
				if (allPlayers[i] != currentPlayer){
					allPlayers[i].getAccount().updateBalance(-100);
					currentPlayer.getAccount().updateBalance(100);
					GUI.setBalance(allPlayers[i].getName(), allPlayers[i].getAccount().getBalance());
					GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
				}
			}
		} else if (getCard == Language.getLang("CARD4")){
			currentPlayer.getAccount().updateBalance(-500);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
		} else if (getCard == Language.getLang("CARD5")){
			currentPlayer.getAccount().updateBalance(1000);
			GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
		} else if (getCard == Language.getLang("CARD6")){
			GameController.movement(currentPlayer.getPlace()+1, 24, currentPlayer.getName());
			currentPlayer.setPlace(23);
			fieldController.landOnField(currentPlayer.getPlace(), playerController, fieldController);
		} else if (getCard == Language.getLang("CARD7")){
			GameController.movement(currentPlayer.getPlace()+1, 40, currentPlayer.getName());
			currentPlayer.setPlace(39);
			fieldController.landOnField(currentPlayer.getPlace(), playerController, fieldController);
		} else if (getCard == Language.getLang("CARD8")){
			GameController.movement(currentPlayer.getPlace()+1, 11, currentPlayer.getName());
			currentPlayer.setPlace(10);
			currentPlayer.setJail(true);
		}
	}
	
}
