package Fields;

import Players.Player;
import Players.PlayerController;

public class Territory  extends Ownable{

	// Created with the constructor
	private int RentT0;
	private int RentT1;
	private int RentT2;
	private int RentT3;
	private int RentT4;
	private int RentT5;
	
	private int HousePrice;
	
	private String colour;
	
	private int HouseAmount;
	
	public Territory (int PriceC, int RentT0C, int RentT1C, int RentT2C, int RentT3C, int RentT4C, int RentT5C, int HousePriceC, int FieldNumberC, String colourC, String NameC){
		
		Price = PriceC;
		RentT0 = RentT0C;
		RentT1 = RentT1C;
		RentT2 = RentT2C;
		RentT3 = RentT3C;
		RentT4 = RentT4C;
		RentT5 = RentT5C;
		HousePrice = HousePriceC;
		FieldNumber = FieldNumberC;
		FieldName = NameC;
		
		Owner = null;
		HouseAmount = 0;
		colour = colourC;
		
	}
	
	@Override
	public void landOnField(PlayerController playerController, FieldController fieldController) {
		Player currentPlayer = playerController.getCurrentPlayer();
		int curRent = 0;
		if (Owner == null){
			Owner = oC.territoryNotOwned(Price, currentPlayer, colour, Owner, FieldNumber);
		} else if (Owner != currentPlayer && Owner != null){
			curRent = getRent();
			oC.territoryOwned(currentPlayer, curRent, Owner);
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
	 *  This method will remove a house from the field, and in turn give half of the price of the house to the players account
	 *   But if there are no houses on the field this method will not do anything
	 * @param playerController So the method can update a players balance
	 */
	public void sellHouse(PlayerController playerController){
		if (HouseAmount > 0){
			HouseAmount = HouseAmount - 1;
			Owner.getAccount().updateBalance((HousePrice / 2));
		}	
	}
	
	public void resetHouses(){
		HouseAmount = 0;
	}
	
	/**
	 *  This method will return the amount of houses that is in the desired object
	 * @return An integer with the amount of houses in the object
	 */
	public int getHouseAmount(){
		return HouseAmount;
	}
	
	public String getColour(){
		return colour;
	}
}
