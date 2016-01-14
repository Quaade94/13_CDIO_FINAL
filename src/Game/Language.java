package Game;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
	
	// Here, we create a Resource Bundle named 'text'. It is static so it is easier accessable in other classes.
	static ResourceBundle text;
	
	public static void setLocale(Locale eng){	
		
		/* Resource bundle 'text' gets defined as our textfile named 'MessageBundle..'
		   where we write our strings. */
				
		//Messagebundle gets called
		text = ResourceBundle.getBundle("MessageBundle", eng);		
	}
		
	/**
	 * 
	 * @param keyword is a string that you define in capital letters.
	 * @return the String you define to the MessageBundle text file.
	 */
	public static String getLang(String keyword){

		// The command is Locale(String language, String country)
		setLocale(new Locale("en", "GB"));
		
		return text.getString(keyword);
	}
}
