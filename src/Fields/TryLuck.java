package Fields;

import Game.Language;

public class TryLuck extends Field {
	
	
	private static String card[] = {Language.getLang("CARD1"),Language.getLang("CARD2"),Language.getLang("CARD3"),Language.getLang("CARD4"),Language.getLang("CARD5"),Language.getLang("CARD6"),Language.getLang("CARD7"),Language.getLang("CARD8"),Language.getLang("CARD9"),Language.getLang("CARD10")};

	
	
	public TryLuck(int FieldNumberC, String NameC){
		
		FieldNumber = FieldNumberC;
		Name = NameC;
		
	}

	@Override
	public void landOnField() {
		
	}
	@Override
	public int getFieldNumber(){
		return FieldNumber;
	}
	@Override
	public String getName(){
		return Name;
	}
	
	public String getChanceMessage(){	
		return card[((int) (Math.random() * card.length))];
	}
	
}
