package by.epam.swift.controller.command.request;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class AcceptRequestOnService implements Command {
	private static final Logger LOGGER = Logger.getLogger(AcceptRequestOnService.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idRequest = Integer.parseInt(request.getParameter(ParameterName.REQUEST_ID));
		int idUser = Integer.parseInt(request.getParameter(ParameterName.USER_ID));
		boolean action = Boolean.parseBoolean(request.getParameter(ParameterName.STATUS_OF_OPERATION));
		
		ServiceFactory factory = ServiceFactory.getInstance();
		RequestService requestService = factory.getRequestService();
	
		try {
			requestService.acceptRequestOnService(idRequest, idUser, action);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_REQUEST_ON_SERVICE_LIST_ADMIN);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
