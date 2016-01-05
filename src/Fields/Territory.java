package Fields;

import Players.Player;

public class Territory {
	
	public Territory (int PriceC, int RentT0, int RentT1, int RentT2, int RentT3, int RentT4, int RentT5, int HousePrice, int PledgingValue, int FieldNumberC, String NameC){
		
		Price = PriceC;
		Baserent = RentT0;
		FieldNumber = FieldNumberC;
		
		
	}
	
	// Created with the constructor
	
	private int Price;
	private int Baserent;
	private int FieldNumber;
	
	// Default values
	
	private Player Owner = null;
	private int HouseAmount = 0;
	private boolean Houses = false;
	private boolean Hotel = false;
	private boolean AllOwned = false;
	
	
	public int getPrice(){
		return Price;
	}
	
	
	
	
	
	
	
}
