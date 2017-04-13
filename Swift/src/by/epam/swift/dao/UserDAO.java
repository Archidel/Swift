package by.epam.swift.dao;

import java.util.List;

import by.epam.swift.bean.User;
import by.epam.swift.dao.exception.DAOException;

/** Interface user DAO
 * @author Archangel
 */
public interface UserDAO {
	/** The method checks whether the user is registered
	 * @param login
	 * @param password
	 * @return boolean
	 * @throws DAOException
	 */
	boolean signIn(String login, int password) throws DAOException;
	/** User registration
	 * @param user
	 * @throws DAOException
	 */
	void signUp(User user) throws DAOException;
	/** Get user by login and passwiord
	 * @param login
	 * @param password
	 * @return {@link User}
	 * @throws DAOException
	 */
	User getUserByLoginAndPassword(String login, String password) throws DAOException;
	/**Get user by user ID
	 * @param idUser
	 * @return {@link User}
	 * @throws DAOException
	 */
	User getUserById(int idUser) throws DAOException;
	/** The method updates the data of this user
	 * @param user
	 * @throws DAOException
	 */
	void editProfile(User user) throws DAOException;
	/** Method returns a list of all user
	 * @return List {@link User}
	 * @throws DAOException
	 */
	List<User> getUserList() throws DAOException;
	/** Method for setting the user lockout time
	 * @param idUser
	 * @param date
	 * @throws DAOException
	 */
	void setBlock(int idUser, String date) throws DAOException;
	/** Method for removing the user lock time
	 * @param idUser
	 * @throws DAOException
	 */
	void removeBlock(int idUser) throws DAOException;
	/** Receiving the current balance of the user
	 * @param idUser
	 * @return Double
	 * @throws DAOException
	 */
	double getBalance(int idUser) throws DAOException;
	/** Method for add balance
	 * @param balance
	 * @param idUser
	 * @throws DAOException
	 */
	void addBalance(double balance, int idUser) throws DAOException;
	/**Returns the number of users
	 * @return int
	 * @throws DAOException
	 */
	int getAmountEntriesListUser() throws DAOException;
}
