package Fields;

import Players.Player;

public class Laborcamp extends OwnableWithoutHouses{
	
	// Created with the constructor
	private int Price;
	private int Baserent;
	private int FieldNumber;
	private int PledgingValue;
	private String Name;
	
	// Other values
	
	private Player Owner;
	private boolean AllOwned;
	
	
	public Laborcamp (int PriceC, int BaserentC, int FieldNumberC, int PledgingValue, String NameC){
		
		Price = PriceC;
		Baserent = BaserentC;
		FieldNumber = FieldNumberC;
		
		Name = NameC;
		
		Owner = null;
		AllOwned = false;
		
	}
	
	@Override
	public int getPrice(){
		return Price;
	}

	@Override
	public int getRent(){
		
		int rent = 0;
		
		rent = Baserent;
		
		if (AllOwned){
			rent = Baserent * 2;
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
		return Name;
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