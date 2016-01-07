package Fields;

import Game.Language;

public class TryLuck extends Field {
	
	
	private static String card[] = {Language.getLang("CARD1"),Language.getLang("CARD2"),Language.getLang("CARD3"),Language.getLang("CARD4"),Language.getLang("CARD5"),Language.getLang("CARD6"),Language.getLang("CARD7"),Language.getLang("CARD8")};

	// Messages
	private String Sub, Des;
	
	
	
	
	public TryLuck(int FieldNumberC, String Sub, String Des){
		
		FieldNumber = FieldNumberC;
	
		
	}

	@Override
	public void landOnField() {
		
	}
	@Override
	public int getFieldNumber(){
		return FieldNumber;
	}
	
	public String getChanceMessage(){	
		return card[((int) (Math.random() * card.length))];
	}
	
	public String getSubText(){
		return Sub;
	}
	public String getDesText(){
		return Des;
	}
	
}
