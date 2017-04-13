package by.epam.swift.dao.factory;

import by.epam.swift.dao.AgreementDAO;
import by.epam.swift.dao.InitializationSourceDAO;
import by.epam.swift.dao.NewsDAO;
import by.epam.swift.dao.RequestServiceDAO;
import by.epam.swift.dao.TariffDAO;
import by.epam.swift.dao.UserDAO;
import by.epam.swift.dao.impl.AgreementDAOImpl;
import by.epam.swift.dao.impl.InitializationSourceDAOImpl;
import by.epam.swift.dao.impl.NewsDAOImpl;
import by.epam.swift.dao.impl.RequestServiceDAOImpl;
import by.epam.swift.dao.impl.TariffDAOImpl;
import by.epam.swift.dao.impl.UserDAOImpl;

/** A singleton class that connects a layer of services and dao
 * @author Archangel
 *
 */
public final class DAOFactory {
	private static DAOFactory instance = null;
	private final InitializationSourceDAO initializationSourceDAO = new InitializationSourceDAOImpl();
	private final UserDAO userDAO = new UserDAOImpl();
	private final NewsDAO newsDAO = new NewsDAOImpl();
	private final RequestServiceDAO requestServiceDAO = new RequestServiceDAOImpl();
	private final AgreementDAO agreementDAO = new AgreementDAOImpl();
	private final TariffDAO tariffDAO = new TariffDAOImpl();
	
	private DAOFactory() {}

	public static DAOFactory getInstance() {
		if(instance == null){
			instance = new DAOFactory();
		}
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	public RequestServiceDAO getRequestServiceDAO() {
		return requestServiceDAO;
	}

	public InitializationSourceDAO getInitializationSourceDAO() {
		return initializationSourceDAO;
	}

	public TariffDAO getTariffDAO() {
		return tariffDAO;
	}

	public AgreementDAO getAgreementDAO() {
		return agreementDAO;
	}
	
}
