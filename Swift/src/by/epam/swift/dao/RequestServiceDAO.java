package by.epam.swift.dao;


import java.util.List;

import by.epam.swift.bean.RequestOnService;
import by.epam.swift.dao.exception.DAOException;

/** Interface Request on service DAO.
 * @author Archangel
 *
 */
public interface RequestServiceDAO {
	/**The method for applying for the addition of a service.
	 * @param idAgreement
	 * @param idTariff
	 * @param date
	 * @param serviceAction
	 * @throws DAOException
	 */
	void makeRequestOnService(int idAgreement, int idTariff, String date, boolean serviceAction) throws DAOException;		
	/** The method returns request on service list for user.
	 * @param idAgrement
	 * @param begin
	 * @param offset
	 * @return List {@link RequsetOnService}
	 * @throws DAOException
	 */
	List<RequestOnService> getRequestOnServiceList(int idAgrement, int begin, int offset) throws DAOException;
	/** The method returns request on service list for moderator, administrator.
	 * @param begin
	 * @param offset
	 * @return {@link RequestOnService}
	 * @throws DAOException
	 */
	List<RequestOnService> getRequestOnServiceList(int begin, int offset) throws DAOException;
	/** The method returns the number of request on service for user.
	 * @param idUser
	 * @return int
	 * @throws DAOException
	 */
	int getAmountEntriesRequestList(int idUser) throws DAOException;
	/**The method returns the number of request on service for moderator, administrator.
	 * @return int
	 * @throws DAOException
	 */
	int getAmountEntriesRequestList() throws DAOException;
	/**Get Request on service by id
	 * @param idRequest
	 * @return {@link RequestOnService}
	 * @throws DAOException
	 */
	RequestOnService getRequestOnServiceById(int idRequest) throws DAOException;
	/** Remove request on service by id
	 * @param idRequest
	 * @throws DAOException
	 */
	void removeRequestOnService(int idRequest) throws DAOException;
	/** Accept the Requset on service from the user
	 * @param idUser
	 * @param idTariff
	 * @param status
	 * @throws DAOException
	 */
	void acceptRequestOnService(int idUser, int idTariff, boolean status) throws DAOException;
}
