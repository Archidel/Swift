package by.epam.swift.controller.configuration;

/**Store all URLs of all pages and redirect commands
 * @author Archangel
 */
public final class PageName {
	private PageName() {}
	
	public static final String SECURITY_PAGE = "/security";
	public static final String ERROR_WRONG_REQUEST_PAGE = "/errorPage";

	public static final String INDEX_PAGE = "/index";
	public static final String ABOUT_US_PAGE = "/about";
	public static final String AUTHORIZATION_PAGE = "/authorization";
//AGREEMENT
	public static final String GET_AGREEMENT_LIST = "/agreementlist";
	public static final String GET_SINGLE_AGREEMENT_PAGE = "/singleagreement";
	
//NEWS	
	public static final String GET_SINGLE_NEWS_PAGE = "/getsinglenews";
	public static final String GET_NEWS_LIST_USER_PAGE = "/listnews";
	public static final String GET_NEWS_LIST_ADMIN_PAGE = "/listnewsadmin";
	public static final String ADD_NEWS_PAGE = "/addnews";
	public static final String EDIT_NEWS_PAGE = "/editnews";
//USER	
	public static final String EDIT_PROFILE_PAGE = "/editprofile";
	public static final String GET_USER_LIST_PAGE = "/userlist";
	public static final String USER_BALANCE_PAGE = "/balance";

//TARIFF	
	public static final String TARIFF_LIST_USER_PAGE = "/tarifflist";	
	public static final String TARIFF_LIST_ADMIN_PAGE = "/tarifflistadmin";
	public static final String SEARCH_TARIFF_RESULT_PAGE = "/searchresult";	
	public static final String ADD_TARIFF_PAGE = "/addtariff";
	public static final String GET_SINGLE_TARIFF_PAGE = "/getsingletariff";
	public static final String EDIT_TARIFF_PAGE = "/edittariff";
	
//REQUEST
	public static final String REQUEST_ON_SERVICE_PAGE = "/requestonservice";
	public static final String REQUEST_ON_SERVICE_LIST_ADMIN_PAGE = "/requestlistadmin";
	public static final String REQUEST_ON_SERVICE_LIST_USER_PAGE = "/requestlist";
	public static final String GET_SINGLE_REQUEST_ON_SERVICE_PAGE = "/singlerequest";
	
//REDIRCET	
	public static final String REDIRECT_EDIT_NEWS_PAGE = "/Controller?command=upload_news_data_to_edit&news_id=";
	public static final String REDIRECT_GET_NEWS_LIST_ADNIM_PAGE = "/Controller?command=get_news_list_admin&page=1";			
	public static final String REDIRECT_ADD_NEWS_SUCCESS = "/Controller?command=redirect&pagename=addnews&message=News added successfully&status=true";
	public static final String REDIRECT_ADD_NEWS_ERROR = "/Controller?command=redirect&pagename=addnews&message=Failed to add news&status=false";
	public static final String REDIRECT_SIGN_IN_ERROR = "/Controller?command=redirect&pagename=authorization&message=Incorrect login or password&status=false";
	public static final String REDIRECT_SIGN_UP_SUCCESS = "/Controller?command=redirect&pagename=index&message=Registration completed successfully&status=true";
	public static final String REDIRECT_SIGN_UP_ERROR = "/Controller?command=redirect&pagename=authorization&message=Incorrect registration data&status=false";
	public static final String REDIRECT_EDIT_PROFILE_ERROR = "/Controller?command=redirect&pagename=editprofile&message=Failed to edit users profile&status=false";
	public static final String REDIRECT_EDIT_PROFILE_SUCCESS = "/Controller?command=redirect&pagename=editprofile&message=Users profile edition was successfully&status=true";
	public static final String REDIRECT_ADD_BALANCE_ERROR = "/Controller?command=redirect&pagename=index&message=Error Replenishing balance&status=false";
	public static final String REDIRECT_ADD_BALANCE_SUCCESS = "/Controller?command=redirect&pagename=index&message=Balance replenishment was successful&status=true";
	public static final String REDIRECT_CREATE_AGREEMENT_ERROR = "/Controller?command=redirect&pagename=createagreement&message=Error sending the agreement, check if all the data is filled in&status=false";
	public static final String REDIRECT_CREATE_AGREEMENT_SUCCESS = "/Controller?command=redirect&pagename=createagreement&message=The agreement was sent to the administration for consideration&status=true";
	public static final String REDIRECT_ADD_TARIFF_TYPE_ERROR = "/Controller?command=redirect&pagename=index&message=Failed to add type of tariff&status=false";
	public static final String REDIRECT_ADD_TARIFF_TYPE_SUCCESS = "/Controller?command=redirect&pagename=index&message=Type of tariff added successfully&status=true";
	public static final String REDIRECT_ADD_TARIFF_SUCCESS = "/Controller?command=upload_data_to_add_tariff";
	public static final String REDIRECT_ADD_TARIFF_ERROR = "/Controller?command=redirect&pagename=addtariff&message=Failed to add this tariff&status=false";
	public static final String REDIRECT_EDIT_TARIFF = "/Controller?command=upload_data_to_edit_tariff&tariff_id=";
	public static final String REDIRECT_REMOVE_TARIFF = "/Controller?command=get_tariff_list_admin&tariff_type=";
	public static final String REDIRECT_AGREEMENT_LIST = "/Controller?command=get_agreement_list&page=1";
	
	public static final String REDIRECT_MAKE_REQUEST_ON_SERVICE_SUCCESS = "/Controller?command=redirect&pagename=index&message=Your request to add a service has been sent to the administration&status=true";
	public static final String REDIRECT_MAKE_REQUEST_ON_SERVICE_ERROR = "/Controller?command=redirect&pagename=index&message=Error sending a request to add a service, check the entered data&status=false";

	public static final String REDIRECT_REQUEST_ON_SERVICE_LIST_USER =  "/Controller?command=get_request_on_service_list_user&page=1";
	public static final String REDIRECT_REQUEST_ON_SERVICE_LIST_ADMIN =  "/Controller?command=get_request_on_service_list_admin&page=1";

	public static final String REDIRECT_USER_LIST = "/Controller?command=get_user_list&page=1";
}
