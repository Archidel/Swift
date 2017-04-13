package by.epam.swift.dao;

import java.util.List;

import by.epam.swift.bean.Agreement;
import by.epam.swift.dao.exception.DAOException;

/**Interface agreement DAO.
 * @author Archangel
 */
public interface AgreementDAO {
	/** Method creates Agreement.
	 * @param idUser
	 * @param date
	 * @throws DAOException
	 */
	void createAgreement(int idUser, String date) throws DAOException;
	/** The method returns id agreement by user id.
	 * @param idUser
	 * @return int
	 * @throws DAOException
	 */
	int getIdAgreementByUserId(int idUser) throws DAOException;
	/**The method returns Agreement list by user id (accepted).
	 * @param idUser
	 * @return int
	 * @throws DAOException
	 */
	int getIdAgreementByUserIdAccepted(int idUser) throws DAOException;
	/**  The method returns Agreement list.
	 * @param begin
	 * @param offset
	 * @return List {@link Agreement}
	 * @throws DAOException
	 */
	List<Agreement> getAgreementList(int begin, int offset) throws DAOException;
	/**The method returns the number of agreements.
	 * @return int
	 * @throws DAOException
	 */
	int getAmountEntriesListAgreement() throws DAOException;
	/** The method returns the Agreement by id.
	 * @param idAgreement
	 * @return int
	 * @throws DAOException
	 */
	Agreement getAgreementById(int idAgreement) throws DAOException;
	/** Remove agreement.
	 * @param idAgreement
	 * @param idAdmin
	 * @throws DAOException
	 */
	void removeAgreement(int idAgreement, int idAdmin) throws DAOException;
	/** Accept the agreement from the user.
	 * @param idAgreement
	 * @param idAdmin
	 * @throws DAOException
	 */
	void acceptAgreement(int idAgreement, int idAdmin) throws DAOException;
}
