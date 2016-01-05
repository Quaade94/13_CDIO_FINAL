package Players;

public class Player {
	
	private Account account;
	private int place;
	private boolean isJailed;
	private String name;
	
	
	public Player(){
		account = new Account();
		place = 0;
		isJailed = false;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean getJailed(){
		return isJailed;
	}
	
	public void setJail(boolean jail){
		isJailed=jail;
	}
	
	public int getPlace(){
		return place;
	}
	
	public void setPlace(int nextPlace){
		
	}
	
	public String toString(){
		String bleh=" "+name+" : "+account;
		return bleh;
	}

}
