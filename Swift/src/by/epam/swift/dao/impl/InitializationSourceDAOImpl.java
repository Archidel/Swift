package by.epam.swift.dao.impl;

import java.io.IOException;
import by.epam.swift.dao.InitializationSourceDAO;
import by.epam.swift.dao.connection.ConnectionPool;
import by.epam.swift.dao.exception.ConnectionPoolException;
import by.epam.swift.dao.exception.DAOException;

/** The class implements the interface {@link InitializationSourceDAO}
 * @author Archangel
 */
public class InitializationSourceDAOImpl implements InitializationSourceDAO{

	@Override
	public void initSource() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		
		try {
			connectionPool.init();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		}
	}

	@Override
	public void destroySource() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		
		try {
			connectionPool.close();
		} catch (IOException e) {
			throw new DAOException("Failure to close all connections", e);
		}
		
	}

}
