package by.epam.swift.controller.configuration;

/**	<h1>Command name</h1>
 * This enumeration is used to initialize all possible commands.
 * @author Albert Zarankovich
 */

public enum CommandName {
//GENERAL
	
	/**
	 * General command.
	 */
	COMMAND, 
	/**
	 * Command for worn request. When command not found we get this class.
	 */
	WRONG_REQUEST, 
	/**
	 * Command for redirects on difference pages.
	 */
	REDIRECT, 
//INITIALIZATION
	/**
	 * Command for initialization connection with source.
	 */
	INITIALIZATION_SOURCE,
	/**
	 * Command for destroy connection with source.
	 */
	DESTROY_SOURCE, 
	
	//USER
	/**
	 *  Command for loginization.
	 */
	SIGN_IN, 
	/**
	 *  Command for registration user.
	 */
	SIGN_UP, 	
	/**
	 * Command for exit for user's account.
	 */
	LOGOUT, 
	/**
	 * Command for change site's localization.
	 */
	LOCALIZATION, 
	/**
	 * Command for update/edit user data.
	 */
	EDIT_PROFILE,
	/**
	 *  Command for get user list.
	 */
	GET_USER_LIST,
	/**
	 * Command for remove block for user.
	 */
	REMOVE_BLOCK,
	/**
	 *  Command for get user balance.
	 */
	GET_BALANCE, 
	/**
	 *  Command for add balance.
	 */
	ADD_BALANCE, 
	/**
	 *  Command for up or down user's position.
	 */
	UP_POSITION,
//TARIFF
	/**
	 * Command for searching tariff name.
	 */
	SEARCH_TARIFF,
	/**
	 *  Command for add new tariff.
	 */
	ADD_TARIFF,
	/** 
	 *  Command for get more info about tariff.
	 */
	GET_SINGLE_TARIFF,
	/**
	 *  Command for get tariff list.
	 */
	GET_TARIFF_LIST,	
	/**
	 *  Command for upload data to edit tariff form.
	 */
	UPLOAD_DATA_TO_EDIT_TARIFF,
	/**
	 *  Command for upload data to add tariff form.
	 */
	UPLOAD_DATA_TO_ADD_TARIFF,
	/**
	 *  Command for update/Edit tariff data.
	 */
	EDIT_TARIFF,
	/**
	 *  Command for remove tariff.
	 */
	REMOVE_TARIFF,
	/**
	 *  Command for add new type of tariff.
	 */
	ADD_TARIFF_TYPE,
	/**
	 *  Command for get tariff list for administration with different status.
	 */
	GET_TARIFF_LIST_ADMIN,  
	/** 
	 * Command for add new news.
	 */
	ADD_NEWS, 
	/**
	 *  Command for get more info about news.
	 */
	GET_SINGLE_NEWS,
	/**
	 *  Command for update/edit news data.
	 */
	EDIT_NEWS, 
	/**
	 *  Command for remove news.
	 */
	REMOVE_NEWS, 
	/**
	 *  Command for get news list.
	 */
	GET_NEWS_LIST, 
	/**
	 *  Command for get news list for administration with different status.
	 */
	GET_NEWS_LIST_ADMIN, 
	/**
	 *  Command for upload news data to edit news form.
	 */
	UPLOAD_NEWS_DATA_TO_EDIT, 	
	/**
	 *  Command for blocking user.
	 */
	BLOCK_USER,
//AGREEMENT
	/**
	 *  Command for  create new agreement.
	 */
	CREATE_AGREEMENT, 
	/**
	 *  Command for  get agreement list.
	 */
	GET_AGREEMENT_LIST, 
	/**
	 *  Command for remove agreement.
	 */
	REMOVE_AGREEMENT, 
	/**
	 *  Command for get more info about agreement.
	 */
	GET_SINGLE_AGREEMENT, 
	/**
	 *  Command for accept agreement.
	 */
	ACCEPT_AGREEMENT,
//REQUEST	
	/**
	 * Command for accept request on service.
	 */
	ACCEPT_REQUEST_ON_SERVICE, 
	/**
	 * Command for remove request on service.
	 */
	REMOVE_REQUEST_ON_SERVICE,
	/**
	 *  Command for get more info about request on service.
	 */
	GET_SINGLE_REQUEST_ON_SERVICE, 
	/**
	 *  Command for upload data request on service form.
	 */
	UPLOAD_DATA_TO_REQUEST_ON_SERVICE, 
	/**
	 *  Command for make request on service.
	 */
	MAKE_REQUEST_ON_SERVICE, 
	/**
	 *  Command for get request on service list for user.
	 */
	GET_REQUEST_ON_SERVICE_LIST_USER, 
	/**
	 *  Command for get request on service list for administrations.
	 */
	GET_REQUEST_ON_SERVICE_LIST_ADMIN;
}
