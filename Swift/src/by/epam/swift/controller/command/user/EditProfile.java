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

/**Class for update/edit user data.
 * This class has implementation {@link Command}.
 * @author Albert Zarankovich
 */
public class EditProfile implements Command {
	private static final Logger LOGGER = Logger.getLogger(EditProfile.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		User user = new User();
		user.setName(request.getParameter(ParameterName.USER_NAME));
		user.setSurname(request.getParameter(ParameterName.USER_SURNAME));
		user.setLogin(request.getParameter(ParameterName.USER_LOGIN));
		user.setPhone(request.getParameter(ParameterName.USER_PHONE));
		user.setEmail(request.getParameter(ParameterName.USER_EMAIL));
		user.setBirthdate(request.getParameter(ParameterName.USER_BIRTHDATE));
		String passport = request.getParameter(ParameterName.USER_PASSPORT);
		String address = request.getParameter(ParameterName.USER_ADDRESS);
		
		HttpSession session = request.getSession();
		User userSession = (User) session.getAttribute(AttributeName.USER);
		user.setId(userSession.getId());

		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		
		try {
			user = userService.editProfile(user, passport, address);
			session.setAttribute(AttributeName.USER, user);
			request.setAttribute(AttributeName.MORE, user);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_EDIT_PROFILE_SUCCESS);				
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_EDIT_PROFILE_ERROR);	
			LOGGER.error(e);
		}
	}

}
