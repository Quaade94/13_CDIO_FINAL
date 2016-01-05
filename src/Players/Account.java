package Players;

public class Account {

	private int balance = 1500;
	
	/**
	 * opretter en konto for spilleren
	 */
	public Account(){
	}
	
	/**
	 * Opdaterer en spillers penge
	 * @param exxxtra Mængden den skal opdateres med (bemærk det gøres ved +=
	 */
	public void updateBalance(int exxxtra){
		this.balance += exxxtra;
	}
	
	/**
	 * Giver en kontos balance
	 * @return Balancen på kontoen
	 */
	public int getBalance(){
		return this.balance;
	}
}
