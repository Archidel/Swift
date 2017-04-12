package by.epam.swift.service.impl;

import by.epam.swift.dao.InitializationSourceDAO;
import by.epam.swift.dao.exception.DAOException;
import by.epam.swift.dao.factory.DAOFactory;
import by.epam.swift.service.InitializationSourceService;
import by.epam.swift.service.exception.ServiceException;

public class InitializationServiceImpl implements InitializationSourceService{

	@Override
	public void initSource() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		InitializationSourceDAO initializationDAO = daoFactory.getInitializationSourceDAO();
		
		try {
			initializationDAO.initSource();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	
	}

	@Override
	public void destroySource() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		InitializationSourceDAO initializationDAO = daoFactory.getInitializationSourceDAO();
		
		try {
			initializationDAO.destroySource();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

}
