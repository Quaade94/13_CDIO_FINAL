package Test;

import Fields.TryLuck;
import Game.Language;

public class LuckTestClass extends TryLuck{
	
	private int chosenCard;
	private static String card[] = {Language.getLang("CARD1"),Language.getLang("CARD2"),Language.getLang("CARD3"),Language.getLang("CARD4"),Language.getLang("CARD5"),Language.getLang("CARD6"),Language.getLang("CARD7"),Language.getLang("CARD8"),Language.getLang("CARD9"),Language.getLang("CARD10"),Language.getLang("CARD11"),Language.getLang("CARD12"),Language.getLang("CARD13")};
	
	public LuckTestClass(int FieldNumberC, String SubC, String DesC) {
		super(FieldNumberC, SubC, DesC);
	}

	public void setChanceCard(int cardC){
		chosenCard = cardC;
	}
	@Override
	public String getChanceMessage(){
		return card[chosenCard];
	}
}
