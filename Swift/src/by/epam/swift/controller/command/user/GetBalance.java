package by.epam.swift.controller.command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class GetBalance implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetBalance.class);

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		String idUser = request.getParameter(ParameterName.USER_ID);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try {
			double balance = userService.getBalance(idUser);
			request.setAttribute(AttributeName.MORE, balance);
		} catch (ServiceException e) {
			LOGGER.error(e);
		}

		try {
			request.getRequestDispatcher(PageName.USER_BALANCE).forward(request, response);
		} catch (ServletException | IOException e) {
			LOGGER.error(e);
		}
		
	}

}
