package Fields;

import Players.Player;

public abstract class Ownable  extends Field{

	public abstract int getRent();
	public abstract int getHousePrice();
	public abstract int getPledgingValue();
	public abstract int getFieldNumber();
	public abstract String getName();
	public abstract void setOwner(Player Owner);
	public abstract Player getOwner();
	public abstract void resetOwner();
	public abstract void setHouseAmount(int HousesM);
	public abstract int getHouseAmount();
	public abstract int getPrice();
	
}
