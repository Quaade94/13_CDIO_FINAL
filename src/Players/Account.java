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
	 * @param exxxtra M�ngden den skal opdateres med (bem�rk det g�res ved +=
	 */
	public void updateBalance(int exxxtra){
		this.balance += exxxtra;
	}
	
	/**
	 * Giver en kontos balance
	 * @return Balancen p� kontoen
	 */
	public int getBalance(){
		return this.balance;
	}
}
