package by.epam.swift.controller.command.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.User;
import by.epam.swift.controller.command.Command;
import by.epam.swift.controller.configuration.AttributeName;
import by.epam.swift.controller.configuration.PageName;
import by.epam.swift.controller.configuration.ParameterName;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class SetBlockUser implements Command {
	private static final Logger LOGGER = Logger.getLogger(SetBlockUser.class);  
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String blockDate = request.getParameter(ParameterName.USER_BLOCK_TO);
		int idUser = Integer.parseInt(request.getParameter(ParameterName.USER_ID));
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try {
			userService.setBlock(idUser, blockDate);
			List<User> list = userService.getUserList();
			request.setAttribute(AttributeName.LIST, list);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_USER_LIST);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
