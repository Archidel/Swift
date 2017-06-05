package by.epam.swift.controller.command.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.epam.swift.bean.User;
import by.epam.swift.controller.AttributeName;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**This class has implementation {@link Command}.
 * Class is used to sign in.
 * @author Archangel
 */
public class SignIn implements Command {
	private static final Logger LOGGER = Logger.getLogger(SignIn.class);  
	
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String login = request.getParameter(ParameterName.USER_LOGIN);
		String password = request.getParameter(ParameterName.USER_PASSWORD);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try {
			User user = userService.signIn(login, password);			
			HttpSession session = request.getSession();
			session.setAttribute(AttributeName.USER, user);
			session.setAttribute(AttributeName.LOGGED, true);
			response.sendRedirect(request.getContextPath() + PageName.INDEX_PAGE);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_SIGN_IN_ERROR);
			LOGGER.error(e);
		}
	}

}
