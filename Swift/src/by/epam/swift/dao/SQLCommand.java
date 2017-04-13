package by.epam.swift.dao;

public final class SQLCommand {
	private SQLCommand() {}
	
	public static final String FOREING_KET_CHECKS_FALSE = "SET FOREIGN_KEY_CHECKS=0";
	public static final String FOREING_KET_CHECKS_TRUE = "SET FOREIGN_KEY_CHECKS=1";
	
//REQUEST ON SERVICE
	public static final String INSERT_REQUEST_ON_SERVICE = "INSERT INTO request (a_id, t_id, r_date, r_service_action) VALUES (?,?,?,?)";

	public static final String UPDATE_REQUEST_STATUS = "UPDATE request SET r_status = 1 WHERE r_id = ?";
	public static final String INSERT_REQUEST_ENABLE_TARIFF = "INSERT IGNORE INTO user_m2m_tariff(u_id, t_id) VALUES (?,?)";
	public static final String UPDATE_REQUEST_DISABLE_TARIFF = "UPDATE user_m2m_tariff SET u_id = 0, t_id = 0 WHERE u_id = ? AND t_id = ?";

	
	public static final String SELECT_USER_REQUEST_ON_SERVLICE_LIST_LIMIT = "SELECT r_id, t_id, r_date, r_service_action FROM request WHERE r_status = 0 AND a_id = ? ORDER BY r_date DESC LIMIT ?, ?";
	public static final String SELECT_ADMIN_REQUEST_ON_SERVLICE_LIST_LIMIT = "SELECT r_id, a_id, t_id, r_date, r_service_action FROM request WHERE r_status = 0 ORDER BY r_date DESC LIMIT ?, ?";
	public static final String SELECT_USER_REQUEST_ON_SERVICE_LIST_COUNT = "SELECT COUNT(*) as amount FROM request WHERE a_id = ? AND r_status = 0";
	public static final String SELECT_ADMIN_REQUEST_ON_SERVICE_LIST_COUNT = "SELECT COUNT(*) as amount FROM request WHERE r_status = 0";
	public static final String SELECT_REQUEST_ACTIVE_STATUS = "SELECT r_id, u_id, r_id_tariff, r_type_tariff, r_date, r_service_action FROM request WHERE r_status = 0 ORDER BY r_date DESC";
	public static final String SELECT_REQUEST_BY_ID = "SELECT * FROM request where r_id = ?";
	
	//USER
	public static final String SELECT_USER = "SELECT * FROM user";
	public static final String SELECT_USER_ID_BY_LOGIN_PASSWORD = "SELECT u_id FROM user WHERE u_login = ? AND u_password = ?";
	public static final String SELECT_USER_BY_LOGIN_PASSWORD = "SELECT * FROM user WHERE u_login = ? AND u_password = ?";
	public static final String INSERT_SIGN_UP_USER = "INSERT INTO user (u_name, u_surname, u_login, u_email, u_password, u_birthdate) VALUES (?,?,?,?,?,?)";
	public static final String UPDATE_USER = "UPDATE user SET u_name = ?, u_surname= ?, u_login = ?, u_passport = ?, u_email = ?, u_birthdate = ?, u_phone = ?, u_adress = ? WHERE u_id = ?";
	public static final String UPDATE_USER_ADD_BALANCE = "UPDATE user SET u_balance = (u_balance + ?) WHERE u_id = ?";
	public static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE u_id = ?";
	public static final String UPDATE_USER_BLOCK_BY_ID = "UPDATE user SET u_blocked_till = ? WHERE u_id = ?";
	public static final String SELECT_USER_BALANCE_BY_ID = "SELECT u_balance FROM user WHERE u_id = ?";
	
	//AGREEMENT
	public static final String INSERT_AGREEMENT = "INSERT INTO agreement (u_id, a_date_creation) VALUES (?,?)";
	public static final String SELECT_AGREEMENT_ID_BY_USERID = "SELECT a_id FROM agreement WHERE u_id = ?";
	public static final String SELECT_AGREEMENT_ID_BY_USERID_ACCEPTED = "SELECT a_id FROM agreement WHERE admin_u_id > 0 AND u_id = ?";
	
	public static final String SELECT_AGREEMENT_BY_ID = "SELECT u_id, admin_u_id, a_date_creation, a_status FROM agreement WHERE a_id = ?";
	public static final String SELECT_AGREEMENT_ACTIVE_STATUS_LIMIT = "SELECT a_id, u_id, a_date_creation, admin_u_id FROM agreement WHERE a_status = 0 ORDER BY a_date_creation DESC LIMIT ?,?";
	public static final String SELECT_AGREEMENT_ACTIVE_STATUS_COUNT = "SELECT COUNT(*) as amount FROM agreement WHERE a_status = 0";
	public static final String UPDATE_AGREEMENT_ADMINID_STATUS = "UPDATE agreement SET a_status = 1, admin_u_id = ? WHERE a_id = ?";
	public static final String UPDATE_AGREEMENT_ADMINID = "UPDATE agreement SET admin_u_id = ? WHERE a_id = ?";

	//TRIFF
	public static final String INSERT_ADD_TARIFF_TYPE = "INSERT INTO tariff_type (tt_type) VALUES (?)";
	public static final String INSERT_TARIFF = "INSERT INTO tariff (t_title, t_price, tt_id, t_description) VALUES (?,?,?,?)";
	
	public static final String UPDATE_TARIFF = "UPDATE tariff SET t_title = ?, t_price = ?, t_description = ? WHERE t_id = ?";
	public static final String UPDATE_TARIFF_STATUS = "UPDATE tariff SET t_status = ? WHERE t_id = ?";
	
	public static final String SELECT_TARIFF_BY_ID = "SELECT t_title, t_price, t_description, t_status, tt_type FROM tariff LEFT JOIN tariff_type ON tariff.tt_id = tariff_type.tt_id WHERE t_id = ?";
	public static final String SELECT_TARIFF_ID_BY_TITLE_AND_TYPE = "SELECT t_id FROM tariff WHERE t_title = ? AND tt_id = ?";
	public static final String SELECT_TARIFF_TITLE_BY_ID = "SELECT t_title FROM tariff WHERE t_id = ?";
	public static final String SELECT_TARIFF_STATUS_BY_ID = "SELECT t_status FROM tariff WHERE t_id = ?";
	public static final String SELECT_TARIFF_ID_TYPE_BY_TITLE = "SELECT tt_id FROM tariff_type WHERE tt_type = ?";

	public static final String SELECT_TARIFF_BY_TITLE = "SELECT t_title, t_price, t_description, t_status, tt_type FROM tariff LEFT JOIN tariff_type ON tariff.tt_id = tariff_type.tt_id WHERE t_title = ?";
	public static final String SELECT_TARIFF_BY_TITLE_COUNT = "SELECT COUNT(*) as amount FROM tariff WHERE t_status = 0 AND t_title = ?";
	public static final String SELECT_TARIFF_BY_TITLE_LIMIT = "SELECT t_id, t_price, t_description, t_status, tt_type FROM tariff LEFT JOIN tariff_type ON tariff.tt_id = tariff_type.tt_id WHERE t_title = ? LIMIT ?,?";

	public static final String SELECT_TARIFF_ACTIVE_STATUS = "SELECT t_id, t_title, t_price, t_description, t_status, tt_type FROM tariff LEFT JOIN tariff_type ON tariff.tt_id = tariff_type.tt_id WHERE t_status = 0 AND tt_type = ? ORDER BY t_title ASC";
	
	public static final String SELECT_TARIFF_ACTIVE_STATUS_NO_TYPE = "SELECT t_id, t_title, t_price, t_description, t_status, tt_type FROM tariff LEFT JOIN tariff_type ON tariff.tt_id = tariff_type.tt_id WHERE t_status = 0 ORDER BY t_title ASC";
	
	
	public static final String SELECT_TARIFF_ACTIVE_STATUS_LIMIT = "SELECT t_id, t_title, t_price, t_description, t_status, tt_type FROM tariff LEFT JOIN tariff_type ON tariff.tt_id = tariff_type.tt_id WHERE t_status = 0 AND tt_type = ? ORDER BY t_title ASC LIMIT ?, ?";
	public static final String SELECT_TARIFF_ACTIVE_STATUS_COUNT = "SELECT COUNT(*) as amount FROM tariff LEFT JOIN tariff_type ON tariff.tt_id = tariff_type.tt_id WHERE t_status = 0 AND tt_type = ?";
	public static final String SELECT_TARIFF_INACTIVE_STATUS_LIMIT = "SELECT t_id, t_title, t_price, t_description, t_status, tt_type FROM tariff LEFT JOIN tariff_type ON tariff.tt_id = tariff_type.tt_id WHERE tt_type = ? ORDER BY t_title ASC LIMIT ?, ?";
	public static final String SELECT_TARIFF_INACTIVE_STATUS_COUNT = "SELECT COUNT(*) as amount FROM tariff LEFT JOIN tariff_type ON tariff.tt_id = tariff_type.tt_id WHERE tt_type = ?";
	public static final String SELECT_TARIFF_TYPE_TITLE = "SELECT tt_type FROM tariff_type";
	public static final String SELECT_TARIFF_TITLE = "SELECT t_title FROM tariff WHERE t_status = 0 ORDER BY t_title ASC";
	
	//NEWS
	public static final String INSERT_NEWS = "INSERT INTO news (n_title, n_description, n_date_publication) VALUES (?,?,?)";

	public static final String UPDATE_NEWS = "UPDATE news SET n_title = ?, n_description = ? WHERE n_id = ?";
	public static final String UPDATE_NEWS_STATUS = "UPDATE news SET n_status = ? WHERE n_id = ?";

	public static final String SELECT_NEWS_ACTIVE_STATUS_COUNT = "SELECT COUNT(*) as amount FROM news WHERE n_status = 0";
	public static final String SELECT_NEWS_INACTIVE_STATUS_COUNT = "SELECT COUNT(*) as amount FROM news";
	public static final String SELECT_NEWS_ACTIVE_STATUS_LIMIT = "SELECT * FROM news WHERE n_status = 0 ORDER BY n_date_publication DESC LIMIT ?, ?";
	public static final String SELECT_NEWS_INACTIVE_STATUS_LIMIT = "SELECT * FROM news ORDER BY n_date_publication DESC limit ?,?";	
	public static final String SELECT_NEWS_BY_ID = "SELECT n_id, n_date_publication, n_title, n_description FROM news WHERE n_id = ?";
	public static final String SELECT_NEWS_STATUS_BY_ID = "SELECT n_status FROM news WHERE n_id = ?";

}		
