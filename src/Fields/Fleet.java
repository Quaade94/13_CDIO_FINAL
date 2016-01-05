package Fields;

import Players.Player;

public class Fleet {
	
	
	// Created with the constructor
	
	private int Price;
	private int RentT0;
	private int RentT1;
	private int RentT2;
	private int RentT3;
	
	private int FieldNumber;
	
	// Default values
	
	private Player Owner;
	private int AmountOwned;
	
	public Fleet (int PriceC, int RentT0C, int RentT1C, int RentT2C, int RentT3C, int PledgingValue, int FieldNumberC, String NameC){
		
		Price = PriceC;
		RentT0 = RentT0C;
		RentT1 = RentT1C;
		RentT2 = RentT2C;
		RentT3 = RentT3C;
		
		FieldNumber = FieldNumberC;
		
		Owner = null;
		AmountOwned = 0;
		
	}
	
	public void setOwner(Player OwnerM){
		Owner = OwnerM;
	}
	public void resetOwner(){
		Owner = null;
	}
	public Player getOwner(){
		return Owner;
	}
	
	public int getPrice(){
		return Price;
	}
	
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
		
		return rent;
	}
	
	public int getFieldNumber(){
		return FieldNumber;
	}

}
