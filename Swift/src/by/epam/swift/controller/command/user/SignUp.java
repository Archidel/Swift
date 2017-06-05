package by.epam.swift.controller.command.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.swift.bean.User;
import by.epam.swift.controller.PageName;
import by.epam.swift.controller.ParameterName;
import by.epam.swift.controller.command.Command;
import by.epam.swift.service.UserService;
import by.epam.swift.service.exception.ServiceException;
import by.epam.swift.service.factory.ServiceFactory;

/**This class has implementation {@link Command}.
 * Class is used for sign up.
 * @author Archangel
 */

public class SignUp implements Command {
	private static final Logger LOGGER = Logger.getLogger(SignUp.class);  
	
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		User user = new User();
		user.setName(request.getParameter(ParameterName.USER_NAME));
		user.setSurname(request.getParameter(ParameterName.USER_SURNAME));
		user.setLogin(request.getParameter(ParameterName.USER_LOGIN));
		user.setEmail(request.getParameter(ParameterName.USER_EMAIL));
		user.setBirthdate(request.getParameter(ParameterName.USER_BIRTHDATE));
		user.setPhone(request.getParameter(ParameterName.USER_PHONE));
		String password = request.getParameter(ParameterName.USER_PASSWORD);
		String confirmPassword = request.getParameter(ParameterName.USER_CONFIRM_PASSWORD);
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try {
			userService.signUp(user, password, confirmPassword);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_SIGN_UP_SUCCESS);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_SIGN_UP_ERROR);
			LOGGER.error(e);
		}
	}

}
