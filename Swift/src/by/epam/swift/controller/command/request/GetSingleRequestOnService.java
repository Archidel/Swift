package by.epam.swift.controller.command.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.Agreement;
import by.epam.swift.bean.RequestOnService;
import by.epam.swift.bean.User;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.AgreementService;
import by.epam.swift.service.RequestService;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class GetSingleRequestOnService implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetSingleRequestOnService.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		int idRequest = Integer.parseInt(request.getParameter(ParameterName.REQUEST_ID));
		
		ServiceFactory factory = ServiceFactory.getInstance();
		RequestService requestService = factory.getRequestService();
		UserService userService = factory.getUserService();
		AgreementService agreementService = factory.getAgreementService();
		
		try {
			RequestOnService requestOnService = requestService.getRequestOnServiceById(idRequest);
			Agreement agreement = agreementService.getAgreementById(requestOnService.getIdAgreement());
			User user = userService.getUserById(agreement.getIdUser());
			request.setAttribute(AttributeName.USER, user);
			request.setAttribute(AttributeName.MORE, requestOnService);
		} catch (ServiceException e) {
			LOGGER.error(e);
		}
		
		try {
			request.getRequestDispatcher(PageName.GET_SINGLE_REQUEST_ON_SERVICE_PAGE).forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
		
	}

}
