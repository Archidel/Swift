package by.epam.swift.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import by.epam.swift.bean.News;
import by.epam.swift.dao.ColumnLabel;
import by.epam.swift.dao.NewsDAO;
import by.epam.swift.dao.SQLCommand;
import by.epam.swift.dao.connection.ConnectionPool;
import by.epam.swift.dao.exception.ConnectionPoolException;
import by.epam.swift.dao.exception.DAOException;

public class NewsDAOImpl implements NewsDAO {
	
	@Override
	public void addNews(String title, String description, String date) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.INSERT_NEWS);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, description);
			preparedStatement.setString(3, date);
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement);
		}
	}

	@Override
	public List<News> getNewsListUser(int begin, int offset) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<News> list = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_NEWS_ACTIVE_STATUS_LIMIT);
			preparedStatement.setInt(1, begin);
			preparedStatement.setInt(2, offset);
			resultSet = preparedStatement.executeQuery();
			
			list = new LinkedList<News>();
			News news = null;
			
			while(resultSet.next()){
				news = new News();
				news.setId(resultSet.getInt(ColumnLabel.NEWS_ID));
				news.setDatePublication(resultSet.getDate(ColumnLabel.NEWS_DATE_PUBLICATION));
				news.setTitle(resultSet.getString(ColumnLabel.NEWS_TITLE));
				news.setDescription(resultSet.getString(ColumnLabel.NEWS_DESCRIPTION));
				list.add(news);
			}
		
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}		
		
		return list;
	}

	@Override
	public News getNewsById(int idNews) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		News news = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_NEWS_BY_ID);
			preparedStatement.setInt(1, idNews);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				news = new News();
				news.setId(resultSet.getInt(ColumnLabel.NEWS_ID));
				news.setDatePublication(resultSet.getDate(ColumnLabel.NEWS_DATE_PUBLICATION));
				news.setTitle(resultSet.getString(ColumnLabel.NEWS_TITLE));
				news.setDescription(resultSet.getString(ColumnLabel.NEWS_DESCRIPTION));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}				
		
		return news;
	}

	@Override
	public void editNews(News news) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_NEWS);
			preparedStatement.setString(1, news.getTitle());
			preparedStatement.setString(2, news.getDescription());
			preparedStatement.setInt(3, news.getId());
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement);
		}
	}

	@Override
	public void removeNews(int idNews, boolean newsStatus) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_NEWS_STATUS);
			preparedStatement.setInt(2, idNews);
			if(newsStatus){
				preparedStatement.setBoolean(1, false);
			}else{
				preparedStatement.setBoolean(1, true);
			}
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement);
		}
	}

	@Override
	public boolean getNewsStatusById(int idNews) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean status = false;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_NEWS_STATUS_BY_ID);
			preparedStatement.setInt(1, idNews);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			status = resultSet.getBoolean(ColumnLabel.NEWS_STATUS);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return status;				
	}

	@Override
	public List<News> getNewsListAdmin(int begin, int offset) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<News> list = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_NEWS_INACTIVE_STATUS_LIMIT);
			preparedStatement.setInt(1, begin);
			preparedStatement.setInt(2, offset);
			resultSet = preparedStatement.executeQuery();
			
			list = new LinkedList<News>();
			News news = null;
			
			while(resultSet.next()){
				news = new News();
				news.setId(resultSet.getInt(ColumnLabel.NEWS_ID));
				news.setDatePublication(resultSet.getDate(ColumnLabel.NEWS_DATE_PUBLICATION));
				news.setTitle(resultSet.getString(ColumnLabel.NEWS_TITLE));
				news.setDescription(resultSet.getString(ColumnLabel.NEWS_DESCRIPTION));
				news.setStatus(resultSet.getBoolean(ColumnLabel.NEWS_STATUS));
				list.add(news);
			}
		
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}		
		
		return list;
	}

	@Override
	public int getAmountEntriesNewsListUser() throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int numberEntries = 0;
		
		try {
			connection = pool.take();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQLCommand.SELECT_NEWS_ACTIVE_STATUS_COUNT);		
			resultSet.next();
			numberEntries = resultSet.getInt(ColumnLabel.AMOUNT);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, statement, resultSet);
		}		
		
		return numberEntries;
	}

	@Override
	public int getAmountEntriesNewsListAdmin() throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int numberEntries = 0;
		
		try {
			connection = pool.take();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQLCommand.SELECT_NEWS_INACTIVE_STATUS_COUNT);		
			resultSet.next();
			numberEntries = resultSet.getInt(ColumnLabel.AMOUNT);	
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, statement, resultSet);
		}		
		
		return numberEntries;
	}
}
