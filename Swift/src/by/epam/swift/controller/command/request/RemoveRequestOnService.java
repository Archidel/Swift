package by.epam.swift.controller.command.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.RequestOnService;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.controller.configuration.RequestMessage;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class RemoveRequestOnService implements Command {
	private static final Logger LOGGER = Logger.getLogger(RemoveRequestOnService.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		int idReqest = Integer.parseInt(request.getParameter(ParameterName.REQUEST_ID));
		ServiceFactory factory = ServiceFactory.getInstance();
		RequestService requestService = factory.getRequestService();
	
		try {
			requestService.removeRequestOnService(idReqest);
			List<RequestOnService> list = requestService.getRequestList();	
			request.setAttribute(AttributeName.LIST, list);
			request.setAttribute(AttributeName.STATUS_SUCCESS, RequestMessage.REMOVE_REQUEST_SUCCESS);
		} catch (ServiceException e) {
			request.setAttribute(AttributeName.STATUS_ERROR, RequestMessage.REMOVE_REQUEST_ERROR);
			LOGGER.error(e);
		}
		
		try {
			request.getRequestDispatcher(PageName.MANAGEMENT_SERVICE_PAGE).forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
	}

}
