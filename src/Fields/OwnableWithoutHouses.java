package Fields;

import Players.Player;

public abstract class OwnableWithoutHouses extends Field {
	
	public abstract int getRent();
	public abstract int getPledgingValue();
	public abstract int getFieldNumber();
	public abstract String getName();
	public abstract void setOwner(Player Owner);
	public abstract Player getOwner();
	public abstract void resetOwner();
	
}
