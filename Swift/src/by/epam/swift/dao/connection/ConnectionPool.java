package by.epam.swift.dao.connection;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import by.epam.swift.dao.connection.manager.DBParameter;
import by.epam.swift.dao.connection.manager.DBResourceManager;
import by.epam.swift.dao.exception.ConnectionPoolException;
import by.epam.swift.dao.exception.DAOException;

/**A class that provides connections for user requests
 * @author Archangel
 *
 */
public final class ConnectionPool implements Closeable{
	private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);  
	
	private static final ConnectionPool instance = new ConnectionPool();
	private BlockingQueue<Connection> freeConnection;
	private BlockingQueue<Connection> busyConnection;
	
	private int poolsize;
	private String driver;
	private String user;
	private String password;
	private String url;
 	
	/** This constructor serves to initialize the connection parameters to the database */
	private ConnectionPool() {
		DBResourceManager resourceManager = DBResourceManager.getInstance();
		this.driver = resourceManager.getValue(DBParameter.DB_DRIVER);
		this.user = resourceManager.getValue(DBParameter.DB_USER);
		this.password = resourceManager.getValue(DBParameter.DB_PASSWORD);
		this.url = resourceManager.getValue(DBParameter.DB_URL);
		
		try{
			this.poolsize = Integer.parseInt(resourceManager.getValue(DBParameter.DB_POOLSIZE));
		}catch (NumberFormatException e) {
			this.poolsize = 6;
		}	
	}
	
	/**This method creates free connections. And also stores busy and free connections.
	 * @throws ConnectionPoolException
	 */
	public void init() throws ConnectionPoolException{
		freeConnection = new ArrayBlockingQueue<Connection>(poolsize);
		busyConnection = new ArrayBlockingQueue<Connection>(poolsize);
		
		try{
			Class.forName(driver);
			for(int i = 0; i < poolsize; i++){
				freeConnection.add(DriverManager.getConnection(url, user, password));
			}
		}catch (ClassNotFoundException e) {
			throw new ConnectionPoolException("Can't find database driver class", e);
		} catch (SQLException e) {
			throw new ConnectionPoolException("SQLException in ConnectionPool", e);
		}
		
	}
	
	/** The method provides a free connection
	 * @return {@link Connection}
	 * @throws ConnectionPoolException
	 */
	public Connection take() throws ConnectionPoolException{
		Connection connection = null;
		try {
			connection = freeConnection.take();
			busyConnection.put(connection);
		} catch (InterruptedException e) {
			throw new ConnectionPoolException("Error connecting to the data source", e);
		}
		return connection;
	}
	
	/**Method of transferring a connection from a statute busy status is free
	 * @param connection
	 * @throws InterruptedException
	 * @throws DAOException
	 */
	public void free(Connection connection) throws InterruptedException, DAOException{
		if(connection == null){
			throw new DAOException("Connection is null");
		}
		
		Connection tempConnection = connection;
		connection = null;
		busyConnection.remove(tempConnection);
		freeConnection.put(tempConnection);
	}
	
	public static ConnectionPool getInstance(){
		return instance;
	}
	
	@Override
	public void close() throws IOException {
		List<Connection> listConnection = new ArrayList<Connection>();
		listConnection.addAll(busyConnection);
		listConnection.addAll(freeConnection);
		
		for(Connection connection: listConnection){
			try {
				if(connection != null){
					connection.close();
				}
			} catch (SQLException e) {
				LOGGER.error(e);
			}
		}
	}
	
	/** Overload method for close all connection.
	 * @param con
	 * @param st
	 * @param preSt
	 * @param rs
	 */
	public void closeConnection(Connection con, Statement st, PreparedStatement preSt, ResultSet rs){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "Statement isn't closed", e);
			}
		}
		
		if(preSt != null){
			try {
				preSt.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "PrepareStatement ins't closed", e);
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "ResultSet ins't closed", e);
			}
		}
	}

	/** Overload method for close all connection.
	 * @param con
	 * @param st
	 */
	public void closeConnection(Connection con, Statement st){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "Statement isn't closed", e);
			}
		}
	}
	
	/** Overload method for close all connection.
	 * @param con
	 * @param preSt
	 */
	public void closeConnection(Connection con, PreparedStatement preSt){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(preSt != null){
			try {
				preSt.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "PrepareStatement ins't closed", e);
			}
		}
	}
	
	/** Overload method for close all connection.
	 * @param con
	 * @param rs
	 */
	public void closeConnection(Connection con, ResultSet rs){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "ResultSet ins't closed", e);
			}
		}
	}
	
	/** Overload method for close all connection.
	 * @param con
	 * @param st
	 * @param preSt
	 */
	public void closeConnection(Connection con, Statement st, PreparedStatement preSt){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "Statement isn't closed", e);
			}
		}
		
		if(preSt != null){
			try {
				preSt.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "PrepareStatement ins't closed", e);
			}
		}
		
	}
	
	/** Overload method for close all connection.
	 * @param con
	 * @param preSt
	 * @param rs
	 */
	public void closeConnection(Connection con, PreparedStatement preSt, ResultSet rs){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(preSt != null){
			try {
				preSt.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "PrepareStatement ins't closed", e);
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "ResultSet ins't closed", e);
			}
		}
	}
	
	/** Overload method for close all connection.
	 * @param con
	 * @param st
	 * @param rs
	 */
	public void closeConnection(Connection con, Statement st, ResultSet rs){
		if(con != null){
			try {
				free(con);
			} catch (InterruptedException | DAOException e) {
				LOGGER.log(Level.ERROR, "Connection isn't return to the pool", e);
			}
		}
		
		if(st != null){
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "Statement isn't closed", e);
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, "ResultSet ins't closed", e);
			}
		}
	}
	
	
}
