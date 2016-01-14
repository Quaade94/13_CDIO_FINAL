package Players;

public class Player {
	
	private Account account;
	private int place;
	private boolean isJailed;
	private String name;
	private int fleetOwned;
	private int laborOwned;
	private String[] territoryColours;
	private boolean isBankcupt;
	
	/**
	 * Opretter en spiller, med konto, placering og f�ngselsstatus
	 */
	public Player(){
		account = new Account();
		place = 0;
		isJailed = false;
		fleetOwned = 0;
		laborOwned = 0;
		territoryColours = new String[22];
		isBankcupt = false;
	}
	
	public Account getAccount(){
		return account;
	}
	
	/**
	 * S�tter spillerens navn
	 * @param name Spillerens �nskede navn
	 */
	public void setName(String name){
		this.name=name;
	}
	
	/**
	 * Returnerer spillerens navn
	 * @return Spillerens navn
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Returnerer hvorvidt spilleren er i f�ngsel (true = ja)
	 * @return spillerens f�ngselsstatus
	 */
	public boolean getJailed(){
		return isJailed;
	}
	
	/**
	 * S�tter spillerens f�ngselsstatus
	 * @param jail True = i f�ngsel
	 */
	public void setJail(boolean jail){
		isJailed=jail;
	}
	
	/**
	 * F�r spillerens position p� spillepladen
	 * @return spillerens position
	 */
	public int getPlace(){
		return place;
	}
	
	/**
	 * S�tter spillerens position
	 * @param nextPlace
	 */
	public void setPlace(int nextPlace){
		place = nextPlace;
	}
	
	/**
	 * Udskriver spillerens navn og konto
	 */
	public String toString(){
		String bleh=" "+name+" : "+account;
		return bleh;
	}
	/**
	 * 
	 * @return Antallet af fleetfelter spilleren ejer
	 */
	public int getFleetOwned(){
		return fleetOwned;
	}
	/**
	 * Tilføjer 1 til antallet af fleetfelter spilleren ejer
	 */
	public void updateFleetOwned(){
		fleetOwned++;
	}
	/**
	 * Reducerer antallet af fleets owned med 1
	 */
	public void reduceFleetOwned(){
		fleetOwned--;
	}
	/**
	 * 
	 * @return Antallet af Laborcampfelter spilleren ejer
	 */
	public int getLaborOwned(){
		return laborOwned;
	}
	/**
	 * Tilføjer 1 til antaller af laborcampfelter spilleren ejer
	 */
	public void updateLaborOwned(){
		laborOwned++;
	}
	/**
	 * Reducerer antallet af laborOwned med 1
	 */
	public void reduceLaborOwned(){
		laborOwned--;
	}
	/**
	 * 
	 * @return Ét array med farverne på de grunde spilleren ejer
	 */
	public String[] getTerColour(){
		return territoryColours;
	}
	/**
	 * Indsætter farven af en grund i et array for spilleren
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
	 * Fjerner en farve af en grund i et array for spilleren
	 * @param colour
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
		isBankcupt = true;
	}
	/**
	 *  This method will return the value of isBanckrupt atribut of the Player object.
	 * @return the value of isBanckrupt atribut of the Player object.
	 */
	public boolean isPlayerBanckrupt(){
		return isBankcupt;
	}

}
