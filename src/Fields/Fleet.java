package Fields;

import Players.Player;

public class Fleet {
	
	public Fleet (int PriceC, int BaserentC, int FieldNumberC, String NameC){
		
		Price = PriceC;
		Baserent = BaserentC;
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
