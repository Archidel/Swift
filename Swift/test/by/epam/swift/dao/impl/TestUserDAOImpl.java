package by.epam.swift.dao.impl;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.swift.dao.UserDAO;
import by.epam.swift.dao.connection.ConnectionPool;
import by.epam.swift.dao.exception.ConnectionPoolException;
import by.epam.swift.dao.exception.DAOException;
import by.epam.swift.dao.factory.DAOFactory;


public class TestUserDAOImpl {
	
	@BeforeClass
	public static void initSource() throws ConnectionPoolException{
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.init();
	}
	
	@AfterClass
	public static void destroySource() throws IOException{
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.close();
	}
	
	@Test
	public void testSignIn() throws DAOException{
		String login = "junit";
		String password = "12345678";
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		boolean result = userDAO.signIn(login, password.hashCode());
		assertTrue(result);
	}
}
