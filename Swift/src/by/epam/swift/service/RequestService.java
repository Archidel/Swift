package by.epam.swift.service;

import java.util.Date;
import java.util.List;

import by.epam.swift.bean.RequestOnService;
import by.epam.swift.service.exception.ServiceException;

/**Interface Request on service Service.
 * @author Archangel
 *
 */
public interface RequestService {
	/** Get Request on service by id.
	 * @param idRequestOnService
	 * @return {@link RequestOnService}
	 * @throws ServiceException
	 */
	RequestOnService getRequestOnServiceById(int idRequestOnService) throws ServiceException;
	/** Remove request on service by id.
	 * @param idRequestOnService
	 * @throws ServiceException
	 */
	void removeRequestOnService(int idRequestOnService) throws ServiceException;
	/**Create new request on service from user.
	 * @param title
	 * @param type
	 * @param datePeriod
	 * @param serviceAction
	 * @param idUser
	 * @throws ServiceException
	 */
	void makeRequestOnService(String title, String type, String datePeriod, String serviceAction, int idUser, Date blockDate) throws ServiceException;	
	/** The method returns request on service list for user.
	 * @param idUser
	 * @param numberPage
	 * @return List {@link RequsetOnService}
	 * @throws ServiceException
	 */
	List<RequestOnService> getRequestOnServiceList(int idUser, int numberPage) throws ServiceException;
	/** The method returns the number of request on service for user.
	 * @param idUser
	 * @return int
	 * @throws ServiceException
	 */
	int getAmountEntriesRequestList(int idUser) throws ServiceException;
	/** The method returns request on service list for moderator, administrator.
	 * @param numberPage
	 * @return {@link RequestOnService}
	 * @throws ServiceException
	 */
	List<RequestOnService> getRequestOnServiceList(int numberPage) throws ServiceException;
	/** The method returns the number of request on service for moderator, administrator.
	 * @return int
	 * @throws ServiceException
	 */
	int getAmountEntriesRequestList() throws ServiceException;
	/**Accept the Request on service from the user.
	 * @param idRequest
	 * @param idUser
	 * @param action
	 * @param blockDate
	 * @throws ServiceException
	 */
	void acceptRequestOnService(int idRequest, int idAdmin,int idUser, boolean action) throws ServiceException;
}
