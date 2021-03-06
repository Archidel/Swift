package by.epam.swift.controller.command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.User;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

public class UploadDataToSetBlock implements Command {
	private static final Logger LOGGER = Logger.getLogger(UploadDataToSetBlock.class);

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int idUser = Integer.parseInt(request.getParameter(ParameterName.USER_ID));
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try {
			User user = userService.getUserById(idUser);
			request.setAttribute(AttributeName.USER, user);
			request.getRequestDispatcher(PageName.SET_USER_BLOCK_PAGE).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}

	}

}
