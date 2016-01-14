package Players;

public class Player {
	
	private Account account;
	private int place;
	private boolean isJailed;
	private String name;
	private int fleetOwned;
	private int laborOwned;
	private String[] territoryColours;
	private boolean isBankrupt;
	
	/**
	 * Creates a plater with an account, a place, prisonstatus and his owned fields(0 in the beginning)
	 */
	public Player(){
		account = new Account();
		place = 0;
		isJailed = false;
		fleetOwned = 0;
		laborOwned = 0;
		territoryColours = new String[22];
		isBankrupt = false;
	}
	
	/**
	 * A method to get the players account
	 * @return The players account
	 */
	public Account getAccount(){
		return account;
	}
	
	/**
	 * Sets the name of the player
	 * @param name 
	 */
	public void setName(String name){
		this.name=name;
	}
	
	/**
	 * Returns the players name
	 * @return The players name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Returns whether or not the player is in jail
	 * @return The players prison status (return = in jail)
	 */
	public boolean getJailed(){
		return isJailed;
	}
	
	/**
	 * Changes the players prison status
	 * @param jail = true means the player is in jail
	 */
	public void setJail(boolean jail){
		isJailed=jail;
	}
	
	/**
	 * Gets the players position
	 * @return The players position
	 */
	public int getPlace(){
		return place;
	}
	
	/**
	 * Sets the players next position
	 * @param nextPlace The players next position
	 */
	public void setPlace(int nextPlace){
		place = nextPlace;
	}

	/**
	 * @return The amount of fleetOwned by the player
	 */
	public int getFleetOwned(){
		return fleetOwned;
	}
	/**
	 * Adds to the amount of fleetOwned by 1
	 */
	public void updateFleetOwned(){
		fleetOwned++;
	}
	/**
	 * Reduces the number of fleetOwned by 1
	 */
	public void reduceFleetOwned(){
		fleetOwned--;
	}
	/**
	 * 
	 * @return The amount of laborOwned by the player
	 */
	public int getLaborOwned(){
		return laborOwned;
	}
	/**
	 * Adds to the amount of laborOwned by 1
	 */
	public void updateLaborOwned(){
		laborOwned++;
	}
	/**
	 * Reduces the number of LaberOwned by 1
	 */
	public void reduceLaborOwned(){
		laborOwned--;
	}
	/**
	 * @return An array of the owned colours for the player
	 */
	public String[] getTerColour(){
		return territoryColours;
	}
	/**
	 * Puts the colour of a property in an array, for the players
	 */
	public void addTerColour(String colour){
		for (int i = 0; i < territoryColours.length; i++){
			if (territoryColours[i] == null){
				territoryColours[i] = colour;
				break;
			}
		}
	}
	/**
	 * Removes a color of a property in an array, for the player
	 * @param colour The colour that's going to be removed
	 */
	public void removeTerColour(String colour){
		for (int i = 0; i < territoryColours.length; i++){
			if (territoryColours[i] == colour){
				territoryColours[i] = null;
				break;
			}
		}
	}
	
	/**
	 * This method will set the atribut isBanckrupt in the Player obkect to true... 
	 *  NB - There is no way to set it to false again later, so use with care.
	 */
	public void setPlayerToIsBankcupt(){
		isBankrupt = true;
	}
	/**
	 *  This method will return the value of isBanckrupt atribute of the Player object.
	 * @return the value of isBanckrupt atribute of the Player object.
	 */
	public boolean isPlayerBanckrupt(){
		return isBankrupt;
	}

}
