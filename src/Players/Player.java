package Players;

public class Player {
	
	private Account account;
	private int place;
	private boolean isJailed;
	private String name;
	
	/**
	 * Opretter en spiller, med konto, placering og fængselsstatus
	 */
	public Player(){
		account = new Account();
		place = 0;
		isJailed = false;
	}
	
	public Account getAccount(){
		return account;
	}
	
	/**
	 * Sætter spillerens navn
	 * @param name Spillerens ønskede navn
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
	 * Returnerer hvorvidt spilleren er i fængsel (true = ja)
	 * @return spillerens fængselsstatus
	 */
	public boolean getJailed(){
		return isJailed;
	}
	
	/**
	 * Sætter spillerens fængselsstatus
	 * @param jail True = i fængsel
	 */
	public void setJail(boolean jail){
		isJailed=jail;
	}
	
	/**
	 * Får spillerens position på spillepladen
	 * @return spillerens position
	 */
	public int getPlace(){
		return place;
	}
	
	/**
	 * Sætter spillerens position
	 * @param nextPlace
	 */
	public void setPlace(int nextPlace){
		
	}
	
	/**
	 * Udskriver spillerens navn og konto
	 */
	public String toString(){
		String bleh=" "+name+" : "+account;
		return bleh;
	}

}
