package by.epam.swift.controller.command.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.swift.bean.RequestOnService;
import by.epam.swift.bean.User;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.controller.configuration.RequestMessage;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class AcceptRequestOnService implements Command {
	private static final Logger LOGGER = Logger.getLogger(AcceptRequestOnService.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		int idReqest = Integer.parseInt(request.getParameter(ParameterName.REQUEST_ID));
		String typeTariff = request.getParameter(ParameterName.TARIFF_TYPE);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AttributeName.USER);
		int idUser = user.getId();
		
		ServiceFactory factory = ServiceFactory.getInstance();
		RequestService requestService = factory.getRequestService();
	
		try {
			requestService.applyRequest(idReqest, idUser, typeTariff);
			List<RequestOnService> list = requestService.getRequestList();	
			request.setAttribute(AttributeName.LIST, list);
			request.setAttribute(AttributeName.STATUS_SUCCESS, RequestMessage.APPLY_REQUEST_SUCCESS);
		} catch (ServiceException e) {
			request.setAttribute(AttributeName.STATUS_ERROR, RequestMessage.APPLY_REQUEST_ERROR);
			LOGGER.error(e);
		}
		
		try {
			request.getRequestDispatcher(PageName.MANAGEMENT_SERVICE_PAGE).forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
		
	}

}
