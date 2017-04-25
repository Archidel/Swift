package by.epam.swift.controller.command.initialization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.service.InitializationSourceService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/** <h1>InitializationSource</h1>
 * This class has implementation {@link Command}.
 * Class is used for initialization source.
 * @author Archangel
 */
public class InitializationSource implements Command {
	private static final Logger LOGGER = Logger.getLogger(InitializationSource.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory factory = ServiceFactory.getInstance();
		InitializationSourceService initializationService = factory.getInitializationSourceService();
		
		try {
			initializationService.initSource();
			LOGGER.info("Database has been initialized");
		} catch (ServiceException e) {
			LOGGER.info("Database has not been initialized");
			LOGGER.error(e);
		}	
	}

}
