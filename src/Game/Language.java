package Game;

import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
	
	// Here, we create a Resource Bundle named 'text'. It is static so it is easier accessable in other classes.
	static ResourceBundle text;
	
	public static void setLocale(Locale eng){	
		
		/* Resource bundle 'text' gets defined as our textfile named 'MessageBundle..'
		   where we write our strings. */
		
		
		// So Messagebundle  gets called here
		text = ResourceBundle.getBundle("MessageBundle", eng);
		
	}
		
	// a get method so we can call our string to the other klasses.
	/**
	 * 
	 * @param keyword is a string that you define in capital letters.
	 * @return the String you define to the MessageBundle text file.
	 */
	public static String getLang(String keyword){
		
		// Locale describes our regions language, signs etc..
		
		// The command is Locale(String language, String country). Here we set it to the type english in great britain.
		setLocale(new Locale("en", "GB"));
		
		return text.getString(keyword);
	}
	
}

//  .properties makes it possible to open the file in alle text editors.