package Fields;

import Players.Player;

public class FieldController {
	
	static Field[] fields;
	public static void initializeFieldCreator(){
		fields = Creator.createFields();
	}
	
	public static int getPrice(int fieldIndex){
		int price = -1;
		if (fields[fieldIndex] instanceof Ownable){
			price = ((Ownable) fields[fieldIndex]).getPrice();
		}
		return price;	
	}
	public static int getRent(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getRent();
		}
		return rent;	
	}
	public static int getHousePrice(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((WithHouses) fields[fieldIndex]).getHousePrice();
		}
		return rent;	
	}
	public static int getPledgingValue(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getPledgingValue();
		}
		return rent;	
	}
	public static int getFieldNumber(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getFieldNumber();
		}
		return rent;	
	}
	public static String getName(int fieldIndex){
		String name = null;
		if (fields[fieldIndex] instanceof Ownable){
			name = ((Ownable) fields[fieldIndex]).getName();
		}
		return name;	
	}
	public static void setOwner(int fieldIndex, Player Owner){
		if (fields[fieldIndex] instanceof Ownable){
			((Ownable) fields[fieldIndex]).setOwner(Owner);
		}
	}
	public static Player getOwner(int fieldIndex){
		Player Owner = null;
		if (fields[fieldIndex] instanceof Ownable){
			Owner = ((Ownable) fields[fieldIndex]).getOwner();
		}
		return Owner;	
	}
	public static void resetOwner(int fieldIndex){
		if (fields[fieldIndex] instanceof Ownable){
			((Ownable) fields[fieldIndex]).resetOwner();
		}
	}
	public static void setHouseAmount(int fieldIndex, int AmountOfHouses){
		if (fields[fieldIndex] instanceof Ownable){
			((WithHouses) fields[fieldIndex]).setHouseAmount(AmountOfHouses);
		}
	}
	public static int getHouseAmount(int fieldIndex){
		int AmountOfHouses = -1;
		if (fields[fieldIndex] instanceof Ownable){
			AmountOfHouses = ((WithHouses) fields[fieldIndex]).getHouseAmount();
		}
		return AmountOfHouses;	
	}
}