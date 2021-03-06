package by.epam.swift.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import by.epam.swift.bean.RequestOnService;
import by.epam.swift.dao.ColumnLabel;
import by.epam.swift.dao.RequestServiceDAO;
import by.epam.swift.dao.SQLCommand;
import by.epam.swift.dao.connection.ConnectionPool;
import by.epam.swift.dao.exception.ConnectionPoolException;
import by.epam.swift.dao.exception.DAOException;

/** The class implements the interface {@link RequestServiceDAO}
 * @author Archangel
 */
public class RequestServiceDAOImpl implements RequestServiceDAO {

	@Override
	public void makeRequestOnService(int idAgreement, int idTariff, String date, boolean serviceAction) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			statement = connection.createStatement();
			statement.executeQuery(SQLCommand.FOREING_KEY_CHECKS_FALSE);
			preparedStatement = connection.prepareStatement(SQLCommand.INSERT_REQUEST_ON_SERVICE);
			preparedStatement.setInt(1, idAgreement);
			preparedStatement.setInt(2, idTariff);
			preparedStatement.setString(3, date);
			preparedStatement.setBoolean(4, serviceAction);
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'inser_request_on_serivce'", e);
		}finally {
			pool.closeConnection(connection, statement, preparedStatement);
		}		
		
	}

	@Override
	public List<RequestOnService> getRequestOnServiceList(int idAgreement, int begin, int offset) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<RequestOnService> list = null;

		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_USER_REQUEST_ON_SERVLICE_LIST_LIMIT);
			preparedStatement.setInt(1, idAgreement);
			preparedStatement.setInt(2, begin);
			preparedStatement.setInt(3, offset);
			resultSet = preparedStatement.executeQuery();
			
			list = new LinkedList<RequestOnService>();
			RequestOnService requestOnService = null;
			
			while(resultSet.next()){
				requestOnService = new RequestOnService();
				requestOnService.setIdAgreement(idAgreement);
				requestOnService.setIdRequest(resultSet.getInt(ColumnLabel.REQUEST_ON_SERVICE_ID));
				requestOnService.setIdTariff(resultSet.getInt(ColumnLabel.TARIFF_ID));
				requestOnService.setDate(resultSet.getDate(ColumnLabel.REQUEST_ON_SERVICE_DATE));
				requestOnService.setServiceAction(resultSet.getBoolean(ColumnLabel.REQUEST_ON_SERVICE_ACTION));
				list.add(requestOnService);
			}
		
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_user_request_on_service_list_limit'", e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}	
		
		return list;
	}

	@Override
	public int getAmountEntriesRequestList(int idUser) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int amountEntries = 0;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_USER_REQUEST_ON_SERVICE_LIST_COUNT);
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			amountEntries = resultSet.getInt(ColumnLabel.AMOUNT);
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_user_request_on_service_list_count'", e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return amountEntries;
	}

	@Override
	public List<RequestOnService> getRequestOnServiceList(int begin, int offset) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<RequestOnService> list = null;

		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_ADMIN_REQUEST_ON_SERVLICE_LIST_LIMIT);
			preparedStatement.setInt(1, begin);
			preparedStatement.setInt(2, offset);
			resultSet = preparedStatement.executeQuery();
			
			list = new LinkedList<RequestOnService>();
			RequestOnService requestOnService = null;
			
			while(resultSet.next()){
				requestOnService = new RequestOnService();
				requestOnService.setIdAgreement(resultSet.getInt(ColumnLabel.AGREEMENT_ID));
				requestOnService.setIdRequest(resultSet.getInt(ColumnLabel.REQUEST_ON_SERVICE_ID));
				requestOnService.setIdTariff(resultSet.getInt(ColumnLabel.TARIFF_ID));
				requestOnService.setDate(resultSet.getDate(ColumnLabel.REQUEST_ON_SERVICE_DATE));
				requestOnService.setServiceAction(resultSet.getBoolean(ColumnLabel.REQUEST_ON_SERVICE_ACTION));
				list.add(requestOnService);
			}
		
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_admin_request_on_service_list_limit'", e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}	
		
		return list;
	}

	@Override
	public int getAmountEntriesRequestList() throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int amountEntries = 0;
		
		try {
			connection = pool.take();
			statement =  connection.createStatement();
			resultSet = statement.executeQuery(SQLCommand.SELECT_ADMIN_REQUEST_ON_SERVICE_LIST_COUNT);
			resultSet.next();
			amountEntries = resultSet.getInt(ColumnLabel.AMOUNT);
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_admin_request_on_service_list_count'", e);
		}finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		
		return amountEntries;
	}

	@Override
	public RequestOnService getRequestOnServiceById(int idRequest) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		RequestOnService requestOnService = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_REQUEST_BY_ID);
			preparedStatement.setInt(1, idRequest);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				requestOnService = new RequestOnService();
				requestOnService.setIdRequest(idRequest);
				requestOnService.setIdAgreement(resultSet.getInt(ColumnLabel.AGREEMENT_ID));
				requestOnService.setIdTariff(resultSet.getInt(ColumnLabel.TARIFF_ID));
				requestOnService.setDate(resultSet.getDate(ColumnLabel.REQUEST_ON_SERVICE_DATE));
				requestOnService.setStatus(resultSet.getBoolean(ColumnLabel.REQUEST_ON_SERVICE_STATUS));
				requestOnService.setServiceAction(resultSet.getBoolean(ColumnLabel.REQUEST_ON_SERVICE_ACTION));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_request_by_id'", e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}	
		
		return requestOnService;
	}

	@Override
	public void removeRequestOnService(int idRequestOnService) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.UPDATE_REQUEST_STATUS);
			preparedStatement.setInt(1, idRequestOnService);
			preparedStatement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'insert_news'", e);
		}finally {
			pool.closeConnection(connection, preparedStatement);
		}
		
	}

	@Override
	public void acceptRequestOnService(int idUser, int idTariff, boolean action, int idAdmin, double tariffPrice) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		PreparedStatement preparedStatement3 = null;
		
		try {
			connection = pool.take();
			statement = connection.createStatement();
			statement.executeQuery(SQLCommand.FOREING_KEY_CHECKS_FALSE);			
			connection.setAutoCommit(false);		
			//The second operation
			if(action){
				preparedStatement1 = connection.prepareStatement(SQLCommand.INSERT_REQUEST_ENABLE_TARIFF);
				preparedStatement1.setInt(1, idUser);
				preparedStatement1.setInt(2, idTariff);
				preparedStatement1.executeUpdate();
			}else{
				preparedStatement1 = connection.prepareStatement(SQLCommand.DElETE_REQUEST_TARIFF);
				preparedStatement1.setInt(1, idUser);
				preparedStatement1.setInt(2, idTariff);
				preparedStatement1.executeUpdate();
			}			
			//The third operation
			preparedStatement2 = connection.prepareStatement(SQLCommand.UPDATE_USER_ADD_BALANCE);
			preparedStatement2.setDouble(1, tariffPrice);
			preparedStatement2.setInt(2, idAdmin);
			preparedStatement2.executeUpdate();
			//The fourth operation
			preparedStatement3 = connection.prepareStatement(SQLCommand.UPDATE_WITHDRAW_MONEY);
			preparedStatement3.setDouble(1, tariffPrice);
			preparedStatement3.setInt(2, idUser);
			preparedStatement3.executeUpdate();	
			connection.commit();
			
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			try {
				if(connection != null){
					connection.rollback();					
				}
			} catch (SQLException e1) {
				throw new DAOException("Error executing the rollback ", e1);			}
			throw new DAOException("Error executing the query 'insert_request_enable_tariff or update_request_disable_tariff, update_user_add_balance, update_withdraw_money'", e);
		}finally {
			pool.closeConnection(connection, statement, preparedStatement1, preparedStatement2, preparedStatement3);
		}
		
	}

	@Override
	public List<Integer> getUserTariffList(int idUser) throws DAOException {
		ConnectionPool pool  = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Integer> list = null;
		
		try {
			connection = pool.take();
			preparedStatement = connection.prepareStatement(SQLCommand.SELECT_USER_TARIFF_LIST);
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			list = new ArrayList<Integer>();
			while (resultSet.next()) {
				list.add(resultSet.getInt(ColumnLabel.TARIFF_ID));
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("There was a problem connecting to the database", e);
		} catch (SQLException e) {
			throw new DAOException("Error executing the query 'select_user_tariff_list'",e);
		}finally {
			pool.closeConnection(connection, preparedStatement, resultSet);
		}
		
		return list;
	}

}
