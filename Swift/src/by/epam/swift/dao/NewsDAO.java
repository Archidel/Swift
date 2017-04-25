package by.epam.swift.dao;


import java.util.List;

import by.epam.swift.bean.News;
import by.epam.swift.dao.exception.DAOException;
 
/** Interface News DAO.
 * @author Archangel
 */
public interface NewsDAO {
	/**Method for adding news.
	 * @param title
	 * @param description
	 * @param date
	 * @throws DAOException
	 */
	void addNews(String title, String description, String date) throws DAOException;
	/**Method returns a list of news that is available to the user.
	 * @param begin
	 * @param offset
	 * @return List {@link News}
	 * @throws DAOException
	 */
	List<News> getNewsListUser(int begin, int offset) throws DAOException;
	/**Method returns a list of news that is available to the moderator, administrator.
	 * @param begin
	 * @param offset
	 * @return List {@link News}
	 * @throws DAOException
	 */
	List<News> getNewsListAdmin(int begin, int offset) throws DAOException;
	/** Get news by id.
	 * @param idNews
	 * @return {@link News}
	 * @throws DAOException
	 */
	News getNewsById(int idNews) throws DAOException;
	/** The method updates the data of this news by id.
	 * @param news
	 * @throws DAOException
	 */
	void editNews(News news) throws DAOException;
	/** Remove news by id.
	 * @param idNews
	 * @param newsStatus
	 * @throws DAOException
	 */
	void removeNews(int idNews, boolean newsStatus) throws DAOException;
	/** Obtaining the status of news by ID.
	 * @param idNews
	 * @return boolean
	 * @throws DAOException
	 */
	boolean getNewsStatusById(int idNews) throws DAOException;
	/** Returns the number of records by user request.
	 * @return int
	 * @throws DAOException
	 */
	int getAmountEntriesNewsListUser() throws DAOException;
	/** Returns the number of records by moderator, administrator request.
	 * @return
	 * @throws DAOException
	 */
	int getAmountEntriesNewsListAdmin() throws DAOException;
}
