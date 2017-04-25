package by.epam.swift.controller.command.user;

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
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class AddBalance implements Command {
	private static final Logger LOGGER = Logger.getLogger(AddBalance.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AttributeName.USER);
		int idUser = user.getId();
		String balance = request.getParameter(ParameterName.USER_BALANCE);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try {
			userService.addBalance(balance, idUser);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_BALANCE_SUCCESS);		
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_BALANCE_ERROR);
			LOGGER.error(e);
		}
	}

}
