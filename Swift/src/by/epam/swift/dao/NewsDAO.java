package by.epam.swift.dao;


import java.util.List;

import by.epam.swift.bean.News;
import by.epam.swift.dao.exception.DAOException;

public interface NewsDAO {
	void addNews(String title, String description, String date) throws DAOException;
	List<News> getNewsListUser(int begin, int offset) throws DAOException;
	List<News> getNewsListAdmin(int begin, int offset) throws DAOException;
	News getNewsById(int idNews) throws DAOException;
	void editNews(News news) throws DAOException;
	void removeNews(int idNews, boolean newsStatus) throws DAOException;
	boolean getNewsStatusById(int idNews) throws DAOException;
	int getAmountEntriesNewsListUser() throws DAOException;
	int getAmountEntriesNewsListAdmin() throws DAOException;
}
