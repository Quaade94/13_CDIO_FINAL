package Fields;

import Players.Player;
import Players.PlayerController;

public class FieldController {
	
	private Field[] fields;
	
	public FieldController(){
		initializeFieldCreator();
	}
	public void initializeFieldCreator(){
		Creator factory = new Creator();
		fields = factory.createFields();
	}
	

//	Comments
	
	public int getFieldNumber(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Field){
			rent = ((Field) fields[fieldIndex]).getFieldNumber();
		}
		return rent;	
	}
	
	public void landOnField(int fieldIndex, PlayerController playerController){
		if (fields[fieldIndex] instanceof Field){
			((Field) fields[fieldIndex]).landOnField(playerController);
		}
	}
	
//	Nearly Commen
	
	public String getName(int fieldIndex){
		String name = null;
		if (fields[fieldIndex] instanceof Field){
			name = ((Field) fields[fieldIndex]).getName();
		}
		return name;	
	}
	
	
//	Price / Rent / PledgingValue
	
	
	public   int getPrice(int fieldIndex){
		int price = -1;
		if (fields[fieldIndex] instanceof Ownable){
			price = ((Ownable) fields[fieldIndex]).getPrice();
		}
		return price;	
	}
	public   int getRent(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getRent();
		}
		return rent;	
	}
	public   int getPledgingValue(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getPledgingValue();
		}
		return rent;	
	}
	
	
//	Owners
	
	
	public   void setOwner(int fieldIndex, Player Owner){
		if (fields[fieldIndex] instanceof Ownable){
			((Ownable) fields[fieldIndex]).setOwner(Owner);
		}
	}
	public   Player getOwner(int fieldIndex){
		Player Owner = null;
		if (fields[fieldIndex] instanceof Ownable){
			Owner = ((Ownable) fields[fieldIndex]).getOwner();
		}
		return Owner;	
	}
	public   void resetOwner(int fieldIndex){
		if (fields[fieldIndex] instanceof Ownable){
			((Ownable) fields[fieldIndex]).resetOwner();
		}
	}
	
	
//	Houses
	
	
	public   void setHouseAmount(int fieldIndex, int AmountOfHouses){
		if (fields[fieldIndex] instanceof Territory){
			((Territory) fields[fieldIndex]).setHouseAmount(AmountOfHouses);
		}
	}
	public   int getHouseAmount(int fieldIndex){
		int AmountOfHouses = -1;
		if (fields[fieldIndex] instanceof Territory){
			AmountOfHouses = ((Territory) fields[fieldIndex]).getHouseAmount();
		}
		return AmountOfHouses;	
	}
	public   int getHousePrice(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Territory){
			rent = ((Territory) fields[fieldIndex]).getHousePrice();
		}
		return rent;	
	}
	
	
	//  ChanceCards / Jails

	
	public   String getChanceMessage(int fieldIndex){
		String Message = null;
		if (fields[fieldIndex] instanceof TryLuck){
			Message = ((TryLuck) fields[fieldIndex]).getChanceMessage();
		}
		return Message;
	}
	public   String getSubText(int fieldIndex){
		String SubText = null;
		if (fields[fieldIndex] instanceof NonOwnable){
			SubText = ((NonOwnable) fields[fieldIndex]).getSubText();
		}
		if (fields[fieldIndex] instanceof Jail){
			SubText = ((Jail) fields[fieldIndex]).getSubText();
		}
		return SubText;
	}
	public   String getDesText(int fieldIndex){
		String DesText = null;
		if (fields[fieldIndex] instanceof ParkChance){
			DesText = ((ParkChance) fields[fieldIndex]).getDescription();
		}
		return DesText;
	}
	
	
	
//	Start
	
	
	public   int getStartMoney(int fieldIndex){
		int StartMoney = -1;
		if (fields[fieldIndex] instanceof Start){
			StartMoney = ((Start) fields[fieldIndex]).getStartMoney();
		}
		return StartMoney;
	}
	
	
//	Tax
	
	
	public   int pay(int fieldIndex){
		int Tax = -1;
		if (fields[fieldIndex] instanceof Tax){
			Tax = ((Tax) fields[fieldIndex]).payTax();
		}
		return Tax;
	}
	
	
	
	
	
	
	
	
	

	
}