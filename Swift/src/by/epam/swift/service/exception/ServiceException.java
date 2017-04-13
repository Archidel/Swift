package by.epam.swift.service.exception;

/**This is an exception for working on a Service layer
 * @author Archangel
 *
 */
public class ServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public ServiceException() {
		super();
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}
	
	/**
	 * @param exception
	 */
	public ServiceException(Exception e) {
		super(e);
	}
	
	/**
	 * @param message
	 * @param exception
	 */
	public ServiceException(String message, Exception e) {
		super(message, e);
	}

}
