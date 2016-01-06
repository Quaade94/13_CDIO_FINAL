package Fields;

import Players.Player;

public class Territory  extends Ownable{
	
	// Created with the constructor
	
	private int Price;
	private int RentT0;
	private int RentT1;
	private int RentT2;
	private int RentT3;
	private int RentT4;
	private int RentT5;
	private int HousePrice;
	private int PledgingValue;
	private int FieldNumber;
	private String Name;
	
	// Other values
	
	private Player Owner;
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
		Name = NameC;
		
		Owner = null;
		HouseAmount = 0;
		
	}
	
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
	
	
	public int getHousePrice(){
		return HousePrice;
	}
	public int getPledgingValue(){
		return PledgingValue;
	}
	public int getFieldNumber(){
		return FieldNumber;
	}
	public String getName(){
		return Name;
	}
	
	public void setOwner(Player OwnerM){
		Owner = OwnerM;
	}
	public Player getOwner(){
		return Owner;
	}
	public void resetOwner(){
		Owner = null;
	}
	public void setHouseAmount(int HousesM){
		HouseAmount = HousesM;
	}
	

	public int getHouseAmount(){
		return HouseAmount;
	}
	
}
