package Players;

public class Account {

	private int balance = 30000;
	private int balanceReset = balance;
	
	/**
	 * Creates an account for the player
	 */
	public Account(){
	}
	
	/**
	 * Updates the players money (by addition)
	 * @param update The amount of money you want to add (+)
	 */
	public void updateBalance(int update){
		this.balance += update;
	}
	
	/**
	 * Gets the players balance
	 * @return int
	 */
	public int getBalance(){
		return this.balance;
	}
	
	/**
	 * Resets the players balance
	 */
	public void resetBalance(){
		balance = balanceReset;
	}
}
