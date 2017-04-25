package by.epam.swift.service;

import by.epam.swift.service.exception.ServiceException;;
/**Interface initialization Service.
 * @author Archangel
 */
public interface InitializationSourceService {
	/**Method for initialization source when server is started.
	 * @throws ServiceException
	 */
	void initSource() throws ServiceException;
	/**Method for initialization source when server is shutting down.
	 * @throws ServiceException
	 */
	void destroySource() throws ServiceException;
}
