package by.epam.swift.service.validation;

/** Regular expression for {@link ValidationData}
 * @author Archangel
 */
public final class RegularExpression {
	private RegularExpression() {}
	/** Latin letters or digits at least 3 symbols up to 16 */
	public static final String LOGIN_REGULAR = "[a-zA-Z0-9]{3,16}+$";
	/** Latin letters or digits at least 8 symbols up to 32 */
	public static final String PASSWORD_REGULAR = "[a-zA-Z0-9]{8,32}+$";
	/** Example: vasia.pupkin@gmail.com. */
	public static final String EMAIL_REGULAR = "([a-zA-Z0-9].+)\\@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
	/** Latin letters or digits at least 3 symbols up to 32 */
	public static final String NAME_REGULAR = "[a-zA-Z]{3,32}+$";
	/** Example: (29) 1234567 */
	public static final String PHONE_REGULAR = "((\\(?\\d{2}\\)?.?)(.?\\d{3}.?\\d{2}.?\\d{2}))";
	/** Regular expression for prices. Example: 1, 2, 24, 55 */
	public static final String PRICE_REGULAR = "\\d+";
	/** Regular expression for double value. Example: 0.1, 0.2, 0.24, 0.55 */
	public static final String DOUBLE_REGULAR = "[+-]?\\d*\\.?\\d+";
	/** Regular expression for check passport. Example: KH1234567 */
	public static final String PASSPORT_REGULAR = "[a-zA-Z]{2}+[0-9]{7}+";
}
