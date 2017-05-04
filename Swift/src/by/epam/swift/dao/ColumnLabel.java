package by.epam.swift.dao;

/**Database column names column store.
 * @author Archangel
 */
public final class ColumnLabel {
	private ColumnLabel() {}
//USER
	public static final String USER_ID = "u_id";
	public static final String USER_NAME = "u_name";
	public static final String USER_SURNAME = "u_surname";
	public static final String USER_LOGIN = "u_login";
	public static final String USER_PASSWORD = "u_password";
	public static final String USER_PASSPORT = "u_passport";
	public static final String USER_EMAIL = "u_email";
	public static final String USER_BIRTHDATE = "u_birthdate";
	public static final String USER_PHONE = "u_phone";
	public static final String USER_ADRESS = "u_adress";
	public static final String USER_POSITION = "u_position";
	public static final String USER_BALANCE = "u_balance";
	public static final String USER_STATUS = "u_status";
	public static final String USER_BLOCKED_TILL = "u_blocked_till";
	public static final String USER_TELEPHONY_ID = "t_id";
	public static final String USER_INTENRET_ID = "i_id";
	public static final String USER_DIGITAL_TV_ID = "d_id";
//AGREEMENT
	public static final String AGREEMENT_ID = "a_id";
	public static final String AGREEMENT_ADMIN_ID = "admin_u_id";
	public static final String AGREEMENT_DATE_CREATION = "a_date_creation";
	public static final String AGREEMENT_STATUS = "a_status";
//REQUEST ON SERVICE
	public static final String REQUEST_ON_SERVICE_ID = "r_id";
	public static final String REQUEST_ON_SERVICE_DATE = "r_date";
	public static final String REQUEST_ON_SERVICE_STATUS = "r_status";
	public static final String REQUEST_ON_SERVICE_ID_TARIFF = "r_id_tariff";
	public static final String REQUEST_ON_SERVICE_TYPE_TARIFF = "r_type_tariff";
	public static final String REQUEST_ON_SERVICE_ACTION = "r_service_action";
//NEWS
	public static final String NEWS_ID = "n_id";
	public static final String NEWS_TITLE = "n_title";
	public static final String NEWS_DESCRIPTION = "n_description";
	public static final String NEWS_DATE_PUBLICATION = "n_date_publication";
	public static final String NEWS_STATUS = "n_status";	
//TARIFF
	public static final String TARIFF_ID = "t_id";
	public static final String TARIFF_TITLE = "t_title";
	public static final String TARIFF_TYPE_TITLE = "tt_type";
	public static final String TARIFF_TYPE_ID = "tt_id";
	public static final String TARIFF_PRICE = "t_price";
	public static final String TARIFF_DESCRIPTION = "t_description";
	public static final String TARIFF_STATUS = "t_status";
//Other
	public static final String AMOUNT = "amount";
}
