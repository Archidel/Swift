package by.epam.swift.service;

import java.util.List;

import by.epam.swift.bean.News;
import by.epam.swift.service.exception.ServiceException;

/**Interface News Service
 * @author Archangel
 *
 */
public interface NewsService {
	/**Method for adding news
	 * @param title
	 * @param description
	 * @throws ServiceException
	 */
	void addNews(String title, String description) throws ServiceException;
	/** Method returns a list of news that is available to the user
	 * @param page
	 * @return List {@link News}
	 * @throws ServiceException
	 */
	List<News> getNewsListUser(int page) throws ServiceException;
	/**Method returns a list of news that is available to the moderator, administrator
	 * @param page
	 * @return List {@link News}
	 * @throws ServiceException
	 */
	List<News> getNewsListAdmin(int page) throws ServiceException;
	/** Get news by id
	 * @param idNews
	 * @return  {@link News}
	 * @throws ServiceException
	 */
	News getNewsById(int idNews) throws ServiceException;
	/** The method updates the data of this tariff by id
	 * @param news
	 * @throws ServiceException
	 */
	void editNews(News news) throws ServiceException;
	/** Remove news by id
	 * @param idNews
	 * @throws ServiceException
	 */
	void removeNews(int idNews) throws ServiceException;
	/** Returns the number of records by user request
	 * @return int
	 * @throws ServiceException
	 */
	int getAmountEntriesNewsListUser() throws ServiceException;
	/** Returns the number of records by moderator, administrator request
	 * @return
	 * @throws ServiceException
	 */
	int getAmountEntriesNewsListAdmin() throws ServiceException;
}
