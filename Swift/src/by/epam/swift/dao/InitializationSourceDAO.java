package by.epam.swift.dao;

import by.epam.swift.dao.exception.DAOException;;

/**Interface initialization  DAO.
 * @author Archangel
 */
public interface InitializationSourceDAO {
	/** Method for initialization source when server is started.
	 * @throws DAOException
	 */
	void initSource() throws DAOException;
	/** Method for initialization source when server is shutting down.
	 * @throws DAOException
	 */
	void destroySource() throws DAOException;
}
