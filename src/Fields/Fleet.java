package Fields;

import Game.Language;
import Players.Player;
import Players.PlayerController;
import desktop_resources.GUI;

public class Fleet extends Ownable{
	
	
	// Created with the constructor
	

	private int RentT0;
	private int RentT1;
	private int RentT2;
	private int RentT3;
	private boolean LuckDoubleFleet = false;
	
	
	// Other values
	
	private int AmountOwned;
	
	public Fleet (int PriceC, int RentT0C, int RentT1C, int RentT2C, int RentT3C, int PledgingValueC, int FieldNumberC, String NameC){
		
		Price = PriceC;
		RentT0 = RentT0C;
		RentT1 = RentT1C;
		RentT2 = RentT2C;
		RentT3 = RentT3C;
		
		PledgingValue = PledgingValueC;
		FieldNumber = FieldNumberC;
		
		FieldName = NameC;
		
		Owner = null;
		AmountOwned = 0;
		
		
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
					currentPlayer.updateFleetOwned();
					AmountOwned = currentPlayer.getFleetOwned();
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
	public void setOwner(Player OwnerM){
		Owner = OwnerM;
	}
	@Override
	public void resetOwner(){
		Owner = null;
	}
	@Override
	public Player getOwner(){
		return Owner;
	}
	@Override
	public int getPrice(){
		return Price;
	}
	@Override
	public int getRent(){
		
		int rent = 0;
		
		if (AmountOwned == 1){
			rent = RentT0;
		}
		if (AmountOwned == 2){
			rent = RentT1;
		}
		if (AmountOwned == 3){
			rent = RentT2;
		}
		if (AmountOwned == 4){
			rent = RentT3;
		}
		if (LuckDoubleFleet){
			rent = rent*2;
		}
		LuckDoubleFleet = false;
		
		return rent;
	}
	
	@Override
	public int getFieldNumber(){
		return FieldNumber;
	}
	@Override
	public int getPledgingValue() {
		return PledgingValue;
	}
	@Override
	public String getName() {
		return FieldName;
	}
	public void setLuckFleetBonus(boolean doublefleet){
		
		LuckDoubleFleet = doublefleet;
	}


}