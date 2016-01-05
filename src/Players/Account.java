package Players;

public class Account {

	private int balance = 1500;
	
	public Account(){
	}
	
	public void updateBalance(int exxxtra){
		this.balance += exxxtra;
	}
	
	public int getBalance(){
		return this.balance;
	}
}
