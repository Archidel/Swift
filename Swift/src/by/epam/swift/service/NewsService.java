package by.epam.swift.service;

import java.util.List;

import by.epam.swift.bean.News;
import by.epam.swift.service.exception.ServiceException;

public interface NewsService {
	void addNews(String title, String description) throws ServiceException;
	List<News> getNewsListUser(int page) throws ServiceException;
	List<News> getNewsListAdmin(int page) throws ServiceException;
	News getNewsById(int idNews) throws ServiceException;
	void editNews(News news) throws ServiceException;
	void removeNews(int idNews) throws ServiceException;
	int getAmountEntriesNewsListUser() throws ServiceException;
	int getAmountEntriesNewsListAdmin() throws ServiceException;
}
