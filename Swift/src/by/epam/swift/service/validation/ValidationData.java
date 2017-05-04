package by.epam.swift.service.validation;

import java.util.regex.Pattern;

import by.epam.swift.bean.News;
import by.epam.swift.bean.Tariff;
import by.epam.swift.bean.User;

/** Validate data.
 * @author Archangel
 */
public final class ValidationData {
	
	private ValidationData() {}
	/** Method for validation request data.
	 * @param title
	 * @param type
	 * @param datePeriod
	 * @param serviceAction
	 * @return boolean 
	 */
	public static boolean validRequest(String title, String type, String datePeriod, String serviceAction){
		boolean isValidTitle = validString(title);
		boolean isValidType = validString(type);
		boolean isValidDatePeriod = validString(datePeriod);
		boolean isValidServiceAction = validString(serviceAction);
		if(isValidDatePeriod && isValidServiceAction && isValidTitle && isValidType){
			return true;
		}else{
			return false;			
		}
	}
	/** Method for check data for make request.
	 * @param idRequestOnService id request on service
	 * @param idUser id user
	 * @param typeTariff type of tariff
	 * @return boolean 
	 */
	public static boolean validRequest(int idRequestOnService, int idUser, String typeTariff){
		boolean isValidIdRequest = validInteger(idRequestOnService);
		boolean isValidIdUser = validInteger(idUser);
		boolean isValidTypeTariff = validString(typeTariff);
		if(isValidIdRequest && isValidIdUser && isValidTypeTariff){
			return true;
		}else{
			return false;
		}
	}
	/** Method for check series and passport number.
	 * @param passport user passport
	 * @return boolean
	 */
	public static boolean validPassport(String passport){
		return Pattern.matches(RegularExpression.PASSPORT_REGULAR, passport);
	}
	/** Method for check user password.
	 * @param user password
	 * @return boolean
	 */
	public static boolean validPassword(String password){
		return Pattern.matches(RegularExpression.PASSWORD_REGULAR, password);
	}
	/**Method for checking the password and its match.
	 * @param password
	 * @param confirmPassword
	 * @return boolean 
	 */
	public static boolean validPassword(String password, String confirmPassword){
		boolean isValidPassword = Pattern.matches(RegularExpression.PASSWORD_REGULAR, password);
		boolean isValidConfirmPassword = Pattern.matches(RegularExpression.PASSWORD_REGULAR, confirmPassword);
		boolean isEqualsPassword = password.equals(confirmPassword);
		if(isEqualsPassword && isValidConfirmPassword && isValidPassword){
			return true;
		}else{
			return false;
		}
	}
	/** Validation tariff data.
	 * @param tariff
	 * @return boolean 
	 */
	public static boolean validTariff(Tariff tariff){
		boolean isValidTitle = validString(tariff.getTitle());
		boolean isValidPrice = validDouble(tariff.getPrice());
		boolean isValidDescription = validString(tariff.getDescription());
		if(isValidDescription && isValidPrice && isValidTitle){
			return true;
		}else{
			return false;
		}
	}
	/** Validation tariff data.
	 * @param title
	 * @param description
	 * @param price
	 * @return boolean
	 */
	public static boolean validTariff(String title, String description, double price){
		boolean isValidTitle = validString(title);
		boolean isValidPrice = validDouble(price);
		boolean isValidDescription = validString(description);
		if(isValidDescription && isValidPrice && isValidTitle){
			return true;
		}else{
			return false;
		}
	}
	/** Validation tariff data.
	 * @param title
	 * @param description
	 * @param price
	 * @return boolean
	 */
	public static boolean validTariff(String title, String description, String price){
		boolean isValidTitle = validString(title);
		boolean isValidDoublePrice = Pattern.matches(RegularExpression.DOUBLE_REGULAR, price);
		boolean isValidDescription = validString(description);
		if(isValidDescription && isValidDoublePrice && isValidTitle){
			return true;
		}else{
			return false;
		}
	}	
	/** Full validation user data.
	 * @param user
	 * @return boolean
	 */
	public static boolean validUserFull(User user){
		boolean isValidName = validString(user.getName());
		boolean isValidSurname = validString(user.getSurname());
		boolean isValidLogin = validString(user.getLogin());
		boolean isValidEmail = validString(user.getEmail());
		boolean isValidPhone = validString(user.getPhone());
		boolean isValidBirthdate = validString(user.getBirthdate());
		boolean isValidPassport = validString(user.getPassport());
		boolean isValidAdress = validString(user.getAddress());
		if(isValidEmail && isValidLogin && isValidName && isValidPhone
				&& isValidSurname && isValidBirthdate && isValidPassport && isValidAdress){
			return true;
		}else{
			return false;
		}
	}
	/** Validation user data.
	 * @param user
	 * @return boolean
	 */
	public static boolean validUser(User user){
		boolean isValidName = Pattern.matches(RegularExpression.NAME_REGULAR, user.getName());
		boolean isValidSurname = Pattern.matches(RegularExpression.NAME_REGULAR, user.getSurname());
		boolean isValidEmail = Pattern.matches(RegularExpression.EMAIL_REGULAR, user.getEmail());
		boolean isValidPhone = Pattern.matches(RegularExpression.PHONE_REGULAR, user.getPhone());
		boolean isValidLogin = Pattern.matches(RegularExpression.LOGIN_REGULAR, user.getLogin());
		if(isValidEmail && isValidLogin && isValidName && isValidPhone && isValidSurname){
			return true;
		}else{
			return false;
		}
	}
	/**Method for check user data for registration.
	 * @param user
	 * @param password
	 * @param confirmPassword
	 * @return boolean
	 */
	public static boolean validSignUpData(User user, String password, String confirmPassword){
		boolean isValidName = Pattern.matches(RegularExpression.NAME_REGULAR, user.getName());
		boolean isValidSurname = Pattern.matches(RegularExpression.NAME_REGULAR, user.getSurname());
		boolean isValidEmail = Pattern.matches(RegularExpression.EMAIL_REGULAR, user.getEmail());
		boolean isValidLogin = Pattern.matches(RegularExpression.LOGIN_REGULAR, user.getLogin());
		boolean isValidPhone = Pattern.matches(RegularExpression.PHONE_REGULAR, user.getPhone());
		boolean isValidPassword = Pattern.matches(RegularExpression.PASSWORD_REGULAR, password);		
		boolean isEqualsPassword = password.equalsIgnoreCase(confirmPassword);
		if(isValidEmail && isEqualsPassword && isValidLogin && isValidName && 
				isValidPassword && isValidSurname && isValidPhone){
			return true;
		}else{
			return false;
		}
	}
	/** Method for check user sign in data.
	 * @param login
	 * @param password
	 * @return true of false
	 */
	public static boolean validSignInData(String login, String password){
		if(validString(login) && validString(password)){
			return true;
		}else{
			return false;
		}
	}
	/**Method for check new data.
	 * @param titile
	 * @param description
	 * @return true of false
	 */
	public static boolean validAddNews(String titile, String description){
		if(validString(titile) && validString(description)){
			return true;
		}else{
			return false;
		}
	}
	/**Method for check integer < 0.
	 * @param integer
	 * @return true of false
	 */
	public static boolean validInteger(int integer){
		if(integer < 0){
			return false;
		}else{
			return true;
		}
	}
	
	/**Method for check integer < 0.
	 * @param integer
	 * @return
	 */
	public static boolean validInteger(String integer){
		return Pattern.matches(RegularExpression.NUMBER_REGULAR, integer);
	}
	/**Method for check double < 0.
	 * @param d
	 * @return boolean
	 */
	public static boolean validDouble(double d){
		if(d < 0){
			return false;
		}else{
			return true;
		}
	}
	/** Validation double valid.
	 * @param d
	 * @return boolean
	 */
	public static boolean validDouble(String d){
		return Pattern.matches(RegularExpression.DOUBLE_REGULAR, d);
	}
	/**Method for check edit news data.
	 * @param news
	 * @return boolean
	 */
	public static boolean validEditNews(News news){
		boolean isValidId = validInteger(news.getId());
		boolean isValidTitle = validString(news.getTitle());
		boolean isValidDescription = validString(news.getDescription());
		if(isValidId && isValidTitle && isValidDescription){
			return true;
		}else{
			return false;
		}
	}
	/**Method for check String == null or isEmpty.
	 * @param line
	 * @return true of false
	 */
	public static boolean validString(String line){
		if(line == null || line.isEmpty()){
			return false;
		}else{
			return true;
		}		
	}
	
}
