package Fields;

import Game.Language;

public class TryLuck extends Park_Chance {
	
	
	private static String card[] = {Language.getLang("CARD1"),Language.getLang("CARD2"),Language.getLang("CARD3"),Language.getLang("CARD4"),Language.getLang("CARD5"),Language.getLang("CARD6"),Language.getLang("CARD7"),Language.getLang("CARD8")};

	// Messages
	
	public TryLuck(int FieldNumberC, String SubC, String DesC){
		
		FieldNumber = FieldNumberC;
		
		SubText = SubC;
		Description = DesC;
	
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
	@Override
	public String getSubText(){
		return SubText;
	}
	@Override
	public String getDescription(){
		return Description;
	}



	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
