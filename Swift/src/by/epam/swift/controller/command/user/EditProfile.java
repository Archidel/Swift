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

public class EditProfile implements Command {
	private static final Logger LOGGER = Logger.getLogger(EditProfile.class);
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
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
		boolean statusOperation = false;
		
		try {
			user = userService.editProfile(user, passport, address);
			session.setAttribute(AttributeName.USER, user);
			request.setAttribute(AttributeName.MORE, user);
			statusOperation = true;
		} catch (ServiceException e) {
			LOGGER.error(e);
		}
		
		try {
			if(statusOperation){
				response.sendRedirect(request.getContextPath() + PageName.REDIRECT_EDIT_PROFILE_SUCCESS);				
			}else{
				response.sendRedirect(request.getContextPath() + PageName.REDIRECT_EDIT_PROFILE_ERROR);	
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
		
	}

}
