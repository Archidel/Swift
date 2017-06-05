package by.epam.swift.controller.command.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for get user balance.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class GetBalance implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetBalance.class);

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String idUser = request.getParameter(ParameterName.USER_ID);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try {
			double balance = userService.getBalance(idUser);
			request.setAttribute(AttributeName.MORE, balance);
			request.getRequestDispatcher(PageName.USER_BALANCE_PAGE).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
