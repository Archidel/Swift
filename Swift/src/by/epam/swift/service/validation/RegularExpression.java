package by.epam.swift.service.validation;

/** Regular expression for {@link ValidationData}.
 * @author Archangel
 */
public final class RegularExpression {
	private RegularExpression() {}
	/** Latin letters or digits at least 3 symbols up to 16 */
	public static final String LOGIN_REGULAR = "[a-zA-Z0-9_-]{3,16}+$";
	/** Latin letters or digits at least 8 symbols up to 32 */
	public static final String PASSWORD_REGULAR = "[a-zA-Z0-9]{8,32}+$";
	/** Example: vasia.pupkin.6@gmail.com. */
	public static final String EMAIL_REGULAR = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	/** Latin letters or digits at least 3 symbols up to 32*/
	public static final String NAME_REGULAR = "[a-zA-Z0-9-]{3,16}$";
	/** Example: 44-475-33-85, (44)-475-33-85, 44 475 33 85, (44) 475 33 85, 44.475.33.85, 44 4753385, 4753385. */
	public static final String PHONE_REGULAR = "^(1[ \\-\\+]{0,3}|\\+1[ -\\+]{0,3}|\\+1|\\+)?((\\(\\+?1-[2-9][0-9]{1,2}\\))|(\\(\\+?[2-8][0-9][0-9]\\))|(\\(\\+?[1-9][0-9]\\))|(\\(\\+?[17]\\))|(\\([2-9][2-9]\\))|([ \\-\\.]{0,3}[0-9]{2,4}))?([ \\-\\.][0-9])?([ \\-\\.]{0,3}[0-9]{2,4}){2,3}$";
	/** Regular expression for prices. Example: 1, 2, 24, 55 */
	public static final String NUMBER_REGULAR = "\\d+";
	/** Regular expression for double value. Example: 0.1, 0.2, 0.24, 0.55 */
	public static final String DOUBLE_REGULAR = "[+-]?\\d*\\.?\\d+";
	/** Regular expression for check passport. Example: KH1234567 */
	public static final String PASSPORT_REGULAR = "[a-zA-Z]{2}+[0-9]{7}+$";	
}