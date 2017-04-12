package by.epam.swift.controller.command.initialization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.service.InitializationSourceService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class DestroySource implements Command {
	private static final Logger LOGGER = Logger.getLogger(DestroySource.class);
	 
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory factory = ServiceFactory.getInstance();
		InitializationSourceService initializationService = factory.getInitializationSourceService();
		 
		try {
			initializationService.destroySource();
			LOGGER.info("Database has been destroyed");
		} catch (ServiceException e) {
			LOGGER.info("Database has not been destroyed");
			LOGGER.error(e);
		}
	}

}
