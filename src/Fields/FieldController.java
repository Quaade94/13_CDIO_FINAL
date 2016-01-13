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
	
	public void landOnField(int PlayerPosition, PlayerController playerController, FieldController fieldController){
		if (fields[PlayerPosition] instanceof Field){
			((Field) fields[PlayerPosition]).landOnField(playerController, fieldController);
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
	
	
	public int getPrice(int fieldIndex){
		int price = -1;
		if (fields[fieldIndex] instanceof Ownable){
			price = ((Ownable) fields[fieldIndex]).getPrice();
		}
		return price;	
	}
	public int getRent(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Ownable){
			rent = ((Ownable) fields[fieldIndex]).getRent();
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
	
	
//	Owners
	
	
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
	
	
//	Houses
	
	
	public void setHouseAmount(int fieldIndex, int AmountOfHouses){
		if (fields[fieldIndex] instanceof Territory){
			((Territory) fields[fieldIndex]).setHouseAmount(AmountOfHouses);
		}
	}
	public int getHouseAmount(int fieldIndex){
		int AmountOfHouses = -1;
		if (fields[fieldIndex] instanceof Territory){
			AmountOfHouses = ((Territory) fields[fieldIndex]).getHouseAmount();
		}
		return AmountOfHouses;	
	}
	public int getHousePrice(int fieldIndex){
		int rent = -1;
		if (fields[fieldIndex] instanceof Territory){
			rent = ((Territory) fields[fieldIndex]).getHousePrice();
		}
		return rent;	
	}
	
	/**
	 *  This method will remove all houses from a field objekt, with no safety precautions, so these will need to be implementet around this method 
	 * @param fieldIndex
	 */
	public void resetHouses(int fieldIndex){
		if (fields[fieldIndex] instanceof Territory){
			((Territory) fields[fieldIndex]).resetHouses();
		}
	}
	
	/**
	 *  This method will remove a house from the field, and in turn give half of the price of the house to the players account
	 *   But if there are no houses on the field this method will not do anything
	 * @param playerController So the method can update a players balance
	 * @param fieldIndex The numberd field that the method will be sent to
	 */
	public void sellHouse(PlayerController playerController, int fieldIndex){
		
		if (fields[fieldIndex] instanceof Territory){
			((Territory) fields[fieldIndex]).sellHouse(playerController);
		}
		
	}
	
	//  ChanceCards / Jails

	
	public String getChanceMessage(int fieldIndex){
		String Message = null;
		if (fields[fieldIndex] instanceof TryLuck){
			Message = ((TryLuck) fields[fieldIndex]).getChanceMessage();
		}
		return Message;
	}
	public String getSubText(int fieldIndex){
		String SubText = null;
		if (fields[fieldIndex] instanceof NonOwnable){
			SubText = ((NonOwnable) fields[fieldIndex]).getSubText();
		}
		if (fields[fieldIndex] instanceof Jail){
			SubText = ((Jail) fields[fieldIndex]).getSubText();
		}
		return SubText;
	}
	public String getDesText(int fieldIndex){
		String DesText = null;
		if (fields[fieldIndex] instanceof ParkChance){
			DesText = ((ParkChance) fields[fieldIndex]).getDescription();
		}
		return DesText;
	}
	public void setLuckFleetBonus(int fieldIndex, boolean doublefleet){
		if (fields[fieldIndex] instanceof Fleet){
			((Fleet) fields[fieldIndex]).setLuckFleetBonus(doublefleet);	
		}
	}

	
	
	
//	Start
	
	
	public int getStartMoney(int fieldIndex){
		int StartMoney = -1;
		if (fields[fieldIndex] instanceof Start){
			StartMoney = ((Start) fields[fieldIndex]).getStartMoney();
		}
		return StartMoney;
	}
	
	
//	Tax
	
	
	public int pay(int fieldIndex){
		int Tax = -1;
		if (fields[fieldIndex] instanceof Tax){
			Tax = ((Tax) fields[fieldIndex]).payTax();
		}
		return Tax;
	}
	
	
	//Territory colour
	
	public String getColour(int fieldIndex){
		String colour = "";
		if (fields[fieldIndex] instanceof Territory){
			colour = ((Territory) fields[fieldIndex]).getColour();
		}
		return colour;
	}
	
	
	
	

	
}