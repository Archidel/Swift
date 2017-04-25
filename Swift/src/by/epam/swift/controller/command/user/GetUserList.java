package by.epam.swift.controller.command.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
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

/**Class for get user list.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class GetUserList implements Command {
	private static final Logger LOGGER = Logger.getLogger(GetUserList.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int numberPage = Integer.parseInt(request.getParameter(ParameterName.NUMBER_PAGE));
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try {
			request.setAttribute(AttributeName.NUMBER_PAGE, numberPage);
			int numberEntries = userService.getAmountEntriesListUser();	
			request.setAttribute(AttributeName.AMOUNT_RESULT, numberEntries);
			int amountPage = (int) Math.ceil(numberEntries * 1.0 / 10);
			request.setAttribute(AttributeName.AMOUNT_PAGE, amountPage);
			
			List<User> list = userService.getUserList();
			request.setAttribute(AttributeName.LIST, list);
			request.getRequestDispatcher(PageName.GET_USER_LIST_PAGE).forward(request, response);
		} catch (ServiceException e) {	
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);
		}
	}

}
