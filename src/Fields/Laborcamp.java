package Fields;

import Game.Die;
import Game.Language;
import Players.Player;
import Players.PlayerController;
import desktop_resources.GUI;

public class Laborcamp extends Ownable{
	
	// Created with the constructor
	private int Baserent;
	
	// Other values
	
	
	public Laborcamp (int PriceC, int BaserentC, int FieldNumberC, int PledgingValue, String NameC){
		
		Price = PriceC;
		Baserent = BaserentC;
		FieldNumber = FieldNumberC;
		
		FieldName = NameC;
		
		Owner = null;
		
	}
	@Override
	public void landOnField(PlayerController playerController, FieldController fieldController) {
		Player currentPlayer = playerController.getCurrentPlayer();
		int curRent = 0;
		if (Owner == null){
			if (GUI.getUserLeftButtonPressed(""+Language.getLang("CHOOSE"), ""+Language.getLang("YES"), ""+Language.getLang("NO"))){
				if(currentPlayer.getAccount().getBalance() >= Price){
					currentPlayer.getAccount().updateBalance(-Price);
					Owner = currentPlayer;
					currentPlayer.updateLaborOwned();
					GUI.setOwner(FieldNumber, currentPlayer.getName());
					GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());

				}// else{
//					if (GUI.getUserLeftButtonPressed("You can't afford. Want to pledge?", "YES", "NO")){
//					}
//				}
			}
		} else if (Owner != currentPlayer && Owner != null){
			curRent = getRent();
			if (currentPlayer.getAccount().getBalance() >= curRent){
				currentPlayer.getAccount().updateBalance(-curRent);
				Owner.getAccount().updateBalance(curRent);
				GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
				GUI.setBalance(Owner.getName(), Owner.getAccount().getBalance());
			} else{
				Owner.getAccount().updateBalance(currentPlayer.getAccount().getBalance());
				currentPlayer.getAccount().updateBalance(-currentPlayer.getAccount().getBalance());
				GUI.setBalance(currentPlayer.getName(), currentPlayer.getAccount().getBalance());
				GUI.setBalance(Owner.getName(), Owner.getAccount().getBalance());
			}
		}
	}
	
	@Override
	public int getPrice(){
		return Price;
	}

	@Override
	public int getRent(){
		
		int rent = 0;
		
		rent = Die.getDiceSum() * Baserent;

		if (Owner.getLaborOwned() == 2){
			rent = rent * 2;
		}
		return rent;
	}
	
	@Override
	public int getPledgingValue(){
		return PledgingValue;
	}
	@Override
	public int getFieldNumber(){
		return FieldNumber;
	}
	@Override
	public String getName(){
		return FieldName;
	}
	@Override
	public void setOwner(Player OwnerM){
		Owner = OwnerM;
	}
	@Override
	public Player getOwner(){
		return Owner;
	}
	@Override
	public void resetOwner(){
		Owner = null;
	}

}