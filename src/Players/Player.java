package Players;

public class Player {
	
	private Account account;
	private int place;
	private boolean isJailed;
	private String name;
	private int fleetOwned;
	
	/**
	 * Opretter en spiller, med konto, placering og f�ngselsstatus
	 */
	public Player(){
		account = new Account();
		place = 0;
		isJailed = false;
		fleetOwned = 0;
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
	
	public int getFleetOwned(){
		return fleetOwned;
	}
	public void updateFleetOwned(){
		fleetOwned++;
	}

}
