package Players;

public class Player {
	
	private Account account;
	private int place;
	private boolean isJailed;
	private String name;
	private int fleetOwned;
	private int laborOwned;
	private String[] territoryColours;
	
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
	 * 
	 * @return Ét array med farverne på de grunde spilleren ejer
	 */
	public String[] getTerColour(){
		return territoryColours;
	}
	/**
	 * Indsætter farven af en grund i et array for spilleren
	 */
	public void updateTerColour(String colour){
		for (int i = 0; i < territoryColours.length; i++){
			territoryColours[i] = colour;
		}
	}

}
