package by.epam.swift.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import by.epam.swift.bean.News;
import by.epam.swift.dao.NewsDAO;
import by.epam.swift.dao.exception.DAOException;
import by.epam.swift.dao.factory.DAOFactory;
import by.epam.swift.service.NewsService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.validation.ValidationData;

/** The class implements the interface {@link NewsService}
 * @author Archangel
 */
public class NewsServiceImpl implements NewsService {
	
	@Override
	public void addNews(String title, String description) throws ServiceException {
		if(!ValidationData.validAddNews(title, description)){
			throw new ServiceException("Iccorrent title or description news");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		NewsDAO newsDAO = factory.getNewsDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			
			newsDAO.addNews(title, description, sdf.format(new Date()));
		} catch (DAOException e) {
			throw new ServiceException("Error add new news",e);
		}
	}

	@Override
	public List<News> getNewsListUser(int page) throws ServiceException {
		if(!ValidationData.validInteger(page)){
			throw new ServiceException("Icorrent number of page");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		NewsDAO newsDAO = factory.getNewsDAO();
		int offset = 10;
		int begin = (page * 10) - 10;
		List<News> list = null; 
		
		try {
			list = newsDAO.getNewsListUser(begin, offset);
		} catch (DAOException e) {
			throw new ServiceException("Error getting list of news for user",e);
		}
		
		return list;
	}

	@Override
	public News getNewsById(int idNews) throws ServiceException {
		if(!ValidationData.validInteger(idNews)){
			throw new ServiceException("Iccorrent id news");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		NewsDAO newsDAO = factory.getNewsDAO();
		News news = null;
		
		try {
			news = newsDAO.getNewsById(idNews);
		} catch (DAOException e) {
			throw new ServiceException("Error getting news by id",e);
		}
		
		return news;
	}

	@Override
	public void editNews(News news) throws ServiceException {
		if(!ValidationData.validEditNews(news)){
			throw new ServiceException("Iccorrent data in news");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		NewsDAO newsDAO = factory.getNewsDAO();
		
		try {
			newsDAO.editNews(news);
		} catch (DAOException e) {
			throw new ServiceException("Error editing news",e);
		}

	}

	@Override
	public void removeNews(int idNews) throws ServiceException {
		if(!ValidationData.validInteger(idNews)){
			throw new ServiceException("Iccorrent id news");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		NewsDAO newsDAO = factory.getNewsDAO();
		
		try {
			boolean newsStatus = newsDAO.getNewsStatusById(idNews);
			newsDAO.removeNews(idNews, newsStatus);
		} catch (DAOException e) {
			throw new ServiceException("News removal error",e);
		}
	}

	@Override
	public List<News> getNewsListAdmin(int numberPage) throws ServiceException {
		if(!ValidationData.validInteger(numberPage)){
			throw new ServiceException("Icorrent number of page");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		NewsDAO newsDAO = factory.getNewsDAO();
		List<News> list = null;
		int offset = 10;
		int begin = (numberPage * 10) - 10;
		
		try {
			list = newsDAO.getNewsListAdmin(begin, offset);
		} catch (DAOException e) {
			throw new ServiceException("Error getting news of list for administration",e);
		}

		return list;
	}

	@Override
	public int getAmountEntriesNewsListUser() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		NewsDAO newsDAO = factory.getNewsDAO();
		int numberEntries = 0;
		
		try {
			numberEntries = newsDAO.getAmountEntriesNewsListUser();
		} catch (DAOException e) {
			throw new ServiceException("Error getting amount entries list of news for user",e);
		}
		
		return numberEntries;
	}

	@Override
	public int getAmountEntriesNewsListAdmin() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		NewsDAO newsDAO = factory.getNewsDAO();
		int numberEntries = 0;
		
		try {
			numberEntries = newsDAO.getAmountEntriesNewsListAdmin();
		} catch (DAOException e) {
			throw new ServiceException("Error getting amount entries list of news for administration",e);
		}
		
		return numberEntries;
	}

}
