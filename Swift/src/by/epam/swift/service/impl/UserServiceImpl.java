package by.epam.swift.service.impl;

import java.util.List;

import by.epam.swift.bean.User;
import by.epam.swift.dao.UserDAO;
import by.epam.swift.dao.exception.DAOException;
import by.epam.swift.dao.factory.DAOFactory;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.validation.ValidationData;

/** The class implements the interface {@link UserService}
 * @author Archangel
 */
public class UserServiceImpl implements UserService{
	
	@Override
	public User signIn(String login, String password) throws ServiceException {
		if(!ValidationData.validSignInData(login, password)){
			throw new ServiceException("Iccorrent login or password");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDao = factory.getUserDAO();
		User user = null;
		
		try {
			if(!userDao.signIn(login, password.hashCode())){
				throw new ServiceException("User is not registered in the database");
			}
			user = userDao.getUserByLoginAndPassword(login, password);
		} catch (DAOException e) {
			throw new ServiceException("Error sign in", e);
		}
		
		return user;
	}

	@Override
	public void signUp(User user, String password, String confirmPassword) throws ServiceException {
		if(!ValidationData.validSignUpData(user, password, confirmPassword)){
			throw new ServiceException("Invalid user data");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		user.setPassword(password.hashCode());
		
		try {
			userDAO.signUp(user);
		} catch (DAOException e) {
			throw new ServiceException("Error sing up", e);
		}
	}

	@Override
	public User getUserById(int idUser) throws ServiceException {
		if(!ValidationData.validInteger(idUser)){
			throw new ServiceException("Incorrent id user");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		User user = null;
		
		try {
			user = userDAO.getUserById(idUser);
		} catch (DAOException e) {
			throw new ServiceException("Error asdasdasdasd", e);
		}
		
		return user;
	}

	@Override
	public User editProfile(User user, String passport, String address) throws ServiceException {
		if(!ValidationData.validUser(user)){
			throw new ServiceException("Incorrent user data");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		
		if(passport != null && !passport.isEmpty()){
			if(!ValidationData.validPassport(passport)){
				throw new ServiceException("Incorrent user passport");
			}
			user.setPassport(passport);
		}
		
		if(address != null && !address.isEmpty()){
			user.setAddress(address);
		}
		
		try {
			userDAO.editProfile(user);	
			user = userDAO.getUserById(user.getId());
		} catch (DAOException e) {
			throw new ServiceException("Error edit profile user", e);
		}
				
		return user;
	}

	@Override
	public List<User> getUserList() throws ServiceException {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		List<User> list = null;
		
		try {
			list = userDAO.getUserList();
		} catch (DAOException e) {
			throw new ServiceException("Error getting list of user", e);
		}
		
		return list;
	}

	@Override
	public void setBlock(int idUser, String date) throws ServiceException {
		if(!ValidationData.validInteger(idUser)){
			throw new ServiceException("Incorrent user id");
		}
		
		if(!ValidationData.validString(date)){
			throw new ServiceException("Incorrent user date");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		
		try {
			userDAO.setBlock(idUser, date.replace("-", "."));
		} catch (DAOException e) {
			throw new ServiceException("Set block error", e);
		}
	}

	@Override
	public void removeBlock(int idUser) throws ServiceException {
		if(!ValidationData.validInteger(idUser)){
			throw new ServiceException("Incorrent user id");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		
		try {
			userDAO.removeBlock(idUser);
		} catch (DAOException e) {
			throw new ServiceException("Remove block error", e);
		}
	}

	@Override
	public double getBalance(String idUser) throws ServiceException {
		if(!ValidationData.validInteger(idUser)){
			throw new ServiceException("Incorrnet user id");
		}
		
		int id = Integer.parseInt(idUser);
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		double balance = 0;
		
		try {
			balance = userDAO.getBalance(id);
		} catch (DAOException e) {
			throw new ServiceException("Error getting balance", e);
		}
		
		return balance;
	}

	@Override
	public void addBalance(String balance, int idUser) throws ServiceException {
		if(!ValidationData.validDouble(balance)){
			throw new ServiceException("Incorrent entered balance");
		}
		
		if(!ValidationData.validInteger(idUser)){
			throw new ServiceException("Incorrent id user");
		}
		
		double dBalance = Double.parseDouble(balance);
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		
		try {
			userDAO.addBalance(dBalance, idUser);
		} catch (DAOException e) {
			throw new ServiceException("Error add balance ", e);
		}
	}

	@Override
	public int getAmountEntriesListUser() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		int numberEntries = 0;
		
		try {
			numberEntries = userDAO.getAmountEntriesListUser();
		} catch (DAOException e) {
			throw new ServiceException("Error getting amount entrues list of user", e);
		}
		
		return numberEntries;
	}

	@Override
	public void changePosition(int idUser, String position) throws ServiceException {
		if(!ValidationData.validInteger(idUser)){
			throw new ServiceException("Incorrent user id");
		}
		
		if(!ValidationData.validString(position)){
			throw new ServiceException("Incorrent user position");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		
		try {
			userDAO.changePosition(idUser, position);
		} catch (DAOException e) {
			throw new ServiceException("error changing user position", e);
		}
		
	}
	
}
