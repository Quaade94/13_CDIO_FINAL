package Fields;

import Players.Player;

public class Fleet {
	
	public Fleet (int PriceC, int rentT0, int rentT1, int rentT2, int rentT3, int PledgingValue, int FieldNumberC, String NameC){
		
		Price = PriceC;
		FieldNumber = FieldNumberC;
		
		
	}
	
	// Created with the constructor
	
	private int Price;
	private int Baserent;
	private int FieldNumber;
	
	// Default values
	
	private Player Owner = null;
	private int AmountOwned;
	
	
	
	
	
	
	

}
