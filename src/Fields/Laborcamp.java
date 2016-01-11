package Fields;

import Game.Die;
import Players.Player;
import Players.PlayerController;
import desktop_resources.GUI;

public class Laborcamp extends Ownable{
	
	// Created with the constructor
	private int Baserent;
	
	// Other values

	private boolean AllOwned;
	
	
	public Laborcamp (int PriceC, int BaserentC, int FieldNumberC, int PledgingValue, String NameC){
		
		Price = PriceC;
		Baserent = BaserentC;
		FieldNumber = FieldNumberC;
		
		FieldName = NameC;
		
		Owner = null;
		AllOwned = false;
		
	}
	@Override
	public void landOnField(PlayerController playerController, FieldController fieldController) {
		Player currentPlayer = playerController.getNextPlayer();
		int curRent = 0;
		if (Owner == null){
			if (GUI.getUserLeftButtonPressed("Want to buy?", "YES", "NO")){
				if(currentPlayer.getAccount().getBalance() >= Price){
					currentPlayer.getAccount().updateBalance(-Price);
					Owner = currentPlayer;
					currentPlayer.updateLaborOwned();
					if(currentPlayer.getLaborOwned() == 2){
						AllOwned = true;
					}
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
		
		if (AllOwned){
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