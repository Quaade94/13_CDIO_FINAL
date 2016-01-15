package Fields;

import Players.Player;

public abstract class Ownable  extends Field{
	
	protected int Price;
	protected OwnableController oC = new OwnableController();
	
	protected Player Owner;
	
	

	/**
	 * This method will return the Rent of the object
	 * @return the Rent of the object
	 */
	public abstract int getRent();
	
	/**
	 * This method will set the Owner of the object
	 * @param Owner The Player that you want to set as Owner of the object
	 */
	public abstract void setOwner(Player Owner);
	
	/**
	 * This method will return the Owner of the object
	 * @return the Owner of the object
	 */
	public abstract Player getOwner();
	
	/**
	 * This method will reset the Owner of the object
	 */
	public abstract void resetOwner();
	
	/**
	 * This method will return the Price of the object
	 * @return the Price of the object
	 */
	public abstract int getPrice();
	
	
}
