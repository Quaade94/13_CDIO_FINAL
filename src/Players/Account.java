package Players;

public class Account {

	private int balance;
	
	public Account(int money){
		balance = money;
	}
	
	public void updateBalance(int exxxtra){
		this.balance += exxxtra;
	}
	
	public int getBalance(){
		return this.balance;
	}
}
