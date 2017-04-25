package by.epam.swift.controller.command.agreement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import by.epam.swift.bean.Agreement;
import by.epam.swift.bean.User;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.AgreementService;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class GetSingleAgreement implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetSingleAgreement.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idAgreement = Integer.parseInt(request.getParameter(ParameterName.AGREEMENT_ID));
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AgreementService agreementService = serviceFactory.getAgreementService();
		UserService userService = serviceFactory.getUserService();
		
		try {
			Agreement agreement = agreementService.getAgreementById(idAgreement);
			User user = userService.getUserById(agreement.getIdUser());
			request.setAttribute(AttributeName.MORE, agreement);
			request.setAttribute(AttributeName.USER, user);
			request.getRequestDispatcher(PageName.GET_SINGLE_AGREEMENT_PAGE).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}
}
