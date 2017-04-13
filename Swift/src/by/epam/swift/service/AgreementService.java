package by.epam.swift.service;

import java.util.List;

import by.epam.swift.bean.Agreement;
import by.epam.swift.bean.User;
import by.epam.swift.service.exception.ServiceException;

/**Interface agreement
 * @author Archangel
 */
public interface AgreementService {
	/** Method creates Agreement
	 * @param user
	 * @throws ServiceException
	 */
	void createAgreement(User user) throws ServiceException;
	/** The method returns Agreement list
	 * @param numberPage
	 * @return List {@link Agreement}
	 * @throws ServiceException
	 */
	List<Agreement> getAgreementList(int numberPage) throws ServiceException;
	/**The method returns the number of agreements
	 * @return int
	 * @throws ServiceException
	 */
	int getAmountEntriesListAgreement() throws ServiceException;
	/**Method for get an agreement on the identifier
	 * @param idAgreement
	 * @return {@link Agreement}
	 * @throws ServiceException
	 */
	Agreement getAgreementById(int idAgreement) throws ServiceException;
	/**Remove agreement  
	 * @param idAgreement
	 * @param idAdmin
	 * @throws ServiceException
	 */
	void removeAgreement(int idAgreement, int idAdmin) throws ServiceException;
	/** Accept the agreement from the user
	 * @param idAgreement
	 * @param idAdmin
	 * @throws ServiceException
	 */
	void acceptAgreement(int idAgreement, int idAdmin) throws ServiceException;
	
}
