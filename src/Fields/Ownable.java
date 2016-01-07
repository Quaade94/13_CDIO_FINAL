package Fields;

import Players.Player;

public abstract class Ownable  extends Field{
	
	
	// Created when the constructor is called
	
	protected int Price;
	protected int PledgingValue;
	protected int FieldNumber;
	protected String Name;
	
	// Set later
	
	protected Player Owner;
	
	

	/**
	 * This method will return the Rent of the object
	 * @return the Rent of the object
	 */
	public abstract int getRent();
	
	/**
	 * This method will return the Pledging Value of the object
	 * @return the Pledging Value of the object
	 */
	public abstract int getPledgingValue();
	
	/**
	 * This method will return the Field Number of the object
	 * @return the Field Number of the object
	 */
	public abstract int getFieldNumber();
	
	/**
	 * This method will return the Name of the object
	 * @return the Name of the object
	 */
	public abstract String getName();
	
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
