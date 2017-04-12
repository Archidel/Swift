package by.epam.swift.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import by.epam.swift.bean.User;
import by.epam.swift.dao.ColumnLabel;
import by.epam.swift.dao.SQLCommand;
import by.epam.swift.dao.UserDAO;
import by.epam.swift.dao.connection.ConnectionPool;
import by.epam.swift.dao.exception.ConnectionPoolException;
import by.epam.swift.dao.exception.DAOException;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean signIn(String login, int password) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		boolean userExistance = false;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_USER_ID_BY_LOGIN_PASSWORD);
			preparedStatement.setString(1, login);
			preparedStatement.setInt(2, password);
			resultSet = preparedStatement.executeQuery();
			userExistance = resultSet.next();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return userExistance;
	}

	@Override
	public void signUp(User user) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.INSERT_SIGN_UP_USER);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getLogin());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setInt(5, user.getPassword());
			preparedStatement.setString(6, user.getBirthdate());
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
	public User getUserByLoginAndPassword(String login, String password) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_USER_BY_LOGIN_PASSWORD);
			preparedStatement.setString(1, login);
			preparedStatement.setInt(2, password.hashCode());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				user = new User();
				user.setId(resultSet.getInt(ColumnLabel.USER_ID));
				user.setName(resultSet.getString(ColumnLabel.USER_NAME));
				user.setSurname(resultSet.getString(ColumnLabel.USER_SURNAME));
				user.setLogin(resultSet.getString(ColumnLabel.USER_LOGIN));
				user.setPassword(resultSet.getInt(ColumnLabel.USER_PASSWORD));
				user.setPassport(resultSet.getString(ColumnLabel.USER_PASSPORT));
				user.setEmail(resultSet.getString(ColumnLabel.USER_EMAIL));
				user.setBirthdate(resultSet.getString(ColumnLabel.USER_BIRTHDATE));
				user.setPhone(resultSet.getString(ColumnLabel.USER_PHONE));
				user.setAddress(resultSet.getString(ColumnLabel.USER_ADRESS));
				user.setPosition(resultSet.getString(ColumnLabel.USER_POSITION));
				user.setBalance(resultSet.getDouble(ColumnLabel.USER_BALANCE));
				user.setStatus(resultSet.getBoolean(ColumnLabel.USER_STATUS));
				user.setBlockedTill(resultSet.getDate(ColumnLabel.USER_BLOCKED_TILL));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return user;
	}

	@Override
	public User getUserById(int idUser) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		User user = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_USER_BY_ID);
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				user = new User();
				user.setId(resultSet.getInt(ColumnLabel.USER_ID));
				user.setName(resultSet.getString(ColumnLabel.USER_NAME));
				user.setSurname(resultSet.getString(ColumnLabel.USER_SURNAME));
				user.setLogin(resultSet.getString(ColumnLabel.USER_LOGIN));
				user.setPassword(resultSet.getInt(ColumnLabel.USER_PASSWORD));
				user.setPassport(resultSet.getString(ColumnLabel.USER_PASSPORT));
				user.setEmail(resultSet.getString(ColumnLabel.USER_EMAIL));
				user.setBirthdate(resultSet.getString(ColumnLabel.USER_BIRTHDATE));
				user.setPhone(resultSet.getString(ColumnLabel.USER_PHONE));
				user.setAddress(resultSet.getString(ColumnLabel.USER_ADRESS));
				user.setPosition(resultSet.getString(ColumnLabel.USER_POSITION));
				user.setBalance(resultSet.getDouble(ColumnLabel.USER_BALANCE));
				user.setStatus(resultSet.getBoolean(ColumnLabel.USER_STATUS));
//				user.setBlockedTill(resultSet.getString(ColumnLabel.USER_BLOCKED_TILL));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}

		return user;
	}

	@Override
	public void editProfile(User user)throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_USER);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSurname());
			preparedStatement.setString(3, user.getLogin());
			preparedStatement.setString(4, user.getPassport());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getBirthdate());
			preparedStatement.setString(7, user.getPhone());
			preparedStatement.setString(8, user.getAddress());
			preparedStatement.setInt(9, user.getId());
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
	public List<User> getUserList() throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<User> userList = null;
		
		try {
			connection = pool.take();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQLCommand.SELECT_USER);
			userList = new LinkedList<User>();
			User user = null;
			
			while(resultSet.next()){
				user = new User();
				user.setId(resultSet.getInt(ColumnLabel.USER_ID));
				user.setName(resultSet.getString(ColumnLabel.USER_NAME));
				user.setSurname(resultSet.getString(ColumnLabel.USER_SURNAME));
				user.setLogin(resultSet.getString(ColumnLabel.USER_LOGIN));
				user.setPassword(resultSet.getInt(ColumnLabel.USER_PASSWORD));
				user.setPassport(resultSet.getString(ColumnLabel.USER_PASSPORT));
				user.setEmail(resultSet.getString(ColumnLabel.USER_EMAIL));
				user.setBirthdate(resultSet.getString(ColumnLabel.USER_BIRTHDATE));
				user.setPhone(resultSet.getString(ColumnLabel.USER_PHONE));
				user.setAddress(resultSet.getString(ColumnLabel.USER_ADRESS));
				user.setPosition(resultSet.getString(ColumnLabel.USER_POSITION));
				user.setBalance(resultSet.getDouble(ColumnLabel.USER_BALANCE));
				user.setStatus(resultSet.getBoolean(ColumnLabel.USER_STATUS));
//				user.setBlockedTill(resultSet.getString(ColumnLabel.USER_BLOCKED_TILL));
				userList.add(user);
			}
		
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, statement, resultSet);
		}	
		
		return userList;
	}

	@Override
	public void setBlock(int idUser, String date) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_USER_BLOCK_BY_ID);
			preparedStatement.setString(1, date);
			preparedStatement.setInt(2, idUser);
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
	public void removeBlock(int idUser) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_USER_BLOCK_BY_ID);
			preparedStatement.setString(1, null);
			preparedStatement.setInt(2, idUser);
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
	public double getBalance(int idUser) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		PreparedStatement preparedStatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		double balance = 0;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_USER_BALANCE_BY_ID);
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			balance = resultSet.getInt(ColumnLabel.USER_BALANCE);
		
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return balance;
	}

	@Override
	public void addBalance(double balance, int idUser) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_USER_ADD_BALANCE);
			preparedStatement.setDouble(1, balance);	
			preparedStatement.setInt(2, idUser);
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement);
		}
		
	}
	
}
