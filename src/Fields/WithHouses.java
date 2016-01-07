package Fields;

public abstract class WithHouses  extends Ownable{

	// Created with the constructor
	protected int RentT0;
	protected int RentT1;
	protected int RentT2;
	protected int RentT3;
	protected int RentT4;
	protected int RentT5;
	
	protected int HousePrice;
	
	
	// Other values
	protected int HouseAmount;
	
	
	// Methods
	
	/**
	 *  This method will set the amount of houses in the object
	 * @param HousesM : The amount of houses that you want to be set in the object
	 */
	public abstract void setHouseAmount(int HousesM);
	/**
	 *  This method will return the cost of a house for the desired object
	 * @return An integer with the cost of a house
	 */
	public abstract int getHousePrice();
	/**
	 *  This method will return the amount of houses that is in the desired object
	 * @return An integer with the amount of houses in the object
	 */
	public abstract int getHouseAmount();
	
}
