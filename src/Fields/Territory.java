package Fields;

import Players.Player;

public class Territory {
	
	public Territory (int PriceC, int BaserentC, int FieldNumberC, String NameC){
		
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
	private int HouseAmount = 0;
	private boolean Houses = false;
	private boolean Hotel = false;
	private boolean AllOwned = false;
	
	
	public int getPrice(){
		return 100;
	}
	
	
	
	
	
	
	
}
