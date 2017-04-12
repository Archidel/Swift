package by.epam.swift.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import by.epam.swift.bean.Agreement;
import by.epam.swift.dao.AgreementDAO;
import by.epam.swift.dao.ColumnLabel;
import by.epam.swift.dao.SQLCommand;
import by.epam.swift.dao.connection.ConnectionPool;
import by.epam.swift.dao.exception.ConnectionPoolException;
import by.epam.swift.dao.exception.DAOException;

public class AgreementDAOImpl implements AgreementDAO {

	@Override
	public int getIdAgreementByUserId(int idUser) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int idAgreement = 0;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_AGREEMENT_ID_BY_USERID);
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				idAgreement = resultSet.getInt(ColumnLabel.AGREEMENT_ID);
			}
			
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return idAgreement;
	}

	@Override
	public void createAgreement(int idUser, String date) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.INSERT_AGREEMENT);
			preparedStatement.setInt(1, idUser);
			preparedStatement.setString(2, date);
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
	public List<Agreement> getAgreementList(int begin, int offset) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Agreement> list = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_AGREEMENT_ACTIVE_STATUS_LIMIT);
			preparedStatement.setInt(1, begin);
			preparedStatement.setInt(2, offset);
			resultSet = preparedStatement.executeQuery();
			list = new LinkedList<Agreement>();
			Agreement agreement = null;
			
			while(resultSet.next()){
				agreement = new Agreement();
				agreement.setIdAgreement(resultSet.getInt(ColumnLabel.AGREEMENT_ID));
				agreement.setIdUser(resultSet.getInt(ColumnLabel.USER_ID));
				agreement.setDateCreation(resultSet.getDate(ColumnLabel.AGREEMENT_DATE_CREATION));
				agreement.setIdAdmin(resultSet.getInt(ColumnLabel.AGREEMENT_ADMIN_ID));
				list.add(agreement);
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
	public int getAmountEntriesListAgreement() throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int numerEntries = 0;
		
		try {
			connection = pool.take();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQLCommand.SELECT_AGREEMENT_ACTIVE_STATUS_COUNT);
			resultSet.next();
			numerEntries = resultSet.getInt(ColumnLabel.AMOUNT);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		
		return numerEntries;
	}

	@Override
	public Agreement getAgreementById(int idAgreement) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Agreement agreement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_AGREEMENT_BY_ID);
			preparedStatement.setInt(1, idAgreement);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			agreement = new Agreement();
			agreement.setIdAgreement(idAgreement);
			agreement.setIdUser(resultSet.getInt(ColumnLabel.USER_ID));
			agreement.setIdAdmin(resultSet.getInt(ColumnLabel.AGREEMENT_ADMIN_ID));
			agreement.setStatus(resultSet.getBoolean(ColumnLabel.AGREEMENT_STATUS));
			agreement.setDateCreation(resultSet.getDate(ColumnLabel.AGREEMENT_DATE_CREATION));
		
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return agreement;
	}

	@Override
	public void removeAgreement(int idAgreement, int idAdmin) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_AGREEMENT_ADMINID_STATUS);
			preparedStatement.setInt(1, idAdmin);
			preparedStatement.setInt(2, idAgreement);
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
	public void acceptAgreement(int idAgreement, int idAdmin) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_AGREEMENT_ADMINID);
			preparedStatement.setInt(1, idAdmin);
			preparedStatement.setInt(2, idAgreement);
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
	public int getIdAgreementByUserIdAccepted(int idUser) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int idAgreement = 0;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_AGREEMENT_ID_BY_USERID_ACCEPTED);
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			idAgreement = resultSet.getInt(ColumnLabel.AGREEMENT_ID);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			throw new DAOException(e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return idAgreement;
	}

}
