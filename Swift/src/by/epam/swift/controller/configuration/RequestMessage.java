package by.epam.swift.controller.configuration;

/**Stores system messages. These keys can be passed to the JSP with
	By using the AttributeNames.MESSAGE_ATTRIBUTE attribute of the request object.
 * @author Archangel
 */
public final class RequestMessage {
	private RequestMessage() {}
	
	public static final String NULL_PAGE = "Page not found. Business logic error";
	public static final String WRONG_COMMAND = "Command not found or wrong";
	
	public static final String EDIT_NEWS_ERROR = "Failed to edit news";
	public static final String EDIT_NEWS_SUCCESS = "News editing was successfully";
	public static final String EDIT_INTERNET_TARIFF_ERROR = "Failed to edit internet tariff";
	public static final String EDIT_INTERNET_TARIFF_SUCCESS = "Internet tariff editing was successfully";
	public static final String EDIT_DIGITAL_TV_TARIFF_ERROR = "Failed to edit digital tv tariff";
	public static final String EDIT_DIGITAL_TV_TARIFF_SUCCESS = "Digital tv tariff editing was successfully";
	public static final String EDIT_TELEPHONY_TARIFF_ERROR = "Failed to edit telephony tariff";
	public static final String EDIT_TELEPHONY_TARIFF_SUCCESS = "Telephony tariff editing was successfully";
	public static final String MAKE_ORDER_SUCCESS = "Order to provide services sent";
	public static final String MAKE_ORDER_ERROR = "Not enought user data for order";
	public static final String REMOVE_REQUEST_SUCCESS = "Request was removed";
	public static final String REMOVE_REQUEST_ERROR = "Requset has not been removed";
	public static final String APPLY_REQUEST_SUCCESS = "Requst was applied";
	public static final String APPLY_REQUEST_ERROR = "Requst has not applied";
	public static final String OPERATION_SUCCESS = "Operation was successfully completed";
	public static final String OPERATION_ERROR = "An error occurred performing operations";
}
