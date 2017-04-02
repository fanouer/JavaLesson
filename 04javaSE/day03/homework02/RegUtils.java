package homework02;
/**
 * ื๗าต1
 * @author Administrator
 *
 */
public class RegUtils {
	public static final String IDENTITY_CARD
		= "[0-9]{15}([0-9]{2}[0-9xX])?";
	
	public static final String ZIP_CODE
		= "\\d{6}";
	
	public static final String PHONE_NUMBER
		= "(\\+86|0086)?\\s*\\d{11}";
	
	public boolean check(String str,String regex){
		return str.matches(regex);
	}
}








