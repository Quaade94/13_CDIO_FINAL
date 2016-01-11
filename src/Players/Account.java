package Players;

public class Account {

	private int balance = 26000;
	
	/**
	 * opretter en konto for spilleren
	 */
	public Account(){
	}
	
	/**
	 * Opdaterer en spillers penge
	 * @param exxxtra M�ngden den skal opdateres med (bem�rk det g�res ved +=
	 */
	public void updateBalance(int eXxxtra){
		this.balance += eXxxtra;
	}
	
	/**
	 * Giver en kontos balance
	 * @return Balancen p� kontoen
	 */
	public int getBalance(){
		return this.balance;
	}
}
