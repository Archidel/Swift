package by.epam.swift.dao.impl;

import java.io.IOException;

import by.epam.swift.dao.InitializationSourceDAO;
import by.epam.swift.dao.connection.ConnectionPool;
import by.epam.swift.dao.exception.ConnectionPoolException;
import by.epam.swift.dao.exception.DAOException;

public class InitializationSourceDAOImpl implements InitializationSourceDAO{

	@Override
	public void initSource() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		
		try {
			connectionPool.init();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		}
	
	}

	@Override
	public void destroySource() throws DAOException {
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		
		try {
			connectionPool.close();
		} catch (IOException e) {
			throw new DAOException(e);
		}
		
	}

}
