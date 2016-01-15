package Fields;

import Game.Die;
import Players.Player;
import Players.PlayerController;

public class Laborcamp extends Ownable{

	private int Baserent;

	public Laborcamp (int PriceC, int BaserentC, int FieldNumberC, String NameC){

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
			Owner = oC.laborCampNotOwned(currentPlayer, Price, Owner, FieldNumber);
		} else if (Owner != currentPlayer && Owner != null){
			curRent = getRent();
			oC.laborCampOwned(currentPlayer, Owner, curRent);
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