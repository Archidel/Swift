package by.epam.swift.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import by.epam.swift.bean.Tariff;
import by.epam.swift.dao.ColumnLabel;
import by.epam.swift.dao.SQLCommand;
import by.epam.swift.dao.TariffDAO;
import by.epam.swift.dao.connection.ConnectionPool;
import by.epam.swift.dao.exception.ConnectionPoolException;
import by.epam.swift.dao.exception.DAOException;

public class TariffDAOImpl implements TariffDAO {
	
	@Override
	public List<Tariff> searchTariff(String tariffName, int begin, int offset) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		List<Tariff> list = null;
		
		try {
			connection = pool.take();
			list = new ArrayList<Tariff>();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_BY_TITLE_LIMIT);
			preparedStatement.setString(1, tariffName);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, offset);
			resultSet = preparedStatement.executeQuery();
			Tariff tariff = null;
			
			while(resultSet.next()){
				tariff = new Tariff();
				tariff.setId(resultSet.getInt(ColumnLabel.TARIFF_ID));
				tariff.setTitle(tariffName);
				tariff.setDescription(resultSet.getString(ColumnLabel.TARIFF_DESCRIPTION));
				tariff.setType(resultSet.getString(ColumnLabel.TARIFF_TYPE_TITLE).toUpperCase());
				list.add(tariff);
			}
			
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}	

		return list;
	}

	@Override
	public int getAmountEntriesSearchTariff(String tariff) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int numberEntries = 0;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_BY_TITLE_COUNT);
			preparedStatement.setString(1, tariff);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			numberEntries = resultSet.getInt(ColumnLabel.AMOUNT);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}		
		
		return numberEntries;
	}

	@Override
	public void addTariffType(String tariffType) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.INSERT_ADD_TARIFF_TYPE);
			preparedStatement.setString(1, tariffType);
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
	public List<Tariff> getListTariffActiveStatus(int begin, int offset, String tariffType) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Tariff> list = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_ACTIVE_STATUS_LIMIT);
			preparedStatement.setString(1, tariffType);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, offset);
			resultSet = preparedStatement.executeQuery();
			list = new LinkedList<Tariff>();
			Tariff tariff = null;
			
			while(resultSet.next()){
				tariff = new Tariff();
				tariff.setId(resultSet.getInt(ColumnLabel.TARIFF_ID));
				tariff.setTitle(resultSet.getString(ColumnLabel.TARIFF_TITLE));
				tariff.setType(resultSet.getString(ColumnLabel.TARIFF_TYPE_TITLE).toUpperCase());
				tariff.setDescription(resultSet.getString(ColumnLabel.TARIFF_DESCRIPTION));
				tariff.setPrice(resultSet.getDouble(ColumnLabel.TARIFF_PRICE));
				tariff.setStatus(resultSet.getBoolean(ColumnLabel.TARIFF_STATUS));
				list.add(tariff);
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
	public List<Tariff> getListTariffInactiveStatus(int begin, int offset, String tariffType) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Tariff> list = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_INACTIVE_STATUS_LIMIT);
			preparedStatement.setString(1, tariffType);	
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, offset);
			resultSet = preparedStatement.executeQuery();
			list = new LinkedList<Tariff>();
			Tariff tariff = null;
			
			while(resultSet.next()){
				tariff = new Tariff();
				tariff.setId(resultSet.getInt(ColumnLabel.TARIFF_ID));
				tariff.setTitle(resultSet.getString(ColumnLabel.TARIFF_TITLE));
				tariff.setType(resultSet.getString(ColumnLabel.TARIFF_TYPE_TITLE).toUpperCase());
				tariff.setDescription(resultSet.getString(ColumnLabel.TARIFF_DESCRIPTION));
				tariff.setPrice(resultSet.getDouble(ColumnLabel.TARIFF_PRICE));
				tariff.setStatus(resultSet.getBoolean(ColumnLabel.TARIFF_STATUS));
				list.add(tariff);
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
	public Tariff getTariffById(int idTariff) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Tariff tariff = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_BY_ID);
			preparedStatement.setInt(1, idTariff);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				tariff = new Tariff();
				tariff.setId(idTariff);
				tariff.setTitle(resultSet.getString(ColumnLabel.TARIFF_TITLE));
				tariff.setType(resultSet.getString(ColumnLabel.TARIFF_TYPE_TITLE));
				tariff.setDescription(resultSet.getString(ColumnLabel.TARIFF_DESCRIPTION));
				tariff.setPrice(resultSet.getDouble(ColumnLabel.TARIFF_PRICE));
				tariff.setStatus(resultSet.getBoolean(ColumnLabel.TARIFF_STATUS));
			}
			
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);	
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}				

		return tariff;
	}

	@Override
	public String getTariffTitleById(int idTariff) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String title = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_TITLE_BY_ID);
			preparedStatement.setInt(1, idTariff);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				title = resultSet.getString(ColumnLabel.TARIFF_TITLE);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}		
		
		return title;
	}

	@Override
	public void editTariff(Tariff tariff) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_TARIFF);
			preparedStatement.setString(1, tariff.getTitle());
			preparedStatement.setDouble(2,tariff.getPrice());
			preparedStatement.setString(3,tariff.getDescription());
			preparedStatement.setInt(4,tariff.getId());
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
	public void addTariff(String title, String description, int type, double price) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Statement statement = null;
		
		try {
			connection = pool.take();
			statement = connection.createStatement();
			statement.execute(SQLCommand.FOREING_KET_CHECKS_FALSE);
			preparedStatement = connection.prepareStatement(SQLCommand.INSERT_TARIFF);
			preparedStatement.setString(1, title);
			preparedStatement.setDouble(2, price);
			preparedStatement.setInt(3, type);
			preparedStatement.setString(4, description);
			preparedStatement.executeUpdate();
			
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, statement, preparedStatement);
		}
	}

	@Override
	public void removeTariff(int idTariff, boolean tariffStatus) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_TARIFF_STATUS);
			preparedStatement.setInt(2, idTariff);
			if(tariffStatus){
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
	public boolean getTariffStatusById(int idTariff) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean status = false;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_STATUS_BY_ID);
			preparedStatement.setInt(1, idTariff);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				status = resultSet.getBoolean(ColumnLabel.TARIFF_STATUS);
			}
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
	public int getAmountEntriesListTariffActiveStatus(String tariffType) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int numberEntries = 0;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_ACTIVE_STATUS_COUNT);
			preparedStatement.setString(1, tariffType);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			numberEntries = resultSet.getInt(ColumnLabel.AMOUNT);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}		
		
		return numberEntries;
	}

	@Override
	public int getAmountEntriesListTariffInactiveStatus(String tariffType) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int numberEntries = 0;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_INACTIVE_STATUS_COUNT);
			preparedStatement.setString(1, tariffType);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			numberEntries = resultSet.getInt(ColumnLabel.AMOUNT);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}		
		
		return numberEntries;
	}

	@Override
	public int getIdTariffTypeByTitle(String title) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int idTariffType = 0;
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_ID_TYPE_BY_TITLE);
			preparedStatement.setString(1, title);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			idTariffType = resultSet.getInt(ColumnLabel.TARIFF_TYPE_ID);			
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}

		return idTariffType;
	}

	@Override
	public List<String> getListTypeOfTariff() throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<String> list = null;
		
		try {
			connection = pool.take();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQLCommand.SELECT_TARIFF_TYPE_TITLE);		
			list = new ArrayList<String>();
			
			while (resultSet.next()) {
				list.add(resultSet.getString(ColumnLabel.TARIFF_TYPE_TITLE));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return list;
	}

	@Override
	public List<String> getListTitleOfTariff() throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<String> list = null;
		
		try {
			connection = pool.take();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQLCommand.SELECT_TARIFF_TITLE);		
			list = new LinkedList<String>();
			
			while (resultSet.next()) {
				list.add(resultSet.getString(ColumnLabel.TARIFF_TITLE));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return list;
	}

	@Override
	public List<Tariff> getListTariffActiveStatus() throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Tariff> list = null;
		
		try {
			connection = pool.take();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQLCommand.SELECT_TARIFF_ACTIVE_STATUS_NO_TYPE);
			list = new LinkedList<Tariff>();
			Tariff tariff = null;
			
			while(resultSet.next()){
				tariff = new Tariff();
				tariff.setId(resultSet.getInt(ColumnLabel.TARIFF_ID));
				tariff.setTitle(resultSet.getString(ColumnLabel.TARIFF_TITLE));
				tariff.setType(resultSet.getString(ColumnLabel.TARIFF_TYPE_TITLE).toUpperCase());
				tariff.setDescription(resultSet.getString(ColumnLabel.TARIFF_DESCRIPTION));
				tariff.setPrice(resultSet.getDouble(ColumnLabel.TARIFF_PRICE));
				tariff.setStatus(resultSet.getBoolean(ColumnLabel.TARIFF_STATUS));
				list.add(tariff);
			}
		
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, statement, resultSet);
		}	
		
		return list;
	}

	@Override
	public int getIdTariffByTitleAndType(String title, int type) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int idTariff = 0;
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_TARIFF_ID_BY_TITLE_AND_TYPE);
			preparedStatement.setString(1, title);
			preparedStatement.setInt(2, type);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			idTariff = resultSet.getInt(ColumnLabel.TARIFF_ID);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}	
		
		return idTariff;
	}

}
