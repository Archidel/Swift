package by.epam.swift.controller.command.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**Class for up or down user's position.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class ChangePosition implements Command {
	private static final Logger LOGGER = Logger.getLogger(ChangePosition.class);

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int idUser = Integer.parseInt(request.getParameter(ParameterName.USER_ID));
		String position = request.getParameter(ParameterName.USER_POSITION);
	
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try {
			userService.changePosition(idUser, position);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_USER_LIST);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_PAGE);
			LOGGER.error(e);		
		}
	}

}
