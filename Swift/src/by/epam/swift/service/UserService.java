package by.epam.swift.service;

import java.util.List;

import by.epam.swift.bean.User;
import by.epam.swift.service.exception.ServiceException;

/** Interface user Service.
 * @author Archangel
 *
 */
public interface UserService {
	/** Loginization user.
	 * @param login
	 * @param password
	 * @return {@link User}
	 * @throws ServiceException
	 */
	User signIn(String login, String password) throws ServiceException;
	/** User registration.
	 * @param user
	 * @param password
	 * @param confirmPassword
	 * @throws ServiceException
	 */
	void signUp(User user, String password, String confirmPassword) throws ServiceException;
	/** The method updates the data of this user.
	 * @param idUser
	 * @return {@link User}
	 * @throws ServiceException
	 */
	User getUserById(int idUser) throws ServiceException;
	/** The method updates the data of this user.
	 * @param user
	 * @param passport
	 * @param address
	 * @return {@link User}
	 * @throws ServiceException
	 */
	User editProfile(User user, String passport, String address) throws ServiceException;
	/**
	 * @return Method returns a list of all user.
	 * @throws ServiceException
	 */
	List<User> getUserList() throws ServiceException;
	/** Method for removing the user lock time.
	 * @param idUser
	 * @param date
	 * @throws ServiceException
	 */
	void setBlock(int idUser, String date) throws ServiceException;
	/** Receiving the current balance of the user.
	 * @param idUser
	 * @throws ServiceException
	 */
	void removeBlock(int idUser) throws ServiceException;
	/** Receiving the current balance of the user.
	 * @param idUser
	 * @return Double
	 * @throws ServiceException
	 */
	double getBalance(String idUser) throws ServiceException;
	/**Method for add balance.
	 * @param balance
	 * @param idUser
	 * @throws ServiceException
	 */
	void addBalance(String balance, int idUser) throws ServiceException;
	/** Returns the number of users.
	 * @return int
	 * @throws ServiceException
	 */
	int getAmountEntriesListUser() throws ServiceException;
	
	
	
	
	
	
	
	
	
	void changePosition(int idUser, String position) throws ServiceException;
	
}
