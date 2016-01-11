package Fields;

import Game.Language;
import Players.Player;
import Players.PlayerController;
import desktop_resources.GUI;

public class Territory  extends Ownable{

	// Created with the constructor
	private int RentT0;
	private int RentT1;
	private int RentT2;
	private int RentT3;
	private int RentT4;
	private int RentT5;
	
	private int HousePrice;
	
	
	// Other values
	private int HouseAmount;
	
	public Territory (int PriceC, int RentT0C, int RentT1C, int RentT2C, int RentT3C, int RentT4C, int RentT5C, int HousePriceC, int PledgingValueC, int FieldNumberC, String NameC){
		
		Price = PriceC;
		RentT0 = RentT0C;
		RentT1 = RentT1C;
		RentT2 = RentT2C;
		RentT3 = RentT3C;
		RentT4 = RentT4C;
		RentT5 = RentT5C;
		HousePrice = HousePriceC;
		PledgingValue = PledgingValueC;
		FieldNumber = FieldNumberC;
		FieldName = NameC;
		
		Owner = null;
		HouseAmount = 0;
		
	}
	@Override
	public void landOnField(PlayerController playerController, FieldController fieldController) {
		Player currentPlayer = playerController.getNextPlayer();
		int curRent = 0;
		if (Owner == null){
			if (GUI.getUserLeftButtonPressed(""+Language.getLang("CHOOSE"), ""+Language.getLang("YES"), ""+Language.getLang("NO"))){
				if(currentPlayer.getAccount().getBalance() >= Price){
					currentPlayer.getAccount().updateBalance(-Price);
					Owner = currentPlayer;
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
		
		if (getHouseAmount() == 0){
			rent = getRentT0();
		}
		if (getHouseAmount() == 1){
			rent = getRentT1();
		}
		if (getHouseAmount() == 2){
			rent = getRentT2();
		}
		if (getHouseAmount() == 3){
			rent = getRentT3();
		}
		if (getHouseAmount() == 4){
			rent = getRentT4();
		}
		if (getHouseAmount() == 5){
			rent = getRentT5();
		}
		return rent;
	}
	
	// Private rent methods
	
	private int getRentT0(){
		return RentT0;
	}
	private int getRentT1(){
		return RentT1;
	}
	private int getRentT2(){
		return RentT2;
	}
	private int getRentT3(){
		return RentT3;
	}
	private int getRentT4(){
		return RentT4;
	}
	private int getRentT5(){
		return RentT5;
	}
	
	/**
	 *  This method will return the cost of a house for the desired object
	 * @return An integer with the cost of a house
	 */
	public int getHousePrice(){
		return HousePrice;
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
	/**
	 *  This method will set the amount of houses in the object
	 * @param HousesM : The amount of houses that you want to be set in the object
	 */
	public void setHouseAmount(int HousesM){
		HouseAmount = HousesM;
	}
	/**
	 *  This method will return the amount of houses that is in the desired object
	 * @return An integer with the amount of houses in the object
	 */
	public int getHouseAmount(){
		return HouseAmount;
	}
}
