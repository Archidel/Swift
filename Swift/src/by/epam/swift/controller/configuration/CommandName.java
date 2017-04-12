package by.epam.swift.controller.configuration;

/**	<h1>Command name</h1>
 * This enumeration is used to initialize all possible commands.
 * @author Albert Zarankovich
 */

public enum CommandName {
	/** <h1>COMMAND</h1>General command.*/
	COMMAND, 
	/** <h1>SIGN_IN</h1>Command for sign in user.*/
	SIGN_IN, 
	/**  <h1>SIGN_UP</h1>Command for sign up user.*/
	SIGN_UP, 
	/**  <h1>INITIALIZATION_SOURCE</h1>Command for initialization data source(Connection pool) user.*/
	INITIALIZATION_SOURCE,
	/**  <h1>DESTROY_SOURCE</h1>Command for destroy data source(Connection pool) user.*/
	DESTROY_SOURCE, 
	/**  <h1>WRONG_REQUEST</h1>Command for redirect user on error page.*/
	WRONG_REQUEST, 
	/**  <h1>LOGOUT</h1>Command for logout from user's account.*/
	LOGOUT, 
	/**  <h1>LOCALIZATION</h1>Command for change localization.*/
	LOCALIZATION, 
	/**  <h1>SEARCH_TARIFF</h1>Command for search tariff title by all tariff types.*/
	SEARCH_TARIFF,
	/**  <h1>MORE_ABOUT_EDIT_PROFILE</h1>??????????????????????????????/*/
	MORE_ABOUT_EDIT_PROFILE,
	/**  <h1>EDIT_PROFILE</h1>Command for edit user's profile.*/
	EDIT_PROFILE,
	/**  <h1>GET_USER_LIST</h1>Command for get all registered users list.*/
	GET_USER_LIST,
	/**  <h1>SET_BLOCK</h1>Command for set blocked till for users.*/
	SET_BLOCK,
	/**  <h1>REMOVE_BLOCK</h1>Command for remove blocked till from users.*/
	REMOVE_BLOCK,
	/**  <h1>MORE_ABOUT_TARIFF</h1>Command for get more information about tariff.*/
	MORE_ABOUT_TARIFF,
	/**  <h1>MAKE_ORDER</h1>Command for make order on add new service.*/
	MAKE_ORDER,
	/**  <h1>PAYMENT_FOR_SERVICE</h1>Command for payment for service.*/
	PAYMENT_FOR_SERVICE,
	
	ADD_TARIFF,
	
	GET_SINGLE_TARIFF,
	GET_TARIFF_LIST,
	
	UPLOAD_DATA_TO_EDIT_TARIFF,
	EDIT_TARIFF,
	REMOVE_TARIFF,
	ADD_TARIFF_TYPE,
	
	GET_LIST_NEWS, 
	ADD_NEWS, 
	GET_SINGLE_NEWS,
	GET_MORE_ABOUT_NEWS, 
	EDIT_NEWS, 
	REMOVE_NEWS, 
	
	BLOCK_USER,
	REDIRECT, 
	CREATE_AGREEMENT, 
	
	UPLOAD_DATA_TO_ADD_TARIFF,
	UPLOAD_DATA_TO_REQUEST_ON_SERVICE, 
	MAKE_REQUEST_ON_SERVICE, 
	GET_BALANCE, 
	ADD_BALANCE, 
	GET_REQUEST_ON_SERVICE_LIST_USER, 
	GET_REQUEST_ON_SERVICE_LIST_ADMIN, 
	GET_NEWS_LIST, GET_NEWS_LIST_ADMIN, 
	UPLOAD_NEWS_DATA_TO_EDIT, 
	GET_TARIFF_LIST_ADMIN, 
	GET_AGREEMENT_LIST, 
	REMOVE_AGREEMENT, 
	GET_SINGLE_AGREEMENT, 
	ACCEPT_AGREEMENT, 
	ACCEPT_REQUEST_ON_SERVICE, 
	REMOVE_REQUEST_ON_SERVICE, GET_SINGLE_REQUEST_ON_SERVICE;
}
