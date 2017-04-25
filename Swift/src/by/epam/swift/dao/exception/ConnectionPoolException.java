package by.epam.swift.dao.exception;

/**This is an exception for working on a DAO layer. This exception is used to work with the connection pool.
 * @author Archangel
 *
 */
public class ConnectionPoolException extends Exception{
	private static final long serialVersionUID = 1L;

	public ConnectionPoolException() {
		super();
	}
	/** 
	 * @param message
	 */
	public ConnectionPoolException(String message) {
		super(message);
	}
	/**
	 * @param excepton
	 */
	public ConnectionPoolException(Exception e) {
		super(e);
	}
	/** 
	 * @param message
	 * @param exeption
	 */
	public ConnectionPoolException(String message, Exception e) {
		super(message, e);
	}
}
