package Fields;

import Players.Player;

public class FieldController {
	
	Field[] fields;
	public void initializeFieldCreator(){
		fields = Creator.createFields();
	}
	
	public int getRent(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getRent();
		}
		return rent;	
	}
	public int getHousePrice(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getHousePrice();
		}
		return rent;	
	}
	public int getPledgingValue(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getPledgingValue();
		}
		return rent;	
	}
	public int getFieldNumber(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getFieldNumber();
		}
		return rent;	
	}
	public String getName(int fieldIndex){
		String name = null;
		if (fields[fieldIndex] instanceof Ownable){
			name = ((Ownable) fields[fieldIndex]).getName();
		}
		return name;	
	}
	public void setOwner(int fieldIndex, Player Owner){
		if (fields[fieldIndex] instanceof Ownable){
			((Ownable) fields[fieldIndex]).setOwner(Owner);
		}
	}
	public Player getOwner(int fieldIndex){
		Player Owner = null;
		if (fields[fieldIndex] instanceof Ownable){
			Owner = ((Ownable) fields[fieldIndex]).getOwner();
		}
		return Owner;	
	}
	public void resetOwner(int fieldIndex){
		if (fields[fieldIndex] instanceof Ownable){
			((Ownable) fields[fieldIndex]).resetOwner();
		}
	}
	public void setHouseAmount(int fieldIndex, int AmountOfHouses){
		if (fields[fieldIndex] instanceof Ownable){
			((Ownable) fields[fieldIndex]).setHouseAmount(AmountOfHouses);
		}
	}
	public int getHouseAmount(int fieldIndex){
		int AmountOfHouses = -1;
		if (fields[fieldIndex] instanceof Ownable){
			AmountOfHouses = ((Ownable) fields[fieldIndex]).getHouseAmount();
		}
		return AmountOfHouses;	
	}
}