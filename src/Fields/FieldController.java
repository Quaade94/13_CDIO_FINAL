package Fields;

import Players.Player;

public class FieldController {
	
	static Field[] fields;
	public static void initializeFieldCreator(){
		fields = Creator.createFields();
	}
	

//	Commen
	
	public static int getFieldNumber(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Field){
			rent = ((Field) fields[fieldIndex]).getFieldNumber();
		}
		return rent;	
	}
	
	public static void landOnField(int fieldIndex){
		if (fields[fieldIndex] instanceof Field){
			((Field) fields[fieldIndex]).landOnField();
		}
	}
	
//	Nearly Commen
	
	public static String getName(int fieldIndex){
		String name = null;
		if (fields[fieldIndex] instanceof Ownable){
			name = ((Ownable) fields[fieldIndex]).getName();
		}
		if (fields[fieldIndex] instanceof NonOwnable){
			name = ((NonOwnable) fields[fieldIndex]).getName();
		}
		return name;	
	}
	
	
//	Price / Rent / PledgingValue
	
	
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
	public static int getPledgingValue(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getPledgingValue();
		}
		return rent;	
	}
	
	
//	Owners
	
	
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
	
	
//	Houses
	
	
	public static void setHouseAmount(int fieldIndex, int AmountOfHouses){
		if (fields[fieldIndex] instanceof WithHouses){
			((WithHouses) fields[fieldIndex]).setHouseAmount(AmountOfHouses);
		}
	}
	public static int getHouseAmount(int fieldIndex){
		int AmountOfHouses = -1;
		if (fields[fieldIndex] instanceof WithHouses){
			AmountOfHouses = ((WithHouses) fields[fieldIndex]).getHouseAmount();
		}
		return AmountOfHouses;	
	}
	public static int getHousePrice(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof WithHouses){
			rent = ((WithHouses) fields[fieldIndex]).getHousePrice();
		}
		return rent;	
	}
	
	
	//  ChanceCards

	
	public static String getChanceMessage(int fieldIndex){
		String Message = null;
		if (fields[fieldIndex] instanceof TryLuck){
			Message = ((TryLuck) fields[fieldIndex]).getChanceMessage();
		}
		return Message;
	}
	public static String getSubText(int fieldIndex){
		String SubText = null;
		
		if (fields[fieldIndex] instanceof TryLuck){
			SubText = ((TryLuck) fields[fieldIndex]).getSubText();
		}
		return SubText;
	}
	public static String getDesText(int fieldIndex){
		String DesText = null;
		if (fields[fieldIndex] instanceof TryLuck){
			DesText = ((TryLuck) fields[fieldIndex]).getDesText();
		}
		return DesText;
	}
	
	
//	Start
	
	
	public static int getStartMoney(int fieldIndex){
		int StartMoney = -1;
		if (fields[fieldIndex] instanceof Start){
			StartMoney = ((Start) fields[fieldIndex]).getStartMoney();
		}
		return StartMoney;
	}
	

	
}