package by.epam.swift.controller.command.request;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.swift.bean.User;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class MakeRequestOnService implements Command {
	private static final Logger LOGGER = Logger.getLogger(MakeRequestOnService.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AttributeName.USER);
		
		int idUser = user.getId();
		String title = request.getParameter(ParameterName.TARIFF_TITLE);
		String type = request.getParameter(ParameterName.TARIFF_TYPE);
		String datePeriod = request.getParameter(ParameterName.TARIFF_DATE_PERIOD);
		String serviceAction = request.getParameter(ParameterName.REQUEST_SERVICE_ACTION);
		
		ServiceFactory factory  = ServiceFactory.getInstance();
		RequestService requestService = factory.getRequestService();
		boolean statusOperation = false;
		
		try {
			requestService.makeRequestOnService(title, type, datePeriod, serviceAction, idUser);
			statusOperation = true;
		} catch (ServiceException e) {
			LOGGER.error(e);
		}

		try {
			if(statusOperation){
				response.sendRedirect(request.getContextPath() + PageName.REDIRECT_MAKE_REQUEST_ON_SERVICE_SUCCESS);			
			}else{
				response.sendRedirect(request.getContextPath() + PageName.REDIRECT_MAKE_REQUEST_ON_SERVICE_ERROR);	
			}	
		} catch (IOException e) {
			LOGGER.error(e);
		}
		
	}

}
